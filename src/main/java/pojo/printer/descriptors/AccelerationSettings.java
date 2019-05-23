package pojo.printer.descriptors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * The type Max acceleration.
 */
@Entity
@Table(name = "AccelerationSettings")
public class AccelerationSettings extends Serializer implements Descriptors {


    /**
     * The Id.
     */
    @Id
    @Column(name = "Id")
    int id;

    /**
     * The Descriptor.
     */
    @Column(name = "Descriptor")
    String descriptor = "Acceleration";

    /**
     * The Max acceleration x.
     */
    @Column(name = "maxAccelerationX")
    double maxAccelerationX;
    /**
     * The Max acceleration y.
     */
    @Column(name = "maxAccelerationY")
    double maxAccelerationY;
    /**
     * The Max acceleration z.
     */
    @Column(name = "maxAccelerationZ")
    double maxAccelerationZ;
    /**
     * The Max acceleration e.
     */
    @Column(name = "maxAccelerationE")
    double maxAccelerationE;

    /**
     * The Filament feed accl.
     */
    @Column(name = "filamentFeedAccl")
    double filamentFeedAccl;
    /**
     * The Filament retract accl.
     */
    @Column(name ="filamentRetractAccl")
    double filamentRetractAccl;

    /**
     * Instantiates a new Max acceleration.
     */
    public AccelerationSettings() {
    }

    /**
     * Instantiates a new Acceleration settings.
     *
     * @param maxAccelerationX    the max acceleration x
     * @param maxAccelerationY    the max acceleration y
     * @param maxAccelerationZ    the max acceleration z
     * @param maxAccelerationE    the max acceleration e
     * @param filamentFeedAccl    the filament feed accl
     * @param filamentRetractAccl the filament retract accl
     */
    public AccelerationSettings(double maxAccelerationX, double maxAccelerationY, double maxAccelerationZ, double maxAccelerationE, double filamentFeedAccl, double filamentRetractAccl) {
        this.maxAccelerationX = maxAccelerationX;
        this.maxAccelerationY = maxAccelerationY;
        this.maxAccelerationZ = maxAccelerationZ;
        this.maxAccelerationE = maxAccelerationE;
        this.filamentFeedAccl = filamentFeedAccl;
        this.filamentRetractAccl = filamentRetractAccl;
    }

    /**
     * Gets max acceleration x.
     *
     * @return the max acceleration x
     */
    public double getMaxAccelerationX() {
        return maxAccelerationX;
    }

    /**
     * Sets max acceleration x.
     *
     * @param maxAccelerationX the max acceleration x
     */
    public void setMaxAccelerationX(double maxAccelerationX) {
        this.maxAccelerationX = maxAccelerationX;
    }

    /**
     * Gets max acceleration y.
     *
     * @return the max acceleration y
     */
    public double getMaxAccelerationY() {
        return maxAccelerationY;
    }

    /**
     * Sets max acceleration y.
     *
     * @param maxAccelerationY the max acceleration y
     */
    public void setMaxAccelerationY(double maxAccelerationY) {
        this.maxAccelerationY = maxAccelerationY;
    }

    /**
     * Gets max acceleration z.
     *
     * @return the max acceleration z
     */
    public double getMaxAccelerationZ() {
        return maxAccelerationZ;
    }

    /**
     * Sets max acceleration z.
     *
     * @param maxAccelerationZ the max acceleration z
     */
    public void setMaxAccelerationZ(double maxAccelerationZ) {
        this.maxAccelerationZ = maxAccelerationZ;
    }

    /**
     * Gets max acceleration e.
     *
     * @return the max acceleration e
     */
    public double getMaxAccelerationE() {
        return maxAccelerationE;
    }

    /**
     * Sets max acceleration e.
     *
     * @param maxAccelerationE the max acceleration e
     */
    public void setMaxAccelerationE(double maxAccelerationE) {
        this.maxAccelerationE = maxAccelerationE;
    }

    /**
     * Gets filament feed accl.
     *
     * @return the filament feed accl
     */
    public double getFilamentFeedAccl() {
        return filamentFeedAccl;
    }

    /**
     * Sets filament feed accl.
     *
     * @param filamentFeedAccl the filament feed accl
     */
    public void setFilamentFeedAccl(double filamentFeedAccl) {
        this.filamentFeedAccl = filamentFeedAccl;
    }

    /**
     * Gets filament retract accl.
     *
     * @return the filament retract accl
     */
    public double getFilamentRetractAccl() {
        return filamentRetractAccl;
    }

    /**
     * Sets filament retract accl.
     *
     * @param filamentRetractAccl the filament retract accl
     */
    public void setFilamentRetractAccl(double filamentRetractAccl) {
        this.filamentRetractAccl = filamentRetractAccl;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets descriptor.
     *
     * @return the descriptor
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Sets descriptor.
     *
     * @param descriptor the descriptor
     */
    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public void populateObject(ArrayList<String> arrayList) {

    }

}
