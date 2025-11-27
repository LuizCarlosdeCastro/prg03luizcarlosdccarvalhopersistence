/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.curso.infrastructure.util;


public class StringUtil {
    
    public static boolean isNullOrEmpty(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}