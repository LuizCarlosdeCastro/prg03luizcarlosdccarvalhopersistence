/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity 
@Table( name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Curso extends PersistenceEntity implements Serializable {


    
    private String nome;

 
    private String codigoCurso;

   @Column(name = "ativo", nullable = false)
    private boolean ativo = true;
   
   @Column(name = "status", nullable = false)
    private String status = "Ativo";

   
   
    
}
