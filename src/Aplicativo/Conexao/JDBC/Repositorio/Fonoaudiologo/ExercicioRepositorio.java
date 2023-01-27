package Aplicativo.Conexao.JDBC.Repositorio.Fonoaudiologo;





//import Aplicacao.Conexao.JDBC.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Aplicativo.Conexao.Conexao;
import Aplicativo.Modelo.Saude.Exercicio;




/**
 *
 * @author saulo
 */
public class ExercicioRepositorio {

    Conexao conexao = new Conexao();

    // adiciona exercicios no banco de dados
    public boolean adicionar(Exercicio exercicio) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO exercicio(nome) VALUE(?)"
            );
            st.setString(1, exercicio.getNome());
            //st.setString(2, exercicio.getDescricao());
            st.executeUpdate();

            System.out.println("Adicionado o " + "exercicio: " + exercicio.getId());
            
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o exercicio" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
            //JOptionPane.showMessageDialog(null,"Erro ao adicionar exercicio" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover exercicios do banco de dados
    public void remover(Exercicio exercicio) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM exercicio WHERE id = ?"
            );
            st.setLong(1, exercicio.getId());
            st.executeUpdate();

            System.out.println("Removido o " + "exercicio: " + exercicio.getId());

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o exercicio" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover exercicios do banco de dados
    public void remover(long id) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM exercicio WHERE id = ?"
            );
            st.setLong(1, id);
            st.executeUpdate();

            System.out.println("Removido o " + "exercicio: " + id);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o exercicio" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //lista todos exercicios do tabela exercicios do banco de dados
    public List<Exercicio> listarTodos() {
        ArrayList<Exercicio> exercicios = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexao.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM exercicio");
            while (rs.next()) {
                exercicios.add(new Exercicio(
                        rs.getLong(1), // id 
                        rs.getString(2) // nome
                        //rs.getString(3), // permissao
                        //rs.getString(4) // ativo
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao lista Exercicios " + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);
        }
        return exercicios;
    }

    // atualizar exercicios no banco de dados
    public boolean atualizar(Exercicio exercicio) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE exercicio SET nome = ? where id = ?"
            );
            st.setString(1, exercicio.getNome());
            //st.setString(2, exercicio.getDescricao());
            st.setLong(2, exercicio.getId());
            st.executeUpdate();

            System.out.println("Atualizado o " + "exercicio: " + exercicio.getId());
            
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar exercicio" + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);

        }
    }

    
    
    public Exercicio getId(long id) {
    String sql = "SELECT * FROM exercicio WHERE id = ? limit 1";
    Connection conn = null;
    Exercicio exercicio = new Exercicio();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, id);
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        exercicio.setId(rs.getLong(1)); // id 
        exercicio.setNome(rs.getString(2)); // nome
        /*
        exercicio.setSenha(rs.getString(3)); // senha
        exercicio.setNomeCompleto(rs.getString(4)); // nomeCompleto
        exercicio.setRg(rs.getString(5)); // rg
        exercicio.setCpf(rs.getString(6)); // cpf
         */
        
        System.out.println(exercicio.getNome());
        return exercicio;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista exercicios " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  public Exercicio getId(Exercicio exerciciox) {
    String sql = "SELECT * FROM exercicio where id = ?";
    Connection conn = null;
    Exercicio exercicio = new Exercicio();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, exerciciox.getId());

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        exercicio.setId(rs.getLong(1)); // id 
        exercicio.setNome(rs.getString(2)); // nome
        /*
        exercicio.setSenha(rs.getString(3)); // senha
        exercicio.setNomeCompleto(rs.getString(4)); // nomeCompleto
        exercicio.setRg(rs.getString(5)); // rg
        exercicio.setCpf(rs.getString(6)); // cpf
         */
        return exercicio;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista exercicios " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
}
