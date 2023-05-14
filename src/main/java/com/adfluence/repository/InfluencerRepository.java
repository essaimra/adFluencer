package com.adfluence.repository;

import com.adfluence.entitiy.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, String>{

    Influencer findByPhone(String phone);

    List<Influencer> findByName(String name);
}
