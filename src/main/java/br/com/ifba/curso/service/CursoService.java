/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.infrastructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CursoService implements CursoIService {
    
    @Autowired
    private CursoIDao cursoDao;
    
     @Override
    public Curso save(Curso curso){
        if (StringUtil.isNullOrEmpty(curso.getNome())){
            
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
            
        }
       
        if(StringUtil.isNullOrEmpty(curso.getCodigoCurso())){
            
            
            throw new RuntimeException("Curso " + "já existente no banco de dados.");
        }
        
        
            return cursoDao.save(curso);
        
    }
    
    @Override
    public void delete(Curso curso) throws RuntimeException{
        if(curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else if(curso.getId() == null){
            throw new RuntimeException("Curso não existente no banco de dados");
        }else{
            cursoDao.delete(curso);
        }
    }
    
    @Override
    public Curso update(Curso curso) throws RuntimeException{
        if(curso == null){
            throw new RuntimeException("Dados do " + "curso não preenchidos.");
        }else{
            return cursoDao.update(curso);
        }
    }
    
    @Override
    public List<Curso> findAll() throws RuntimeException{
       return cursoDao.findAll();
    }
    
    @Override
    public Curso findById(Long id) throws RuntimeException{
        return cursoDao.findById(id);
    }
    
    @Override
    public Curso findByCodigo(String codigo) throws RuntimeException{
        return cursoDao.findByCodigo(codigo);
    }
}
