package com.misiontic.unal.securityBackend.models;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name="name", nullable = false, unique = true)
    private String name;
    private String description = "";

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "rol")
    @JsonIgnoreProperties("rol")
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "permissions_rol",
            joinColumns = @JoinColumn(name = "idRol"),
            inverseJoinColumns = @JoinColumn(name = "idPermission")
    )
    @JsonIgnoreProperties("roles")
    private Set<Permission> permissions;

    /**
     *  This method returns the current rol id
     * @return rol id
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * This method return the current rol name
     * @return rol name
     */
    public String getName() {
        return name;
    }

    /**
     * This method updates the value for the rol name
     * @param name rol name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the current rol description
     * @return rol description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method updates the value of the rol description
     * @param description rol description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method returns a list of users associated at the current rol
     * @return users with current rol
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * This method returns the permissions associated to the current rol
     * @return rol permissions
     */
    public Set<Permission> getPermissions() {
        return permissions;
    }

    /**
     * This method updated the permissions associated to the current rol
     * @param permissions rol permissions
     */
    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }}
