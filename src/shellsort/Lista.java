/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shellsort;

/**
 *
 * @author logra
 */
public class Lista {
    
    Nodo inicio = null;
    Nodo fin = null;
    
    public Nodo crearNodo(int dato){
        Nodo nuevo = new Nodo();
        nuevo.anterior = null;
        nuevo.siguiente = null;
        nuevo.dato = dato;
        return nuevo;
    }
    

    public void insertar(int dato){
        Nodo nuevo = crearNodo(dato);
        if(isEmpty()){
            inicio = nuevo;
            fin = nuevo;
        }
        else{
            nuevo.anterior = fin;
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
    
    public void recorrer(){
        Nodo aux = inicio;
        while( aux != null ){
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        }
    }
    
    public Nodo encontrarPar(Nodo raiz, int distancia){        
        Nodo aux = raiz;
        for(int i = 0; i <= distancia; ++i){
            aux = aux.siguiente;
        } 
        return aux;
    }
    
    public void ordenar(int distancia){
        if(distancia <= 0 ){
            return;
        }else{
            int brecha = distancia / 2;
            Nodo parI = inicio;
            Nodo parF = encontrarPar(parI, brecha);
            while(parF != null){
                if(parI.dato >= parF.dato){
                    int temp = parI.dato;
                    parI.dato = parF.dato;
                    parF.dato = temp;
                }
                parI = parI.siguiente;
                parF = parF.siguiente;
            }
            ordenar(brecha);
        }
    }
    
       
    public void shellSort(){
        int tamano = tam(inicio);
        ordenar(tamano);
    }
    
    public int tam(Nodo raiz){
        Nodo aux = raiz;
        int cont = 0;
        while(aux != null){
            aux = aux.siguiente;
            cont++;
        }
        return cont;
    }
        
    public boolean isEmpty(){
        return (inicio == null) && (fin == null);
    }

}