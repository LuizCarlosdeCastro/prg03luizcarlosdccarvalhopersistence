/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;


public interface CursoIService {
    
    public Curso save(Curso curso);
    public void delete(Curso curso);
    public Curso update(Curso curso);
    public List<Curso> findAll();
    public Curso findById(Long id);
    public Curso findByCodigo(String codigo);
    
}