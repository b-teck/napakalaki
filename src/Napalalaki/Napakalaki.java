package Napakalaki;


import java.util.ArrayList;
import java.util.Random;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Napakalaki {
    private static final Napakalaki instance=new Napakalaki();
    private Napakalaki(){}
    private void initPlayers(ArrayList<String> nombres){}
    //private Player nextPlayer(){}
    
    //Dependencias
    private Monster currentMonster;
    private ArrayList<Player> players=new ArrayList();
    private ArrayList<Monster> monsters = new ArrayList();
    private Player currentPlayer;
    private CardDealer dealer;
    private int nJugadores;
    private int indexCurrentPlayer;
    private int indexCurrentMonster;
    
    
    public static Napakalaki getInstance(){
        return instance;
    }

    private void initPlayers(String [] names){
        for(int i=0; i<=names.length;i++){
            players.add(new Player(names[i]));
        }
        nJugadores=names.length;
    }
    private void nextPlayer(){
        if(currentPlayer==null){
            Random r =new Random();
            indexCurrentPlayer=r.nextInt(nJugadores);
            currentPlayer=players.get(indexCurrentPlayer);
        }else{
            indexCurrentPlayer=(indexCurrentPlayer+1)%nJugadores;
        }
    }
    public Player getCurrentPlayer(){
        return players.get(indexCurrentPlayer);
    }
    public Monster getCurrentMonster(){
        return monsters.get(indexCurrentMonster);
    }

    public CombatResult developCombat(){
        CombatResult result = currentPlayer.combat(currentMonster);
        return result;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        Treasure tesoroVi;
        for(int i=0;i<treasures.size();i++){
           tesoroVi=treasures.get(i);
           currentPlayer.discardVisibleTreasure(tesoroVi);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        Treasure tesoroHi;
        for(int i = 0; i<treasures.size(); i++){
            tesoroHi = treasures.get(i);
            currentPlayer.discardHiddenTreasure(tesoroHi);
        }
    }
    
    public void makeTreasuresVisibles(ArrayList<Treasure> treasures){
            for(int i=1;i<=treasures.size();i++){
            Treasure tesoro=treasures.get(i);
            currentPlayer.makeTreasureVisible(tesoro);
        }
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible,ArrayList<Treasure> hidden){
        boolean comprar = currentPlayer.buyLevels(visible, hidden);
        return comprar;
    }
    public void initGame(String [] jugadores){
        dealer.initCards();
        
        if(jugadores.length < 3 || jugadores.length > 4)
            throw new Error("Numero de jugadores incorrecto");
        
        initPlayers(jugadores);
        this.nextTurn();
        
        /*String noms[];
        noms = new String[3];
        for(int i =0;i<=jugadores.length;i++){
            noms[i]=jugadores[i];*/
        }
    }

//    public boolean canMakeTreasureVisible(Treasure t){}

    public void nextTurn(){
        boolean stateOK = this.nextTurnAllowed();
        
        if (stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            boolean dead = currentPlayer.isDead();
            
            if (dead){
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    public boolean nextTurnAllowed(Player jugador){
        if(currentPlayer == null){
            return true;
        }else{
            return currentPlayer.validState();
        }
    }
    public boolean endOfGame(CombatResult result){
        if(result == CombatResult.WinAndWinGame){
            return true;
        }else{
            return false;
        }
            
        
    }
    
    
    
}