package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface admin_credentials_repo extends JpaRepository<admin_credentials,String>
{
    @Query("select count(admin_username) from admin_credentials where admin_username=:admin_username")
    int checkAdminOrNot(@Param("admin_username")String admin_username);
}
