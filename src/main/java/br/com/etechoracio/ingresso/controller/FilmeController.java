package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.FilmeResponseDTO;
import br.com.etechoracio.ingresso.entity.Filme;
import br.com.etechoracio.ingresso.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin("*")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<FilmeResponseDTO> findAll() {
        return filmeService.findAll();
    }

    @PostMapping
    public ResponseEntity<Filme> create(@RequestBody Filme dto) {
        var filmeCriado = filmeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeCriado);
    }

}
