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

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column(name="nickname", nullable = false, unique = true, length = 50)
    private String nickname;
    @Column(name="email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="idRol")
    @JsonIgnoreProperties("users")
    private Rol rol;

    /**
     * This method returns the current user id
     * @return user id
     */
    public Integer getId() {
        return idUser;
    }

    /**
     * This method returns the current user nickname
     * @return user nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method updates the value for the user nickname
     * @param nickname user nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method returns the current user email
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method returns the current encrypted user password
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method updates the value of the user password
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the current user rol
     * @return user rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * This method updates the value of the user rol
     * @param rol user rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
