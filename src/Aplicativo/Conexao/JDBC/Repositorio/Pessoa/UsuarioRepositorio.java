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
import Aplicativo.Modelo.Pessoa.Usuario;


public class UsuarioRepositorio {

  Conexao conexao = new Conexao();

  // adiciona usuarios no banco de dados
  public boolean adicionar(Usuario usuario) {
    String sql = "INSERT INTO usuario(nome,senha,nomecompleto) VALUE(?,?,?)";
    Connection conn = null;
    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setString(1, usuario.getNome());
      st.setString(2, usuario.getSenha());
      st.setString(3, usuario.getNomeCompleto());
      st.executeUpdate();

      System.out.println("Adicionado o " + "usuario: " + usuario.getId());
      return true;
    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao adicionar o usuario" + ex);
      throw new RuntimeException("Erro na conexao" + ex);
      //JOptionPane.showMessageDialog(null,"Erro ao adicionar usuario" + ex);
    } finally {
      conexao.closeConnection(conn);

    }
    //return false;
  }

  //remover usuarios do banco de dados
  public void Remover(Usuario usuario) {
    String sql = "DELETE FROM usuario WHERE id = ?";
    Connection conn = null;
    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, usuario.getId());
      st.executeUpdate();

      System.out.println("Removido o " + "usuario: " + usuario.getId());

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao Remover o usuario" + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
  }

  //remover usuarios do banco de dados
  public void Remover(long id) {
    String sql = "DELETE FROM usuario WHERE id = ?";
    Connection conn = null;
    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, id);
      st.executeUpdate();

      System.out.println("Removido o " + "usuario: " + id);

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao Remover o usuario" + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
  }

  //lista todos usuarios do tabela usuarios do banco de dados
  public List<Usuario> listarTodos() {
    String sql = "SELECT * FROM usuario";
    ArrayList<Usuario> usuarios = new ArrayList<>();
    Connection conn = null;

    try {
      conn = conexao.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        usuarios.add(new Usuario(
                rs.getLong(1), // id 
                rs.getString(2), // nome
                rs.getString(3), // senha
                rs.getString(4), // nomeCompleto
                rs.getString(5), // rg
                rs.getString(6) // cpf
        ));
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista usuarios " + ex);
      throw new RuntimeException("Erro na conexao" + ex);

    } finally {
      conexao.closeConnection(conn);
    }
    return usuarios;
  }

  
  public boolean atualizar(Usuario usuario) {
    String sql = "UPDATE usuario SET nome = ? , senha = ?, nomecompleto = ? where id = ?";
    Connection conn = null;
    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setString(1, usuario.getNome());
      st.setString(2, usuario.getSenha());
      st.setString(3, usuario.getNomeCompleto());
      st.setLong(4, usuario.getId());
      st.executeUpdate();

      System.out.println("Atualizado o " + "usuario: " + usuario.getId());
      return true;
      //JOptionPane.showMessageDialog(null, "salvo no banco de dados");
    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao Atualizar usuario" + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      System.out.println("fechou");
      conexao.closeConnection(conn);
    }
  }

  public Usuario getId(long id) {
    String sql = "SELECT * FROM usuario WHERE id = ? limit 1";
    Connection conn = null;
    Usuario usuario = new Usuario();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, id);
      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        usuario.setId(rs.getLong(1)); // id 
        usuario.setNome(rs.getString(2)); // nome
        usuario.setSenha(rs.getString(3)); // senha
        usuario.setNomeCompleto(rs.getString(4)); // nomeCompleto
        usuario.setRg(rs.getString(5)); // rg
        usuario.setCpf(rs.getString(6)); // cpf
        
        //System.out.println(usuario.getNome());
        return usuario;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista usuarios " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  public Usuario getId(Usuario usuariox) {
    String sql = "SELECT * FROM usuario where id = ?";
    //ArrayList<Usuario> usuarios = new ArrayList<>();
    Connection conn = null;
    Usuario usuario = new Usuario();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setLong(1, usuariox.getId());

      ResultSet rs = st.executeQuery();

      while (rs.next()) {
        usuario.setId(rs.getLong(1)); // id 
        usuario.setNome(rs.getString(2)); // nome
        usuario.setSenha(rs.getString(3)); // senha
        usuario.setNomeCompleto(rs.getString(4)); // nomeCompleto
        usuario.setRg(rs.getString(5)); // rg
        usuario.setCpf(rs.getString(6)); // cpf
        return usuario;
      }

    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista usuarios " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  public Long Validator(String nome, String senha) {
    String sql = "SELECT * FROM usuario where nome = ? and senha = ? limit 1";
    //ArrayList<Usuario> usuarios = new ArrayList<>();
    Connection conn = null;
    Usuario usuario = new Usuario();

    try {
      conn = conexao.getConnection();
      PreparedStatement st = conn.prepareStatement(sql);
      st.setString(1, nome);
      st.setString(2, senha);

      ResultSet rs = st.executeQuery();
      
      while (rs.next()) {
        usuario.setId(rs.getLong(1)); // id 
        usuario.setNome(rs.getString(2)); // nome
        usuario.setSenha(rs.getString(3)); // senha
        usuario.setNomeCompleto(rs.getString(4)); // nomeCompleto
        usuario.setRg(rs.getString(5)); // rg
        usuario.setCpf(rs.getString(6)); // cpf
        return usuario.getId();
      }
      
    } catch (ClassNotFoundException | SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao lista usuarios " + ex);
      throw new RuntimeException("Erro na conexao" + ex);
    } finally {
      conexao.closeConnection(conn);
    }
    return null;
  }
  
  
  
  
  
  public boolean existeUsuarios() {
	    String sql = "SELECT count(*) FROM usuario limit 1";
	    Connection conn = null;
	    long quantidade = 0;

	    try {
	      conn = conexao.getConnection();
	      PreparedStatement st = conn.prepareStatement(sql);
	      //st.setLong(1, id);
	      ResultSet rs = st.executeQuery();

	      while (rs.next()) {
	        quantidade = rs.getLong(1); // id 
	        
	        System.out.println(quantidade);
	        if(quantidade == 1)
	        	return true;
	      }

	    } catch (ClassNotFoundException | SQLException ex) {
	      JOptionPane.showMessageDialog(null, "Erro ao lista usuarios " + ex);
	      throw new RuntimeException("Erro na conexao" + ex);
	    } finally {
	      conexao.closeConnection(conn);
	    }
	    return  false; 
	  }
  
  
  
  
  
  
  public boolean checkDBExists(String dbName){
	  Connection conn = null;
      try {

    	  conn = conexao.getConnection();
      
          ResultSet resultSet = conn.getMetaData().getCatalogs();
          
          while (resultSet.next()) {
          
            String databaseName = resultSet.getString(1);
              if(databaseName.equals(dbName)){
                  return true;
              }
          }
          resultSet.close();

      }
      catch(Exception e){
          e.printStackTrace();
      }
      
      return false;
  }

}
