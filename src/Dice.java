/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki_final;


public class Dice {
    private static final Dice instance=new Dice();
    private Dice(){}
    public static Dice getInstance(){
        return instance;
    }
    //public int nextNumber(){}
        
    
}
