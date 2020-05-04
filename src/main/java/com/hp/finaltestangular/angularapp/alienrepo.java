package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface alienrepo extends JpaRepository<alien,Integer>
{

}
