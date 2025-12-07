package cr.ac.ucenfotec.dao;

import java.sql.Connection;

public abstract class BaseDAO {

    protected ConexionBD conexion = new ConexionBD();

    protected Connection obtenerConexion() throws Exception {
        return conexion.obtenerConexion();
    }
}