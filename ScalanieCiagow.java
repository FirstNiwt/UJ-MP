//Oleksy Dawid gr 1
import java.util.Scanner;
 class Source {
    public static Scanner in=new Scanner(System.in);

    public static void main(String[] args) {
    	int max=0;
    	int liczba_zestawow=in.nextInt();
    	for(int i=0;i<liczba_zestawow;i++)
    	{
    		
    		int liczba_ciagow=in.nextInt();
    		int tab[]=new int[liczba_ciagow];
    		for(int j=0;j<liczba_ciagow;j++)
    		{
    			tab[j]=in.nextInt();
    			int d=tab[j];
    			
    			if(d>max)
    			max=d;
    		}	
    
    		
    		int tab_ciag[][]=new int[liczba_ciagow][max];
    		for(int w=0;w<liczba_ciagow;w++)
    		{
    			int g=0;
    			for(g=0;g<tab[w];g++)
    				tab_ciag[w][g]=in.nextInt();
    			for(int j=g;j<max-tab[w];j++)
    			{
    				tab_ciag[w][j]=Integer.MAX_VALUE;
    			} 
    				
    		}
    
    		Scalanie_min_heap(tab_ciag,tab_ciag.length);
    	}
    	



	

    }
  
    //Scalanie K cišgów
    	static void Scalanie_min_heap(int[][] arr, int k) {
    		Elem[] Arr = new Elem[k];
    		int dl = 0;	
    		for(int i=0;i<arr.length;i++) {
    			Elem node = new Elem(arr[i][0],i,1);
    			
    			Arr[i] = node;
    			dl += arr[i].length;
    		
    		}
            
    		MIN_HEAP mh = new MIN_HEAP(Arr);
     
    		int[] wynik = new int[dl];
     
    		for(int i=0;i<dl;i++) {
    			Elem root = mh.getMin();
    			wynik[i] = root.element;
     
    			if(root.j < arr[root.i].length)
    				root.element = arr[root.i][root.j++];
    			else
    				root.element = Integer.MAX_VALUE;
     
    			mh.switch_Min(root);
    		}
     
    		boolean z=false;
    		for(int i=0;i<wynik.length;i++)
    		{
    			if(wynik[i]!=0)z=true;
    			
    if(wynik[i]!=Integer.MAX_VALUE&&z==false)  					
	    System.out.print(wynik[i] + " ");
    else if(wynik[i]!=Integer.MAX_VALUE&&wynik[i]!=0&&z==true)
    { System.out.print(wynik[i] + " ");}
    			
    			
    		}
    		System.out.println();
     
    	}
     
    	
     
    	
    	//Klasa typu NODE
    	 static class Elem {
    	    	int element;
    	    	int i;
    	    	int j;
    	     
    	    	public Elem(int element, int i, int j) {
    	    		this.element = element;
    	    		this.i = i;
    	    		this.j = j;
    	    	}
    	    }
   
   
     //Klasa MinHeap
   static class MIN_HEAP {
    	int capacity;
    	Elem arr[];
    	int size;
     
    	public MIN_HEAP(Elem[] arr) {
    		this.capacity = arr.length;
    		this.size = this.capacity;
    		this.arr = arr;
    		buildMinHeap();
    	}
     
    	void swap(Elem[] arr, int i, int j) {
    		Elem temp = arr[i];
    		arr[i] = arr[j];
    		arr[j] = temp;
    	}
     
    	int Parent(int i) {
    		return (i-1)/2;
    	}
     
    	int Lewy(int i) {
    		return 2*i + 1;
    	}
     
    	int Prawy(int i) {
    		return 2*i + 2;
    	}
     
    	Elem getMin() {
    		if(size <= 0) {
    			System.out.println("Heap underflow");
    			return null;
    		}
    		return arr[0];
    	}
     
    	
    	void MinHeapfiy(int i) {
    		int l = Lewy(i);
    		int r = Prawy(i);
    		int SL = i;
     
    		if(l < size && arr[l].element < arr[SL].element)
    			SL = l;
    		if(r < size && arr[r].element < arr[SL].element)
    			SL = r;
    		if(SL != i) {
    			swap(arr,i,SL);
    			MinHeapfiy(SL);
    		}
    	}
     
    	void buildMinHeap() {
    		int n = arr.length;
    		for(int i = (n/2)-1;i>=0;i--)
    			MinHeapfiy(i);
    	}
     
    	void switch_Min(Elem root) {
    		arr[0] = root;
    		MinHeapfiy(0);
    	}
     
    	
     
   }
}