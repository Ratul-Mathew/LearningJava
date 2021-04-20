import java.util.*;
import java.util.stream.Collectors;
public class LinkedListVsArrayList {

	private static List<Integer> loadList(List<Integer> list, int count) {
		for(int i = 0; i< count; i++) {
			list.add(i);
		}
		System.out.println("List size after insertion = "+list.size());
		for(int i = 0; i< 10000; i+=2) {
			list.remove(i);
		}
		System.out.println("List size after deletion  = "+list.size());
		return list;
	}
	
	private static void searchList(List<Integer> list) {
		for(int i = 0; i< 10; i++) {
			list.stream()
			 .filter(item -> item.equals(123))
			 .collect(Collectors.toList());
		}
	}
	
	public static void main(String[] args) {
		System.out.println("===============[ ArrayList- Insertion + Deletion]=====================");
		long startTime = System.nanoTime();
		List<Integer> arrayList = loadList(new ArrayList<Integer>(), 1000000);
		long stopTime = System.nanoTime();
		System.out.println("Time taken by ArrayList [Insertion + Deletion] = "+((double) (stopTime - startTime) / 1_000_000_000) + " seconds");
		
		System.out.println("\n\n===============[ LinkedList- Insertion + Deletion]====================");
		long startTime2 = System.nanoTime();
		List<Integer> linkedList = loadList(new LinkedList<Integer>(), 1000000);
		long stopTime2 = System.nanoTime();
		System.out.println("Time taken by LinkedList [Insertion + Deletion] = "+((double) (stopTime2 - startTime2) / 1_000_000_000) + " seconds");
		
		
		System.out.println("\n\n=================[ LinkedList- Search]================================");
		long startTime1 = System.nanoTime();
		searchList(arrayList);
		long stopTime1 = System.nanoTime();
		System.out.println("Time taken by ArrayList [Search] = "+((double) (stopTime1 - startTime1) / 1_000_000_000) + " seconds");
		
		System.out.println("\n\n===============[ LinkedList- Search]==================================");
		long startTime3 = System.nanoTime();
		searchList(linkedList);
		long stopTime3 = System.nanoTime();
		System.out.println("Time taken by LinkedList [Search] = "+((double) (stopTime3 - startTime3) / 1_000_000_000) + " seconds");
		System.out.println("======================================================================");
	}
}

/* Output ->

===============[ ArrayList- Insertion + Deletion]=====================
List size after insertion = 1000000
List size after deletion  = 995000
Time taken by ArrayList [Insertion + Deletion] = 6.694161976 seconds


===============[ LinkedList- Insertion + Deletion]====================
List size after insertion = 1000000
List size after deletion  = 995000
Time taken by LinkedList [Insertion + Deletion] = 0.836311736 seconds


=================[ LinkedList- Search]================================
Time taken by ArrayList [Search] = 0.366446759 seconds


===============[ LinkedList- Search]==================================
Time taken by LinkedList [Search] = 0.275328048 seconds
======================================================================

*/