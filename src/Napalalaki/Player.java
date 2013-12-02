/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napalalaki;

import java.util.ArrayList;


public class Player {
    private boolean dead=true;
    private String name;
    private int level;
  
    private ArrayList<Treasure> hiddenTreasures=new ArrayList();
    private ArrayList<Treasure> visibleTreasures=new ArrayList();
    private BadStuff pendingBadStuff;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
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

    
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    
    
    private void bringToLive(){
        if(this.dead){
            this.dead=true;
        }
    }
    
    private void incrementLevels(int l){
        if (this.level<=4){
            this.level+=l;
        }
    }
    
    private void decrementLevels(int l){
        if (this.level>=1){
            this.level-=l;
        }
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

    private void setPendingBadStuff(BadStuff b){
        this.pendingBadStuff=b;
    }
    
    private void die(){
        this.setLevel(1);
        CardDealer dealer=null;
        dealer.getInstance();
        for( int i = 0 ; i <= this.visibleTreasures.size() ; i++ ){
           dealer.giveTreasureBack(this.visibleTreasures.get(i));
        }
        this.visibleTreasures.clear();
        for( int i = 0 ; i <= this.hiddenTreasures.size() ; i++ ){
           dealer.giveTreasureBack(this.hiddenTreasures.get(i));
        }
        this.hiddenTreasures.clear();
        this.dieIfNoTreasures();
        
    }
    
    private void dieIfNoTreasures(){
        if(this.hiddenTreasures.size()==0 && this.visibleTreasures.size()==0){
            this.dead=true;
        }else{
            this.dead=false;
        }
    }
   private int computeGoldCoinsValue(ArrayList<Treasure> t){
       int niveles=0 , monedas=0;
       for( int i = 0 ; i <= t.size() ; i++ ){
           monedas+=t.get( i ).getGoldCoins();
        }
       niveles=(int)monedas/1000;
       return niveles;
   }
   private boolean canIBuyLevels(int l){
       if(getLevels()+l<4){
           return true;
       }else{
           return false;
       }
   }
    
    
    public void applyPrize(Prize p){
        
        
    }
    //public CombatResult combat(Monster m){}
    public void applyBadStuff(BadStuff bad){
        int nLevels=this.getLevels();
        this.decrementLevels(nLevels);
        this.pendingBadStuff=bad.adjustToFitTreasureList(hiddenTreasures, hiddenTreasures);
        this.setPendingBadStuff(this.pendingBadStuff);
        
    }
//    public boolean makeTreasureVisible(Treasure t){}
//    public boolean canMakeTreasureVisible(Treasure t){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
//    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){}
    public boolean validState(){
        if(this.pendingBadStuff.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public void initTreasures(){
        CardDealer dealer = null;
        dealer.getInstance();
        Dice dice =null;
        dice.getInstance();
        
        if(this.isDeath()){
            this.bringToLive();
        }
        
        Treasure tesoro;
        
        int number=dice.nextNumber();
        int i=0;
        if(number==1){
            
        }else{
            if(number>1 && number<6){
                do{
                    tesoro=dealer.nextTreasure();
                    this.hiddenTreasures.add(tesoro);
                    i++;
                }while(i<=2);
                
            }else{
                if(number==6){
                    
                    do{
                        tesoro=dealer.nextTreasure();
                        this.hiddenTreasures.add(tesoro);
                        i++;
                    }while(i<=3);
                }
            }
        }
    }
    public boolean hasVisibleTreasures(){
        if(this.visibleTreasures.size()>0){
            return true;
        }else{
            return false;
        }
    }
    public int getLevels(){
        int nivel=0;
        boolean collar=false;
        for( int i = 0 ; i < visibleTreasures.size() ; i++ ){
            if(visibleTreasures.get( i ).getType()==TreasureKind.necklace){
                collar=true;
            }
        }
         for( int i = 0 ; i < this.hiddenTreasures.size() ; i++ ){
            if(this.hiddenTreasures.get( i ).getType()==TreasureKind.necklace){
                collar=true;
            }
        }
         if(collar){
            for( int i = 0 ; i < visibleTreasures.size() ; i++ ){
                nivel+=visibleTreasures.get( i ).getMaxBonus();
            }
            for( int i = 0 ; i < hiddenTreasures.size() ; i++ ){
                nivel+=hiddenTreasures.get( i ).getMaxBonus();
            }
         }else{
            for( int i = 0 ; i < visibleTreasures.size() ; i++ ){
                nivel+=visibleTreasures.get( i ).getMinBonus();
            }
            for( int i = 0 ; i < hiddenTreasures.size() ; i++ ){
                nivel+=hiddenTreasures.get( i ).getMinBonus();
            }
         }
         nivel+=this.level;
        return nivel;
    }       
    


public int howManyVisibleTreasures(TreasureKind tKind){
    int tesoros=0;
    for( int i = 0 ; i < visibleTreasures.size() ; i++ ){
            if(visibleTreasures.get( i ).getType()==tKind){
                tesoros++;
            }
        }
    return tesoros;
}

}
    

