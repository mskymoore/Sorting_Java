import java.io.*;
import java.util.*;

public class SortArray{

	public static void main(String[] args){
		LinkedList org = new LinkedList();
		LinkedList away = new LinkedList();
		LinkedList sorted = new LinkedList();
		int hydex, lodex, pass = 0;
		away = inArr(away);//initializes away randomly
		for(int i = 0; i < away.size(); i++){//copies original array for display
			org.add(i, away.get(i));
		}//for
		System.out.println("\nRandomly generated array of size " +away.size()+" is:\n");
		toString(away);//displays randomly generated LinkedList away
		System.out.println();
		while(away.size() > 0){//this is where everything gets sorted out
			if(away.size() == 1){//if there's only one element left
				IntC last = (IntC)away.get(0);
				sorted.add(pass, last);
				away.remove(0);
				pass++;
			}//if
			else {//more than one element
				hydex = findHi(away);
				lodex = findLo(away);
				IntC hi = (IntC)away.get(hydex);
				IntC lo = (IntC)away.get(lodex);
				sorted.add(pass, lo);
				sorted.add(pass+1, hi);
				if(hydex < lodex){//remove higher index first
					away.remove(lodex);//otherwise second element removed is one above target
					away.remove(hydex);	
				}//if
				else {//remove higher index first
					away.remove(hydex);
					away.remove(lodex);
				}//else
				pass++;
			}//else
			System.out.println("Pass " +pass+":");
			toString(sorted);
			System.out.println();
		}//while
		System.out.println("Original Array: ");
		toString(org);
		System.out.println("\nSorted Array: ");
		toString(sorted);
	}//main
	
	public static int findHi(LinkedList a){//finds highest value object of type IntC in a linked list
		int high = Integer.MIN_VALUE;		//and returns the index
		int hydex = 0;
		for(int i = 0; i < a.size(); i++){
			IntC x = (IntC)a.get(i);
			if(x.getv() > high){
				high = x.getv();
				hydex = i;
			}//if
		}//for
		return hydex;
	}//findHi

	public static int findLo(LinkedList a){//finds lowest value object of type IntC in a linked list
		int low = Integer.MAX_VALUE;		//and returns the index
		int lodex = 0;
		for (int i = 0; i < a.size(); i++){
			IntC x = (IntC)a.get(i);
			if(x.getv() < low){
				low = x.getv();
				lodex = i;
			}//if
		}//for
		return lodex;
	}//findLo
	
	public static int rint(){//returns a random integer of the set [0, 100]
		Random r = new Random();
		int ret = r.nextInt(101);
		return ret;
	}//rint
	
	public static IntC r(){//returns IntC object with random value of the set [0,100]
		Random r = new Random();
		IntC ret = new IntC();
		ret.setv(r.nextInt(101));
		return ret;
	}//r

	public static LinkedList inArr(LinkedList a){//initializes a linked list to a random size(using r()) of [0,100]
		for(int i = 0; i < rint(); i++){		//with integer objects with random values of [0,100]
			a.add(i, r());
		}//for
		return a;
	}//initArray

	public static String toString(LinkedList a){//turns a linked list of IntC objects into a string 
		String s = "[";							//of their corresponding values
		for(int i = 0; i < a.size(); i++){
			IntC x = (IntC)a.get(i);
			if(i > 0){s +=", ";}
			s += x.getv();
		}//for
		s += "]";
		System.out.println(s);
		return s;
	}//toString
}//class