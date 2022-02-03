//Dawid Oleksy gr1
import java.util.Scanner;

public class Source {
	  static int delDupls3(long [] tab_pom)
	    {
	    	
	    	  int curr_elems=1;
	    	    int i = 0;
	    	    for (int j = 1; j <tab_pom.length; j++) {
	    	        if (tab_pom[j] != tab_pom[i]) {
	    	            i++;
	    	            tab_pom[i] = tab_pom[j];
	    	            curr_elems++;
	    	            
	    	        }
	    	    }
	    	  
	    	return curr_elems;
	    }
	
	public static int bin_left(long[] A, int n, long szukana_lewa) {
		int start = 0;
		int end = n-1;
				
		while (start <= end)
		{
			if ( A[(start+end)/2] >= szukana_lewa )
			{
				end = (start+end)/2 - 1;
			}
			else
				start = (start+end)/2 + 1;
		}
		
		return start;
		
	}
	
	public static int bin_right(long[] A, int n, long szukana_prawa) {
		int start = 0;
		int end = n-1;
				
		while (start <= end)
		{
			if ( A[(start+end)/2] > szukana_prawa)
			{
				end = (start+end)/2 - 1;
			}
			else
				start = (start+end)/2 + 1;
		}
		
		return end;
		
	}

	public static void main(String[] args) {

		
		Scanner mainScanner = new Scanner(System.in);
		int setCount;
		
		setCount = mainScanner.nextInt();
		
		for ( int i = 0; i < setCount; ++i )
		{
			int Adl = mainScanner.nextInt();
			long[] A = new long[Adl];
			
			for ( int j = 0; j < Adl; ++j )
				A[j] = mainScanner.nextLong();
			
			long ilosc_pr = mainScanner.nextLong();
			
			long a, b;
			int result;
			
			for ( int j = 0; j < ilosc_pr; ++j )
			{
				a = mainScanner.nextLong();
				b = mainScanner.nextLong();
				
				if (a > b)
					result = 0;
				else				
					result = bin_right(A, Adl, b) - bin_left(A, Adl, a) + 1;

			System.out.println( result );
				
				
			}
			
		int dlt=delDupls3(A);
		System.out.println(dlt);
		if(dlt>100)dlt=100;
		for(int w=0;w<dlt;w++){
			if(w%20==0&&w!=0){System.out.println();}
			
			System.out.print(A[w]+" ");
			
			
		}
			
					if(setCount!=1&&setCount!=i+1)System.out.println();
			
		}
		
		
			
		

	
	}

}
/*
2
12
 -1 1 2 2 2 3 5 5 7 7 9 9
12
 1 2
 2 2
 3 6
 2 1
 -1 10
 1 0
 4 6
 4 3
 -1 9
 1 1
 4 4
 0 9
10
1 1 1 1 1 1 1 1 1 1
7
1 2
0 1
1 1
0 0
2 2
3 1
-1 -1 
*/