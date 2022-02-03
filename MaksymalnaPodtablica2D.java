//Oleksy Dawid - 1
import java.util.Scanner;


public class Source{
	public static Scanner in = new Scanner(System.in);
	public static void main(String args[]){

		int ilosctablic;
		int wiersze;
		int kolumny;


		 ilosctablic=in.nextInt();
		 for(int i=0;i<ilosctablic;i++)
		 {
			 wiersze=in.nextInt();
			 kolumny=in.nextInt();
			 int [][] tablica=new int [wiersze][kolumny];
			 for(int j=0;j<wiersze;j++)
			 {
				for(int k=0;k<kolumny;k++)
				{
					tablica[j][k]=in.nextInt();
				}
			 }


        Source saw = new Source();
        System.out.println(saw.maximum_sum(tablica));
    }
}
	    
	    int zmp1=0;
	    int zmienna_do_ujemne_zerowe=0;
	    boolean przynajmniej_jedna;
    class wynik{
        int maximum_sum=0;
        int lewy_kraniec=0;
        int prawy_kraniec=0;
        int gorna_gr=0;
        int dolna_gr=0;

        public String toString() {
        	if(prawy_kraniec==-10)
        	{
        		return "0";
        	}

            return "max_sum=" + maximum_sum + System.lineSeparator() + "[" + gorna_gr
                    + ".." + dolna_gr + ", " + lewy_kraniec
                    + ".." + prawy_kraniec + "]";
        }

    }

    public wynik maximum_sum(int wejsciowa[][])
    {
        int wiersz = wejsciowa.length;
        int kolumny = wejsciowa[0].length;
        int pomocnicza[] = new int[wiersz];
        int zmp=0;


        wynik wynik = new wynik();

        for(int i=0;i<wiersz;i++)
        {
        	if(zmp1==-10)
        		break;

        for(int j=0;j<kolumny;j++)
        {
        	if(wejsciowa[i][j]>0)
        		zmp1=-10;

        }

        }
        for(int i=0;i<wiersz;i++)
        {
        	if(zmp==10)
        		break;

        for(int j=0;j<kolumny;j++)
        {
        	if(wejsciowa[i][j]>=0)
        		zmp=10;

        }

        }
       if(zmp!=10)
        {
        	wynik.prawy_kraniec=-10;
        	return wynik;
        }
        for(int L = 0; L < kolumny ; L++){
            for(int i=0; i < wiersz; i++){
                pomocnicza[i] = 0;
            }
            for(int R = L; R < kolumny; R++){
                for(int i=0; i < wiersz; i++){
                    pomocnicza[i] += wejsciowa[i][R];
                }

                algorytm_kadwynik algorytm_kadwynik = algorytm_kad(pomocnicza);

                if(algorytm_kadwynik.maximum_sum == wynik.maximum_sum && zmp1==0&&przynajmniej_jedna)
                { zmienna_do_ujemne_zerowe++;
               
                	if((wynik.gorna_gr>algorytm_kadwynik.pocz||zmienna_do_ujemne_zerowe==1 ) && ((wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1)||zmienna_do_ujemne_zerowe==1 ) )
                	{
                		 wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                         wynik.lewy_kraniec = L;
                         wynik.prawy_kraniec = R;
                         wynik.gorna_gr = algorytm_kadwynik.pocz;
                         wynik.dolna_gr = algorytm_kadwynik.konc;
                    

                	}
                	if(wynik.gorna_gr==algorytm_kadwynik.pocz&& wynik.dolna_gr > algorytm_kadwynik.konc&& (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1))
                	{
                		wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                        wynik.lewy_kraniec = L;
                        wynik.prawy_kraniec = R;
                        wynik.gorna_gr = algorytm_kadwynik.pocz;
                        wynik.dolna_gr = algorytm_kadwynik.konc;
                	}

                	if(wynik.gorna_gr==algorytm_kadwynik.pocz&& wynik.dolna_gr == algorytm_kadwynik.konc&&wynik.lewy_kraniec>L&& (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1) )

                	{
                		wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                        wynik.lewy_kraniec = L;
                        wynik.prawy_kraniec = R;
                        wynik.gorna_gr = algorytm_kadwynik.pocz;
                        wynik.dolna_gr = algorytm_kadwynik.konc;
                	}
                	if(wynik.gorna_gr==algorytm_kadwynik.pocz&& wynik.dolna_gr == algorytm_kadwynik.konc&&wynik.lewy_kraniec==L &&wynik.prawy_kraniec>R&& (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1))
                	{
                		wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                        wynik.lewy_kraniec = L;
                        wynik.prawy_kraniec = R;
                        wynik.gorna_gr = algorytm_kadwynik.pocz;
                        wynik.dolna_gr = algorytm_kadwynik.konc;
                	}
                }

                if(algorytm_kadwynik.maximum_sum == wynik.maximum_sum)
                {
                	
                	
                }
               if(algorytm_kadwynik.maximum_sum == wynik.maximum_sum && (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)>(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1)&&zmp1!=0)
               {
            	   wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                   wynik.lewy_kraniec = L;
                   wynik.prawy_kraniec = R;
                   wynik.gorna_gr = algorytm_kadwynik.pocz;
                   wynik.dolna_gr = algorytm_kadwynik.konc;
               }
                if(algorytm_kadwynik.maximum_sum > wynik.maximum_sum){
                    wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                    wynik.lewy_kraniec = L;
                    wynik.prawy_kraniec = R;
                    wynik.gorna_gr = algorytm_kadwynik.pocz;
                    wynik.dolna_gr = algorytm_kadwynik.konc;
                }

                if(algorytm_kadwynik.maximum_sum == wynik.maximum_sum && (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1) && wynik.gorna_gr>algorytm_kadwynik.pocz&&zmp1!=0 )
                {
                	 wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                     wynik.lewy_kraniec = L;
                     wynik.prawy_kraniec = R;
                     wynik.gorna_gr = algorytm_kadwynik.pocz;
                     wynik.dolna_gr = algorytm_kadwynik.konc;
                }
                if(algorytm_kadwynik.maximum_sum == wynik.maximum_sum && (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1) && wynik.gorna_gr==algorytm_kadwynik.pocz && wynik.dolna_gr>algorytm_kadwynik.konc&&zmp1!=0)
                {
                	 wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                     wynik.lewy_kraniec = L;
                     wynik.prawy_kraniec = R;
                     wynik.gorna_gr = algorytm_kadwynik.pocz;
                     wynik.dolna_gr = algorytm_kadwynik.konc;
                }
                if(algorytm_kadwynik.maximum_sum == wynik.maximum_sum && (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1) && wynik.gorna_gr==algorytm_kadwynik.pocz && wynik.dolna_gr==algorytm_kadwynik.konc&&wynik.lewy_kraniec>L&&zmp1!=0)
                {
                	wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                    wynik.lewy_kraniec = L;
                    wynik.prawy_kraniec = R;
                    wynik.gorna_gr = algorytm_kadwynik.pocz;
                    wynik.dolna_gr = algorytm_kadwynik.konc;
                }
                if(algorytm_kadwynik.maximum_sum == wynik.maximum_sum && (wynik.prawy_kraniec-wynik.lewy_kraniec + 1)*(wynik.dolna_gr - wynik.gorna_gr + 1)==(R-L+1)*(algorytm_kadwynik.konc-algorytm_kadwynik.pocz +1) && wynik.gorna_gr==algorytm_kadwynik.pocz && wynik.dolna_gr==algorytm_kadwynik.konc&&wynik.lewy_kraniec==L&&wynik.prawy_kraniec>R&&zmp1!=0)
                {
                	wynik.maximum_sum = algorytm_kadwynik.maximum_sum;
                    wynik.lewy_kraniec = L;
                    wynik.prawy_kraniec = R;
                    wynik.gorna_gr = algorytm_kadwynik.pocz;
                    wynik.dolna_gr = algorytm_kadwynik.konc;
                }
            }

        }


        return wynik;
    }

    class algorytm_kadwynik{
        int maximum_sum;
        int pocz;
        int konc;
        public algorytm_kadwynik(int maximum_sum, int pocz, int konc) {
            this.maximum_sum = maximum_sum;
            this.pocz = pocz;
            this.konc = konc;
        }
    }

    public algorytm_kadwynik algorytm_kad(int arr[]){
        int max = 0;
        int maxpocz =0;
        int maxkonc =0;
        int obcnypocz = 0;
        int maxdo_teraz = 0;



        for(int i=0; i < arr.length; i++){

            maxdo_teraz += arr[i];

            if(maxdo_teraz < 0){
                maxdo_teraz = 0;
                obcnypocz = i+1;
                przynajmniej_jedna=false;

            }


            if(max <= maxdo_teraz&&arr[i]!=0)
            {
            	
            	
            	
                maxpocz = obcnypocz;
                maxkonc = i;
                max = maxdo_teraz;
            }


            if(maxdo_teraz==0 && arr[i]==0&& zmp1!=0)
            {
           obcnypocz=i+1;


            }
            if(maxdo_teraz==0 && arr[i]==0 && zmp1==0)
            {
            	przynajmniej_jedna=true;
            	obcnypocz=i;
            	maxkonc=i;
            	max=0;
            	maxpocz = obcnypocz;
            	break;
            }
        }

        return new algorytm_kadwynik(max, maxpocz, maxkonc);
    }



    }
/*
4
5 1
0
0
0
0
4

2 5
 1 1 -1 -1 0
 1 1 -1 -1 4

2 5
 0 -1 -1 1 1
 4 -2 -2 1 1

3 6
 0 0 0 -2 1 1
 0 1 1 -2 1 1
 0 1 1 -2 0 0

max_sum=4
[4..4, 0..0]
max_sum=4
[1..1, 4..4]
max_sum=4
[1..1, 0..0]
max_sum=4
[0..1, 4..5]

*/