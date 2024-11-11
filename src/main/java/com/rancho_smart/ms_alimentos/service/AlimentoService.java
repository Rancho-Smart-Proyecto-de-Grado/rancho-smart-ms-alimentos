package com.rancho_smart.ms_alimentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_alimentos.entity.Alimento;
import com.rancho_smart.ms_alimentos.repository.AlimentoRepository;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public List<Alimento> getAlimentos() {
        return this.alimentoRepository.findAll();
    }

    public List<Alimento> getAlimentosByIdFinca(Long idFinca){
        return this.alimentoRepository.findByIdFinca(idFinca);
    }

    public List<Alimento> getAlimentosByIdUsuario(Long idUsuario){
        return this.alimentoRepository.findByIdUsuario(idUsuario);
    }
    public Optional<Alimento> getAlimentoById(Long id) {
        return this.alimentoRepository.findById(id);
    }

    public Alimento saveAlimento(Alimento alimento) {
        return this.alimentoRepository.save(alimento);
    }

    public void deleteAlimento(Long id) {
        this.alimentoRepository.deleteById(id);
    }
}
