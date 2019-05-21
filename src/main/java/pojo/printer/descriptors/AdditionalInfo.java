package pojo.printer.descriptors;

/**
 * The type Additional info.
 */
public class AdditionalInfo {
    /**
     * The Min feed.
     */
    double minFeed, /**
     * The Min travel feed.
     */
    minTravelFeed, /**
     * The Min segment time.
     */
    minSegmentTime, /**
     * The Max xy jerk.
     */
    maxXYJerk, /**
     * The Max e jerk.
     */
    maxEJerk, /**
     * The Max z jerk.
     */
    maxZJerk;

    /**
     * Instantiates a new Additional info.
     */
    public AdditionalInfo() {
    }

    /**
     * Instantiates a new Additional info.
     *
     * @param minFeed        the min feed
     * @param minTravelFeed  the min travel feed
     * @param minSegmentTime the min segment time
     * @param maxXYJerk      the max xy jerk
     * @param maxEJerk       the max e jerk
     * @param maxZJerk       the max z jerk
     */
    public AdditionalInfo(double minFeed, double minTravelFeed, double minSegmentTime, double maxXYJerk, double maxEJerk, double maxZJerk) {
        this.minFeed = minFeed;
        this.minTravelFeed = minTravelFeed;
        this.minSegmentTime = minSegmentTime;
        this.maxXYJerk = maxXYJerk;
        this.maxEJerk = maxEJerk;
        this.maxZJerk = maxZJerk;
    }

    /**
     * Gets min feed.
     *
     * @return the min feed
     */
    public double getMinFeed() {
        return minFeed;
    }

    /**
     * Sets min feed.
     *
     * @param minFeed the min feed
     */
    public void setMinFeed(double minFeed) {
        this.minFeed = minFeed;
    }

    /**
     * Gets min travel feed.
     *
     * @return the min travel feed
     */
    public double getMinTravelFeed() {
        return minTravelFeed;
    }

    /**
     * Sets min travel feed.
     *
     * @param minTravelFeed the min travel feed
     */
    public void setMinTravelFeed(double minTravelFeed) {
        this.minTravelFeed = minTravelFeed;
    }

    /**
     * Gets min segment time.
     *
     * @return the min segment time
     */
    public double getMinSegmentTime() {
        return minSegmentTime;
    }

    /**
     * Sets min segment time.
     *
     * @param minSegmentTime the min segment time
     */
    public void setMinSegmentTime(double minSegmentTime) {
        this.minSegmentTime = minSegmentTime;
    }

    /**
     * Gets max xy jerk.
     *
     * @return the max xy jerk
     */
    public double getMaxXYJerk() {
        return maxXYJerk;
    }

    /**
     * Sets max xy jerk.
     *
     * @param maxXYJerk the max xy jerk
     */
    public void setMaxXYJerk(double maxXYJerk) {
        this.maxXYJerk = maxXYJerk;
    }

    /**
     * Gets max e jerk.
     *
     * @return the max e jerk
     */
    public double getMaxEJerk() {
        return maxEJerk;
    }

    /**
     * Sets max e jerk.
     *
     * @param maxEJerk the max e jerk
     */
    public void setMaxEJerk(double maxEJerk) {
        this.maxEJerk = maxEJerk;
    }

    /**
     * Gets max z jerk.
     *
     * @return the max z jerk
     */
    public double getMaxZJerk() {
        return maxZJerk;
    }

    /**
     * Sets max z jerk.
     *
     * @param maxZJerk the max z jerk
     */
    public void setMaxZJerk(double maxZJerk) {
        this.maxZJerk = maxZJerk;
    }

}
