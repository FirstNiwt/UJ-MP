//Oleksy Dawid gr1
import java.util.Scanner;

public class Source {

	public static Scanner in = new Scanner(System.in);

	public static void main(String args[]) {
		String w, k;
		int z, n;
		z = in.nextInt();
		for (int i = 0; i < z; i++) {
			Lista_pociagow KEK = new Lista_pociagow();
			n = in.nextInt();

			for (int j = 0; j < n; j++) {
				char g = ' ';
				char s = ' ';

				w = in.next();
				char r = w.charAt(0);

				switch (r) {
				case 'D':
					s = w.charAt(3);
					Wagon U;
					Pociag x;
					if (s == 'p') {
						Pociag E;
						w = in.next();
						E = KEK.Wyszukaj(w);
						if (E == null)
						{System.out.println("Train"+ " " + w+ " "+ "does not exist");
							break;}
						else {
							E.Lista_wagonow.Display(E);
							System.out.println("");

						}
					} else if (s == 'F') {

						w = in.next();
						k = in.next();
						x = KEK.Wyszukaj(w);
						if(x==null)
						{System.out.println("Train"+ " " + w+ " "+ "does not exist");break;}
						if (x.Lista_wagonow.first == x.Lista_wagonow.last)
							KEK.delete(x.nazwa);
						U = x.Lista_wagonow.DeleteFirst();
						KEK.New(k, U.nazwa);
					} else {

						w = in.next();
						k = in.next();
						x = KEK.Wyszukaj(w);
						if(x==null)
						{System.out.println("Train"+ " " + w+ " "+ "does not exist");break;}
						if (x.Lista_wagonow.first == x.Lista_wagonow.last)
							KEK.delete(x.nazwa);
						U = x.Lista_wagonow.DeleteLast();
						KEK.New(k, U.nazwa);

					}
					break;

				case 'I':
					g = w.charAt(6);
					w = in.next();
					k = in.next();
					if (g == 'F') {
						x=KEK.Wyszukaj(w);
						if(x==null)
						{System.out.println("Train"+ " " + w+ " "+ "does not exist");break;}
						x.Lista_wagonow.InsertFirst(k);break;
					} else
					{x=KEK.Wyszukaj(w);
					if(x==null)
					{System.out.println("Train"+ " " + w+ " "+ "does not exist");break;}
						x.Lista_wagonow.InsertLast(k);
					break;
					}
				case 'N':
					w = in.next();
					k = in.next();
					KEK.New(w, k);
					break;
				case 'T':
					KEK.TrainList();
					System.out.println("");
					break;
				case 'U':
					w = in.next();
					k = in.next();
					x=KEK.Wyszukaj(w);
					if(x==null)
					{System.out.println("Train"+ " " + w+ " "+ "does not exist");break;}
					Pociag Y;
					Y=KEK.Wyszukaj(k);
					if(Y==null)
					{System.out.println("Train"+ " " + w+ " "+ "does not exist");break;}
					KEK.Union(x, Y);

					break;
				case 'R':
					w = in.next();
					x=KEK.Wyszukaj(w);
					if(x==null)
					{System.out.println("Train"+ " " + w+ " "+ "does not exist");break;}
					KEK.Reverse(x);
					break;

				}

			}

		}
	}
}

class Pociag

{
	String nazwa;
	Pociag next;
	Lista_wagonow Lista_wagonow = new Lista_wagonow();

	Pociag(String x, Pociag Next) {
		nazwa = x;
		next = Next;

	}

}

class Lista_pociagow
{
	Pociag first;

	Lista_pociagow() {
		first = null;
	}

	Pociag Wyszukaj(String w)
	{

		Pociag current = first;
		while (!current.nazwa.equals(w)) {
			if (current.next == null)
				return null;
			else
				current = current.next;

		}
		return current;

	}

	void New(String x, String y)
	{
		if(first==null||Wyszukaj(x)==null)
		{
		Pociag l;
		l = new Pociag(x, first);
		first = l;
		Wagon w = new Wagon(y);
		l.Lista_wagonow.first = w;
		l.Lista_wagonow.last = w;
		w.next = null;
		w.prev = null;
		}
		else
			{System.out.println("Train" + " " + x+ " "+ "already exists");return;};
		
	}

	void TrainList()
	{
		Pociag current = first;
		System.out.print("Trains: ");
		while (current != null) {
			if (current.next == null) {
				System.out.print(current.nazwa);
				current = current.next;
			} else {
				System.out.print(current.nazwa + " ");
				current = current.next;
			}

		}

	}

	void Reverse(Pociag x)
	{
		Wagon temp = x.Lista_wagonow.first;
		x.Lista_wagonow.first = x.Lista_wagonow.last;
		x.Lista_wagonow.last = temp;

	}

	void Union(Pociag x, Pociag y) {

		if (x.Lista_wagonow.last.next == null && y.Lista_wagonow.first.prev == null) {
			x.Lista_wagonow.last.next = y.Lista_wagonow.first;
			y.Lista_wagonow.first.prev = x.Lista_wagonow.last;
			x.Lista_wagonow.last = y.Lista_wagonow.last;
			delete(y.nazwa);

		} else if (x.Lista_wagonow.last.prev == null && y.Lista_wagonow.first.next == null) {
			x.Lista_wagonow.last.prev = y.Lista_wagonow.first;
			y.Lista_wagonow.first.next = x.Lista_wagonow.last;
			x.Lista_wagonow.last = y.Lista_wagonow.last;
			delete(y.nazwa);

		} else if (x.Lista_wagonow.last.next == null && y.Lista_wagonow.first.next == null) {
			x.Lista_wagonow.last.next = y.Lista_wagonow.first;
			y.Lista_wagonow.first.next = x.Lista_wagonow.last;
			x.Lista_wagonow.last = y.Lista_wagonow.last;
			delete(y.nazwa);

		} else if (x.Lista_wagonow.last.prev == null && y.Lista_wagonow.first.prev == null) {
			x.Lista_wagonow.last.prev = y.Lista_wagonow.first;
			y.Lista_wagonow.first.prev = x.Lista_wagonow.last;
			x.Lista_wagonow.last = y.Lista_wagonow.last;
			delete(y.nazwa);

		}
	}

	public Pociag delete(String x)
	{
		Pociag current = first;
		Pociag previous = first;
		while (!current.nazwa.equals(x)) {
			if (current.next == null)
				return null;
			else {

				previous = current;
				current = current.next;

			}
		}
		if (current == first)
			first = first.next;
		else {
			previous.next = current.next;
			current.next = null;
		}
		return current;
	}

}

class Wagon
{
	String nazwa;
	Wagon next;
	Wagon prev;

	Wagon(String x) {
		nazwa = x;

	}
}

class Lista_wagonow
{
	Wagon first;
	Wagon last;

	Lista_wagonow() {
		first = null;
		last = null;
	}

	void InsertFirst(String y)
	{
		if (first.prev == null) {
			Wagon l = new Wagon(y);
			first.prev = l;
			l.next = first;
			l.prev=null;
			first = l;
		} else {
			Wagon l = new Wagon(y);
			first.next = l;
			l.prev = first;
			l.next=null;
			first = l;
		}

	}

	void InsertLast(String y)
	{
		if (last.next == null) {
			Wagon l = new Wagon(y);
			last.next = l;
			l.prev = last;
			last = l;
		} else {
			Wagon l = new Wagon(y);
			last.prev = l;
			l.next = last;
			last = l;
		}

	}

	Wagon DeleteFirst()
	{
		Wagon temp = first;
		if (first == last) {
			last = null;
			first = null;
		} else if (first.next != null && first.next.prev == first) {
			first.next.prev = null;
			first = first.next;

		} else if (first.prev != null && first.prev.next == first) {
			first.prev.next = null;
			first = first.prev;

		} else if (first.prev != null && first.prev.prev == first) {
			first.prev.prev = null;
			first = first.prev;

		} else if (first.next != null && first.next.next == first) {
			first.next.next = null;
			first = first.next;

		}
		return temp;
	}

	Wagon DeleteLast()
	{
		Wagon temp = last;
		if (first == last) {
			last = null;
			first = null;
		} else if (last.prev != null && last.prev.next == last) {
			last.prev.next = null;
			last = last.prev;
		} else if (last.next != null && last.next.prev == last) {
			last.next.prev = null;
			last = last.next;
		} else if (last.prev != null && last.prev.prev == last) {
			last.prev.prev = null;
			last = last.prev;

		} else if (last.next != null && last.next.next == last) {
			last.next.next = null;
			last = last.next;

		}
		return temp;
	}

	void DisplayForward()
	{

		while (first != null) {
			if ((first.next != null && first.next.next == first)) {
				System.out.print(first.nazwa + " ");
				first = first.next;
				DisplayBackwards();
			} else if (first == last) {
				System.out.print(first.nazwa);
				first = first.next;
			}

			else {
				System.out.print(first.nazwa + " ");
				first = first.next;
			}

		}
	}

	void Display(Pociag x)
	{

		Wagon current = x.Lista_wagonow.first;

		System.out.print(x.nazwa + ":" + " ");
		if (first.prev == null)
			{DisplayForward();}

		else
			DisplayBackwards();

		x.Lista_wagonow.first = current;
	}

	void DisplayBackwards()
	{

		while (first != null) {
			if (first.prev != null && first.prev.prev == first) {
				System.out.print(first.nazwa + " ");
				first = first.prev;
				DisplayForward();
			} else if (first == last) {
				System.out.print(first.nazwa);
				first = first.prev;

			}

			else {
				System.out.print(first.nazwa + " ");
				first = first.prev;
			}

		}

	}
}

/*
 * IN
 8
4
New T1 W1
InsertFirst T1 W2
InsertFirst T1 W3
Display T1
4
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
Display T1
6
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
Reverse T1
Reverse T1
Display T1
7
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
Reverse T1
InsertLast T1 W4
InsertLast T1 W5
Display T1
7
New T1 W1
InsertFirst T1 W2
InsertFirst T1 W3
Reverse T1
InsertFirst T1 W4
InsertFirst T1 W5
Display T1
7
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
Reverse T1
InsertFirst T1 W4
InsertFirst T1 W5
Display T1
10
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
Reverse T1
InsertFirst T1 W4
InsertFirst T1 W5
Reverse T1
InsertFirst T1 W6
InsertFirst T1 W7
Display T1
10
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
Reverse T1
InsertFirst T1 W4
InsertFirst T1 W5
Reverse T1
InsertLast T1 W6
InsertLast T1 W7
Display T1 */


/*
 * OUT
T1: W3 W2 W1
T1: W1 W2 W3
T1: W1 W2 W3
T1: W3 W2 W1 W4 W5
T1: W5 W4 W1 W2 W3
T1: W5 W4 W3 W2 W1
T1: W7 W6 W1 W2 W3 W4 W5

T1: W1 W2 W3 W4 W5 W6 W7
*/
