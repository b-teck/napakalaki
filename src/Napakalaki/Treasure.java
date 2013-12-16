/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

public class Treasure implements Card{
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    public Treasure(String n,int g,int min,int max,TreasureKind t){
        name=n;
        goldCoins=g;
        minBonus=min;
        maxBonus=max;
    }
    public String getName(){
        return name;
    }
    public int getGoldCoins(){
        return goldCoins;
    }
    public int getMinBonus(){
        return minBonus;
    }
    public int getMaxBonus(){
        return maxBonus;
    }
    public TreasureKind getType(){
        return type;

    }
    
    public int getBasicValue(){
        return this.getMinBonus();
    }
    
    public int getSpecialValue(){
        return this.getMaxBonus();
    }
   
}
