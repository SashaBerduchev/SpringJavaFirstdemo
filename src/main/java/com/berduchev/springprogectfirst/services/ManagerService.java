package com.berduchev.springprogectfirst.services;

import com.berduchev.springprogectfirst.model.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> getAllManager();
    Manager getManagerById(Long id);
    Manager createManager(Manager manager);
    void deleteManager(Long id);
}
