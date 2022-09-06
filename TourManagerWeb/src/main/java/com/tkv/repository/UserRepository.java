/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tkv.repository;

import com.tkv.pojo.Users;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    boolean addUser(Users user);
    List<Users> getUsers(String username);
    Users getUserById(int userID);
}
