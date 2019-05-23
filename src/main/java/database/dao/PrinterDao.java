package database.dao;

import database.DatabaseConfig;
import database.Queries;
import pojo.printer.Printer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrinterDao {
    public static void insertPrinterInfo(Printer printer){

        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = DatabaseConfig.getLocalMySQLConn();
            if(con == null){
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
                ps = con.prepareStatement(Queries.INSERT_PRINTER_QUERRY);
                ps.setInt(1,printer.getId());
                ps.setString(2,printer.getSerialCommunicator().getPortDescription());
                ps.setString(3,printer.getPrinterName());
                ps.setString(4,printer.getFirmware());
                ps.setString(5,printer.getPrinterDesc());
                ps.setString(6,printer.getBuildVolume().jsonSerializable(printer.getBuildVolume()));
                ps.setString(7,printer.getStepsPerUnit().jsonSerializable(printer.getStepsPerUnit()));
                ps.setString(8,printer.getMaxFeedrate().jsonSerializable(printer.getMaxFeedrate()));
                ps.setString(9,printer.getAccelerationSettings().jsonSerializable(printer.getAccelerationSettings()));
                ps.setString(10,printer.getAdditionalInfo().jsonSerializable(printer.getAdditionalInfo()));
                ps.setString(11,printer.getHomeOffset().jsonSerializable(printer.getHomeOffset()));
                ps.setString(12,printer.getControlLoopPID().jsonSerializable(printer.getControlLoopPID()));
                ps.setBoolean(13,printer.isHomeCentre());
                con.setAutoCommit(false);
                ps.execute();
                System.out.println("SQL QUERRY === >"+ ps.toString());
                con.commit();

    }catch (SQLException e){
        try{
            throw e;
        }catch (SQLException e1){
            e1.printStackTrace();
        }
        }
        finally {
            try{
                ps.close();
                con.close();
            }catch (SQLException e){
                try{
                    throw  e;
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        }
        }
}
