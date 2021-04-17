
import java.util.ArrayList;

public class ProcessMergeSort {

	public static void mergeSort(ArrayList<Process> processList) {
		if (processList.size() < 2) return;
		int halfOfList = processList.size() / 2;
		ArrayList<Process> firstHalf = new ArrayList<Process>();
		ArrayList<Process> secondHalf = new ArrayList<Process>();

		for(int i = 0; i < halfOfList; i++) {
			firstHalf.add(processList.get(i));
		}

		for(int i = halfOfList; i < processList.size(); i++) {
			secondHalf.add(processList.get(i));
		}

		mergeSort(firstHalf);
		mergeSort(secondHalf);
		merge(firstHalf, secondHalf, processList);

	}

	private static void merge(ArrayList<Process> firstHalf, ArrayList<Process> secondHalf, ArrayList<Process> processList) {
		int a = 0, b = 0;
		while(a + b < processList.size()) {
			if (b == secondHalf.size() || (a < firstHalf.size() && firstHalf.get(a).compareTo(secondHalf.get(b)) < 0)) {
				processList.set(a + b, firstHalf.get(a++));
			}else {
				processList.set(a + b, secondHalf.get(b++));
			 }
		}
	}
}
