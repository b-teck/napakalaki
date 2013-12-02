/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napalalaki;

/**
 *
 * @author hugobarzano
 */
public class Prize {
    //Atributos
    private int treasures;
    private int level;
    
    //Constructor
    public Prize(int treasures,int level){
            this.treasures=treasures;
            this.level=level;
    }
    public Prize(Prize p){
            this.level=p.getLevel();
            this.treasures=p.getTreasures();
    }
    //Consultores
    public int getTreasures(){
            return this.treasures;
            
    }
    public int getLevel(){
            return this.level;
    }
   
    public String toString(){
            return "Treasure = " + Integer.toString(treasures)+ "levels= "+Integer.toString(level);
                   
    }
}
