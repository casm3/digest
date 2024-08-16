package com.saosebastiao.digest.repository;

import com.saosebastiao.digest.entity.Dizimista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DizimistaRepository extends JpaRepository<Dizimista, Long> {
  List<Dizimista> findByNomeContaining(String nome);
  Optional<Dizimista> findByCpf(String cpf);
}
