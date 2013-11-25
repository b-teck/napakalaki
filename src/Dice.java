/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;


public class Dice {
    private static final Dice instance=new Dice();
    private Dice(){}
    public static Dice getInstance(){
        return instance;
    }
    public Random nextNumber(){
    
       Random dado =new Random();
       
       return dado;
    }
    //public int nextNumber(){}
        
    
}
