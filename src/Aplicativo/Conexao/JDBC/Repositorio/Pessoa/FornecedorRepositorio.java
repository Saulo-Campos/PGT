package Aplicativo.Conexao.JDBC.Repositorio.Pessoa;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Aplicativo.Conexao.Conexao;
import Aplicativo.Modelo.Pessoa.Fornecedor;


public class FornecedorRepositorio {

    Conexao conexao = new Conexao();

    // adiciona fornecedors no banco de dados
    public boolean adicionar(Fornecedor fornecedor) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO fornecedor(nome,senha,nomecompleto) VALUE(?,?,?)"
            );
            st.setString(1, fornecedor.getNome());
            st.setString(2, fornecedor.getSenha());
            st.setString(3, fornecedor.getNomeCompleto());
            st.executeUpdate();

            System.out.println("Adicionado o " + "fornecedor: " + fornecedor.getId());
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o fornecedor" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
            //JOptionPane.showMessageDialog(null,"Erro ao adicionar fornecedor" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover fornecedors do banco de dados
    public void remover(Fornecedor fornecedor) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM fornecedor WHERE id = ?"
            );
            st.setLong(1, fornecedor.getId());
            st.executeUpdate();

            System.out.println("Removido o " + "fornecedor: " + fornecedor.getId());

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o fornecedor" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover fornecedors do banco de dados
    public void remover(long id) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM fornecedor WHERE id = ?"
            );
            st.setLong(1, id);
            st.executeUpdate();

            System.out.println("Removido o " + "fornecedor: " + id);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o fornecedor" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //lista todos fornecedors do tabela fornecedors do banco de dados
    public List<Fornecedor> listarTodos() {
        ArrayList<Fornecedor> fornecedors = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexao.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fornecedor");
            while (rs.next()) {
                fornecedors.add(new Fornecedor(
                        rs.getLong(1), // id 
                        rs.getString(2), // nome
                        rs.getString(3), // senha
                        rs.getString(4), // nomeCompleto
                        rs.getString(5), // rg
                        rs.getString(6) // cpf
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao lista Fornecedores " + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);
        }
        return fornecedors;
    }


    // atualizar fornecedors no banco de dados
    public boolean atualizar(Fornecedor fornecedor) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE fornecedor SET nome = ? , senha = ?, nomecompleto = ? where id = ?"
            );
            st.setString(1, fornecedor.getNome());
            st.setString(2, fornecedor.getSenha());
            st.setString(3, fornecedor.getNomeCompleto());
            st.setLong(4, fornecedor.getId());
            st.executeUpdate();

            System.out.println("Atualizado o " + "fornecedor: " + fornecedor.getId());
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar fornecedor" + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);

        }
    }
    
    
    
    
    public Fornecedor getId(long id) {
    String sql = "SELECT * FROM fornecedor WHERE id = ? limit 1";
    Connection conn = null;
    Fornecedor fornecedor = new Fornecedor();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, id);
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        fornecedor.setId(rs.getLong(1)); // id 
        fornecedor.setNome(rs.getString(2)); // nome
        fornecedor.setSenha(rs.getString(3)); // senha
        fornecedor.setNomeCompleto(rs.getString(4)); // nomeCompleto
        fornecedor.setRg(rs.getString(5)); // rg
        fornecedor.setCpf(rs.getString(6)); // cpf
        
        System.out.println(fornecedor.getNome());
        return fornecedor;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista fornecedors " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  public Fornecedor getId(Fornecedor fornecedorx) {
    String sql = "SELECT * FROM fornecedor where id = ?";
    //ArrayList<Fornecedor> fornecedors = new ArrayList<>();
    Connection conn = null;
    Fornecedor fornecedor = new Fornecedor();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, fornecedorx.getId());

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        fornecedor.setId(rs.getLong(1)); // id 
        fornecedor.setNome(rs.getString(2)); // nome
        fornecedor.setSenha(rs.getString(3)); // senha
        fornecedor.setNomeCompleto(rs.getString(4)); // nomeCompleto
        fornecedor.setRg(rs.getString(5)); // rg
        fornecedor.setCpf(rs.getString(6)); // cpf
        return fornecedor;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista fornecedors " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }

}
