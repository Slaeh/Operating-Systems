import java.util.ArrayList;

public class LinkedListTable {
	private ArrayList<LinkedListPCB> PCBTable;
	private int size;

	public LinkedListTable(int size) {
		PCBTable = new ArrayList<LinkedListPCB>();
		this.size = size;
		for(int i = 0; i < this.size; i++) {
			LinkedListPCB linkedlistpcb = new LinkedListPCB(-1);
			PCBTable.add(linkedlistpcb);
		}
	}

	public LinkedListTable() {
		PCBTable = new ArrayList<LinkedListPCB>();
		this.size = 5;
		for(int i = 0; i < 5; i++) {
			LinkedListPCB linkedlistpcb = new LinkedListPCB(-1);
			PCBTable.add(linkedlistpcb);
		}
	}	

	public void create(int index) {
		if(index > this.size || index < 0) {
			throw new IllegalArgumentException("Invalid!");
		}

		if(PCBTable.get(index).getPapi() == -1) {
			LinkedListPCB linkedlistpcb = new LinkedListPCB(index);
			PCBTable.set(index, linkedlistpcb);

		}else {
			int nextIndex = spotTheSpot(index);
			LinkedListPCB nextPCB = new LinkedListPCB(index);
			PCBTable.set(nextIndex, nextPCB);
			LinkedListPCB PCBSpot = PCBTable.get(index);
			PCBSpot.ninos().insertNode(nextIndex);
		}
		
	}

	public int spotTheSpot(int index) {
		index++;
		while(PCBTable.get(index).getPapi() != -1) {
			index++;
			if(index >= this.size) {
				throw new IndexOutOfBoundsException("Out of bounds");
			}
		}

		int check = index;
		return check;
	}

	public void destroy(int index) {
        LinkedListPCB myPCB = PCBTable.get(index);

        while(myPCB.ninos().size() >= 1){
            int last = myPCB.ninos().lastNode();
            System.out.println("Last is " + last);
            int newLast = myPCB.ninos().deleteNode(last);
            destroy(newLast);
        }
         myPCB.setIndex(-1);
    }

	public int getSize() {
		return this.size;
	}

	public void print () {
		for(LinkedListPCB i : PCBTable ) {
			System.out.print(i.getPapi() + ", " + i.ninos().toString());
			System.out.println();
		}
	}

	public String printChildren () {
		StringBuffer children = new StringBuffer();
		children.append("These are my children: ");
		LinkedList childZero = PCBTable.get(0).ninos();
		LinkedNode first = childZero.getHead();
		while(first != null) {
			children.append(first.getData() + ", ");
			first = first.getNext(); 
		}

		return children.toString();
	}
}
