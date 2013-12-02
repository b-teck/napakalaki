/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napalalaki;
import java.util.ArrayList;


public class pruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        ArrayList<Monster> monsters = new ArrayList();
       // Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que 
      //tengan un nivel de combate superior a 10.
        for(int i=0;i<monsters.size();i++){
                if(monsters.get(i).getCombatLevel()>10)
                     System.out.println(monsters.get(i).toString());
        }
        
        //Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que 
       //tengan un mal rollo que implique sólo pérdida de niveles
        
        for(int i=0;i<monsters.size();i++){
            if(monsters.get(i).getBs().getNHiddenTreasures()==0 && monsters.get(i).getBs().getNVisibleTreasures()==0 && monsters.get(i).getBs().getLevels()>0)
                System.out.println( monsters.get(i).toString());
        }
       // Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que 
       // tengan un buen rollo que indique una ganancia de niveles superior a 1
        for(int i=0;i<monsters.size();i++){
                if(monsters.get(i).getPr().getLevel()>1)
                     System.out.println(monsters.get(i).toString());
        }
        
      //  Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que 
      //  tengan un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya 
     //sea visibles y/o ocultos.
        for(int i=0;i<monsters.size();i++){
            if(monsters.get(i).getBs().getNHiddenTreasures()!=0 || monsters.get(i).getBs().getNVisibleTreasures()!=0)
               System.out.println(monsters.get(i).toString());
        }
        System.out.println("\nFIN DE LA MAZMORRA\n");
            
        }
    }

