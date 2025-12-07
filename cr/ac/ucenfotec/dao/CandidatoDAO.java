package cr.ac.ucenfotec.dao;

import cr.ac.ucenfotec.dl.Candidato;
import cr.ac.ucenfotec.dl.PartidoPolitico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO extends BaseDAO {

    public void insertar(Candidato c) throws Exception {
        String sql = "INSERT INTO candidato(nombre, partido_siglas, votos) VALUES (?, ?, ?)";
        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, c.getNombre());
        ps.setString(2, c.getPartido().getSiglas());
        ps.setInt(3, c.getVotos());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            c.setId(rs.getInt(1));
        }

        rs.close();
        ps.close();
        con.close();
    }

    public void actualizarVotos(Candidato c) throws Exception {
        String sql = "UPDATE candidato SET votos = ? WHERE id = ?";
        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, c.getVotos());
        ps.setInt(2, c.getId());
        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public List<Candidato> listar() throws Exception {
        List<Candidato> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, partido_siglas, votos FROM candidato";

        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PartidoPolitico p = new PartidoPolitico("N/A", rs.getString("partido_siglas"));
            lista.add(new Candidato(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    p,
                    rs.getInt("votos")
            ));
        }

        rs.close();
        ps.close();
        con.close();
        return lista;
    }
}