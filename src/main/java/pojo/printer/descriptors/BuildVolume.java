package pojo.printer.descriptors;

import javax.persistence.*;

/**
 * This Class stores the max values of the build volume
 */
@Entity
@Table(name = "BuildVolume")
public class BuildVolume extends Serializer {


    /**
     * The Id.
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue
    int id;

    /**
     * The Descriptor.
     */
    @Column(name = "Descriptor")
    String descriptor = "Build Volume";
    /**
     * The X.
     */
    @Column(name = "X")
    int x;
    /**
     * The Y.
     */
    @Column(name = "Y")
    int y;
    /**
     * The Z.
     */
    @Column(name = "Z")
    int z;

    /**
     * Instantiates a new Build volume.
     */
    public BuildVolume() {
    }

    /**
     * Instantiates a new Build volume.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public BuildVolume(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets z.
     *
     * @return the z
     */
    public int getZ() {
        return z;
    }

    /**
     * Sets z.
     *
     * @param z the z
     */
    public void setZ(int z) {
        this.z = z;
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
