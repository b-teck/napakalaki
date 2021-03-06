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
    public BadStuff(BadStuff bad){
        this.text=bad.getText();
        this.levels=bad.getLevels();
        this.nHiddenTreasures=bad.getNHiddenTreasures();
        this.nVisibleTreasures=bad.getNVisibleTreasures();
        this.specificHiddenTreasures=(ArrayList<TreasureKind>) bad.specificHiddenTreasures.clone();
        this.specificVisibleTreasures=(ArrayList<TreasureKind>) bad.specificVisibleTreasures.clone();
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
    public void substractVisibleTreasure(Treasure t){
        for(int i=0;i<=this.specificVisibleTreasures.size();i++){
            if(this.specificVisibleTreasures.get(i).equals(t.getType())){
                this.specificVisibleTreasures.remove(i);
            }
    }
    }
    public void substractHiddenTreasure(Treasure t){
        for(int i=0;i<=this.specificHiddenTreasures.size();i++){
            if(this.specificHiddenTreasures.get(i).equals(t.getType())){
                this.specificHiddenTreasures.remove(i);
            }
    }
        
    }
    public BadStuff adjustToFitTreasureList(ArrayList<Treasure> v,ArrayList<Treasure> h){
     BadStuff badstuff=new BadStuff(null,0,new ArrayList(),new ArrayList());
        
        for(int i=0;i<specificHiddenTreasures.size();i++){
            for(int j=0;j<h.size();j++){
            if(specificHiddenTreasures.get(i)==h.get(j).getType())
                badstuff.specificHiddenTreasures.add(h.get(j).getType());
            }
        }   
        for(int z=0;z<specificVisibleTreasures.size();z++){
            for(int j=0;j<v.size();j++){
                if(specificVisibleTreasures.get(z)==v.get(z).getType())
                    badstuff.specificVisibleTreasures.add(v.get(j).getType());
            }
        }    
        return badstuff;
        
    }

    
    public boolean getDeath(){
        return this.death;
    }
     public String toString(){
            return text+"Levels= " + Integer.toString(levels)+ "\nNumero Tesoros Visibles "+Integer.toString(nVisibleTreasures)+ "\nNumero Tesoros ocultos"+Integer.toString(nHiddenTreasures);
}
}
