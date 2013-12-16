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
    private Cultist myCultist;
    
    public CultListPlayer(Player p , Cultist c){
        super(p);
        super.setName(p.getName());
        this.myCultist = c;
    }
    
    public int getCombatLevel(){
        return super.getCombatLevel()+this.myCultist.;
    }
    
    public boolean shouldConvert(){
        return true;
    }
    public int getOponentLevel(Monster m){
        return 187878;
    }
    public int computeGoldCoinsValue(Treasure [] t){
        return 1;
    }
    public int getTotalCultListPlayers(){
        return 1;
    }
}
