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
import java.util.Set;

@Entity
@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermission;
    @Column(name="url", nullable = false, unique = true)
    private String url;
    @Column(name="method", nullable = false, length = 10)
    private String method;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnoreProperties("permissions")
    private Set<Rol> roles;

    /**
     * This method returns the current permission id
     * @return permission id
     */
    public Integer getId() {
        return idPermission;
    }

    /**
     * This method return the current permission url
     * @return permission url
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method updates the value of the permission url
     * @param url permission url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method returns the current permission method
     * @return permission method
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method updates the value of the permission method
     * @param method permission method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * This method returns the roles associated to the current permission
     * @return roles with current permission
     */
    public Set<Rol> getRoles() {
        return roles;
    }
}
