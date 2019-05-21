package pojo;

import serialcomms.SerialCommunicator;

/**
 * The type Printer.
 */
public class Printer {

    /**
     * The Serial communicator.
     */
    SerialCommunicator serialCommunicator;

    /**
     * The Printer name.
     */
    String printerName;
    /**
     * The Firmware.
     */
    String firmware;
    /**
     * The Printer desc.
     */
    String printerDesc;

    /**
     * The Max x.
     */
    int maxX, /**
     * The Max y.
     */
    maxY, /**
     * The Max z.
     */
    maxZ;

    /**
     * The Setps x.
     */
    double setpsX, /**
     * The Steps y.
     */
    stepsY, /**
     * The Steps z.
     */
    stepsZ, /**
     * The Steps e.
     */
    stepsE; //Steps per mm for each axis and the extruder
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
    feedE; //Max feed rate for each axis and the extruder
    /**
     * The Acc x max.
     */
    double accXMax, /**
     * The Acc y max.
     */
    accYMax, /**
     * The Acc zmax.
     */
    accZmax, /**
     * The Acc e max.
     */
    accEMax; //Max acceleration for each axis and the extruder
    /**
     * The Filament feed accl.
     */
    double filamentFeedAccl, /**
     * The Filament retract accl.
     */
    filamentRetractAccl; //Default filament retract and feed acceleration
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
     * The P.
     */
    double P, /**
     * The .
     */
    I, /**
     * The D.
     */
    D;

    /**
     * The Is home centre.
     */
    boolean isHomeCentre;

    /**
     * Instantiates a new Printer.
     */
    public Printer() {
    }

    /**
     * Instantiates a new Printer.
     *
     * @param serialCommunicator  the serial communicator
     * @param printerName         the printer name
     * @param firmware            the firmware
     * @param printerDesc         the printer desc
     * @param maxX                the max x
     * @param maxY                the max y
     * @param maxZ                the max z
     * @param setpsX              the setps x
     * @param stepsY              the steps y
     * @param stepsZ              the steps z
     * @param stepsE              the steps e
     * @param feedX               the feed x
     * @param feedY               the feed y
     * @param feedZ               the feed z
     * @param feedE               the feed e
     * @param accXMax             the acc x max
     * @param accYMax             the acc y max
     * @param accZmax             the acc zmax
     * @param accEMax             the acc e max
     * @param filamentFeedAccl    the filament feed accl
     * @param filamentRetractAccl the filament retract accl
     * @param minFeed             the min feed
     * @param minTravelFeed       the min travel feed
     * @param minSegmentTime      the min segment time
     * @param maxXYJerk           the max xy jerk
     * @param maxEJerk            the max e jerk
     * @param maxZJerk            the max z jerk
     * @param homeOffsetX         the home offset x
     * @param homeOffsetY         the home offset y
     * @param homeOffsetZ         the home offset z
     * @param p                   the p
     * @param i                   the I
     * @param d                   the d
     * @param isHomeCentre        the is home centre
     */
    public Printer(SerialCommunicator serialCommunicator, String printerName, String firmware, String printerDesc, int maxX,
                   int maxY, int maxZ, double setpsX, double stepsY, double stepsZ, double stepsE, double feedX, double feedY, double feedZ,
                   double feedE, double accXMax, double accYMax, double accZmax, double accEMax, double filamentFeedAccl, double filamentRetractAccl,
                   double minFeed, double minTravelFeed, double minSegmentTime, double maxXYJerk, double maxEJerk, double maxZJerk, double homeOffsetX,
                   double homeOffsetY, double homeOffsetZ, double p, double i, double d, boolean isHomeCentre) {
        this.serialCommunicator = serialCommunicator;
        this.printerName = printerName;
        this.firmware = firmware;
        this.printerDesc = printerDesc;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        this.setpsX = setpsX;
        this.stepsY = stepsY;
        this.stepsZ = stepsZ;
        this.stepsE = stepsE;
        this.feedX = feedX;
        this.feedY = feedY;
        this.feedZ = feedZ;
        this.feedE = feedE;
        this.accXMax = accXMax;
        this.accYMax = accYMax;
        this.accZmax = accZmax;
        this.accEMax = accEMax;
        this.filamentFeedAccl = filamentFeedAccl;
        this.filamentRetractAccl = filamentRetractAccl;
        this.minFeed = minFeed;
        this.minTravelFeed = minTravelFeed;
        this.minSegmentTime = minSegmentTime;
        this.maxXYJerk = maxXYJerk;
        this.maxEJerk = maxEJerk;
        this.maxZJerk = maxZJerk;
        this.homeOffsetX = homeOffsetX;
        this.homeOffsetY = homeOffsetY;
        this.homeOffsetZ = homeOffsetZ;
        P = p;
        I = i;
        D = d;
        this.isHomeCentre = isHomeCentre;
    }

    /**
     * Gets serial communicator.
     *
     * @return the serial communicator
     */
    public SerialCommunicator getSerialCommunicator() {
        return serialCommunicator;
    }

    /**
     * Sets serial communicator.
     *
     * @param serialCommunicator the serial communicator
     */
    public void setSerialCommunicator(SerialCommunicator serialCommunicator) {
        this.serialCommunicator = serialCommunicator;
    }

    /**
     * Gets printer name.
     *
     * @return the printer name
     */
    public String getPrinterName() {
        return printerName;
    }

    /**
     * Sets printer name.
     *
     * @param printerName the printer name
     */
    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    /**
     * Gets firmware.
     *
     * @return the firmware
     */
    public String getFirmware() {
        return firmware;
    }

    /**
     * Sets firmware.
     *
     * @param firmware the firmware
     */
    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    /**
     * Gets printer desc.
     *
     * @return the printer desc
     */
    public String getPrinterDesc() {
        return printerDesc;
    }

    /**
     * Sets printer desc.
     *
     * @param printerDesc the printer desc
     */
    public void setPrinterDesc(String printerDesc) {
        this.printerDesc = printerDesc;
    }

    /**
     * Gets max x.
     *
     * @return the max x
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Sets max x.
     *
     * @param maxX the max x
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * Gets max y.
     *
     * @return the max y
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Sets max y.
     *
     * @param maxY the max y
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    /**
     * Gets max z.
     *
     * @return the max z
     */
    public int getMaxZ() {
        return maxZ;
    }

    /**
     * Sets max z.
     *
     * @param maxZ the max z
     */
    public void setMaxZ(int maxZ) {
        this.maxZ = maxZ;
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

    /**
     * Gets acc x max.
     *
     * @return the acc x max
     */
    public double getAccXMax() {
        return accXMax;
    }

    /**
     * Sets acc x max.
     *
     * @param accXMax the acc x max
     */
    public void setAccXMax(double accXMax) {
        this.accXMax = accXMax;
    }

    /**
     * Gets acc y max.
     *
     * @return the acc y max
     */
    public double getAccYMax() {
        return accYMax;
    }

    /**
     * Sets acc y max.
     *
     * @param accYMax the acc y max
     */
    public void setAccYMax(double accYMax) {
        this.accYMax = accYMax;
    }

    /**
     * Gets acc zmax.
     *
     * @return the acc zmax
     */
    public double getAccZmax() {
        return accZmax;
    }

    /**
     * Sets acc zmax.
     *
     * @param accZmax the acc zmax
     */
    public void setAccZmax(double accZmax) {
        this.accZmax = accZmax;
    }

    /**
     * Gets acc e max.
     *
     * @return the acc e max
     */
    public double getAccEMax() {
        return accEMax;
    }

    /**
     * Sets acc e max.
     *
     * @param accEMax the acc e max
     */
    public void setAccEMax(double accEMax) {
        this.accEMax = accEMax;
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
     * Gets p.
     *
     * @return the p
     */
    public double getP() {
        return P;
    }

    /**
     * Sets p.
     *
     * @param p the p
     */
    public void setP(double p) {
        P = p;
    }

    /**
     * Gets i.
     *
     * @return the i
     */
    public double getI() {
        return I;
    }

    /**
     * Sets i.
     *
     * @param i the
     */
    public void setI(double i) {
        I = i;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public double getD() {
        return D;
    }

    /**
     * Sets d.
     *
     * @param d the d
     */
    public void setD(double d) {
        D = d;
    }

    /**
     * Is home centre boolean.
     *
     * @return the boolean
     */
    public boolean isHomeCentre() {
        return isHomeCentre;
    }

    /**
     * Sets home centre.
     *
     * @param homeCentre the home centre
     */
    public void setHomeCentre(boolean homeCentre) {
        isHomeCentre = homeCentre;
    }




}
