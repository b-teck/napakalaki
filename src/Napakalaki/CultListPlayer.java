/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Napakalaki;

/**
 *
 * @author juanfra
 */
public class CultListPlayer extends Player {
    private int totalCultListPlayer = 0;
    CultList myCultlist=null;
    
    public CultListPlayer(Player p , CultList c){
        super(p);
        super.setName(p.getName());
        this.cultList=c;
    }
    
    public int getCombatLevel(){
        return super.getCombatLevel();
    }
    
    public boolean shouldConvert(){
        return true;
    }
    public int getOponentLevel(Monster m){
        return 1;
    }
    public int computeGoldCoinsValue(Treasure [] t){
        return 1;
    }
    public int getTotalCultListPlayers(){
        return 1;
    }
}
