public class Process implements Comparable<Process>{
	private int ID;
	private int arrivalTime;
	private int CPUBurst;
	
	public Process(int ID, int arrivalTime, int CPUBurst) {
		this.ID = ID;
		this.arrivalTime = arrivalTime;
		this.CPUBurst = CPUBurst;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public int getarrivalTime() {
		return this.arrivalTime;
	}
	
	public int getCPUBurst() {
		return this.CPUBurst;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public void setArrivalTime(int time) {
		this.arrivalTime = time;
	}
	
	public void decrementCPUBurst() {
		this.CPUBurst--;
	}

	public int compareTo(Process process) {
		if(this.CPUBurst > process.CPUBurst) {
			return 1;
		}else if(this.CPUBurst < process.CPUBurst) return -1;
		return 0;
	}
}