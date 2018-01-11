/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;

import com.gestor.bots.admin.console.dao.BotDAO;
import com.gestor.bots.admin.console.model.Bot;
import com.gestor.bots.exception.CreacionException;
import com.gestor.bots.exception.EliminacionException;
import com.gestor.bots.exception.ModificacionException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author js_cm
 */
@LocalBean
@Stateless
public class BotService {
    
    @EJB
    private BotDAO botDAO;
    
    public List<Bot> obtenerTodos() {
        return this.botDAO.findAll();
    }
    
    public void crear(Bot bot)  {
        try {
            this.botDAO.insert(bot);
        } catch (Exception e) {
            throw new CreacionException("ERR100", e.getMessage() ,e);
        }
    }
    
    public void modificar(Bot bot)  {
        try {
            this.botDAO.update(bot);
        } catch (Exception e) {
            throw new ModificacionException("ERR200", e.getMessage() ,e);
        }
    }
    
    public void eliminar(Bot bot)  {
        try {
            this.botDAO.remove(bot);
        } catch (Exception e) {
            throw new EliminacionException("ERR300", e.getMessage() ,e);
        }
    }
    
}
