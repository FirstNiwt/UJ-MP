//Oleksy Dawid gr 1
import java.util.Scanner;


public class Source{
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]){
		int ilosc_zestawow,ilosc_danych;
		int dane[];
		ilosc_zestawow=in.nextInt();
		for(int w=0;w<ilosc_zestawow;w++)
		{
			ilosc_danych=in.nextInt();
			dane=new int[ilosc_danych];
			for(int k=0;k<ilosc_danych;k++)
				{
				dane[k]=in.nextInt();
				}
			
			System.out.println(numInver(dane));
		}
		
	}
	static long numInver(int wejsciowa[])
	{
	    int pomocnicza[] =new int[wejsciowa.length];
	    return recu_numInver(wejsciowa, pomocnicza, 0, wejsciowa.length- 1);
	}
	static long recu_numInver(int wejsciowa[], int pomocnicza[], int lewa_tab, int prawa_tab)
	{
	  int srodek;
	  long liczba_inwersji = 0;
	  if (prawa_tab > lewa_tab)
	  {
	    srodek = (prawa_tab + lewa_tab)/2;
	    liczba_inwersji  = recu_numInver(wejsciowa, pomocnicza, lewa_tab, srodek);
	    liczba_inwersji += recu_numInver(wejsciowa, pomocnicza, srodek+1, prawa_tab);
	 
	    liczba_inwersji += scal(wejsciowa, pomocnicza, lewa_tab, srodek+1, prawa_tab);
	  }
	  return liczba_inwersji;
	} 
	static long scal(int wejsciowa[],int pomocnicza[],int lewa_tab, int srodek,int prawa_tab)
	{
	  int i,j,w;
	long liczba_inwersji = 0;
	 
	  i = lewa_tab; 
	  j = srodek;  
	  w = lewa_tab; 
	  while ((i <= srodek - 1) && (j <= prawa_tab))
	  {
	    if (wejsciowa[i] <= wejsciowa[j])
	    {
	      pomocnicza[w++] = wejsciowa[i++];
	    }
	    else
	    {
	      pomocnicza[w++] = wejsciowa[j++];
	      liczba_inwersji = liczba_inwersji + (srodek - i);
	    }
	  }
	  while (i <= srodek - 1)
	    pomocnicza[w++] = wejsciowa[i++];
	  while (j <= prawa_tab)
	    pomocnicza[w++] = wejsciowa[j++];
	  for (i=lewa_tab; i <= prawa_tab; i++)
	    wejsciowa[i] = pomocnicza[i];
	  return liczba_inwersji;
	}
} 