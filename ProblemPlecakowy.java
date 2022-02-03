//Oleksy Dawid gr1
import java.util.Scanner;


public class Source
{
	
	static int tab[]=new int[1000000];
	static int i1=0;
	
	static boolean wypisz(int[] tab1,int w)
	{
		if(w>=0)
			{System.out.print(tab1[w]+ " ");return wypisz(tab1,w-1);}
		
		
		
		return false;
		
	}
	public static boolean ProblemPlecakowy(int [] zbior, int n, int cel){
		   if (cel ==0){
		         return true;}
		   if ((cel<0)||(n>=zbior.length))
		      return false;
		   if (ProblemPlecakowy(zbior,n+1,cel - zbior[n])){
		      tab[i1]=zbior[n];
		      i1++;
		      return true;}
		   if (ProblemPlecakowy(zbior,n+1,cel))
		      return true;
		   return false;
		}
    public static void main (String args[])
    {
    	Scanner in = new Scanner(System.in);
          int z=in.nextInt();
          for(int i=0;i<z;i++)
          {
          int pojemnosc=in.nextInt();
          int liczba_elementow=in.nextInt();
          int[] tab1=new int[liczba_elementow];
          
          for(int j=0;j<liczba_elementow;j++)
          {
        	  tab1[j]=in.nextInt();
          }
          if(ProblemPlecakowy(tab1,0,pojemnosc)==true)
              {
        	  System.out.print(pojemnosc + " " + "="+ " ");
        	  wypisz(tab,i1-1);
              System.out.println("");
              i1=0;}
            else
          	  System.out.println("BRAK");
          
          }
     in.close();     
    }
}

/* TEST
2
15
7
1 1 1 1 1 1 10
26
4
13 13 10 16

*/