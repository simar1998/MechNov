package pojo.printer.descriptors;

/**
 * The type Max acceleration.
 */
public class AccelerationMax {
    /**
     * The Max acceleration x.
     */
    double maxAccelerationX, /**
     * The Max acceleration y.
     */
    maxAccelerationY, /**
     * The Max acceleration z.
     */
    maxAccelerationZ, /**
     * The Max acceleration e.
     */
    maxAccelerationE;

    /**
     * Instantiates a new Max acceleration.
     */
    public AccelerationMax() {
    }

    /**
     * Instantiates a new Max acceleration.
     *
     * @param maxAccelerationX the max acceleration x
     * @param maxAccelerationY the max acceleration y
     * @param maxAccelerationZ the max acceleration z
     * @param maxAccelerationE the max acceleration e
     */
    public AccelerationMax(double maxAccelerationX, double maxAccelerationY, double maxAccelerationZ, double maxAccelerationE) {
        this.maxAccelerationX = maxAccelerationX;
        this.maxAccelerationY = maxAccelerationY;
        this.maxAccelerationZ = maxAccelerationZ;
        this.maxAccelerationE = maxAccelerationE;
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
}
