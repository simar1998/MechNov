package pojo.printer;

import pojo.printer.descriptors.*;
import serialcomms.SerialCommunicationHandler;
import serialcomms.SerialCommunicator;

/**
 * The type Printer.
 */
public class Printer extends SerialCommunicationHandler {

    /**
     * The Serial communicator.
     */
    SerialCommunicator serialCommunicator = new SerialCommunicator();

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
     * The Build volume.
     */
    BuildVolume buildVolume;


    /**
     * The Steps per unit.
     */
    StepsPerUnit stepsPerUnit = new StepsPerUnit(); //Steps per mm for each axis and the extruder
    /**
     * The Max feedrate.
     */
    MaxFeedrate maxFeedrate = new MaxFeedrate(); //Max feed rate for each axis and the extruder
    /**
     * The Acceleration settings.
     */
    AccelerationSettings accelerationSettings = new AccelerationSettings(); //Max acceleration for each axis and the extruder
    /**
     * The Additional info.
     */
    AdditionalInfo additionalInfo = new AdditionalInfo(); // additional info
    /**
     * The Home offset.
     */
    HomeOffset homeOffset = new HomeOffset(); //homeoffset

    /**
     * The Control loop pid.
     */
    ControlLoopPID controlLoopPID = new ControlLoopPID(); //ControlLoopPID

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
     * @param serialCommunicator   the serial communicator
     * @param printerName          the printer name
     * @param firmware             the firmware
     * @param printerDesc          the printer desc
     * @param buildVolume          the build volume
     * @param stepsPerUnit         the steps per unit
     * @param maxFeedrate          the max feedrate
     * @param accelerationSettings the acceleration settings
     * @param additionalInfo       the additional info
     * @param homeOffset           the home offset
     * @param controlLoopPID       the control loop pid
     * @param isHomeCentre         the is home centre
     */
    public Printer(SerialCommunicator serialCommunicator, String printerName, String firmware, String printerDesc, BuildVolume buildVolume,
                   StepsPerUnit stepsPerUnit, MaxFeedrate maxFeedrate, AccelerationSettings accelerationSettings, AdditionalInfo additionalInfo, HomeOffset homeOffset,
                   ControlLoopPID controlLoopPID, boolean isHomeCentre) {
        this.serialCommunicator = serialCommunicator;
        this.printerName = printerName;
        this.firmware = firmware;
        this.printerDesc = printerDesc;
        this.buildVolume = buildVolume;
        this.stepsPerUnit = stepsPerUnit;
        this.maxFeedrate = maxFeedrate;
        this.accelerationSettings = accelerationSettings;
        this.additionalInfo = additionalInfo;
        this.homeOffset = homeOffset;
        this.controlLoopPID = controlLoopPID;
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
     * Gets build volume.
     *
     * @return the build volume
     */
    public BuildVolume getBuildVolume() {
        return buildVolume;
    }

    /**
     * Sets build volume.
     *
     * @param buildVolume the build volume
     */
    public void setBuildVolume(BuildVolume buildVolume) {
        this.buildVolume = buildVolume;
    }

    /**
     * Gets steps per unit.
     *
     * @return the steps per unit
     */
    public StepsPerUnit getStepsPerUnit() {
        return stepsPerUnit;
    }

    /**
     * Sets steps per unit.
     *
     * @param stepsPerUnit the steps per unit
     */
    public void setStepsPerUnit(StepsPerUnit stepsPerUnit) {
        this.stepsPerUnit = stepsPerUnit;
    }

    /**
     * Gets max feedrate.
     *
     * @return the max feedrate
     */
    public MaxFeedrate getMaxFeedrate() {
        return maxFeedrate;
    }

    /**
     * Sets max feedrate.
     *
     * @param maxFeedrate the max feedrate
     */
    public void setMaxFeedrate(MaxFeedrate maxFeedrate) {
        this.maxFeedrate = maxFeedrate;
    }

    /**
     * Gets acceleration settings.
     *
     * @return the acceleration settings
     */
    public AccelerationSettings getAccelerationSettings() {
        return accelerationSettings;
    }

    /**
     * Sets acceleration settings.
     *
     * @param accelerationSettings the acceleration settings
     */
    public void setAccelerationSettings(AccelerationSettings accelerationSettings) {
        this.accelerationSettings = accelerationSettings;
    }

    /**
     * Gets additional info.
     *
     * @return the additional info
     */
    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets additional info.
     *
     * @param additionalInfo the additional info
     */
    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Gets home offset.
     *
     * @return the home offset
     */
    public HomeOffset getHomeOffset() {
        return homeOffset;
    }

    /**
     * Sets home offset.
     *
     * @param homeOffset the home offset
     */
    public void setHomeOffset(HomeOffset homeOffset) {
        this.homeOffset = homeOffset;
    }

    /**
     * Gets control loop pid.
     *
     * @return the control loop pid
     */
    public ControlLoopPID getControlLoopPID() {
        return controlLoopPID;
    }

    /**
     * Sets control loop pid.
     *
     * @param controlLoopPID the control loop pid
     */
    public void setControlLoopPID(ControlLoopPID controlLoopPID) {
        this.controlLoopPID = controlLoopPID;
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

    public void storeInDatabase(){
        String stepsPerUnitJson = stepsPerUnit.jsonSerializable(stepsPerUnit);
    }




}
