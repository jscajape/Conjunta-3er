/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;

import com.gestor.bots.admin.console.dao.ClienteDAO;
import com.gestor.bots.admin.console.model.Cliente;
import com.gestor.bots.exception.CreacionException;
import com.gestor.bots.exception.EliminacionException;
import com.gestor.bots.exception.ModificacionException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ClienteService {
    
    @EJB
    private ClienteDAO clienteDAO;
    
    public List<Cliente> obtenerTodos() {
        return this.clienteDAO.findAll();
    }
    
    public void crear(Cliente cliente)  {
        try {
            this.clienteDAO.insert(cliente);
        } catch (Exception e) {
            throw new CreacionException("ERR100", e.getMessage() ,e);
        }
    }
    
    public void modificar(Cliente cliente)  {
        try {
            this.clienteDAO.update(cliente);
        } catch (Exception e) {
            throw new ModificacionException("ERR200", e.getMessage() ,e);
        }
    }
    
    public void eliminar(Cliente cliente)  {
        try {
            this.clienteDAO.remove(cliente);
        } catch (Exception e) {
            throw new EliminacionException("ERR300", e.getMessage() ,e);
        }
    }
    
}

