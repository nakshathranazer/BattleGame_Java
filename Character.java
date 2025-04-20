import java.util.Random;
import java.util.*;
import java.util.ArrayList;
import java.util.*;

public class Character{
private String name;
private double attackvalue;
private double maximumhealthvalue;
private double currenthealthvalue;
private int numberofwinsinthebattlegame;
private static ArrayList<Spell> spells;
public Character (String name,double attackvalue,double maximumhealthvalue,int numberofwinsinthebattlegame){

this.name = name;
this.currenthealthvalue=maximumhealthvalue;
this.attackvalue=attackvalue;
this.maximumhealthvalue=maximumhealthvalue;
this.numberofwinsinthebattlegame=numberofwinsinthebattlegame;

}
public void setSpells(ArrayList<Spell> spe){
 ArrayList<Spell> spes=new ArrayList<Spell>();
 
 spes.addAll(spe);
 this.spells=spes;
}
public void displaySpells(ArrayList<Spell> spe){
         for ( int i = 0; i < spe.size(); i++){
          System.out.println( this.spells.get(i).toString());
         }

}
public double castSpells(String name,int l){
          
          //System.out.println(l);
         for ( int i = 0; i < this.spells.size(); i++){
          String f=this.spells.get(i).getName();
          if(name.equalsIgnoreCase(f)){
          return this.spells.get(i).getMagicDamage(l);
          }
          
          }
          return -1.0;
         
         
          }
          

public String getName() {
return this.name;
}
public double  getAttackValue(){
return this.attackvalue;
}
public double getMaxHealth() {
return this.maximumhealthvalue;
}
public double  getCurrHealth(){
   return this.currenthealthvalue;
  
}
public int  getNumWins(){
return  this.numberofwinsinthebattlegame;
}
@Override
public String toString(){ 
   double cu=this.getCurrHealth();
   String curr = String.format("%1$.2f", cu);
  
   return this.name+"'s Current Health :"+curr;
 }  

public double getAttackDamage(int a){
    
   double start = 0.7;
   double end = 1.0;
   double random = new Random(a).nextDouble();
   double result = start + (random * (end - start));    
 
   return attackvalue*result;

}
public double takeDamage(double b){
      this.currenthealthvalue= this.currenthealthvalue-b;
      return this.currenthealthvalue;

}  
public void increaseWins(){
     
     this.numberofwinsinthebattlegame=this.numberofwinsinthebattlegame+1;
     }
 }        

