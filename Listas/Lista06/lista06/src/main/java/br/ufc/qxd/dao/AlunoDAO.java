package br.ufc.qxd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.qxd.connection.ConnectionFactory;
import br.ufc.qxd.model.Aluno;

public class AlunoDAO {
    PreparedStatement stmt = null;
    Connection con = null;
    String sql = null;
    ResultSet rs = null;
    List<Aluno> alunos;
    Aluno aluno;

    public void insertAluno(Aluno aluno) {
        sql = "Insert into aluno" + "(id_aluno, nome_aluno, cpf_aluno, telefone_aluno, matricula_aluno)"
                + "values (?,?,?,?,?)";
        con = ConnectionFactory.getConnection();
        stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getMatricula());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public Aluno selectAluno(int id_aluno) {
        sql = "Select * from aluno where id_aluno = ?";
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_aluno);
            rs = stmt.executeQuery();

            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome_aluno"));
                aluno.setCpf(rs.getString("cpf_aluno"));
                aluno.setTelefone(rs.getString("telefone_aluno"));
                aluno.setMatricula(rs.getString("matricula_aluno"));
                return aluno;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public List<Aluno> selectAlunos() {
        sql = "Select * from aluno order by id_aluno";
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            alunos = new ArrayList<Aluno>();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome_aluno"));
                aluno.setCpf(rs.getString("cpf_aluno"));
                aluno.setTelefone(rs.getString("telefone_aluno"));
                aluno.setMatricula(rs.getString("matricula_aluno"));
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return alunos;
    }

    public void updateAluno(Aluno aluno) {
        sql = "Update aluno set nome_aluno = ?, cpf_aluno = ?, telefone_aluno = ?, matricula_aluno = ? where id_aluno = ?";
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getMatricula());
            stmt.setInt(5, aluno.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void deleteAluno(int id_aluno) {
        sql = "Delete from aluno where id_aluno = ?";
        con = ConnectionFactory.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_aluno);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
