
public class LinkedNode {
	private int data;
	private LinkedNode next;

	public LinkedNode(int data) {
		this.data = data;
		this.next = (null);
	}

	public LinkedNode(int data, LinkedNode next) {
		this.data = data;
		this.next = next;
	}

	public LinkedNode getNext() {
		return this.next;
	}
	
	public int getData() {
		return this.data;
	}
	

	public void setNext(LinkedNode next) {
		this.next = next;
	}
	
	public String toString() {  
		StringBuffer returnData = new StringBuffer();
		return returnData.append(this.data).toString();
	}
}
