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

import com.misiontic.unal.securityBackend.models.Permission;
import com.misiontic.unal.securityBackend.services.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionServices permissionServices;

    @GetMapping("/all")
    public List<Permission> getAllPermissions(){
        return this.permissionServices.index();
    }

    @GetMapping("/{id}")
    public Optional<Permission> getPermissionById(@PathVariable("id") int id){
        return this.permissionServices.show(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<Permission> insertPermission(@RequestBody Permission permission){
        return this.permissionServices.create(permission);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable("id") int id, @RequestBody Permission permission){
        return this.permissionServices.update(id, permission);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePermission(@PathVariable("id") int id){
        return this.permissionServices.delete(id);
    }
}
