package pojo.printer.descriptors;

/**
 * The type Home offset.
 */
public class HomeOffset extends Serializer {
    /**
     * The Home offset x.
     */
    double homeOffsetX, /**
     * The Home offset y.
     */
    homeOffsetY, /**
     * The Home offset z.
     */
    homeOffsetZ;

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

}
