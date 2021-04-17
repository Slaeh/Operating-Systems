
public class ArrayPCB {
	private int parent, firstChild, olderChild, youngerChild;
	
	public ArrayPCB(int parent, int firstChild, int olderChild, int youngerChild) {
		this.parent = parent;
	}
	
	public ArrayPCB(int parent) {
		this.parent = parent;
		this.firstChild = -1;
		this.olderChild = -1;
		this.youngerChild = -1;
	}
	
	public int getParent() {
		return this.parent;
	}
	
	public int getFirstChild() {
		return this.firstChild;
	}
	
	public int getOlderSibling() {
		return this.olderChild;
	}
	
	public int getYoungerSibling() {
		return this.youngerChild;
	}
	
	public void setFirst(int index) {
		this.firstChild = index;
	}
	
	public void setOlder(int index) {
		this.olderChild = index;
	}
	
	public void setYounger(int index) {
		this.youngerChild = index;
		
	}
	
	public void setParent(int index) {
		this.parent = index;
	}
}
