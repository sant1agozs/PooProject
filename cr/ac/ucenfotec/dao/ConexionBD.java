package cr.ac.ucenfotec.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/eleccion";
    private static final String USER = "root";
    private static final String PASS = "PGCenfo2025?";

    public Connection obtenerConexion() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}