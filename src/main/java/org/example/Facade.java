package org.example;

import java.sql.Connection;

public class Facade {

    public static void main(String[] args) {
        HelperFacade.generateReport(
                HelperFacade.DBTypes.MYSQL,
                HelperFacade.ReportTypes.HTML,
                "TEST");
    }

}

class MySqlHelper {

    public static Connection getMySqlDBConnection() {
        //get MySql DB connection using connection parameters
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }

    public void generateMySqlHTMLReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }
}

class OracleHelper {

    public static Connection getOracleDBConnection() {
        //get Oracle DB connection using connection parameters
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }

    public void generateOracleHTMLReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }

}

class HelperFacade {

    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
        java.sql.Connection con = null;
        switch (dbType) {
            case MYSQL -> {
                con = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case HTML -> mySqlHelper.generateMySqlHTMLReport(tableName, con);
                    case PDF -> mySqlHelper.generateMySqlPDFReport(tableName, con);
                }
            }
            case ORACLE -> {
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case HTML -> oracleHelper.generateOracleHTMLReport(tableName, con);
                    case PDF -> oracleHelper.generateOraclePDFReport(tableName, con);
                }
            }
        }

    }

    public enum DBTypes {
        MYSQL,
        ORACLE
    }

    public enum ReportTypes {
        HTML,
        PDF
    }
}
