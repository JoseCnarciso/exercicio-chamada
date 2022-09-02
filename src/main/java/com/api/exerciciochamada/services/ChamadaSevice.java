package com.api.exerciciochamada.services;

import com.api.exerciciochamada.exceptions.IdAlunoException;
import com.api.exerciciochamada.exceptions.NomeAlunoException;
import com.api.exerciciochamada.models.Aluno;
import com.api.exerciciochamada.repositories.ChamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;


// Nesta camada cria se os métodos para a camada controller

@Service
public class ChamadaSevice {

    @Autowired
    ChamadaRepository chamadaRepository;

    public List<Aluno> findAll(){
        return chamadaRepository.findAll();
    }

    @Transactional
    public Aluno save(Aluno aluno){

        if (aluno.getId() !=null){
            Optional<Aluno> alunoOptional = chamadaRepository.findById(aluno.getId());
            if (!alunoOptional.isPresent()){
                System.out.println("Aluno não encontrado");
                return null;
            }
        }
        return chamadaRepository.save(aluno);
    }


    public Aluno findById(Integer id) throws IdAlunoException {

        Optional<Aluno>alunoOptional = chamadaRepository.findById(id);
        if (!alunoOptional.isPresent()) {
            throw new IdAlunoException();
        }
        return alunoOptional.get();
    }

    public List<Aluno> findByName (String name) throws NomeAlunoException {
        List<Aluno> alunos = chamadaRepository.findAll().stream()
                .filter(aluno -> aluno.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        if(alunos == null || alunos.isEmpty()){
            throw new NomeAlunoException();
        }
        return alunos;
    }
    public void deleteById(Integer id){
        chamadaRepository.deleteById(id);
    }

    public List<Aluno>findByAge(Integer age){
        return chamadaRepository.findAll().stream()
                .filter(aluno -> aluno.getAge() == age)
                .collect(Collectors.toList());
    }



}
