/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.bugtracker.dao;

import com.training.bugtracker.model.Tracker;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Dao {
    public List<Tracker> retrieve() throws Exception;
    public void save(Tracker tracker) throws Exception;
}
