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
    private BadStuff pendingBadStuff= new  BadStuff(" ",0,0,0);

    public boolean isDead() {
        if(dead){
            return true;
        }else{
            return false;
        }
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
        int bonus=0 , nivel=0;
        boolean esta=false;
        for(int i=0; i<=visibleTreasures.size();i++){
            if(this.visibleTreasures.get(i).getType()==TreasureKind.necklace){
               bonus+=this.visibleTreasures.get(i).getMaxBonus();
            }else{
               bonus+=this.visibleTreasures.get(i).getMinBonus();
            }
            nivel+=this.getLevels()+bonus;
            
        }
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
             if(visibleTreasures.get( i ).getType()==TreasureKind.necklace){
                 collar=visibleTreasures.get( i );
                 CardDealer.getInstance().giveTreasureBack(collar);
                 visibleTreasures.remove(i);
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
    public CombatResult combat(Monster m){
        CombatResult resultado=null;
        Napakalaki npk=Napakalaki.getInstance();
        Dice dado;
        BadStuff bs;
        boolean muerto;
        int nJugador=this.getLevels(), nMonster=npk.getCurrentMonster().getCombatLevel(), escapa=0;
        
        if(nJugador>nMonster){
            this.applyPrize(Napakalaki.getInstance().getCurrentMonster().getPr());
            if(Napakalaki.getInstance().getCurrentPlayer().getLevels()>=10){
                resultado=CombatResult.WinAndWinGame;
            }else{
                resultado=CombatResult.LoseAndDie;
                dado=Dice.getInstance();
                escapa=dado.nextNumber();
            }
            if(escapa<5){
                muerto=Napakalaki.getInstance().getCurrentMonster().kills();
                Napakalaki.getInstance().getCurrentMonster().getBs().MyBadStuffisDead();
                if(muerto){
                    this.die();
                    resultado=CombatResult.LoseAndDie;
                }else{
                    bs=Napakalaki.getInstance().getCurrentMonster().getBs();
                    resultado=CombatResult.Lose;
                    this.applyBadStuff(bs);
                }
            }
        }else{
            resultado=CombatResult.LoseAndScape;
            this.discardNecklaceVisible();
        }
        
        return resultado;
        
    }
    
    public void applyBadStuff(BadStuff bad){
        int nLevels=this.getLevels();
        this.decrementLevels(nLevels);
        this.pendingBadStuff=bad.adjustToFitTreasureList(hiddenTreasures, hiddenTreasures);
        this.setPendingBadStuff(this.pendingBadStuff);
        
    }
   public boolean makeTreasureVisible(Treasure t){
        if(this.canMakeTreasureVisible(t)){
            this.visibleTreasures.add(t);
            this.hiddenTreasures.remove(t);
            return true;
        }else{
            return false;
        }
       
   }

    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if((pendingBadStuff==null)&&pendingBadStuff.isEmpty()){
            pendingBadStuff.substractVisibleTreasure(t);
        }
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if((pendingBadStuff==null)&&pendingBadStuff.isEmpty()){
            pendingBadStuff.substractHiddenTreasure(t);
        }
        dieIfNoTreasures();
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        CardDealer dealer = CardDealer.getInstance(); 
        Treasure tesoro;
        if(this.canIBuyLevels(this.computeGoldCoinsValue(visible))){
            this.incrementLevels(this.computeGoldCoinsValue(visible));
            this.visibleTreasures.removeAll(visible);
            this.hiddenTreasures.removeAll(hidden);

            for(int i=0;i<=this.visibleTreasures.size();i++){
                tesoro = this.visibleTreasures.get(i);
                dealer.giveTreasureBack(tesoro);
            }

            for(int i=0;i<=this.hiddenTreasures.size();i++){
                tesoro = this.hiddenTreasures.get(i);
                dealer.giveTreasureBack(tesoro);
            }
            return true;
        }else{
            return false;
        }
    }
    
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
    

