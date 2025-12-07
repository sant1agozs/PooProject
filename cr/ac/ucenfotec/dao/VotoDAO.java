package cr.ac.ucenfotec.dao;

import cr.ac.ucenfotec.dl.Candidato;
import cr.ac.ucenfotec.dl.Ciudadano;
import cr.ac.ucenfotec.dl.PartidoPolitico;
import cr.ac.ucenfotec.dl.Voto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VotoDAO extends BaseDAO {

    // ===================== INSERTAR VOTO =====================
    public void insertar(Voto v) throws Exception {
        String sql = "INSERT INTO voto(ciudadano_cedula, candidato_id) VALUES (?, ?)";
        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, v.getVotante().getCedula());
        ps.setInt(2, v.getCandidato().getId());
        ps.executeUpdate();

        ps.close();
        con.close();
    }

    // ===================== LISTAR VOTOS (CORREGIDO) =====================
    public List<Voto> listar() throws Exception {
        List<Voto> lista = new ArrayList<>();

        String sql = """
            SELECT v.ciudadano_cedula,
                   v.candidato_id,
                   c.nombre AS candidato_nombre,
                   c.partido_siglas,
                   c.votos AS candidato_votos
            FROM voto v
            INNER JOIN candidato c ON v.candidato_id = c.id;
        """;

        Connection con = obtenerConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            // Ciudadano dummy (solo ocupamos la cédula)
            Ciudadano ciudadano = new Ciudadano("N/A", rs.getString("ciudadano_cedula"), true);

            // Partido del candidato
            PartidoPolitico partido = new PartidoPolitico("N/A", rs.getString("partido_siglas"));

            // Candidato REAL con ID real
            Candidato candidato = new Candidato(
                    rs.getInt("candidato_id"),
                    rs.getString("candidato_nombre"),
                    partido,
                    rs.getInt("candidato_votos")
            );

            lista.add(new Voto(ciudadano, candidato));
        }

        rs.close();
        ps.close();
        con.close();
        return lista;
    }
}