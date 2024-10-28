package com.rancho_smart.ms_alimentos.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALIMENTO")
public class Alimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlimento;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "TIPO")
    private TipoAlimento tipo;

    @Column(name = "COMPOSICION_NUTRICIONAL")
    private String composicionNutricional;

    @Column(name = "FECHA_CADUCIDAD")
    private LocalDate fechaDeCaducidad;

    @Column(name = "CANTIDAD_DISPONIBLE")
    private int cantidadDisponible;

    @Column(name = "PRECIO_POR_UNIDAD")
    private double precioPorUnidad;

    @ElementCollection
    private List<String> proveedores;

    public Alimento(Long idUsuario, String nombre, TipoAlimento tipo, String composicionNutricional,
            LocalDate fechaDeCaducidad, int cantidadDisponible, double precioPorUnidad, List<String> proveedores) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipo = tipo;
        this.composicionNutricional = composicionNutricional;
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.cantidadDisponible = cantidadDisponible;
        this.precioPorUnidad = precioPorUnidad;
        this.proveedores = proveedores;
    }

    public Alimento() {
    }

    public Long getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Long idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoAlimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlimento tipo) {
        this.tipo = tipo;
    }

    public String getComposicionNutricional() {
        return composicionNutricional;
    }

    public void setComposicionNutricional(String composicionNutricional) {
        this.composicionNutricional = composicionNutricional;
    }

    public LocalDate getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public void setFechaDeCaducidad(LocalDate fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public List<String> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<String> proveedores) {
        this.proveedores = proveedores;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }    
}
