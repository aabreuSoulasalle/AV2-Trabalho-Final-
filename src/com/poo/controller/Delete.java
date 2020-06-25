/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.controller;

import com.poo.dao.ClienteDAO;
import com.poo.dao.PetDAO;
import com.poo.model.Cliente;
import com.poo.model.Funcionario;
import com.poo.model.Pet;

/**
 *
 * @author MeuPC
 */
public class Delete {
    public String deletarCliente(Cliente cliente){
        try{
            ClienteDAO dao = new ClienteDAO();
            dao.delete(cliente);
            
            return "Cliente deletado!";
        }
        catch(Exception e){
            return "Falha ao deletar";
        }
    }
    
    public String deletarFuncionario(Funcionario funcionario){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    
    public String deletarPet(Pet pet){
        try{
            Pet pt = new Pet();
            PetDAO dao = new PetDAO();
            dao.delete(pet);
            return "pet deletado!!!";
        }
        catch(Exception e){
            return "Erro ao deletar o pet!!!";
        }
    }
}
