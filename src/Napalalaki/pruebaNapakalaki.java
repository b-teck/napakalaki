/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napalalaki;
import java.util.ArrayList;


public class pruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String [] nombres = {"pablo","lucia","juanfra"};
        Napakalaki npk = Napakalaki.getInstance();
        npk.initGame(nombres);

        Dice dado = Dice.getInstance();
        int resDado = dado.nextNumber();

        Monster monstruo = new Monster("",0, null, null);

        if(npk.nextTurn()){
            monstruo=npk.getCurrentMonster();
            npk.getCurrentPlayer().combat(monstruo);
        }
    
    }
}

