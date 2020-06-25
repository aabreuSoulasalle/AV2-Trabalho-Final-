
package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Cliente;

public class ClienteDAO {
    public void insert(Cliente cliente){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	String sql = "insert into cliente(cpf, nome, telefone) values (?, ?, ?)";
	
	
	try {
		
		
		stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
		stmt.setString(1, cliente.getCpf()); //primeiro parametro da query
		stmt.setString(2, cliente.getNome());//segundo parametro
		stmt.setString(3, cliente.getTelefone());
                
		stmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
    }
    
    public List<Cliente> readAll() {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "select cpf, name, telefone from cliente";
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		if(rs != null) {
			
			while(rs.next()) {
				
				Cliente cliente = new Cliente();
                                cliente.setCpf(rs.getString("cpf"));
				cliente.setNome(rs.getString("matricula"));
				cliente.setTelefone(rs.getString("telefone"));
				
				clientes.add(cliente);
				}
			}
		
		} 
		catch(SQLException e) {
			e.printStackTrace();
		} 
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
    
    public void update(Cliente cliente) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	String sql = "update cliente set cpf = ?, name = ?, telefone = ? where cpf = ? or name = ?";
	
	try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getCpf());
		stmt.setString(2, cliente.getNome());
		stmt.setString(3, cliente.getTelefone());
		stmt.setString(4, cliente.getCpf());
                stmt.setString(5, cliente.getNome());
		
		stmt.executeUpdate();
		
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con);
	}
	
    }
    
    public void delete(Cliente cliente) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	String sql = "delete from cliente where cpf = ? or nome = ?";
	
	try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getCpf());
		stmt.setString(2, cliente.getNome());
		
		stmt.executeUpdate();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con);
	}
    }


}
