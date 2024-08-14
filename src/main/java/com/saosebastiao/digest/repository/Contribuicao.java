package com.saosebastiao.digest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contribuicao extends JpaRepository<Contribuicao, Long> {
}
