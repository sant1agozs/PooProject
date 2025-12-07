package cr.ac.ucenfotec.dao;

import cr.ac.ucenfotec.dl.Ciudadano;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadanoDAO extends BaseDAO {

    // INSERTAR NUEVO CIUDADANO
    public void insertar(Ciudadano c) throws Exception {
        String sql = "INSERT INTO ciudadano(nombre, cedula, yavoto) VALUES (?, ?, ?)";
        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, c.getNombre());
        ps.setString(2, c.getCedula());
        ps.setBoolean(3, c.getYaVoto());

        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void actualizar(Ciudadano c) throws Exception {
        String sql = "UPDATE ciudadano SET yavoto = ? WHERE cedula = ?";
        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setBoolean(1, c.getYaVoto());
        ps.setString(2, c.getCedula());

        ps.executeUpdate();
        ps.close();
        con.close();
    }

    // LISTAR CIUDADANOS
    public List<Ciudadano> listar() throws Exception {
        List<Ciudadano> lista = new ArrayList<>();

        String sql = "SELECT nombre, cedula, yavoto FROM ciudadano";
        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new Ciudadano(
                    rs.getString("nombre"),
                    rs.getString("cedula"),
                    rs.getBoolean("yavoto")
            ));
        }

        rs.close();
        ps.close();
        con.close();
        return lista;
    }
}