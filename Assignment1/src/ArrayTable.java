import java.util.ArrayList;
public class ArrayTable {
	private ArrayList<ArrayPCB> arrayTable;
	private int size;

	public ArrayTable(int size) {
		arrayTable = new ArrayList<ArrayPCB>();
		this.size = size;
		for(int i = 0; i < size; i++) {
			ArrayPCB arrayPCB = new ArrayPCB(-1);
			arrayTable.add(arrayPCB);
		}
	}

	public ArrayTable() {
		this.size = 5;
		for(int i = 0; i < size; i++) {
			ArrayPCB arrayPCB = new ArrayPCB(-1);
			arrayTable.add(arrayPCB);
		}
	}

	public void create(int index) {
		if(index > this.size || index < 0) {
			throw new IllegalArgumentException("Invalid!");
		}
		if(arrayTable.get(index).getParent() == -1) {
			ArrayPCB newPCB = new ArrayPCB(index);
			arrayTable.set(index, newPCB);
		}else {
			int nextIndex = spotTheSpot(index);
			ArrayPCB newPCB = new ArrayPCB(index);

			ArrayPCB thisPCB = arrayTable.get(index);
			if(thisPCB.getFirstChild() == -1) {
				thisPCB.setFirst(nextIndex);
				arrayTable.set(nextIndex, newPCB);
			}else{
				int youngestChild = thisPCB.getFirstChild();

				while(arrayTable.get(youngestChild).getYoungerSibling() != -1){ 
					youngestChild = arrayTable.get(youngestChild).getYoungerSibling();
				}
				arrayTable.get(youngestChild).setYounger(nextIndex);
				newPCB.setOlder(youngestChild);
				arrayTable.set(nextIndex, newPCB);
			}
		}
	}

	public int spotTheSpot(int index) {
		index++;
		while(arrayTable.get(index).getParent() != -1) {
			index++;
			if(index >= this.size) {
				throw new IndexOutOfBoundsException("Out of bounds");
			}
		}

		int check = index;
		return check;
	}

	public boolean checkForFirstChild(int index) {
		ArrayPCB myPCB = arrayTable.get(index);
		return myPCB.getFirstChild() != -1;
	}

	public boolean checkForYoungerSibling(int index) {
		ArrayPCB myPCB = arrayTable.get(index);
		return myPCB.getYoungerSibling() != -1;
	}

	public void destroy(int index) {
		ArrayPCB thisPCB = arrayTable.get(index);
		if(thisPCB.getParent() != -1) {
			if(checkForFirstChild(index)) {
				int youngestChild = thisPCB.getFirstChild();
				noSurvivors(youngestChild);
				ArrayPCB newPCB = new ArrayPCB(-1);
				arrayTable.set(youngestChild, newPCB);
				arrayTable.set(index, newPCB);
			}else {
				ArrayPCB newPCB = new ArrayPCB(-1);
				arrayTable.set(index, newPCB);
			}
		}
	}

	public boolean noSurvivors(int youngestChild) {
		if(checkForFirstChild(youngestChild)) {
			int first = arrayTable.get(youngestChild).getFirstChild();
			noSurvivors(first);
			ArrayPCB newPCB = new ArrayPCB(-1);
			arrayTable.set(first, newPCB);
		}


		if(checkForYoungerSibling(youngestChild)) {
			int young = arrayTable.get(youngestChild).getYoungerSibling();
			noSurvivors(young);
			ArrayPCB newPCB = new ArrayPCB(-1);
			arrayTable.set(young, newPCB);
		}

		ArrayPCB newPCB = new ArrayPCB(-1);
		arrayTable.set(youngestChild, newPCB);
		return false;
	}
	public int size() {
		return this.size;
	}
	
	public void print() {
		for(ArrayPCB i : arrayTable) {
			System.out.println("Parent " + i.getParent() + ", First child " + i .getFirstChild() + " , Older sibling " + i.getOlderSibling() + ", Younger sibling " + i.getYoungerSibling());

		}
		System.out.println();
	}
}
