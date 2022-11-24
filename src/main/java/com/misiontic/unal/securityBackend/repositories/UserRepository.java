package com.misiontic.unal.securityBackend.repositories;

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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    // Customized query using SpringBoot notation
    Optional<User> findByEmail(String email);

    // Customized query using SpringBoot notation
    Optional<User> findByNickname(String nickname);

    // Customized query using SQL and dependencies injection
    @Query(value = "SELECT * FROM user WHERE email=? AND password=?;", nativeQuery = true)
    Optional<User> validateLogin(String email, String password);
}
