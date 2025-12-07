package cr.ac.ucenfotec.dao;

import cr.ac.ucenfotec.dl.PartidoPolitico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidoDAO extends BaseDAO {

    public void insertar(PartidoPolitico p) throws Exception {
        String sql = "REPLACE INTO partido (nombre, siglas) VALUES (?, ?)";

        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getSiglas());

        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<PartidoPolitico> listar() throws Exception {
        List<PartidoPolitico> lista = new ArrayList<>();

        String sql = "SELECT nombre, siglas FROM partido";

        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new PartidoPolitico(
                    rs.getString("nombre"),
                    rs.getString("siglas")
            ));
        }

        rs.close();
        ps.close();
        con.close();

        return lista;
    }
}