
public class LinkedListPCB {
	private int index;
	private LinkedList list;

	public LinkedListPCB() {
		this.list = new LinkedList();
		this.index = 0; 
	}
	
	public LinkedListPCB(int index) {
		this.list = new LinkedList();
		this.index = index;
	}
	
	public int getPapi() {
		return this.index;
	}
	
	public LinkedList ninos() {
		return this.list;
	}
	
	public void setIndex(int number) {
		this.index = number;
	}
	
	
}
