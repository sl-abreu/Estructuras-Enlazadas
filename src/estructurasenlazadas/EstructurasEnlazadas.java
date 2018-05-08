/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasenlazadas;

/**
 *
 * @author robot
 */
public class EstructurasEnlazadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EE<Integer> n=new EE(),n2=new EE();
        
        for(int i=1;i<10;i+=2)
            n.addLast(i);
        for(int j=2;j<17;j+=2)
            n2.addLast(j);
        System.out.println(n.toString());
        System.out.println(n2.toString());
        System.out.println(n.merge(n2));
        System.out.println(n.toString());
        System.out.println(n2.toString());
    }
    
}
