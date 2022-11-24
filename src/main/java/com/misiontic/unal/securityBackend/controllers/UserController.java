package com.misiontic.unal.securityBackend.controllers;

/*
 * Copyright: Copyright (c) 2022
 *
 * License
 *
 * Copyright (c) 2022 by Carlos Andres Sierra Virgüez.
 * All rights reserved.
 *
 * This file is part of Academic #MisionTIC2022 Project Software.
 *
 * Academic #MisionTIC2022 Project is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Academic #MisionTIC2022 Project is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Academic #MisionTIC2022 Project.
 * If not, see <https://www.gnu.org/licenses/>.
 */

import com.misiontic.unal.securityBackend.models.User;
import com.misiontic.unal.securityBackend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return this.userServices.index();
    }

    @GetMapping("/by_id/{id}")
    public Optional<User> getUserById(@PathVariable("id") int id){
        return this.userServices.show(id);
    }

    @GetMapping("/by_nickname/{nickname}")
    public User getUserByNickname(@PathVariable("nickname") String nickname){
        return this.userServices.showByNickname(nickname);
    }

    @GetMapping("/by_email/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return this.userServices.showByEmail(email);
    }

    @PostMapping("/insert")
    public ResponseEntity<User> insertUser(@RequestBody User user){
        return this.userServices.create(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        return this.userServices.login(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
        return this.userServices.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int id){
        return this.userServices.delete(id);
    }
}
