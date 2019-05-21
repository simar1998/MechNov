package pojo.printer.descriptors;

/**
 * This descriptor class strores the maximum feedrate for a printer
 */
public class MaxFeedrate {

    /**
     * The Feed x.
     */
    double feedX, /**
     * The Feed y.
     */
    feedY, /**
     * The Feed z.
     */
    feedZ, /**
     * The Feed e.
     */
    feedE;

    /**
     * Instantiates a new Max feedrate.
     */
    public MaxFeedrate() {
    }

    /**
     * Instantiates a new Max feedrate.
     *
     * @param feedX the feed x
     * @param feedY the feed y
     * @param feedZ the feed z
     * @param feedE the feed e
     */
    public MaxFeedrate(double feedX, double feedY, double feedZ, double feedE) {
        this.feedX = feedX;
        this.feedY = feedY;
        this.feedZ = feedZ;
        this.feedE = feedE;
    }

    /**
     * Gets feed x.
     *
     * @return the feed x
     */
    public double getFeedX() {
        return feedX;
    }

    /**
     * Sets feed x.
     *
     * @param feedX the feed x
     */
    public void setFeedX(double feedX) {
        this.feedX = feedX;
    }

    /**
     * Gets feed y.
     *
     * @return the feed y
     */
    public double getFeedY() {
        return feedY;
    }

    /**
     * Sets feed y.
     *
     * @param feedY the feed y
     */
    public void setFeedY(double feedY) {
        this.feedY = feedY;
    }

    /**
     * Gets feed z.
     *
     * @return the feed z
     */
    public double getFeedZ() {
        return feedZ;
    }

    /**
     * Sets feed z.
     *
     * @param feedZ the feed z
     */
    public void setFeedZ(double feedZ) {
        this.feedZ = feedZ;
    }

    /**
     * Gets feed e.
     *
     * @return the feed e
     */
    public double getFeedE() {
        return feedE;
    }

    /**
     * Sets feed e.
     *
     * @param feedE the feed e
     */
    public void setFeedE(double feedE) {
        this.feedE = feedE;
    }
}
