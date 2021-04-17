import java.util.ArrayList;

public class SRTF  {
	private ArrayList<Process> processList;
	private ArrayList<Process> readyQueue;
	private int systemCounter, cpuUtil;
	private SchedulingStatistics stats = new SchedulingStatistics();
	private int[] tempArrival, tempOnCPU, tempFirstOnCPU, tempCompletion;	

	public SRTF(ArrayList<Process> processList) {
		this.readyQueue = new ArrayList<Process>();
		this.processList = processList;
		this.systemCounter = 0;
		this.tempArrival = new int[processList.size()];
		this.tempOnCPU = new int[processList.size()];
		this.tempFirstOnCPU = new int[processList.size()];
		for(int i = 0; i < tempFirstOnCPU.length; i++) {
			tempFirstOnCPU[i] = -1;
		}
		this.tempCompletion = new int[processList.size()];
		this.cpuUtil = 0;
	}

	public void add() {
		for(Process i : processList) {
			if(i.getarrivalTime() == systemCounter) {
				this.readyQueue.add(new Process(i.getID(), i.getarrivalTime(), i.getCPUBurst()));
				this.tempArrival[i.getID()-1] = systemCounter;
			}
		}
		ProcessMergeSort.mergeSort(readyQueue);
	}

	public void remove(int index) {
		tempCompletion[readyQueue.get(index).getID()-1] = systemCounter;
		readyQueue.remove(index);
	}

	public void runShortestRemainingTimeFirst() {
		int start = 0;
		System.out.println("Scheduling algorithm: Shortest Remaining Time First");
		System.out.println("============================================================");
		while(!readyQueue.isEmpty()) {
			if(tempFirstOnCPU[readyQueue.get(start).getID()-1] == -1) {
				tempFirstOnCPU[readyQueue.get(start).getID()-1] = systemCounter;
			}
			System.out.println("<System time " + systemCounter + "> process " + readyQueue.get(start).getID() + " is running");
			readyQueue.get(start).decrementCPUBurst();
			tempOnCPU[readyQueue.get(start).getID()-1]++;
			cpuUtil++;
			systemCounter++;
			this.add();
			if(readyQueue.get(start).getCPUBurst() == 0) {
				System.out.println("<System time " + systemCounter + "> process " + readyQueue.get(start).getID() + " is finished...");
				this.remove(start);
			}
		}
		
		if(this.readyQueue.isEmpty()){
			System.out.println("<System time " + systemCounter + "> All processes finished...");
			System.out.println("============================================================");
			stats.setFirstArrival(tempArrival);
			stats.setCompletion(tempCompletion);
			stats.setFirstCPU(tempFirstOnCPU);
			stats.setTimeOnCPU(tempOnCPU);
			System.out.println("Average CPU Utilization: " + (cpuUtil/systemCounter) * 100.0 + "%");
			System.out.println("Average waiting time: " + stats.averageWait());
			System.out.println("Average response time: " + stats.averageResponseTime());
			System.out.println("Average turnaround time: " + stats.averageTurnAroundTime());
		}
	}
}