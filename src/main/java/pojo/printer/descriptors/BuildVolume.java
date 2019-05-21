package pojo.printer.descriptors;

/**
 * This Class stores the max values of the build volume
 */
public class BuildVolume {

    /**
     * The X.
     */
    int x;
    /**
     * The Y.
     */
    int y;
    /**
     * The Z.
     */
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
}
