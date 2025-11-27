
        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery; 
import org.springframework.stereotype.Repository;



@Repository
public class CursoDao extends GenericDao<Curso> implements CursoIDao {
    
    @Override
    public Curso findByCodigo(String codigo) {
        
        try {
            String jpql = "SELECT c FROM Curso c WHERE c.codigoCurso = :codigo";
            
            TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
            query.setParameter("codigo", codigo);

            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

   
}
