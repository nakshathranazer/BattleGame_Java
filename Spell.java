import java.util.Random;
public class Spell {
private String name;
private double minimumdamage;
private double maximumdamage;
private double chanceofsuccess;

public Spell(String name,double minimumdamage,double maximumdamage,double chanceofsuccess){


if (chanceofsuccess<0 ||chanceofsuccess>1){
 throw new IllegalArgumentException("Chance Of Success must be between 0 and 1");
}

if (minimumdamage<0 ||minimumdamage>maximumdamage){
 throw new IllegalArgumentException("check minimumdamage value");
}
this.name=name;
this.minimumdamage=minimumdamage;
this.maximumdamage=maximumdamage;
this.chanceofsuccess=chanceofsuccess;
}
public String  getName() {

return this.name;
}
public double getMagicDamage(int a){
   double random = new Random(a).nextDouble();
   double start = 0;
   double end = 1;
   double result = start + (random * (end - start));
   if (result>this.chanceofsuccess){
      return 0;
   }
   else{
   double st = this.minimumdamage;
   double e = this.maximumdamage;
   double re = st + (random * (e - st));
   return re;
   }
   }
   
   
@Override
public String toString(){ 
   double c1=this.minimumdamage;
   String C1 =String.format("%1$.2f", c1);
   double c2=this.maximumdamage;
   String C2 =String.format("%1$.2f", c2);
   double c3=this.chanceofsuccess*100;
   String C3=String.format("%1$.2f", c3);
   String D=this.name;
   String d=D+":*:"+C1+":*:"+C2+":*:"+C3;
   
  
   return d;
 }    
 } 
