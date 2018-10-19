/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.bugtracker.model;

/**
 *
 * @author Admin
 */
public class Tracker {
    Integer ticketNum = 0;
    String description = "";
    String handleBy = "";
    String status = "";

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHandleBy() {
        return handleBy;
    }

    public void setHandleBy(String handleBy) {
        this.handleBy = handleBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tracker{" + "ticketNum=" + ticketNum +
               ", description=" + description + 
               ", handleBy=" + handleBy + 
               ", status=" + status + '}';
    }
    
    
}
