/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author erdem
 */
public class GITLanguage {
    private LinkedList<Int> linkedInt=new LinkedList();
    private LinkedList<Float> linkedFloat = new LinkedList();
    
    String[] strTokens=new String[100];
    private int numOfStr=0;
    
    /*verilen stringin integer linked listte olup olmadığına bakar*/
    private boolean searchInt(String s){
       int i;
  Iterator<Int> iter=linkedInt.listIterator(0);
  i=0;
       while(iter.hasNext()){
           Int var=iter.next();
           if(var.getL().equals(s))
               return true;
          }
       
      return false;
       
    }
    /*verilen stringin double linked listte olup olmadığına bakar*/
    private boolean searchFloat(String s){
        Iterator<Float> iterF=linkedFloat.listIterator(0);
       
      while(iterF.hasNext()){
          Float var=iterF.next();
          if(var.getL().equals(s))
              return true;
      }
      return false;
    }
    /*verilen stringin listte hangi indexte olup olmadığına bakar*/
    private int where(String s){
       Iterator<Int> iterI=linkedInt.listIterator(0);
       int i;
       i=0;
       while(iterI.hasNext()){
           Int var=iterI.next();
           if(var.getL().equals(s))
               return i;
           ++i;
       }
       Iterator<Float> iterF=linkedFloat.listIterator(0);
       i=0;while(iterF.hasNext()){
          
          
           Float v=iterF.next();
           if(v.getL().equals(s))
               return i;
           ++i;
       }
       return -1;
    }
    
   
    
    private boolean isIn(String str,String[] s,int lenght){
        int i;
        
        for(i=0;i<lenght;++i)
            if(s[i].equals(str))
                return true;
        return false;
    }
    /*sayi double ise parse olur ve true dondurur*/
    boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException num){
            return false;
        }
       
    }
    
    /*bos constructor*/
    GITLanguage(){
        
    }
    
    void menu(String f) throws IOException, Excep{
        /*file adi*/
        String fileN=f;
        /*try catch blogu IOException fırlatılma ihtimali icin*/
        try{
            /*dosya acilir ve okuma saglanir*/
            FileInputStream in=new FileInputStream(fileN);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            String str;
            int i;
            /*tüm satırlar bitene kadar oku*/
            /*her bir satırı tek tek parcala*/
            while((str=br.readLine())!=null){
                i=0;
                StringTokenizer strTok=new StringTokenizer(str);
                    while(strTok.hasMoreTokens()){
                        /*satiirdaki tum kelimeler string arrayinde tutulur*/
                        strTokens[i]=strTok.nextToken();
                      
                        ++i;
                        /*string sayisi*/
                        numOfStr=i;
                        
                    }
                    /*eger satir "int" ile başlıyorsa bu durumda yanindaki obje 
                     * varmı yok mu listede diye bak
                     atama yapilmissa buda hata*/
                    if(strTokens[0].equals("int")){
                    if(numOfStr>2){
                        /*eger initialize yapiliyorsa bu hata*/
                        if(strTokens[2]=="="){
                            throw new Excep("it is invalid to initialize");
                        }
                        /*eger o degisken kulanilmissa hata*/
                        else if(searchInt(strTokens[2]) || searchFloat(strTokens[2])){
                            throw new Excep("it is invalid it was used");
                        }
                        }
                        else {
                            /*normal bir degiskense linkedInt liste ekler objeyi adi ve degeri sifir olarak*/
                            Int obj=new Int(strTokens[1],0);
                            linkedInt.add(obj);
                                                  }
                    }
                    /*float ise */
                    else if(strTokens[0].equals("float")){
                        /*eger degisken tanımliyor ve initialize etme 
                         * vs yapmissa hata */
                        
                        if(numOfStr>2){
                        if(strTokens[2]=="="){
                           throw new Excep("it is invalid to initialize");
                        }
                       
                        }
                            /*eger variable daha önce tanimlanmissa exception firlatilir*/
                         else if(searchInt(strTokens[1])
                                || searchFloat(strTokens[1])){
                            throw new Excep("it is invalid it was declared before");
                        }
                        else{
                            /*yeni bir Float objesi olusur ve float
                             * listesine eklenir*/
                            Float obj=new Float(strTokens[1],0);
                           
                            linkedFloat.add(obj);
                        }
                    }
                    /*eger satirda atama varsa ilk string var mı diye listeye 
                     bakılır */
                    else if(isIn("=",strTokens,numOfStr)){
                        /*eger atama yapilacak degisken tanimlanmamissa hata*/
                        
                        
                        if(Character.isDigit(strTokens[0].charAt(0)))
                            throw new Excep("No lValue");
                            
                        
                        if(!(searchInt(strTokens[0]) || searchFloat(strTokens[0])))
                            throw new Excep("undefined variable");
                        /*tanimlanmisa hesaplancak kisim infixToPostfix 
                         * sinifinin convert metoduna gonderilir
                         postfix olarak return eden string 
                         PostfixEvaluator evalInt metoduna verilir
                         ve sonuc listteki degiskenin degeri olarak atanir*/
                        else   if(searchInt(strTokens[0])){
                        InfixToPostfix p=new InfixToPostfix();
                        int k;
                        int l;
                        l=0;
                           String d="";
                         String[] a=new String[10];
                        for(k=2;k<numOfStr-1;++k,++l){
                            d += strTokens[k]+" ";
                          a[l]=strTokens[k];
                          
                        }
                        a[l]=strTokens[k];
                        d+=strTokens[k];
                     
                     /*eger convert metoduna gonderilen stringteki her bir 
                      karakter integer a parse edilemiyorsa type uyusmazligi
                      bu hata*/ 
                      int m;
                           for(m=0;m<l+1;++m){
                               if(!isInteger(a[m]) )
                                      if( !(isIn("*",a,l) || isIn("/",a,l)|| isIn("+",a,l) || isIn("-",a,l) || isIn("(",a,l)
                                       || isIn(")",a,l))){
                                    throw new Excep("incompitible type for integer");}
                     
                           }
                           
                           /*string postfix notasyona cevrildi*/
                        String string=p.convert(d);
                         /*eger aritmetik islemlerde degisken varsa onun degeri 
                          * stringte belirlenir ve eval classına yollanır*/
                        StringTokenizer string2=new StringTokenizer(string);
                        
                        String[] str2=new String[10];
                        
                        for(m=0;string2.hasMoreTokens();++m){
                            str2[m]=string2.nextToken();
                        //System.out.println(str2[m]);
                        
                        }
                        StringBuilder build=new StringBuilder();
                     
                         int v=0;
                        //System.out.print("vfdsg"+str2[0]);
                         for(v=0;v<m;++v)
                         {  
                                 if(searchInt(str2[v])){
                                     build.append(linkedInt.get(where(str2[v])).getN());
                                     build.append(' ');
                                 }
                                 else{
                                     build.append(str2[v]);
                                     build.append(' ');
                                    //System.out.print("dfg"+str2[v]);
                                 }
                                 
                         }
                        //System.out.println(build.toString());
                        PostfixEvaluator eval=new PostfixEvaluator();
                       int res=eval.evalInt(build.toString());
                       /*linkedInt listindeki degiskenin bulundugu 
                        * yerdeki deger hesaplanan deger olarak set edilir*/
                       linkedInt.get(where(strTokens[0])).setN(res);
                    }
                    
                        else if(searchFloat(strTokens[0])){
                            InfixToPostfix ip=new InfixToPostfix();
                            int k,l;
                            String strn="";
                            l=0;
                            String[] a=new String[10];
                            for(k=2;k<numOfStr-1;++k,++l){
                                strn+=strTokens[k]+" ";
                                a[l]=strTokens[k];
                                
                            }
                            strn+=strTokens[k];
                            a[l]=strTokens[k];
                            int v;
                            for(v=0;v<l+1;++v)
                                if(isInteger(a[v]) ||
                                    !(isIn("/",a,l) || isIn("*",a,l) || isIn("+",a,l) || isIn("-",a,l)
                                            || isIn("(",a,l) || isIn(")",a,l)))
                                    throw new Excep("uncompitible  type "
                                            + "between int and float");
                            
                            
                            
                            
                            
                            String s=ip.convert(strn);
                            StringTokenizer string2=new StringTokenizer(s);
                        int m;
                        String[] str2=new String[10];
                        
                        for(m=0;string2.hasMoreTokens();++m){
                            str2[m]=string2.nextToken();
                        }
                            
                            StringBuilder build=new StringBuilder();
                     
                         
                        //System.out.print("vfdsg"+str2[0]);
                         for(v=0;v<m;++v)
                         {  
                                 if(searchFloat(str2[v])){
                                     build.append(linkedFloat.get(where(str2[v])).getN());
                                     //System.out.print("gryth"+linkedFloat.get(where(str2[v])).getN());
                                     build.append(' ');
                                 }
                                 else{
                                     build.append(str2[v]);
                                     build.append(' ');
                                    //System.out.print("dfg"+str2[v]);
                                 }
                                 
                         }
                              //System.out.println("build"+build.toString());   
                            
                            PostfixEvaluator eval=new PostfixEvaluator();
                            double res=eval.evalDouble(build.toString());
                        linkedFloat.get(where(strTokens[0])).setN(res);
                        
                         //burada eger strTokens[0] listte toksa undefined exception fırlat
                        }
                      
                    }
                    else if(strTokens[0].equals("print")){
                        StringBuilder s=new StringBuilder();
                        s.append(strTokens[1]);
                        if(searchInt(strTokens[1]))
                           System.out.println(linkedInt.get(where(strTokens[1])).getN());
                            
            else if(searchFloat(strTokens[1]))
                    System.out.println(linkedFloat.get(where(strTokens[1])).getN());
            else if(Character.isDigit(strTokens[1].charAt(0)))
                System.out.println(s.charAt(0));
             else
                throw new Excep("this variable is not found in the lists");
                
            }
                    else{
                        throw new Excep("no such reserved word");
                    }}
        }catch(IOException e){
            e.printStackTrace();
        }catch(Excep e){
               throw new Excep(e.getMessage());
    }
            
            
    }
}
    

    
