package com.rancho_smart.ms_alimentos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_alimentos.entity.Alimento;
import com.rancho_smart.ms_alimentos.service.AlimentoService;

@RestController
@RequestMapping(path = "/alimentos")
public class AlimentoRESTController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    public ResponseEntity<List<Alimento>> getAllAlimentos() {
        List<Alimento> listado = this.alimentoService.getAlimentos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimento> getAlimentoById(@PathVariable Long id) {
        Optional<Alimento> alimento = this.alimentoService.getAlimentoById(id);
        return alimento.map(ResponseEntity::ok)
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<Alimento>> getAlimentosByIdFinca(@PathVariable Long idFinca){
        List<Alimento> alimentosFinca = this.alimentoService.getAlimentosByIdFinca(idFinca);
        if(alimentosFinca.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(alimentosFinca, HttpStatus.OK);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Alimento>> getAlimentosByIdUsuario(@PathVariable Long idUsuario){
        List<Alimento> alimentosUsuario = this.alimentoService.getAlimentosByIdUsuario(idUsuario);
        if(alimentosUsuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(alimentosUsuario, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Alimento> saveAlimento(@RequestBody Alimento alimento) {
        Alimento alimentoCreado = this.alimentoService.saveAlimento(alimento);
        return new ResponseEntity<>(alimentoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alimento> updateAlimento(@PathVariable Long id, @RequestBody Alimento alimento) {
        if (!this.alimentoService.getAlimentoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            alimento.setIdAlimento(id);
            Alimento alimentoActualizado = this.alimentoService.saveAlimento(alimento);
            return new ResponseEntity<>(alimentoActualizado, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlimento(@PathVariable Long id) {
        if (!this.alimentoService.getAlimentoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.alimentoService.deleteAlimento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
