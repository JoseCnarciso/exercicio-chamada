package com.api.exerciciochamada.repositories;

import com.api.exerciciochamada.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadaRepository extends JpaRepository<Aluno,Integer> {
}
