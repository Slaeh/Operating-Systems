public class SchedulingStatistics {
	private int[] firstArrival, firstCPU, timeOnCPU, completion;

	public double averageWait() {
		double ans = 0;
		int timeCPU, timeArrive,timeComplete;
		for(int i=0; i < completion.length; i++) {
			timeCPU = timeOnCPU[i];
			timeArrive = firstArrival[i];
			timeComplete = completion[i];
			ans += (timeComplete-timeArrive)-timeCPU;
		}
		ans = ans/completion.length;
		return ans;
	}

	public double averageResponseTime() {
		double ans = 0;
		int firstcpu, arrived;
		for(int i = 0; i < completion.length; i++) {
			arrived = firstArrival[i];
			firstcpu = firstCPU[i];
			ans += (firstcpu - arrived);
		}
		ans = ans/completion.length;
		return ans;
	}

	public double averageTurnAroundTime() {
		double ans = 0;
		int timeArrived, timeCompleted;
		for(int i = 0;i < completion.length; i++) {
			timeArrived = firstArrival[i];
			timeCompleted = completion[i];
			ans += (timeCompleted - timeArrived);
		}
		ans = ans/completion.length;
		return ans; 
	}

	public int[] getFirstArrival() {
		return firstArrival;
	}
	public void setFirstArrival(int[] firstArrival) {
		this.firstArrival = firstArrival;
	}
	public int[] getFirstCPU() {
		return firstCPU;
	}
	public void setFirstCPU(int[] firstCPU) {
		this.firstCPU = firstCPU;
	}
	public int[] getTimeOnCPU() {
		return timeOnCPU;
	}
	public void setTimeOnCPU(int[] timeOnCPU) {
		this.timeOnCPU = timeOnCPU;
	}
	public int[] getCompletion() {
		return completion;
	}
	public void setCompletion(int[] completion) {
		this.completion = completion;
	}

}
