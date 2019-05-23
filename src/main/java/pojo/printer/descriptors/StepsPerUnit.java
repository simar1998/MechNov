package pojo.printer.descriptors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * This descriptor class stores the steps per mm of a printer
 */
@Entity
@Table(name = "StepsPerUnit")
public class StepsPerUnit extends Serializer implements Descriptors {
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
    String descriptor = "STEPS PER UNIT";
    /**
     * The Setps x.
     */
    @Column(name = "setpsX")
    double setpsX;
    /**
     * The Steps y.
     */
    @Column(name = "setpsY")
    double stepsY;
    /**
     * The Steps z.
     */
    @Column(name = "setpsZ")
    double stepsZ;
    /**
     * The Steps e.
     */
    @Column(name = "setpsE")
    double stepsE;

    /**
     * Instantiates a new Steps per unit.
     */
    public StepsPerUnit() {
    }

    /**
     * Instantiates a new Steps per unit.
     *
     * @param setpsX the setps x
     * @param stepsY the steps y
     * @param stepsZ the steps z
     * @param stepsE the steps e
     */
    public StepsPerUnit(double setpsX, double stepsY, double stepsZ, double stepsE) {
        this.setpsX = setpsX;
        this.stepsY = stepsY;
        this.stepsZ = stepsZ;
        this.stepsE = stepsE;
    }

    /**
     * Gets setps x.
     *
     * @return the setps x
     */
    public double getSetpsX() {
        return setpsX;
    }

    /**
     * Sets setps x.
     *
     * @param setpsX the setps x
     */
    public void setSetpsX(double setpsX) {
        this.setpsX = setpsX;
    }

    /**
     * Gets steps y.
     *
     * @return the steps y
     */
    public double getStepsY() {
        return stepsY;
    }

    /**
     * Sets steps y.
     *
     * @param stepsY the steps y
     */
    public void setStepsY(double stepsY) {
        this.stepsY = stepsY;
    }

    /**
     * Gets steps z.
     *
     * @return the steps z
     */
    public double getStepsZ() {
        return stepsZ;
    }

    /**
     * Sets steps z.
     *
     * @param stepsZ the steps z
     */
    public void setStepsZ(double stepsZ) {
        this.stepsZ = stepsZ;
    }

    /**
     * Gets steps e.
     *
     * @return the steps e
     */
    public double getStepsE() {
        return stepsE;
    }

    /**
     * Sets steps e.
     *
     * @param stepsE the steps e
     */
    public void setStepsE(double stepsE) {
        this.stepsE = stepsE;
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
        String inputLine = this.fromSerialOutput(arrayList,this.descriptor);
    }
}
