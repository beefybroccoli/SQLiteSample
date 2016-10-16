/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author macbook
 */
public class DemonstrateSQLite {

    public static String LINUX_DIRECTORY = "./src/db/";
    public static String DATABASE_NAME = "test.db";
    public static String CONNECTION_STRING = "jdbc:sqlite:" + LINUX_DIRECTORY + DATABASE_NAME;

    public static Connection getDatbaseConnection() {
        //System.out.println("------------------------------------------");
        Connection connection = null;
        try {
            //Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(CONNECTION_STRING);
            return connection;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Opened database successfully");
        return connection;

    }

    public static void createNewTable() {
        System.out.println("----------------------------");
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getDatbaseConnection();
            System.out.println("Opened database successfully");

            statement = connection.createStatement();
            String sql = "CREATE TABLE COMPANY "
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + " NAME           TEXT    NOT NULL, "
                    + " AGE            INT     NOT NULL, "
                    + " ADDRESS        CHAR(50), "
                    + " SALARY         REAL)";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

        }
        System.out.println("Table created successfully");
    }

    public static void insert() {
        System.out.println("----------------------------");
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getDatbaseConnection();
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            statement.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            statement.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            statement.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            statement.executeUpdate(sql);

            statement.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public static void select() {
        System.out.println("----------------------------");
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getDatbaseConnection();
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM COMPANY;");
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                String address = resultset.getString("address");
                float salary = resultset.getFloat("salary");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            resultset.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Select done successfully");
    }

    public static void update() {
        System.out.println("----------------------------");
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getDatbaseConnection();
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
            statement.executeUpdate(sql);
            connection.commit();

            ResultSet rs = statement.executeQuery("SELECT * FROM COMPANY;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Update done successfully");
    }

    public static void delete() {
        System.out.println("----------------------------");
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getDatbaseConnection();
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            String sql = "DELETE from COMPANY where ID=2;";
            statement.executeUpdate(sql);
            connection.commit();

            ResultSet resultset = statement.executeQuery("SELECT * FROM COMPANY;");
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                String address = resultset.getString("address");
                float salary = resultset.getFloat("salary");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            resultset.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }

    public static void main(String args[]) {
        createNewTable();
        insert();
        select();
        update();
        select();
    }

}
