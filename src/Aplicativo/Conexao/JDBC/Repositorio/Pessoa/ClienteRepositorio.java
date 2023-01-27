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
import Aplicativo.Modelo.Pessoa.Cliente;



/**
 *
 * @author saulo
 */
public class ClienteRepositorio {

    Conexao conexao = new Conexao();

    // adiciona clientes no banco de dados
    public boolean adicionar(Cliente cliente) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO cliente(nome,senha,nomecompleto) VALUE(?,?,?)"
            );
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getSenha());
            st.setString(3, cliente.getNomeCompleto());
            st.executeUpdate();
            System.out.println("Adicionado o " + "cliente: " + cliente.getId());
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o cliente" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover clientes do banco de dados
    public void remover(Cliente cliente) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM cliente WHERE id = ?"
            );
            st.setLong(1, cliente.getId());
            st.executeUpdate();

            System.out.println("Removido o " + "cliente: " + cliente.getId());

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o cliente" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //remover clientes do banco de dados
    public void remover(long id) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM cliente WHERE id = ?"
            );
            st.setLong(1, id);
            st.executeUpdate();

            System.out.println("Removido o " + "cliente: " + id);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover o cliente" + ex);
            throw new RuntimeException("Erro na conexao" + ex);
        } finally {
            conexao.closeConnection(conn);
        }
    }

    //lista todos clientes do tabela clientes do banco de dados
    public List<Cliente> listarTodos() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Connection conn = null;

        try {
            conn = conexao.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getLong(1), // id 
                        rs.getString(2), // nome
                        rs.getString(3), // senha
                        rs.getString(4), // nomeCompleto
                        rs.getString(5), // rg
                        rs.getString(6) // cpf
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao lista clientes " + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);
        }
        return clientes;
    }

    // atualizar clientes no banco de dados
    public boolean atualizar(Cliente cliente) {
        Connection conn = null;
        try {
            conn = conexao.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE cliente SET nome = ? , senha = ?, nomecompleto = ? where id = ?"
            );
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getSenha());
            st.setString(3, cliente.getNomeCompleto());
            st.setLong(4, cliente.getId());
            st.executeUpdate();

            System.out.println("Atualizado o " + "cliente: " + cliente.getId());
            return true;
            //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar cliente" + ex);
            throw new RuntimeException("Erro na conexao" + ex);

        } finally {
            conexao.closeConnection(conn);

        }
    }
    
    
    
     public Cliente getId(long id) {
    String sql = "SELECT * FROM cliente WHERE id = ? limit 1";
    Connection conn = null;
    Cliente cliente = new Cliente();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, id);
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        cliente.setId(rs.getLong(1)); // id 
        cliente.setNome(rs.getString(2)); // nome
        cliente.setSenha(rs.getString(3)); // senha
        cliente.setNomeCompleto(rs.getString(4)); // nomeCompleto
        cliente.setRg(rs.getString(5)); // rg
        cliente.setCpf(rs.getString(6)); // cpf
        
        System.out.println(cliente.getNome());
        return cliente;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista clientes " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }

}
