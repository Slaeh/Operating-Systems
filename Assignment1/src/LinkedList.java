
public class LinkedList {

	private LinkedNode header;
	private int size; 

	public LinkedList() {
		this.header = null;
		this.size = 0;
	}

	public void insertNode(int data) {
		LinkedNode newNode = new LinkedNode(data,null);
		if(this.header == null) {
			this.header = newNode;
			this.size++;
		}else {
			LinkedNode start = this.header;
			while(start.getNext() != null) {
				start = start.getNext();
			}
			start.setNext(newNode);
			this.size++;
		}
	}

	public int deleteNode(int data) {
		if(this.size == 1) {
			this.size--;
			int holdThis = header.getData();
			this.header = null;
			return holdThis;
		}
		LinkedNode first = this.header;
		LinkedNode second = this.header.getNext();
		while(second.getData() != data) {
			second = second.getNext();
			first = first.getNext();
		}

		int returnThis = second.getData();
		first.setNext(null);
		this.size--;
		return returnThis;
	}


	public int size() {
		return this.size;
	}

	public LinkedNode getHead() {
		return this.header;
	}

	public boolean isEmpty() {
		return this.size == 0;

	}

	public int lastNode() {
		LinkedNode start = this.header;
		while(start.getNext() != null) {
			start = start.getNext();
		}
		return start.getData();
	}
}
