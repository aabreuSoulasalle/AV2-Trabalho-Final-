
package com.poo.dao;

import com.poo.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.poo.jdbc.ConnectionFactory;


/**
 *
 * @author MeuPC
 */
public class FuncionarioDAO {
    public void insert(Funcionario funcionario){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
         
	String sql = "insert into funcionario(id, name, senha, ativo, cargo) values (?, ?, ?, ?, ?)";
	
	
	try {
		
		
		stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
		stmt.setString(1, funcionario.getId()); //primeiro parametro da query
		stmt.setString(2, funcionario.getNome()); //segundo parametro
		stmt.setString(3, funcionario.getSenha());
                stmt.setString(4, funcionario.getAtivo());
                stmt.setString(5, funcionario.getCargo());
                
		stmt.executeUpdate();
                
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
	
	
	
	
}
    public List<Funcionario> readAll() {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "select matricula, name from funcionario";
	
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		if(rs != null) {
			
			while(rs.next()) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getString("id"));
				funcionario.setNome(rs.getString("name"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setAtivo(rs.getString("ativo"));
				funcionario.setCargo(rs.getString("cargo"));
				
				funcionarios.add(funcionario);
				}
			}
            } 
	catch(SQLException e) {
            e.printStackTrace();
            } 
	finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return funcionarios;
	}
    public void update(Funcionario funcionario) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	String sql = "update funcionario set matricula = ?, nome = ? where matricula = ? or nome = ?";
	
	try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, funcionario.getId());
		stmt.setString(2, funcionario.getNome());
		stmt.setString(3, funcionario.getSenha());
		stmt.setString(4, funcionario.getAtivo());
		stmt.setString(5, funcionario.getCargo());
		
		stmt.executeUpdate();
		
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con);
	}
	
}
    public void delete(Funcionario funcionario) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	String sql = "delete from funcionario where id = ? or nome = ?";
	
	try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, funcionario.getId());
		stmt.setString(2, funcionario.getNome());
		
		stmt.executeUpdate();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con);
	}
    }
    public Funcionario login(Funcionario funcionario){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "select id, nome, senha, ativo, cargo from funcionario where id = ? and senha = ?";
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getId());
            stmt.setString(2, funcionario.getSenha());
            rs = stmt.executeQuery();
            if(rs.next()){
                Funcionario fun = new Funcionario();
                fun.setId(rs.getString("id"));
		fun.setNome(rs.getString("nome"));
		fun.setAtivo(rs.getString("ativo"));
		fun.setCargo(rs.getString("cargo"));
                
                
                ConnectionFactory.closeConnection(con);
                return fun;
            }
        }
        catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con);
	}
        return funcionario;
    }

}
