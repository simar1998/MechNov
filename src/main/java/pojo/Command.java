package pojo;

/**
 * The type Command.
 */
public class Command {

    /**
     * The Firmware.
     */
    String firmware;
    /**
     * The Command.
     */
    String command;
    /**
     * The Command desc.
     */
    String commandDesc;
    /**
     * The Command desc long.
     */
    String commandDescLong;

    /**
     * Instantiates a new Command.
     */
    public Command() {
    }

    /**
     * Instantiates a new Command.
     *
     * @param firmware        the firmware
     * @param command         the command
     * @param commandDesc     the command desc
     * @param commandDescLong the command desc long
     */
    public Command(String firmware, String command, String commandDesc, String commandDescLong) {
        this.firmware = firmware;
        this.command = command;
        this.commandDesc = commandDesc;
        this.commandDescLong = commandDescLong;
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
     * Gets command.
     *
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets command.
     *
     * @param command the command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Gets command desc.
     *
     * @return the command desc
     */
    public String getCommandDesc() {
        return commandDesc;
    }

    /**
     * Sets command desc.
     *
     * @param commandDesc the command desc
     */
    public void setCommandDesc(String commandDesc) {
        this.commandDesc = commandDesc;
    }

    /**
     * Gets command desc long.
     *
     * @return the command desc long
     */
    public String getCommandDescLong() {
        return commandDescLong;
    }

    /**
     * Sets command desc long.
     *
     * @param commandDescLong the command desc long
     */
    public void setCommandDescLong(String commandDescLong) {
        this.commandDescLong = commandDescLong;
    }
}
