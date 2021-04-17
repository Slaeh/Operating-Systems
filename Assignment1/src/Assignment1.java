
public class Assignment1 {
	public static void main (String[] args) {
		LinkedListTable testTable = new LinkedListTable(1000);
		long startTime = System.nanoTime();
		
		for(int i = 0; i < testTable.getSize(); i++) {
			testTable.create(0);
		}
		long endTime = System.nanoTime();
		System.out.println("Finished creating Linked List. Our Linked List took " + (endTime - startTime) + " in nanoseconds.");
		
		ArrayTable testTable2 = new ArrayTable(1000);
		long startTime2 = System.nanoTime();
		for(int i = 0; i < testTable2.size(); i++) {
			testTable2.create(0);
		}
		long endTime2 = System.nanoTime();
		System.out.println("Finished creating array. Our array took " + (endTime2 - startTime2) + " in nanoseconds.");
		
		long first = (endTime - startTime);
		long second = (endTime2 - startTime2);
		
		if(first > second) {
			long difference = second - first;
			System.out.println("Linked list saved " + difference + "nanoseconds.");
		}else {
			long difference = second - first;
			System.out.println("Our Array saved " + difference + " nanoseconds.");
		}
	}
}
