
public class ProcessNode {

	private int ID, arrivalTime, CPUBurst;
	private ProcessNode next;

	public ProcessNode(int id, int arrivalTime, int CPUBurst) {
		this.ID = id;
		this.arrivalTime = arrivalTime;
		this.CPUBurst = CPUBurst;
		this.next = null;
	}

	public ProcessNode(int id, int arrivalTime, int CPUBurst, ProcessNode next) {
		this.ID = id;
		this.arrivalTime = arrivalTime;
		this.CPUBurst = CPUBurst;
		this.next = next;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getCPUBurst() {
		return CPUBurst;
	}

	public void setCPUBurst(int CPUBurst) {
		this.CPUBurst = CPUBurst;
	}

	public ProcessNode getNext() {
		return next;
	}

	public void setNext(ProcessNode next) {
		this.next = next;
	}
	
	public void decrementProcessNode() {
		this.CPUBurst--;
	}

}
