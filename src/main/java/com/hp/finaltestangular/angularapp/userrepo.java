package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepo extends JpaRepository<user,Integer>
{
    @Query("from user where name= :name")
    user find_id_of_user(@Param("name") String username);

    @Query("select count(name) from user where name=:username")
    int checkUsernameAvailabilityStatus(@Param("username")String username);

}
