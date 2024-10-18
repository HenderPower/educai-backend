package br.itb.tcc.educai.controller;


import br.itb.tcc.educai.exceptions.BadRequest;
import br.itb.tcc.educai.model.Laudo;
import br.itb.tcc.educai.service.LaudoService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/diretor")
public class DiretorController {


    private final LaudoService laudoService;


    public DiretorController(LaudoService laudoService) {
        this.laudoService = laudoService;
    }

    @GetMapping("/laudo")
    public ResponseEntity<List<Laudo>> listarTodosLaudos() {
        return ResponseEntity.ok().body(laudoService.listarTodosLaudos());
    }

    @GetMapping("/laudo/{id}")
    public ResponseEntity<Laudo> buscarLaudoPorId(@PathVariable(value = "id") String id) {
        try {
            return ResponseEntity.ok().body(laudoService.buscarLaudoPorId(Long.parseLong(id)));

        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como por exemplo 1517.");
        }

    }
    @PostMapping("/laudo")
    @Transactional
    public ResponseEntity<Laudo> salvarLaudo(@RequestBody Laudo laudo) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/diretor/laudo").toUriString());
        return ResponseEntity.created(uri).body(laudoService.salvarLaudo(laudo));
    }

    @PutMapping("/laudo/{id}")
    @Transactional
    public ResponseEntity<Laudo> atualizarLaudo(@RequestBody Laudo laudo, @PathVariable (value = "id") String id) {
        try {
            return ResponseEntity.ok().body(laudoService.atualizarLaudo(laudo, Long.parseLong(id)));

        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 1517.");
        }
    }

    // Object : Representa qualquer tipo de Classe (objeto)
    @DeleteMapping("/laudo/{id}")
    @Transactional
    public ResponseEntity<Object> deletarLaudo(@PathVariable(value = "id") String id) {
        try{
            if(laudoService.deletarLaudo(Long.parseLong(id))) {
                return ResponseEntity.ok().body("Laudo com o id " + id + " excluída com sucesso");
            }
        }catch (NumberFormatException ex) {

            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 1517.");
        }

        return ResponseEntity.ok().body("Não foi possível a exclusão do laudo com o id " + id);
    }

}
