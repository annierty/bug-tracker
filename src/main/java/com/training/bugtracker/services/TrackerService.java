/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.bugtracker.services;

import com.training.bugtracker.constants.BugTrackerConstants;
import com.training.bugtracker.dao.TrackerDao;
import com.training.bugtracker.model.Tracker;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service(BugTrackerConstants.SERVICE_TRACKER)
@Transactional
public class TrackerService {
    private final TrackerDao trackerDao = new TrackerDao();
    public List<Tracker> getBugList() throws Exception {
        return trackerDao.retrieve();
    }
    
}
