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
public class Insert {
    public String cadastraCliente(Cliente cliente){
        try{
            ClienteDAO dao = new ClienteDAO();
            dao.insert(cliente);
            return "Cliente cadastrado!!";
        }
        catch(Exception e){
            return "Erro no cadastro do Cliete";
        }
    }
    
    public String cadastraFuncionario(Funcionario funcionario){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    
    public String cadastraPet(Pet pet){
        try{
            PetDAO dao = new PetDAO();
            dao.insert(pet);
            return "Pet cadastrado!!";
        }
        catch(Exception e){
            return "Erro no cadastro do Cliete";
        }
    }
}
