/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;
import java.util.Collections;

public class CardDealer {
    private static final CardDealer instance=null;
    private CardDealer(){}
    private ArrayList<Monster> unusedMonsters=new ArrayList();
    private ArrayList<Monster> usedMonsters=new ArrayList();
    private ArrayList<Treasure> unusedTreasures=new ArrayList();
    private ArrayList<Treasure> usedTreasures=new ArrayList();
    
   
    
    //Mazo de tesoros:
    
    private void initTreasureCardDeck(){
        
        //Si mi amo
    Treasure Si_mi_amo=new Treasure("¡Si mi amo!",0,4,7,TreasureKind.helmet);
    unusedTreasures.add(Si_mi_amo);
        //Botas de investigacion
    Treasure Botas_inv=new Treasure("Botas de Investigacion",600,3,4,TreasureKind.shoe);
    unusedTreasures.add(Botas_inv);
        //Capucha de cthulhu
    Treasure Capucha_cthulhu=new Treasure("Capucha de Cthulhu",500,3,5,TreasureKind.helmet);
    unusedTreasures.add(Capucha_cthulhu);
        //A prueba de babas
    Treasure Babas=new Treasure("A prueba de babas",400,2,5,TreasureKind.armor);
    unusedTreasures.add(Babas);
        //Botas de lluvia acida
    Treasure Botas=new Treasure("Botas de Lluvia Acida",800,1,1,TreasureKind.bothHand);
    unusedTreasures.add(Botas);
        //Casco Minero
    Treasure C_minero=new Treasure("Casco Minero",400,2,4,TreasureKind.helmet);
    unusedTreasures.add(C_minero);
        //Ametralladora thompson
    Treasure Thompson=new Treasure("Ametralladora Thompson",600,4,8,TreasureKind.bothHand);
    unusedTreasures.add(Thompson);
        //Camiseta de la UGR
    Treasure Ugr=new Treasure("Camiseta de la UGR",100,1,7,TreasureKind.armor);
    unusedTreasures.add(Ugr);
        //Clavo de rail ferroviario
    Treasure Clavo=new Treasure("Clavo de Rail Ferroviario",400,3,6,TreasureKind.oneHand);
    unusedTreasures.add(Clavo);
        //cuchillo de sushi arcano
    Treasure Sushi=new Treasure("Cuchillo de Sushi Arcano",300,2,3,TreasureKind.oneHand);
    unusedTreasures.add(Sushi);
        //Fez alopodo
    Treasure Fez=new Treasure("Fez Alopodo",700,3,5,TreasureKind.helmet);
    unusedTreasures.add(Fez);
        //Hacha Prehistorica
    Treasure Hacha=new Treasure("Hacha Prehistorica",500,2,5,TreasureKind.oneHand);
    unusedTreasures.add(Hacha);
        //El aparato del profesor Tesla
    Treasure Tesla=new Treasure("El aparato del Pr.Tesla",900,4,8,TreasureKind.armor);
    unusedTreasures.add(Tesla);
        //Gaita
    Treasure Gaita=new Treasure("Gaita",500,4,5,TreasureKind.bothHand);
    unusedTreasures.add(Gaita);
        //insecticida
    Treasure Insecticida=new Treasure("Insecticida",300,2,3,TreasureKind.oneHand);
    unusedTreasures.add(Insecticida);
        //Escopeta
    Treasure Escopeta=new Treasure("Escopeta de 3 cañones",700,4,6,TreasureKind.bothHand);
    unusedTreasures.add(Escopeta);
        //Garabato mistico
    Treasure Garabato=new Treasure("Garabato Mistico",300,2,2,TreasureKind.oneHand);
    unusedTreasures.add(Garabato);
        //La fuerza de Mr.T
    Treasure T=new Treasure("La fuerza de Mr.T",1000,0,0,TreasureKind.necklace);
    unusedTreasures.add(T);
        //La rebeca metalica
    Treasure Metallica=new Treasure("La rebeca Metallica",400,2,3,TreasureKind.armor);
    unusedTreasures.add(Metallica);
        //Mazo de los antiguos
    Treasure Mazo=new Treasure("Mazo de los Antiguos",200,3,4,TreasureKind.oneHand);
    unusedTreasures.add(Mazo);
        //NecroPlayBoyCon
    Treasure NecroPlayBoyCon=new Treasure("NecroPlayBoyCon",300,3,5,TreasureKind.oneHand);
    unusedTreasures.add(NecroPlayBoyCon);
        //Lanzallamas
    Treasure Lanzallamas=new Treasure("Lanzallamas",800,4,8,TreasureKind.bothHand);
    unusedTreasures.add(Lanzallamas);
        //Necromicon
    Treasure Necromicon=new Treasure("Necromicon",100,1,1,TreasureKind.oneHand);
    unusedTreasures.add(Necromicon);
        //Necronomicon
    Treasure Necronomicon=new Treasure("Necronomicon",800,5,7,TreasureKind.bothHand);
    unusedTreasures.add(Necronomicon);
        //Linterna a dos manos
    Treasure Linterna=new Treasure("Linterna a dos manos",400,3,6,TreasureKind.bothHand);
    unusedTreasures.add(Linterna);
        //Necro-gnomicon
    Treasure Necrognomicon=new Treasure("Necrognomicon",200,2,4,TreasureKind.oneHand);
    unusedTreasures.add(Necrognomicon);
        //Necrotelecom
    Treasure Necrotelecom=new Treasure("Necrotelecom",300,2,3,TreasureKind.helmet);
    unusedTreasures.add(Necrotelecom);
        //Porra preternatural
    Treasure Porra=new Treasure("Porra preternatural",200,2,3,TreasureKind.oneHand);
    unusedTreasures.add(Porra);
        //Tentaculo de pega
    Treasure Tentaculo=new Treasure("Tentaculo de pega",200,0,1,TreasureKind.helmet);
    unusedTreasures.add(Tentaculo);
        //Zapato deja-amigos
    Treasure Zapato=new Treasure("Zapato deja amigos",500,0,1,TreasureKind.shoe);
    unusedTreasures.add(Zapato);
        //Shogulador
    Treasure Shogulador=new Treasure("Shogulador",600,1,1,TreasureKind.bothHand);
    unusedTreasures.add(Shogulador);
        //Varita de atizamiento
    Treasure Varita=new Treasure("Varita de atizamiento",400,3,4,TreasureKind.oneHand);
    unusedTreasures.add(Varita);
        

    
    }
   
    //Mazo de monstruos
    
    private void initMonsterCardDeck(){
       
        //Byakhees
        ArrayList<TreasureKind> tvpByakhees = new ArrayList();
        tvpByakhees.add(TreasureKind.armor);
        ArrayList<TreasureKind> topByakhees = new ArrayList();
        topByakhees.add(TreasureKind.armor);
        BadStuff ByakheesBs=new BadStuff("Pierdes tu armadura visible y otra oculta",0,tvpByakhees,topByakhees);
        Prize ByakheesPr=new Prize(2,1);
        Monster ByakheesDeBonanza=new Monster("Byakhees de bonanza",8,ByakheesBs,ByakheesPr);
        unusedMonsters.add(ByakheesDeBonanza);
        //Chibithulhu
        ArrayList<TreasureKind> tvpChibithulhu = new ArrayList();
        tvpChibithulhu.add(TreasureKind.helmet);
        BadStuff ChibithulhuBs=new BadStuff("Embobados con el lindo primigenio,te descartas de tu casco visible",0,tvpChibithulhu,new ArrayList());
        Prize ChibithulhuPr=new Prize(1,1);
        Monster Chibithulhu=new Monster("Chibithulhu",2,ChibithulhuBs,ChibithulhuPr);
        unusedMonsters.add(Chibithulhu);
        
        
        //El supor de Dunwich
        
        ArrayList<TreasureKind> tvpElSoporDeDunwich = new ArrayList();
        tvpElSoporDeDunwich.add(TreasureKind.shoe);
        BadStuff ElSoporDeDunwichBs=new BadStuff("El primordial bostezo contagioso, pierdes el calzado visible",0,tvpElSoporDeDunwich,new ArrayList());
        Prize ElSoporDeDunwichPr=new Prize(1,1);
        Monster ElSoporDeDunwich =new Monster(" El Sopor De Dunwich ",2,ElSoporDeDunwichBs,ElSoporDeDunwichPr);
        unusedMonsters.add(ElSoporDeDunwich);
        
        //Angeles de la noche ibbicenca
        
        ArrayList<TreasureKind> tvpAngeles = new ArrayList();
        tvpAngeles.add(TreasureKind.oneHand);
        ArrayList<TreasureKind> topAngeles = new ArrayList();
        topAngeles.add(TreasureKind.oneHand);
        BadStuff AngelesBs=new BadStuff("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo.Descarta una mano visible y una mano oculta",0,tvpAngeles,topAngeles);
        Prize AngelesPr=new Prize(4,1);
        Monster AngelesDeLaNocheIbicenca =new Monster(" Ángeles de la noche Ibicenca ",14,AngelesBs,AngelesPr);
       unusedMonsters.add(AngelesDeLaNocheIbicenca);
        //El gorron en el umbral
        
        BadStuff GorronBs=new BadStuff("Pierdes todos tus tesoros visibles",0,10,0);
        Prize GorronPr=new Prize(3,1);
        Monster ElGorronEnElUmbral =new Monster(" El gorrón en el umbral ",10,GorronBs,GorronPr);
        unusedMonsters.add(ElGorronEnElUmbral);
        
        //H.P.Munchcraft
        ArrayList<TreasureKind> tvpHpm = new ArrayList();
        tvpHpm.add(TreasureKind.armor);
        BadStuff HpmBs=new BadStuff("Pierdes la armadura visible",0,tvpHpm,new ArrayList());
        Prize HpmPr=new Prize(2,1);
        Monster HpMunchcraft =new Monster("H.P. Munchcraft ",6,HpmBs,HpmPr);
        unusedMonsters.add(HpMunchcraft);
        
        //Bichgooth
        ArrayList<TreasureKind> tvpBichgooth = new ArrayList();
        tvpHpm.add(TreasureKind.armor);
        BadStuff BichgoothBs=new BadStuff("Sientes bichos bajo tu ropa, descarta tu armadura visible",0,tvpBichgooth,new ArrayList());
        Prize BichgoothPr=new Prize(1,1);
        Monster Bichgooth =new Monster("Bichgooth",2,BichgoothBs,BichgoothPr);
        unusedMonsters.add(Bichgooth);
        
        
        //EL Rey de Rosa
        ArrayList<TreasureKind> tvpRey = new ArrayList();
        BadStuff ReyBs=new BadStuff("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        Prize ReyPr=new Prize(4,2);
        Monster ElReyDeRosa =new Monster("EL Rey De Rosa",13,ReyBs,ReyPr);
        unusedMonsters.add(ElReyDeRosa);
        
        
        //La que redacta en las tinieblas
        BadStuff tinieblasBs=new BadStuff("Toses los pulmones y pierdes 2 niveles",2,0,0);
        Prize tinieblasPr=new Prize(1,1);
        Monster LaQueRedactaLasTinieblas =new Monster("La Que Redacta Las Tinieblas",2,tinieblasBs,tinieblasPr);
        unusedMonsters.add( LaQueRedactaLasTinieblas);
        
        
        //Los hondos 
        BadStuff HondosBs=new BadStuff("Estos monstruos resultan bastante superficiales y "
                + "te aburren mortalmente. Estas muerto",true);
        Prize HondosPr=new Prize(2,1);
        Monster LosHondos =new Monster("Los Hondos",8,HondosBs,HondosPr);
        unusedMonsters.add(LosHondos);
        
        //Semillas Cthulhu
              
        
        BadStuff SemillasBs=new BadStuff("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        Prize SemillasPr=new Prize(2,1);
        Monster SemillasCthulhu =new Monster("Semillas Cthulhu",4,SemillasBs,SemillasPr);
        unusedMonsters.add(SemillasCthulhu);
        
        //Dameargo
        ArrayList<TreasureKind> tvpDame = new ArrayList();
        tvpDame.add(TreasureKind.oneHand);
        BadStuff DameBs=new BadStuff("Te intentas escaquear. Pierdes una mano visible",0,tvpDame,new ArrayList());
        Prize DamePr=new Prize(2,1);
        Monster Dameargo =new Monster("Dameargo",1,DameBs,DamePr);
        unusedMonsters.add(Dameargo);
        
        //Pollipólipo volante
        
        BadStuff PolliBs=new BadStuff("Da mucho asquito. Pierdes 3 niveles",3,new ArrayList(),new ArrayList());
        Prize PolliPr=new Prize(3,1);
        Monster PollipolipoVolante =new Monster("Pollipólipo Volante",3,PolliBs,PolliPr);
        unusedMonsters.add(PollipolipoVolante);
        
        //Yskhtihyssg-Goth
        BadStuff GothBs=new BadStuff("No le hace gracia que pronuncien mal su nombre. Estas muerto",true);
        Prize GothPr=new Prize(3,1);
        Monster YskhtihyssgGoth =new Monster("Yskhtihyssg-Goth",12,GothBs,GothPr);
        unusedMonsters.add(YskhtihyssgGoth);
        
        //Familia Feliz
        BadStuff FamiliaBs=new BadStuff("La familia te atrapa. Estas muerto",true);
        Prize FamiliaPr=new Prize(4,1);
        Monster FamiliaFeliz =new Monster("Familia Feliz",1,FamiliaBs,FamiliaPr);
        unusedMonsters.add(FamiliaFeliz);
        
        //Roboggoth
        ArrayList<TreasureKind> tvpRoboggoth = new ArrayList();
        tvpRoboggoth.add(TreasureKind.bothHand);
        BadStuff RoboggothBs=new BadStuff("La quita directiva primaria te obliga a perder 2 niveles"
                + "y un tesoro 2 manos visible",2,tvpRoboggoth,new ArrayList());
        Prize RoboggothPr=new Prize(2,1);
        Monster Roboggoth =new Monster("Roboggoth",8,RoboggothBs,RoboggothPr);
        unusedMonsters.add(Roboggoth);
        
        //El Espia
           
        ArrayList<TreasureKind> tvpEspia= new ArrayList();
        tvpEspia.add(TreasureKind.helmet);
        BadStuff EspiaBs=new BadStuff("Te asusta en la noche."
                + "Pierdes un casco visible",0,tvpEspia,new ArrayList());
        Prize EspiaPr=new Prize(1,1);
        Monster ElEspia =new Monster("El Espia",5,EspiaBs,EspiaPr);
        unusedMonsters.add(ElEspia);
        
        //EL Lengua
        
         
        BadStuff LenguasBs=new BadStuff("Menudo susto te llevas."
                + "Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        Prize LenguasPr=new Prize(1,1);
        Monster ElLenguas =new Monster("El Lenguas",20,LenguasBs,LenguasPr);
        unusedMonsters.add(ElLenguas);
        
         
        
        //Bicefalo
        ArrayList<TreasureKind> tvpBicefalo= new ArrayList();
        tvpBicefalo.add(TreasureKind.oneHand);
        tvpBicefalo.add(TreasureKind.oneHand);
       
        
        tvpBicefalo.add(TreasureKind.bothHand);
        
        BadStuff BicefaloBs=new BadStuff("Te faltan manos para tanta cabeza"
                + "Pierdes 3 niveles y tus tesoros visibles de las manos",3,tvpBicefalo,new ArrayList());
        Prize BicefaloPr=new Prize(1,1);
        Monster Bicefalo =new Monster("Bicefalo",20,BicefaloBs,BicefaloPr);
        unusedMonsters.add(Bicefalo);
        
        System.out.println("LA MAZMORRA DE LOS MONSTRUOS\n");
    }
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
        
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }    

        
    public static CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
             unusedTreasures = new ArrayList(usedTreasures);
             usedTreasures.clear();
             Collections.shuffle(unusedTreasures);
        }
        Treasure tesoro = unusedTreasures.get(unusedTreasures.size()-1);
        unusedTreasures.remove(tesoro);
        return tesoro;
    }
    
    public Monster nextMonster(){
         if(unusedMonsters.isEmpty()){
            unusedMonsters = new ArrayList(usedMonsters);
            usedMonsters.clear();
            Collections.shuffle(unusedMonsters);
        }
        Monster monsters = unusedMonsters.get(unusedMonsters.size()-1);
        usedMonsters.add(monsters);
        unusedMonsters.remove(monsters);
        return monsters;
    }
    
    public void giveTreasureBack(Treasure t){
        this.usedTreasures.add(t);
    }
    public void giveMonsterBack(Monster m){
        this.usedMonsters.add(m);
    }
    public void initCards(){
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
    }
    
}
