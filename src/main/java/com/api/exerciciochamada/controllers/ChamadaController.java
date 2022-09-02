package com.api.exerciciochamada.controllers;

import com.api.exerciciochamada.dto.AlunoDto;
import com.api.exerciciochamada.exceptions.GenericControllerAdvice;
import com.api.exerciciochamada.exceptions.IdAlunoException;
import com.api.exerciciochamada.exceptions.NomeAlunoException;
import com.api.exerciciochamada.models.Aluno;
import com.api.exerciciochamada.services.ChamadaSevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamada-db")
public class ChamadaController {

    @Autowired
    ChamadaSevice chamadaSevice;

    @PostMapping
    public ResponseEntity<Object> saveAluno( @RequestBody AlunoDto alunoDto ) {
        Aluno aluno = new Aluno();
        // Converte o alunoDto para aluno
        BeanUtils.copyProperties(alunoDto, aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(chamadaSevice.save(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(chamadaSevice.findAll());
    }

    @GetMapping("/forid/{id}")
    public ResponseEntity<Object> findById( @PathVariable Integer id ) throws IdAlunoException {
        return ResponseEntity.status(HttpStatus.OK).body(chamadaSevice.findById(id));
    }

    @GetMapping("/forname")
    public ResponseEntity<List<Aluno>> forName( @RequestParam String name ) throws NomeAlunoException {
        return ResponseEntity.status(HttpStatus.OK).body(chamadaSevice.findByName(name));
    }

    @GetMapping("/forage")
    public ResponseEntity<List<Aluno>> forAge( @RequestParam(name = "age") Integer age ) {
        return ResponseEntity.status(HttpStatus.OK).body(chamadaSevice.findByAge(age));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById( @PathVariable Integer id ) {
        chamadaSevice.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
