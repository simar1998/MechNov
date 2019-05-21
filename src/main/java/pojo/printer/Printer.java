package pojo.printer;

import pojo.printer.descriptors.BuildVolume;
import pojo.printer.descriptors.AccelerationMax;
import pojo.printer.descriptors.MaxFeedrate;
import pojo.printer.descriptors.StepsPerUnit;
import serialcomms.SerialCommunicator;

public class Printer {

    SerialCommunicator serialCommunicator;

    String printerName;
    String firmware;
    String printerDesc;

    BuildVolume buildVolume;

    StepsPerUnit stepsPerUnit; //Steps per mm for each axis and the extruder
    MaxFeedrate maxFeedrate; //Max feed rate for each axis and the extruder
    AccelerationMax accelerationMax; //Max acceleration for each axis and the extruder
    double filamentFeedAccl, filamentRetractAccl; //Default filament retract and feed acceleration
    double minFeed, minTravelFeed, minSegmentTime, maxXYJerk, maxEJerk, maxZJerk;
    double homeOffsetX,homeOffsetY,homeOffsetZ;

    double P,I,D;

    boolean isHomeCentre;

    public Printer() {
    }


}
