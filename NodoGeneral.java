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
public class NodoGeneral {
    char valor;
    NodoLiga ini;
    NodoLiga fin;
    
    public  NodoGeneral(char x){
        valor=x;
        ini=null;
        fin=null;
    }
    
    //la direccion de tipo NodoG se obtiene a travez del path
    public boolean pushLiga(NodoGeneral destino){
        
        NodoLiga temp=new NodoLiga(destino);
        
        if(temp==null){
            return false;
        }
        
        if(ini==null && fin== null){
            ini=fin=temp;
            return true;
        }
        
        fin.sig=temp;
        temp.ant=fin;
        fin=temp;
        return true;
    }
    
   public boolean popLiga(NodoGeneral d){
       if(ini==null && fin== null){
            return false;
        }
        
        if(ini==fin && ini.direccion==d){
                fin=ini=null;   
            return true;
        }
        
        if(ini.direccion==d){
            NodoLiga temp=ini.sig;
            ini.sig=null;
            temp.ant=null;
            ini=temp;
            return true;
        }
        
        if(fin.direccion==d){           
            NodoLiga temp=fin.ant;
            temp.sig=null;
            fin.ant=null;
            fin=temp;
            return true;  
        }

        for(NodoLiga temp=ini.sig; temp!=fin; temp=temp.sig ){ 
            if(temp.direccion==d){
                
                temp.ant.sig=temp.sig;
                temp.sig.ant=temp.ant;
                temp.ant=null;
                temp.sig=null;
                return true; 
            }
        } 
        return false;
   }
   
   public boolean esHoja(){
       return ini==null && fin ==null;
   }

    public String mostrar(){
        if(ini==null && fin==null){
            return "LISTA VACIA";
        }
        return mostrar(ini);
    }
    
    private String mostrar(NodoLiga temp){
        if(temp==null){
            return"";
        }
        return temp.direccion+" \n "+mostrar(temp.sig);
                
    }   

}
