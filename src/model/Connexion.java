/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Administrateur
 */
public class Connexion {
    private static Connection conn;
    // Les propriétés
    static {
//    Connection conn;
    String urlPilote = "com.mysql.jdbc.Driver";
    String urlBD = "jdbc:mysql://localhost:3306/bddVente";
    String User = "root";
    String pwd = "";

        try {
            Class.forName(urlPilote);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            conn = (Connection) DriverManager.getConnection(urlBD, User, pwd);
            System.err.println("Connexion établie avec succes");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } /*finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }*/
    }

    public static Connection getConnexion() {
        return conn;
    }

    public static void closeConnexion() {
           try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
         
    }
}

