package com.olo.tasks.ideas.repository;

import com.olo.tasks.ideas.entity.Ideas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends JpaRepository<Ideas, Long> {


}

