package com.adfluence.services.likes.repository;


import com.adfluence.entitiy.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, String>{

    @Query("SELECT COUNT(l) FROM Likes l")
    Long getTotalLikesCount();

}
