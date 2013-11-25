/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;

public class BadStuff {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind>specificHiddenTreasures=new ArrayList();
    private ArrayList<TreasureKind>specificVisibleTreasures=new ArrayList();
    //Contrtructore
    public BadStuff(String text,int levels,int nVisible,int nHidden){
        this.text=text;
        this.levels=levels;
        this.nVisibleTreasures=nVisible;
        this.nHiddenTreasures=nHidden;
    }
    public BadStuff(String text,boolean death){
        this.text=text;
        this.death=death;
    }
    public BadStuff(String text,int levels,ArrayList<TreasureKind> tVisible,ArrayList<TreasureKind> tHidden){
            this.text=text;
            this.levels=levels;
            this.specificVisibleTreasures=(ArrayList<TreasureKind>) tVisible.clone();
            this.specificHiddenTreasures=(ArrayList<TreasureKind>) tHidden.clone();
    }
    public BadStuff(BadStuff bc){
        this.text=bc.getText();
        this.levels=bc.getLevels();
        this.nHiddenTreasures=bc.getNHiddenTreasures();
        this.nVisibleTreasures=bc.getNVisibleTreasures();
        this.specificHiddenTreasures=(ArrayList<TreasureKind>) bc.specificHiddenTreasures.clone();
        this.specificVisibleTreasures=(ArrayList<TreasureKind>) bc.specificVisibleTreasures.clone();
    }
    
    public boolean isEmpty(){
        if(this.text.equals("") && this.levels==0 && this.nHiddenTreasures==0 && this.nVisibleTreasures==0){
            return true;
        }else{
            return false;
        }
    }
    public boolean MyBadStuffisDead(){
         if( death == true)
             return true;
         else
             return false;
}
//    public boolean kills(){}
    
    //Consultores
    public String getText(){
            return this.text;
    }
    public int getLevels(){
        return this.levels;
    }
    public int getNVisibleTreasures(){
            return this.nVisibleTreasures;
    }
    public int getNHiddenTreasures(){
            return this.nHiddenTreasures;
    }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
     public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    public void substractVisibleTreasure(Treasure t){}
    public void substractHiddenTreasure(Treasure t){}
    //public BadStuff adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){}

    
    public boolean getDeath(){
        return this.death;
    }
     public String toString(){
            return text+"Levels= " + Integer.toString(levels)+ "\nNumero Tesoros Visibles "+Integer.toString(nVisibleTreasures)+ "\nNumero Tesoros ocultos"+Integer.toString(nHiddenTreasures);
}
}
