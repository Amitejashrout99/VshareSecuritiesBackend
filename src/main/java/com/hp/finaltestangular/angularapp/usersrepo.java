package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface usersrepo extends JpaRepository<users,String>
{
    @Query("from users where username= :name")
    users find_user(@Param("name")String name_of_user);




}
