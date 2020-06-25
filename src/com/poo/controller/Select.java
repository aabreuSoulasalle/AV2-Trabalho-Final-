/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.controller;

import com.poo.dao.FuncionarioDAO;
import com.poo.dao.PetDAO;
import com.poo.model.Cliente;
import com.poo.model.Funcionario;
import com.poo.model.Pet;
import com.poo.view.TelaPrincipal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MeuPC
 */
public class Select {
    public String buscaCliente(Cliente cliente){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    
    public String buscaFuncionario(Funcionario funcionario){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    

    
    public String listaCliente(Cliente cliente){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    
    public String listaFuncionario(Funcionario funcionario){
        try{
            
            return "";
        }
        catch(Exception e){
            return "";
        }
    }
    
    public List<Pet> listaPet(){
        
        List<Pet> pets = new ArrayList<Pet>();
        PetDAO dao = new PetDAO();
        pets = dao.readAll();
            
        return pets;
        
    }
    
    public Funcionario logar(Funcionario funcionario){
        Funcionario fun = new Funcionario ();
        try{
            FuncionarioDAO dao = new FuncionarioDAO();
            fun = dao.login(funcionario);
        
            if("true".equals(fun.getAtivo())){
                return fun;
            }
        }
        catch(Exception e) {
            return fun;
        }	
       return fun; 
        
    }
    
}
