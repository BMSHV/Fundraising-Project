package com.springboot.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sprint1.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Integer> {

}
