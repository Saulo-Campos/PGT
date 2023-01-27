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
import Aplicativo.Modelo.Saude.Metodo;


/**
 *
 * @author saulo
 */
public class MetodoRepositorio {

    Conexao conexao = new Conexao();

    // adiciona metodos no banco de dados
    public boolean adicionar(Metodo metodo) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO metodo(nome) VALUE(?)"
            );
            st.setString(1, metodo.getNome());
            //st.setString(2, metodo.getDescricao());
            st.executeUpdate();

            System.out.println("Adicionado o " + "metodo: " + metodo.getId());
            
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o metodo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
            //JOptionPane.showMessageDialog(null,"Erro ao adicionar metodo" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover metodos do banco de dados
    public void remover(Metodo metodo) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM metodo WHERE id = ?"
            );
            st.setLong(1, metodo.getId());
            st.executeUpdate();

            System.out.println("Removido o " + "metodo: " + metodo.getId());

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o metodo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover metodos do banco de dados
    public void remover(long id) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM metodo WHERE id = ?"
            );
            st.setLong(1, id);
            st.executeUpdate();

            System.out.println("Removido o " + "metodo: " + id);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o metodo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //lista todos metodos do tabela metodos do banco de dados
    public List<Metodo> listarTodos() {
        ArrayList<Metodo> metodos = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexao.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM metodo");
            while (rs.next()) {
                metodos.add(new Metodo(
                        rs.getLong(1), // id 
                        rs.getString(2) // nome
                        //rs.getString(3), // permissao
                        //rs.getString(4) // ativo
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao lista Metodos " + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);
        }
        return metodos;
    }

    // atualizar metodos no banco de dados
    public boolean atualizar(Metodo metodo) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE metodo SET nome = ? where id = ?"
            );
            st.setString(1, metodo.getNome());
            //st.setString(2, metodo.getDescricao());
            st.setLong(2, metodo.getId());
            st.executeUpdate();

            System.out.println("Atualizado o " + "metodo: " + metodo.getId());
            
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar metodo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);

        }
    }

    
    
    public Metodo getId(long id) {
    String sql = "SELECT * FROM metodo WHERE id = ? limit 1";
    Connection conn = null;
    Metodo metodo = new Metodo();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, id);
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        metodo.setId(rs.getLong(1)); // id 
        metodo.setNome(rs.getString(2)); // nome
        /*
        metodo.setSenha(rs.getString(3)); // senha
        metodo.setNomeCompleto(rs.getString(4)); // nomeCompleto
        metodo.setRg(rs.getString(5)); // rg
        metodo.setCpf(rs.getString(6)); // cpf
         */
        
        System.out.println(metodo.getNome());
        return metodo;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista metodos " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  public Metodo getId(Metodo metodox) {
    String sql = "SELECT * FROM metodo where id = ?";
    //ArrayList<Metodo> metodos = new ArrayList<>();
    Connection conn = null;
    Metodo metodo = new Metodo();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, metodox.getId());

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        metodo.setId(rs.getLong(1)); // id 
        metodo.setNome(rs.getString(2)); // nome
        /*
        metodo.setSenha(rs.getString(3)); // senha
        metodo.setNomeCompleto(rs.getString(4)); // nomeCompleto
        metodo.setRg(rs.getString(5)); // rg
        metodo.setCpf(rs.getString(6)); // cpf
         */
        return metodo;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista metodos " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
}
