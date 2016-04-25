/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.Date;

/**
 *
 * @author moroclash
 */
public  class Validations {
    
   public static boolean Is_digit(String Word)
   {
      try{
          Integer.parseInt(Word);
          return true;
      }catch(Exception e){
          return false;
      }
              
       
       
   }
   
   public static boolean Is_alpha(String Word)
   {
       int len=Word.length();
       while (len!=0)
       {
            char s=Word.charAt(len); 
            boolean tr=  Character.isDigit(s);
                if(tr==true)
                   return false;
          len --;
       }
       return true;
   }
   
   public static boolean Is_email(String Word)
   {    //anything@3digit at least .com  
       int len=Word.length()-4;
       int com=Word.length()-4;
       int a []=new int[2];
       while (len!=0)
       {
            char s=Word.charAt(len); 
           if(s=='@' && len >3 && Is_alpha(Word.substring(len)))
           {
               a[0]=1;                
           }
           len --;    
       }
       
            if(".com".equals(Word.substring(com)))
                   a[1]=1;
       
        if(a[0]==1&&a[1]==1)   
       return true;
        else 
            return false;
   }
   
   
   public static boolean Is_passord(String Word)
   {
       boolean test1,test2,test3=true;
       test1=Is_alpha(Word);
       test2=Is_digit(Word);
       if(test1 || test2)
           return false;
       else
       {
           int len =Word.length();
           int i=0,k=0;
           while(len!=0)
           {
               test3=true;
               int  s=(int)Word.indexOf(len);
               
               if(s<=65&&s>=90&&i==0)
               {
                   i ++;
               }
              if(s<=97&&s>=122&&k==0)
              {
                  k++;
              }
              if(k==1&&i==1)
              {
                  test3=false;
                  break;
              }
           }
           return !(test1 || test2||test3);
       }
       
   }
   
   public static boolean Is_date(String Word)
   {
       //1920-02-30 OR 30-02-1964
     String s1=Word.substring(1,4),s2=Word.substring(6, 7),s3=Word.substring(9, 10);
     if(Is_digit(s1)&&Is_digit(s2)&&Is_digit(s3))
     {
         if(Integer.parseInt(s3)<32&&Integer.parseInt(s3)>0&&Integer.parseInt(s2)<13&&Integer.parseInt(s3)>0)
         return true; 
         
     }
     else
     {
         String s6=Word.substring(1,2),s5=Word.substring(4,5),s4=Word.substring(7, 10);
         if(Is_digit(s6)&&Is_digit(s5)&&Is_digit(s4))
             {
                 if(Integer.parseInt(s6)<32&&Integer.parseInt(s6)>0&&Integer.parseInt(s5)<13&&Integer.parseInt(s5)>0)
                 return true;
             }
     }
     return false;
   }
   
   public static boolean Is_double(String Word)
   {
       try{
           Double.parseDouble(Word);
           return true;
       }catch(Exception e){
           return false;
       }
   }
    
}
