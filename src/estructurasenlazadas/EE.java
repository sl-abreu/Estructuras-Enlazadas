/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasenlazadas;

import java.util.Iterator;

/**
 *
 * @author robot
 */
public class EE<T> implements Iterable<T> {
    private Node<T> start;
    private Node<T> end;
    
    public EE(){
        start=null;
        end=null;
    }
    
    public boolean isEmpty(){
        return start==null;
    }
    public void addFirst(T dato){
        Node<T> nuevo=new Node(dato);
        
        nuevo.setLink(start);
        start=nuevo;
        if(end==null)
            end=nuevo;
    }
    public void addLast(T dato){
        Node<T> nuevo=new Node(dato);
        
        if(end==null)
            start=nuevo;
        else
            end.setLink(nuevo);
        end=nuevo;
    }
    public boolean addAfter(T dato, T ant){
        boolean res=false;
        Node<T> aux=searchNode(ant),nuevo;
        
        if(aux!=null){
            nuevo=new Node<T>(dato);
            nuevo.setLink(aux.getLink());
            aux.setLink(nuevo);
            res=true;
            if(aux==end)
                end=nuevo;
        }
        return res;
    }
    public boolean addBefore(T dato, T sig){
        boolean res=false;
                
        if(dato!=null && sig!=null && !isEmpty()){
            Node<T> nuevo;
            if(start.getDato().equals(sig)){
                res=true;
                nuevo=new Node(dato);
                nuevo.setLink(start);
                start=nuevo;
            }else{
                Node<T> ant=start,act=start.getLink();
                while(act!=null && !act.getDato().equals(sig)){
                    ant=act;
                    act=act.getLink();
                }
                if(act!=null){
                    res=true;
                    nuevo=new Node(dato);
                    ant.setLink(nuevo);
                    nuevo.setLink(act);
                }
            }
        }
        return res;
    }
    public T removeFirst(){
        T res=null;
                
        if(start!=null){
            Node<T> aux=start;
            
            res=start.getDato();
            if(start==end)  //hay un solo nodo
                end=null;
            start=start.getLink();
            aux.setLink(null);
            aux=null;
        }
        return res;
    }
    public T removeLast(){
        T res=null;
        Node<T> temp=start;
        
        if(!isEmpty()){
            res=end.getDato();
            if(start!=end){
                while(temp.getLink()!=end)
                    temp=temp.getLink();
                temp.setLink(null);
                end=temp;
            }
            else{
                end=null;
                start=null;
            }
        }
        return res;
    }
    public T removeBefore(T sig){
        T res=null;
        
        if(sig!=null && !isEmpty() && start!=end && !start.getDato().equals(sig)){
            if(start.getLink().getDato().equals(sig))
                res=removeFirst();
            else{
                Node<T> ap=start;
                while(ap.getLink().getLink()!=null && !ap.getLink().getLink().getDato().equals(sig))
                    ap=ap.getLink();
                if(ap.getLink().getLink()!=null){
                    Node<T> temp=ap.getLink();
                    
                    ap.setLink(temp.getLink());
                    temp.setLink(null);
                    res=temp.getDato();
                }
            }
        }
        return res;
    }
//    public T remove(T dato){
//        Node<T> temp;
//        
//        
//    }
    
    public T search(T dato){
        Iterator<T> it=iterator();
        T temp,res=null;
        boolean aux=false;
        
        while(!aux && it.hasNext()){
            temp=it.next();
            if(temp.equals(dato)){
                aux=true;
                res=temp;
            }
        }
        return res;
    }
    
    public T searchR(T dato){
        T res=null;
        
        if(dato!=null && !isEmpty()){
            if(dato.equals(start.getDato()))
                res=start.getDato();
            else if(dato.equals(end.getDato()))
                res=end.getDato();
            else
                res=searchR(dato,start.getLink());
        }
        return res;
    }
    private T searchR(T dato, Node nodo){
        if(dato.equals(nodo.getDato()))
            return (T) nodo.getDato();
        else if(nodo.getLink()!=null)
            return searchR(dato,nodo.getLink());
        else
            return null;
    }
    
    private Node searchNode(T dato){
        Node res=null;
        
        if(dato!=null && !isEmpty()){
            if(dato.equals(start.getDato()))
                res=start;
            else if(dato.equals(end.getDato()))
                res=end;
            else
                res=searchNode(dato,start.getLink());
        }
        return res;
    }
    private Node searchNode(T dato, Node nodo){
        if(dato.equals(nodo.getDato()))
            return nodo;
        else if(nodo.getLink()!=null)
            return searchNode(dato,nodo.getLink());
        else
            return null;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new IteratorEE(start);
    }
    
    @Override
    public String toString(){
        StringBuilder cad=new StringBuilder();
        Node<T> ap=start;
        
        return toString(ap,cad);
    }
    private String toString(Node<T> ap,StringBuilder cad){
        if(ap==null)
            return cad.toString();
        else{
            cad.append(ap.getDato()+"\t");
            return toString(ap.getLink(),cad);
        }
    }
/*  Versión no recursiva pero ilustrativa del uso de nodos
    @Override
    public String toString(){
        StringBuilder cad=new StringBuilder();
        Node<T> ap=start;
        
        while(ap!=null){
            cad.append(ap.getDato());
            ap=ap.getLink();
        }
        return cad.toString();
    }
*/
}
