/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;


public interface CursoIController {
    
    public List<Curso> findAll();
    public Curso save(Curso curso);
    public Curso update(Curso curso);
    public void delete(Curso curso);
    public Curso findById(Long id);
    
    
}