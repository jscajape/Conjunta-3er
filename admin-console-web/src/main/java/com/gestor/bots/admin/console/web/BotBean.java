/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.web;

import com.gestor.bots.admin.console.model.Bot;
import com.gestor.bots.admin.console.servicio.BotService;
import com.gestor.bots.admin.console.web.common.BaseBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author js_cm
 */
@Named
@ViewScoped
public class BotBean extends BaseBean implements Serializable{
    
    @Inject
    private BotService botService;
    
    private List<Bot> botList;

    private Bot bot;
    private Bot botSel;
    
    @PostConstruct
    public void init() {
        this.botList = this.botService.obtenerTodos();
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Bot getBotSel() {
        return botSel;
    }

    public void setBotSel(Bot botSel) {
        this.botSel = botSel;
    }

    public List<Bot> getBotList() {
        return botList;
    }
}
