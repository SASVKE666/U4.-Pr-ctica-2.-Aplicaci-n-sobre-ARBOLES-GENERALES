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
public class ArbolGeneral {
    NodoGeneral raiz;
    NodoGeneral padre;
    
    public ArbolGeneral(){
        raiz=null;
    }
    
    public boolean pushNodoGeneral(String path,char v){
        if(path.isEmpty()){
            if(raiz==null){
                raiz=new NodoGeneral(v);
                return true;
            }
            return false;
        }
        
        padre =buscarNodo(path);
        if(padre==null){
            return false;
        }
        
        NodoGeneral buscarhijo=buscarNodo(path+"/"+v);
        //si la busqueda me regresa un NULL se crea.
        //si la busqueda me regresa un !=NULL no se crea.
        if(buscarhijo!=null){
            return false;
        }
        buscarhijo=null;//Para que no ocupe espacio
        
        NodoGeneral hijo= new NodoGeneral(v);
        if(hijo==null){
            return false;
        }
        
        return padre.pushLiga(hijo);
        /*
        1.- raiz==null(pathvacio)
        2.- buscar padre, si es null return false
        3.- buscar repetido si existe return false
        4.- crear hijo si es null return false
        5.- return padre.pushLiga(hijo)
        */ 
    }
    
    protected NodoGeneral buscarNodo(String path){
        // considarar que el path enviado es /m  /m/w  /m/w/a
        if(path.isEmpty()){
            return null;
        }
        
        path=path.substring(1);
        //   m/w/a/f
        String[] vector=path.split("/");
        
        if(raiz.valor==vector[0].charAt(0)){
            
            if(vector.length==1){
                return raiz;
            }
            for(NodoLiga temp=raiz.ini;temp!=null;temp=temp.sig){
                if(temp.direccion.valor==vector[1].charAt(0)){
                    if(vector.length==2){
                        return temp.direccion;
                    }
                    return buscarNodo(temp.direccion, path.substring(3));
                }
            }
        }
        
        return null;
    }
    
    private NodoGeneral buscarNodo(NodoGeneral nodoE, String path){
        //CASO BASE
        if(path.isEmpty()){
            return nodoE;
        }
        
        path=path.substring(1);
        String vector[];
        if(path.length()==1){
            vector=new String[1];
            vector[0]=path;
        }else{
            vector=path.split("/");
        }
        
        for(NodoLiga temp=nodoE.ini;temp!=null;temp=temp.sig){
            if(temp.direccion.valor==vector[0].charAt(0)){
                buscarNodo(temp.direccion,path.substring(1));
            }
        }
        
        return null;
    }
    
    public boolean popNodoGeneral(String path){
        NodoGeneral hijo= buscarNodo(path);
        if(hijo==null){
            return false;
        }
        
        if(hijo==raiz){
            if(raiz.esHoja()){
                raiz=null;
                return true;
            }
            return false;
        }
        
        String pathPadre = obtenerPathPadre(path);
        
        NodoGeneral padre= buscarNodo(pathPadre);
        if(hijo.esHoja()){
            padre.popLiga(hijo);
            return true;
        }
        return false;
    }
    
    private String obtenerPathPadre(String path){
        int ultimaDiagonal=path.lastIndexOf("/")-1;
        return path.substring(0,ultimaDiagonal);
    }
    
    public String mostrar(){
        if(raiz.ini==null && raiz.fin==null){
            return "LISTA VACIA";
        }
        return mostrar(raiz.ini);
    }
    
    private String mostrar(NodoLiga temp){
        if(temp==null){
            return"";
        }
        return temp.direccion+" \n "+mostrar(temp.sig);
                
    }
    
    public String mostrarpadre(){
        
        //String pathPadre = obtenerPathPadre(path);
        
        if(padre.ini==null && padre.fin==null){
            return "LISTA VACIA";
        }
        return mostrar(raiz.ini);
    }
    
    private String mostrarpadre(NodoLiga temp){
        if(temp==null){
            return"";
        }
        return temp.direccion+" \n "+mostrar(temp.sig);
                
    }
}
