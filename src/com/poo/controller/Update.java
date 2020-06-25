/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.controller;

import com.poo.dao.PetDAO;
import com.poo.model.Cliente;
import com.poo.model.Funcionario;
import com.poo.model.Pet;

/**
 *
 * @author MeuPC
 */
public class Update {
    public String alterarCliente(Cliente cliente){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    
    public String alterarFuncionario(Funcionario funcionario){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    
    public void alterarPet(Pet pet){
        PetDAO dao = new PetDAO();
        dao.update(pet);
        
    }
}
