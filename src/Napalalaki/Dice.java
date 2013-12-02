/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Napalalaki;
import java.util.*;

public class Dice {
    private static final Dice instance=null;
    private Dice(){}
    public static Dice getInstance(){
        return instance;
    }
    public int nextNumber(){
    
       
        int dado = (int)Math.floor(Math.random()*6+1);
       
       return dado;
    }

        
    
}
