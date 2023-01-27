package Aplicativo.Conexao.JDBC.Repositorio.Pessoa;





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
import Aplicativo.Modelo.Pessoa.Cargo;

/**
 *
 * @author saulo
 */
public class CargoRepositorio {

    Conexao conexao = new Conexao();

    // adiciona cargos no banco de dados
    public boolean adicionar(Cargo cargo) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO cargo(nome) VALUE(?)"
            );
            st.setString(1, cargo.getNome());
            //st.setString(2, cargo.getPermissao());
            st.executeUpdate();

            System.out.println("Adicionado o " + "cargo: " + cargo.getId());
            
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o cargo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
            //JOptionPane.showMessageDialog(null,"Erro ao adicionar cargo" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover cargos do banco de dados
    public void remover(Cargo cargo) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM cargo WHERE id = ?"
            );
            st.setLong(1, cargo.getId());
            st.executeUpdate();

            System.out.println("Removido o " + "cargo: " + cargo.getId());

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o cargo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover cargos do banco de dados
    public void remover(long id) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM cargo WHERE id = ?"
            );
            st.setLong(1, id);
            st.executeUpdate();

            System.out.println("Removido o " + "cargo: " + id);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o cargo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //lista todos cargos do tabela cargos do banco de dados
    public List<Cargo> listarTodos() {
        ArrayList<Cargo> cargos = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexao.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cargo");
            while (rs.next()) {
                cargos.add(new Cargo(
                        rs.getLong(1), // id 
                        rs.getString(2) // nome
                        //rs.getString(3), // permissao
                        //rs.getString(4) // ativo
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao lista Cargos " + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);
        }
        return cargos;
    }

    // atualizar cargos no banco de dados
    public boolean atualizar(Cargo cargo) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE cargo SET nome = ? where id = ?"
            );
            st.setString(1, cargo.getNome());
            //st.setString(2, cargo.getPermissao());
            st.setLong(2, cargo.getId());
            st.executeUpdate();

            System.out.println("Atualizado o " + "cargo: " + cargo.getId());
            
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar cargo" + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);

        }
    }

    
    
    public Cargo getId(long id) {
    String sql = "SELECT * FROM cargo WHERE id = ? limit 1";
    Connection conn = null;
    Cargo cargo = new Cargo();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, id);
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        cargo.setId(rs.getLong(1)); // id 
        cargo.setNome(rs.getString(2)); // nome
        /*
        cargo.setSenha(rs.getString(3)); // senha
        cargo.setNomeCompleto(rs.getString(4)); // nomeCompleto
        cargo.setRg(rs.getString(5)); // rg
        cargo.setCpf(rs.getString(6)); // cpf
         */
        
        System.out.println(cargo.getNome());
        return cargo;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista cargos " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  public Cargo getId(Cargo cargox) {
    String sql = "SELECT * FROM cargo where id = ?";
    //ArrayList<Cargo> cargos = new ArrayList<>();
    Connection conn = null;
    Cargo cargo = new Cargo();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, cargox.getId());

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        cargo.setId(rs.getLong(1)); // id 
        cargo.setNome(rs.getString(2)); // nome
        /*
        cargo.setSenha(rs.getString(3)); // senha
        cargo.setNomeCompleto(rs.getString(4)); // nomeCompleto
        cargo.setRg(rs.getString(5)); // rg
        cargo.setCpf(rs.getString(6)); // cpf
         */
        return cargo;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista cargos " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  
}
