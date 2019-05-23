package pojo.printer.descriptors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Home offset.
 */
@Entity
@Table(name = "HomeOffset")
public class HomeOffset extends Serializer {

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
    String descriptor = "Home offset";
    /**
     * The Home offset x.
     */
    @Column(name = "homeOffsetX")
    double homeOffsetX;
    /**
     * The Home offset y.
     */
    @Column(name = "homeOffsetY")
    double homeOffsetY;
    /**
     * The Home offset z.
     */
    @Column(name = "homeOffsetZ")
    double homeOffsetZ;

    /**
     * Instantiates a new Home offset.
     */
    public HomeOffset() {
    }

    /**
     * Instantiates a new Home offset.
     *
     * @param homeOffsetX the home offset x
     * @param homeOffsetY the home offset y
     * @param homeOffsetZ the home offset z
     */
    public HomeOffset(double homeOffsetX, double homeOffsetY, double homeOffsetZ) {
        this.homeOffsetX = homeOffsetX;
        this.homeOffsetY = homeOffsetY;
        this.homeOffsetZ = homeOffsetZ;
    }

    /**
     * Gets home offset x.
     *
     * @return the home offset x
     */
    public double getHomeOffsetX() {
        return homeOffsetX;
    }

    /**
     * Sets home offset x.
     *
     * @param homeOffsetX the home offset x
     */
    public void setHomeOffsetX(double homeOffsetX) {
        this.homeOffsetX = homeOffsetX;
    }

    /**
     * Gets home offset y.
     *
     * @return the home offset y
     */
    public double getHomeOffsetY() {
        return homeOffsetY;
    }

    /**
     * Sets home offset y.
     *
     * @param homeOffsetY the home offset y
     */
    public void setHomeOffsetY(double homeOffsetY) {
        this.homeOffsetY = homeOffsetY;
    }

    /**
     * Gets home offset z.
     *
     * @return the home offset z
     */
    public double getHomeOffsetZ() {
        return homeOffsetZ;
    }

    /**
     * Sets home offset z.
     *
     * @param homeOffsetZ the home offset z
     */
    public void setHomeOffsetZ(double homeOffsetZ) {
        this.homeOffsetZ = homeOffsetZ;
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
}
