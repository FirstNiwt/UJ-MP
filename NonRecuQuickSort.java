//Oleksy Dawid  gr1
import java.util.Scanner;
public class Source {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int liczba_zestawow;
	      int liczba_w_tablicy;
	      liczba_zestawow=in.nextInt();
	      for(int i=0;i<liczba_zestawow;i++)
	      {
	      liczba_w_tablicy=in.nextInt();
	      long tablica[]=new long[liczba_w_tablicy];
	      for(int j=0;j<liczba_w_tablicy;j++)
	      {
	    	  tablica[j]=in.nextLong();
	    	  
	      }
	      
	 quickSort(tablica.length,tablica);
	 
	 for(int w=0;w<tablica.length;w++)
	 {
		 if(w!=tablica.length-1)
		 System.out.print(tablica[w]+ " ");
		 else
			 System.out.print(tablica[w]);
	 }
	 System.out.println();
	}
	}
	      
	public static void quickSort(final int tablica_dl,long tablica[]) {
	    int lewy = 0;
	    int prawy = tablica_dl - 1;
	    int pom1, pom2 = 0;
	    int temp = prawy;
	    while (true) {
	    pom2--;
	    while (lewy < temp) {
	        pom1 = partition(lewy, temp,tablica);
	        tablica[temp] = -tablica[temp];
	         temp = pom1 - 1;
	        ++pom2;
	      }
	     if (pom2 < 0)
	          break;
	      lewy++;
	     temp = KolejnyR(lewy, tablica_dl,tablica);
	     tablica[temp] = -tablica[temp];
	    }
	}

	 static int KolejnyR(final int lewy, final int tablica_dl,long tablica[]) {
	  for (int pom2 = lewy; pom2 < tablica_dl; ++pom2) {
	       if (tablica[pom2] < 0)
	        return pom2;
	   }
	  return tablica_dl - 1;
	}

	static int partition(int lewy, int prawy,long tablica[]) {
	    long pivot = tablica[(lewy + prawy) / 2];
	    while (lewy <= prawy) {
	        while (tablica[prawy] > pivot)
	         prawy--;
	        while (tablica[lewy] < pivot)
	          lewy++;
	        if (lewy <= prawy) {
	            long tmp = tablica[prawy];
	          tablica[prawy] = tablica[lewy];
	          tablica[lewy] = tmp;
	           lewy++;
	            prawy--;
	        }
	    }
	    return lewy;
	}}