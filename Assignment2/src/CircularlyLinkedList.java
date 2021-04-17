
public class CircularlyLinkedList{
	private ProcessNode tail;
	private int size;
	
	public CircularlyLinkedList() {
		this.size = 0; 
	}
	
	public void rotateProcess() {
		if(this.isEmpty()) return;
		this.tail = this.tail.getNext();
	}
	
	public int first() {
		if (this.isEmpty()) return 0;
		return this.tail.getNext().getCPUBurst();
	}
	
	public ProcessNode getHead() {
		if(this.size == 1) {
			return this.tail;
		}
		return this.tail.getNext();
	}
	
	public int last() {
		if (this.isEmpty()) return 0;	
		return this.tail.getNext().getCPUBurst();
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.tail == null;
	}
	
	public void addFirst(int id, int arrivaltime, int burst) {
		ProcessNode newProcess = new ProcessNode(id, arrivaltime , burst);
		if (this.isEmpty()) {
			this.tail = newProcess;
			this.tail.setNext(tail);
		} else {
			newProcess.setNext(this.tail.getNext());
			this.tail.setNext(newProcess);
		}
		this.size++;
	}
	
	public void addLast(int id, int arrivaltime, int burst) {
		this.addFirst(id, arrivaltime, burst);
		this.rotateProcess();
	}
	
	public void removeFirst() {
		ProcessNode oldProcess = this.tail.getNext();
		if (oldProcess == this.tail) {
			this.tail = null;
		}else {
			this.tail.setNext(oldProcess.getNext());
		}
		this.size--;
	}
}
