package com.saosebastiao.digest.repository;

import com.saosebastiao.digest.entity.Dizimista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DizimistaRepository extends JpaRepository<Dizimista, Long> {
}
