/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;


public class Player {
    private boolean dead=true;
    private String name;
    private int level;
  
    private ArrayList<Treasure> hiddenTreasures=new ArrayList();
    private ArrayList<Treasure> visibleTreasures=new ArrayList();
    private BadStuff pendingBadStuff;

    public Player(String name){
            this.name=name;
    }
      public boolean isDeath(){

          if(dead){
            return true;
        }else{
              return false;
        }
      }

    public int getCombatLevel(){
        int nivel=0;
        for( int i = 0 ; i <= hiddenTreasures.size() ; i++ ){
           nivel+=hiddenTreasures.get( i ).getMaxBonus();
        }
         for( int i = 0 ; i <= visibleTreasures.size() ; i++ ){
           nivel+=visibleTreasures.get( i ).getMaxBonus();
        }
        nivel+=this.level;
        return nivel;
    }

    public boolean canMakeTreasureVisible(Treasure t ){
        boolean puede=false;
         for( int i = 0 ; i < hiddenTreasures.size() ; i++ ){
             if(hiddenTreasures.get( i ).equals(t) && hiddenTreasures.size()>4){
                 puede=true;
                 break;
             }
        }
        return puede;
    }

    
  //  public ArrayList<Treasure> getHiddenTreasures(){}
//    public ArrayList<Treasure> getVisibleTreasures(){}
    
    
    private void bringToLive(){
        if(this.dead){
            this.dead=true;
        }
    }
    
    private void incrementLevels(int l){
        this.level+=l;
    }
    
    private void decrementLevels(int l){
        this.level-=l;
    }

    private void discardNecklaceVisible(){
        Treasure collar;
        for( int i = 0 ; i < visibleTreasures.size() ; i++ ){
             if(visibleTreasures.get( i ).getType().toString().equals("necklace")){
                 collar=visibleTreasures.get( i );
                 visibleTreasures.remove(i);
                 //falta pasar a BadStuff s
                 
             }
        }
    }

    private void setPendingBadStuff(BadStuff b){}
    private void die(){}
    
    private void dieIfNoTreasures(){}
//    private int computeGoldCoinsValue(ArrayList<Treasure> t){}
//    private boolean canIBuyLevels(float l){}
    
    
    public void applyPrize(Prize p){}
    //public CombatResult combat(Monster m){}
    public void applyBadStuff(BadStuff bad){}
//    public boolean makeTreasureVisible(Treasure t){}
//    public boolean canMakeTreasureVisible(Treasure t){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
//    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){}
//    public boolean validState(){}
//    public boolean initTreasures(){}
//    public boolean hasVisibleTreasures(){}
    public int getLevels(){
        return level;
    }            
}
    

