/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

import estructurasenlazadas.*;

/**
 *
 * @author robot
 */
public class PilaEE<T> implements PilaADT<T> {
    private Node<T> tope;
    
    public PilaEE(){
        tope=null;
    }
    
    @Override
    public boolean isEmpty(){
        return tope==null;
    }
    @Override
    public void push(T dato){
        Node<T> nuevo=new Node(dato);
        
        nuevo.setLink(tope);
        tope=nuevo;
    }
    @Override
    public T pop(){
        T res=null;
        
        if(!isEmpty()){
            res=tope.getDato();
            tope=tope.getLink();
        }
        return res;
    }
    @Override
    public T peek(){
        T res=null;
        
        if(!isEmpty())
            res=tope.getDato();
        return res;
    }
    /*private EE<T> pila;
    
    public PilaEE(){
    pila=new EE();
    }
    
    @Override
    public void push(T dato){
    pila.addFirst(dato);
    }
    @Override
    public T pop(){
    return pila.removeFirst();
    }
    @Override
    public T peek(){
    return pila.iterator().next();
    }
    @Override
    public boolean isEmpty(){
    return pila.isEmpty();
    }*/

    @Override
    public boolean equals(PilaADT<T> otra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
