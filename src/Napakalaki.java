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


    //public CombatResult developCombat(){}
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){}
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){}
    public void makeTreasuresVisibles(ArrayList<Treasure> treasures){}
    //public boolean buyLevels(ArrayList<Treasure> visible,ArrayList<Treasure> hidden){}
    public void initGame(ArrayList<String> jugadores){}
//    public Player getCurrentPlayer(){}
//    public Monster getCurrentMonster(){}
//    public boolean canMakeTreasureVisible(Treasure t){}
//    public void nextTurn(){}
    public boolean nextTurnAllowed(Player jugador){
        if(jugador.validState()){
            return true;
        }else{
            return false;
        }
    }
    public boolean endOfGame(CombatResult result){
        if(result == CombatResult.WinAndWinGame){
            return true;
        }else{
            return false;
        }
            
        
    }
//    
    
    
    
}
