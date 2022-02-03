//Oleksy Dawid gr 1
import java.util.Scanner;

public class Source {
    public static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        int liczba_zestawow=in.nextInt();
             for(int i=0;i<liczba_zestawow;i++){
                int dlugosc_tablicy=in.nextInt();
                  int[] A=new int[dlugosc_tablicy];
                       for(int j=0;j<dlugosc_tablicy;j++){
                           A[j]=in.nextInt();
                                       }
            int liczaba_zapytan=in.nextInt();
             for(int z=0;z<liczaba_zapytan;z++){
                 int Q=in.nextInt();
                     if(Q<1 || Q>dlugosc_tablicy)
                         System.out.println(Q+" brak");
                          else {
                            int kty_elem = Select(A, Q - 1, 0, A.length);
                              System.out.println(Q + " " + kty_elem);
                }
            }
        }
    }
    static void sort(int arr[],int L,int R)
    {
       
    for (int i = L	; i <R; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < R; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void swap(int A[], int w, int x)
    {
        int tmp=A[w];
          A[w]=A[x];
          A[x]=tmp;
   }

 

    static int Select(int[] A, int k, int lewykraniec, int prawykraniec) {
        int p = 50;
        if (prawykraniec-lewykraniec < p) {
                sort(A,lewykraniec,prawykraniec); 
                return A[k+lewykraniec];
        }
        int medL=lewykraniec-5;
        int medR=lewykraniec;
        while(medR!=prawykraniec) {
            medL += 5;
            medR += 5;
            if (medR > prawykraniec) {
                medR = prawykraniec;
            }
            sort(A,medL,medR);
        }
        
        int medians=(prawykraniec-lewykraniec)/5;
        int c=lewykraniec+2;
            for(int i=lewykraniec;i<medians+lewykraniec;i++){
                 swap(A,i,c);
                 c+=5;
        }
        int M=Select(A,medians/2,lewykraniec,medians+lewykraniec);
           int pivot_l = lewykraniec;
          int pivot_r = prawykraniec-1;
                   for (int v= pivot_l; v <= pivot_r; v++) {
                         if (A[v] < M) {
                             swap(A, pivot_l, v);
                             pivot_l++;
                              }
                              if (A[v] > M) {
                               swap(A, pivot_r, v);
                               pivot_r--;
                                  v--;
                                       }
                                            }
       
        if(k+lewykraniec<pivot_l+1) {
            return Select(A, k, lewykraniec, pivot_l);
        }
        if(k+lewykraniec<pivot_r+1)
             return M;
               return Select(A,k+lewykraniec-pivot_r-1,pivot_r+1,prawykraniec);
    }

}