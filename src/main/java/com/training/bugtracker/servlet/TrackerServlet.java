/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.bugtracker.servlet;

import com.training.bugtracker.config.db.DbConnector;
import com.training.bugtracker.config.db.PostgresHelper;
import com.training.bugtracker.dao.TrackerDao;
import com.training.bugtracker.model.Tracker;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = "/home")
public class TrackerServlet extends HttpServlet{
    private static final Logger LOGGER = Logger.getLogger(TrackerServlet.class.getName());
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           request.getSession().setAttribute("list", this.retrieveBugList());
        } catch (Exception ex) {
            Logger.getLogger(TrackerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        RequestDispatcher dispatcher = 
        request.getRequestDispatcher("WEB-INF/views/display-tracker-list.jsp");
        dispatcher.forward(request, response);

    }
     @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       RequestDispatcher dispatcher = 
        request.getRequestDispatcher("WEB-INF/views/add-new-tracker.jsp");
        dispatcher.forward(request, response);

	}
    
     private List<Tracker> retrieveBugList() {
        List <Tracker> bugList = new ArrayList();
        PostgresHelper client = new PostgresHelper(
                             DbConnector.HOST, 
                             DbConnector.DB_NAME,
                             DbConnector.USERNAME,
                             DbConnector.PASSWORD);

             try {
                 if (client.connect()) {
                     ResultSet res = client.execQuery("SELECT * FROM public.bug_tracker");
                     while(res.next()) {
                        Tracker tracker = new Tracker();
                 tracker.setTicketNum(res.getInt("ticket_num"));
                 tracker.setDescription(res.getString("description"));
                 tracker.setHandleBy(res.getString("handled_by"));
                 tracker.setStatus(res.getString("tracker_status"));
                 bugList.add(tracker);
                     }
                 }

                return bugList;
              } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             }catch (SQLException e) {
                 LOGGER.log(Level.SEVERE, "Failed to retrieve the list of bug.", e);
             }

             return null;
    }
    
       
}
