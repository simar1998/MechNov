package database;

public class Queries {
    public static final String INSERT_PRINTER_QUERRY = "INSERT INTO PRINTERS(ID, SERIAL_COMMUNICATOR, PRINTER_NAME, FIRMWARE, PRINTER_DESC, BUILD_VOLUME, STEPS_PER_UNIT, MAX_FEED_RATE, ACCELERATION_SETTINGS, ADDITIONAL_INFO, HOME_OFF_SET, CONTROL_LOOP_PID, IS_HOME_CENTRE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
