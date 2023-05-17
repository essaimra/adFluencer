package com.adfluence.services.influencer.repository;

import com.adfluence.entitiy.Influencer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, String>{

    Influencer findByPhone(String phone);

    List<Influencer> findByName(String name);

    @Query("SELECT i FROM Influencer i")
    Slice<Influencer> findByChunck(PageRequest pageRequest);
}
