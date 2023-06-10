package com.misterkourouma.trainings.springboot.repository;

import com.misterkourouma.trainings.springboot.model.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {
}
