package pojo;

import serialcomms.SerialCommunicator;

public class Printer {

    SerialCommunicator serialCommunicator;

    String printerName;
    String firmware;
    String printerDesc;

    int maxX,maxY,maxZ;

    double setpsX, stepsY, stepsZ, stepsE; //Steps per mm for each axis and the extruder
    double feedX,feedY,feedZ,feedE; //Max feed rate for each axis and the extruder
    double accXMax, accYMax, accZmax, accEMax; //Max acceleration for each axis and the extruder
    double filamentFeedAccl, filamentRetractAccl; //Default filament retract and feed acceleration
    double minFeed, minTravelFeed, minSegmentTime, maxXYJerk, maxEJerk, maxZJerk;
    double homeOffsetX,homeOffsetY,homeOffsetZ;

    double P,I,D;

    boolean isHomeCentre;

    public Printer() {
    }


}
