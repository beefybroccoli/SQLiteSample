/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.util.ArrayList;
import java.util.List;
import sqlite_demonstration.SQLiteDatabase;

/**
 *
 * @author macbook
 */
public class Database_Version_3 {

    public static void main(String[] args) {

        runTest();

        //getQueryArray();
    }

    public static void runTest() {
        String linx_database_directory = "./src/db/";

        SQLiteDatabase db = new SQLiteDatabase(linx_database_directory, "mydb");

        db.createTable(referenceQuery());
    }

    public static List<String> getQueryArray() {
        List<String> result = new ArrayList<String>();
        String massInputQueries = massInputQueries();

        String[] stringArray = massInputQueries.split(";");
        for (String element : stringArray) {
            int startIndex = element.indexOf("CREATE");
            element = element.substring(startIndex) + ";";
            element = element.replaceAll("IF NOT EXISTS `mydb`.", "");
            element = element.replaceAll("`", "");
            System.out.println("element : " + element + "\n");
            result.add(element);
        }

        return result;
    }

    public static String referenceQuery() {
        return "CREATE TABLE COMPANY "
                + "(ID INT PRIMARY KEY     NOT NULL,"
                + " NAME           TEXT    NOT NULL, "
                + " AGE            INT     NOT NULL, "
                + " ADDRESS        CHAR(50), "
                + " SALARY         REAL)";
    }
    
    

    public static String massInputQueries() {
        return "";
    }

}
