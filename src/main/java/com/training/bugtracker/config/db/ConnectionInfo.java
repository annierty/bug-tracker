/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.bugtracker.config.db;

/**
 *
 * @author Admin
 */
public class ConnectionInfo {
  public String _url = "jdbc:postgresql://localhost:5433/tracker?user=postgres&password=admin";
  public ConnectionInfo(){
  }

   public String getUrl() throws Exception{
     try{
            String url = _url;
           return url;
     } catch (Exception e) {
            System.out.println("Error" + e);
            throw e;
      }

   }
}
