package com.astontech.dao.mssql;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import java.sql.Connection;
    import java.sql.DriverManager;
import java.sql.SQLException;

    public abstract class MSSQL {

        //region PROPERTIES

        protected static String dbHost = "localhost";
        protected static String dbName = "AstonEngineer";
        protected static String dbUser = "brandon";
        protected static String dbPass = "bg";
        protected static String useSSL = "false";
        protected static String procBod = "true";
        protected static Connection connection = null;

        protected static final int GET_BY_ID = 10;
        protected static final int GET_COLLECTION = 20;
        protected static final int INSERT = 10;
        protected static final int UPDATE = 20;
        protected static final int DELETE = 30;

        final static Logger logger = Logger.getLogger(Main.class);

        //endregion

         protected static void Connect() {

                try {
                    //  + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod
                    connection = DriverManager.getConnection("jdbc:sqlserver://" + dbHost + ":1433;databaseName=" + dbName + ";user=" + dbUser + ";password=" + dbPass);
                } catch (SQLException ex) {
                    logger.error("Connection failed: " + ex);
                }

            if(connection != null) {
                logger.info("Connected to MS SQL database");
            } else {
                logger.info("Connection failed");
            }
        }

}
