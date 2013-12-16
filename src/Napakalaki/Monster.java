/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;


public class Monster implements Card{
    private String name;
    private int combatLevel;
    private Prize p;
    private BadStuff bs;
    private int levelChangeAgainstCultistPlayer;
    //Constructor
    public Monster(String name,int level,BadStuff bc, Prize price,int levelC){
            this.name=name;
            this.combatLevel=level;
            this.bs= new BadStuff(bc);
            this.p=new Prize(price);
            this.levelChangeAgainstCultistPlayer=levelC;
    }
    
    //Consultores
    public String getName(){
            return this.name;
    }
    public int getCombatLevel(){
        return this.combatLevel;
    }

    public int getLevelChangeAgainstCultistPlayer() {
        return levelChangeAgainstCultistPlayer;
    }

    
    public String toString(){
            return name + "\n\n Nivel de combate = " + Integer.toString(combatLevel)+ "\nBadStuff= "+bs.toString()+"\nPrize= "+ p.toString(); 
    }
    public BadStuff getBs(){
           return this.bs;
    }
    public Prize getPr(){
            return this.p;
    }
    public boolean kills(){
       
         if( bs.getDeath() == true)
             return true;
         else
             return false;
    }
    
    public int getLevelsGained(){
        return p.getTreasures();
    }
    
    public int getBasicValue(){
        return this.getCombatLevel();
    }
    
    public int getSpecialValue(){
        return this.getLevelsGained()+this.getLevelChangeAgainstCultistPlayer();
    }

}
