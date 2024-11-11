package com.rancho_smart.ms_alimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_alimentos.entity.Alimento;
import java.util.List;


@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
    public List<Alimento> findByIdFinca(Long idFinca);
    public List<Alimento> findByIdUsuario(Long idUsuario);
}
