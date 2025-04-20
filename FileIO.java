import java.io.*;  
import java.util.*;  
import java.io.FileWriter;
import java.util.ArrayList;

    
    public class FileIO{
   
    public  static Character  readCharacter(String filee) {
    
        try  
     {  
     File file=new File(filee);    //creates a new file instance  
     FileReader fr=new FileReader(filee);   //reads the file  
     BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
     String a;
     double b;
     double c;
     int d;
     a=br.readLine();
     String B=br.readLine();
     b=Double.parseDouble(B);
     String C=br.readLine();
     c=Double.parseDouble(C);
     String D=br.readLine(); 
     d=Integer.parseInt(D);         
     Character f= new Character(a,b,c,d);
     fr.close();
     return f;
}

catch (FileNotFoundException fnfe)
{
   System.out.println("File not found");
}
catch (IOException ioe)
{
   System.out.println("I/O error ");
}

return null;
}  
public  static ArrayList<Spell> readSpells(String filee) {


      try  
     {  
     File file=new File(filee);    //creates a new file instance  
     FileReader fr=new FileReader(filee);   //reads the file  
     BufferedReader br=new BufferedReader(fr); 
     
     
     String line;  

     ArrayList<Spell> list=new ArrayList<Spell>();//Creating arraylist

     while((line=br.readLine())!=null)  
     {  
     String a;
     double b;
     double c;
     double d;      
     String[] words=line.split("\t");
     a=words[0];
     b=Double.parseDouble(words[1]);
     c=Double.parseDouble(words[2]);
     d=Double.parseDouble(words[3]);
   
    
     list.add(new Spell(a,b,c,d));    
     }  
 
     fr.close();    
     return list;
     
     
     
     
     
     
     
     }

catch (FileNotFoundException fnfe)
{
   System.out.println("File not found");
}
catch (IOException ioe)
{
   System.out.println("I/O error ");
}
return null;
}  
 public  static void  writeCharacter(Character c,String filee) {
    
        try  
     {  
     FileWriter writer = new FileWriter(filee);  
     BufferedWriter buffer = new BufferedWriter(writer);  
     
    
    
      
     String a;
     double b;
     double x;
     int d;
     a=c.getName();
     
     b=c.getAttackValue();
     String B=Double.toString(b);
     x=c.getMaxHealth();
     String X=Double.toString(x);
     d=c.getNumWins(); 
     String D=Integer.toString(d); 
     buffer.write(a);  
     buffer.write("\n");  
     buffer.write(B);
     buffer.write("\n");  
     buffer.write(X);
     buffer.write("\n");  
     buffer.write(D);
     buffer.close();           
              

             
  
   
}


catch (IOException ioe)
{
   System.out.println("I/O error ");
}

}     
 }    
     
     
     
     
     
     

 


      
    




