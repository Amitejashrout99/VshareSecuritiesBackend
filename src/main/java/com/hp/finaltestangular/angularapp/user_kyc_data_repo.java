package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_kyc_data_repo extends JpaRepository<user_kyc_data,Integer>
{

}
