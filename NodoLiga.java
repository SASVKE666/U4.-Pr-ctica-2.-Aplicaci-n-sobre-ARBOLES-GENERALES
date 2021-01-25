/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbolgeneral;

/**
 *
 * @author REAL
 */
public class NodoLiga {
    NodoGeneral direccion;
    NodoLiga sig;
    NodoLiga ant;
    
    public NodoLiga(NodoGeneral destino){
        direccion=destino;
        sig=null;
        ant=null;
    }
}
