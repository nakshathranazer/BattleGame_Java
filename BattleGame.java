import java.util.Random;
import java.io.*;  
import java.util.*;  
import java.io.FileWriter;
import java.util.Scanner;

public class BattleGame{
private  Random r;
public  BattleGame(){
      Random rand = new Random();
     
      this.r = rand;
     
      
      }
public int gen(int seed){
   this.r.setSeed(seed);
   int ra = this.r.nextInt();
   return ra;
   
}
public static void playGame(String plfile,String monfile,String spellfile,int se){
   
   ArrayList<Spell> s=FileIO.readSpells(spellfile);
   if (s == null){
     System.out.println("Game will be played without Spells.");
   }
   
   Character p=FileIO.readCharacter(plfile);
   p.setSpells(s);
   System.out.printf("Spellname|MinDamage|MaxDamage|ChanceOfSuccess"); 
   System.out.println("\n");
   p.displaySpells(s);
   Character m=FileIO.readCharacter(monfile);
   if (p instanceof Character==false || m instanceof Character==false){
       System.out.println("Game cannot be played");
       return;
     }
  
     System.out.println("\n");
    System.out.println(p.toString());
    
    System.out.printf("AttackValue : %.2f ",p.getAttackValue());
    System.out.printf("NumberOfWins: %d ",p.getNumWins());
    System.out.println("\n");
    
    System.out.println("\n");
    System.out.println(m.toString());
    System.out.printf("AttackValue: %.2f ",m.getAttackValue());
    System.out.printf("NumberOfWins: %d ",m.getNumWins());
    System.out.println("\n");
    System.out.println("Enter Command");
    Scanner sc= new Scanner(System.in);
    while(p.getCurrHealth()>0 && m.getCurrHealth()>0){
    
    String command = sc.nextLine();
    
    
   
    {
      
      if(command.equals("attack")){
      
       BattleGame o=new BattleGame();
      
       double attack=p.getAttackDamage(se);
       String attackStr = String.format("%1$.2f", attack);
       System.out.printf("%s attacks and",p.getName());
         
       System.out.printf("damage produced is");
       
       System.out.println(attackStr);
         System.out.println("\n");
      
       m.takeDamage(attack);
       if (m.getCurrHealth()>0){
         System.out.println(m.toString());
       } 
       else{
       System.out.printf(p.getName());
       System.out.println("knocked out");
       break;
       }
  	
     
       double atack=m.getAttackDamage(se);
       String atackStr = String.format("%1$.2f", atack);
       System.out.printf("%s attacks and",m.getName());
         
       System.out.printf("damage produced is");
       
       System.out.println(atackStr);
         System.out.println("\n");
       p.takeDamage(atack);
       if (p.getCurrHealth()>0){
         System.out.println(p.toString());
       } 
       else{
       System.out.printf(m.getName());
       System.out.println("knocked out");
       break;
       }
      }
      else if(command.equals("quit")) {
       System.out.println("Good Bye");
       return;
      
      }
      else{
        
        BattleGame o=new BattleGame();
        String spellName=command;
        
        double damage=p.castSpells(spellName,se);
        if (damage<=0){
         System.out.printf("%s tried to cast a %s but failed",p.getName(),spellName);
         System.out.println("\n");
         
        }
        else{
        System.out.printf("%s Casted and",p.getName());
         
         System.out.printf("damage produced is");
         System.out.println(damage);
         System.out.println("\n");
       
     
        }
       
       double aack=m.getAttackDamage(se);
       String aackStr = String.format("%1$.2f", aack);
       System.out.printf("%s attacks for",m.getName());
        System.out.printf("damage produced is");
        System.out.println(aackStr);
        System.out.println("\n");
       p.takeDamage(aack);
       if (p.getCurrHealth()>0){
       
         System.out.println(p.toString());
       } 
       else{
       System.out.println("monster knocked out");
       break;
       }
      }
       System.out.println("\n");
        
 }
  if (p.getCurrHealth()<=0 || m.getCurrHealth()<=0){ break;}
  
  System.out.println("Enter Command");
  
  }
   
 if (p.getCurrHealth()<=0){
     System.out.printf(p.getName());
     System.out.printf(" lost");
     System.out.println("\n");
     System.out.printf(m.getName());
     System.out.printf(" won");
     System.out.println("\n");
     m.increaseWins();
   
     FileIO.writeCharacter(m,monfile);
     System.out.printf("Monster won %d times .written to monster.txt",m.getNumWins());
 }
 else{ 
     System.out.printf(p.getName());
     System.out.printf(" won");
     System.out.println("\n");
     System.out.printf(m.getName());
     System.out.printf(" lost");
     System.out.println("\n");
     p.increaseWins();
    
     FileIO.writeCharacter(p,plfile);
     System.out.printf("Player won %d times.written to player.txt",p.getNumWins());
   }
   
  
   }
}
