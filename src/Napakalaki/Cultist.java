package Napakalaki;

abstract class Cultist implements Card{
    
    private String name;
    private int gainedLevels;
    
    public Cultist(String nombre, int niveles){
        name=nombre;
        gainedLevels=niveles;
    }
    
    public int getBasicValue(){
        return 1;
    }
}
