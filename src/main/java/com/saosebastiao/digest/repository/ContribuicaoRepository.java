package com.saosebastiao.digest.repository;

import com.saosebastiao.digest.entity.Contribuicao;
import com.saosebastiao.digest.entity.Dizimista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContribuicaoRepository extends JpaRepository<Contribuicao, Long> {
  List<Contribuicao> findByDizimista(Dizimista dizimista);
}
