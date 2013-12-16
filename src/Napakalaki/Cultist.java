package Napakalaki;

abstract class Cultist implements Card{
    
    private String name;
    private int gainedLevels;
    
    public Cultist(String nombre, int niveles){
        name=nombre;
        gainedLevels=niveles;
    }
    public int getGainedLevels(){
        return gainedLevels;
    }
    public int getBasicValue(){
        return getGainedLevels();
    }
    public int getSpecialValue(){
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
}
