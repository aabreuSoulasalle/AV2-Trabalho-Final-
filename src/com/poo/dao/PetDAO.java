package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Pet;

public class PetDAO {
    public void insert(Pet pet){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	String sql = "insert into pet(cpfResponsavel, raca, nome, histCuida) values (?, ?, ?, ?)";
	
	
	try {
		
		
		stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
		stmt.setString(1, pet.getCpfResponsavel()); //primeiro parametro da query
		stmt.setString(2, pet.getRaca()); //segundo parametro
		stmt.setString(3, pet.getNome());
                stmt.setString(4, pet.getHistCuida());
		stmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
    }
    public List<Pet> readAll() {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "select cpfResponsavel, raca, nome, histCuida from pet";
	
	List<Pet> pets = new ArrayList<Pet>();
	
	try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		if(rs != null) {
			
			while(rs.next()) {
				
				Pet pet = new Pet();
				pet.setCpfResponsavel(rs.getString("cpfResponsavel"));
				pet.setRaca(rs.getString("raca"));
				pet.setNome(rs.getString("nome"));
				pet.setHistCuida(rs.getString("histCuida"));
				
				pets.add(pet);
				}
			}
		
		} 
		catch(SQLException e) {
			e.printStackTrace();
		} 
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return pets;
	}//!!!!!!!!!!!!!!!!!!!!!!
    
    
    public void update(Pet pet) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	String sql = "update pet set cpfResponsavel = ?, raca = ?, nome = ?, histCuida = ? where cpfResponsavel = ? or nome = ?";
	
	try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, pet.getCpfResponsavel());
		stmt.setString(2, pet.getRaca());
		stmt.setString(3, pet.getNome());
		stmt.setString(4, pet.getHistCuida());
                stmt.setString(5, pet.getCpfResponsavel());
		stmt.setString(6, pet.getNome());
                
		stmt.executeUpdate();
		
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.closeConnection(con);
	}
	
    }
    public void delete(Pet pet) {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	String sql = "delete from pet where cpfResponsavel = ? or nome = ?";
	
	try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, pet.getCpfResponsavel());
		stmt.setString(2, pet.getNome());
		
		stmt.executeUpdate();
	}
	catch(SQLException e){
		System.out.println("!!!!!Erro ao tentar deletar na tabela aws!!!!!!!!!!");
	}
	finally {
		ConnectionFactory.closeConnection(con);
	}
    }

}
