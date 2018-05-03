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
        EE<String> nombs=new EE();
        
        nombs.addFirst("Juan");
        nombs.addFirst("Pedro");
        nombs.addLast("María");
        System.out.println(nombs.toString());
        System.out.println(nombs.removeFirst());
        System.out.println(nombs.toString());
    }
    
}
