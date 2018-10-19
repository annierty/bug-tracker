/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.bugtracker.dao;

import com.training.bugtracker.config.db.ConnectionInfo;
import com.training.bugtracker.model.Tracker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */

public class TrackerDao implements Dao {
   private static final Logger LOGGER = Logger.getLogger(TrackerDao.class.getName());
   
    @Override
    public List<Tracker> retrieve() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res;
        try{
            List <Tracker> bugList = new ArrayList();
           conn = createDBConnection();
           String query_statement = new StringBuilder("SELECT * FROM public.bug_tracker").toString();
           pstmt = conn.prepareStatement(query_statement);
           res = pstmt.executeQuery();

            while (res.next()) {
                     Tracker tracker = new Tracker();
                    tracker.setTicketNum(res.getInt("ticket_num"));
                    tracker.setDescription(res.getString("description"));
                    tracker.setHandleBy(res.getString("handled_by"));
                    tracker.setStatus(res.getString("tracker_status"));
                    bugList.add(tracker);               
            }

            res.close();
            pstmt.close();
            res = null;
            pstmt = null;

           return bugList;
        }catch(Exception e) {
           LOGGER.log(Level.SEVERE, "Failed to retrieve the list of bug.", e);
        } finally {
            conn.close();
            pstmt.close();
        }
        return null;
    }

    @Override
    public void save(Tracker tracker) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private Connection createDBConnection() throws Exception {
        Class.forName("org.postgresql.Driver");

        ConnectionInfo ci = new ConnectionInfo();
        return DriverManager.getConnection(ci.getUrl());
    }
    
}
