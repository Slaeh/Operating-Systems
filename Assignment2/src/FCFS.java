import java.util.ArrayList;

public class FCFS {
	private ArrayList<Process> processList;
	private ArrayList<Process> readyQueue;
	private SchedulingStatistics stats;
	private int systemCounter;
	private int[] tempArrival, tempOnCPU, tempFirstOnCPU, tempCompletion;
	private int cpuUtil;

	public FCFS(ArrayList<Process> processList) {
		this.processList = processList;
		this.stats = new SchedulingStatistics();
		this.readyQueue = new ArrayList<Process>();
		this.tempArrival = new int[processList.size()];
		this.tempOnCPU = new int[processList.size()];
		this.tempFirstOnCPU = new int[processList.size()];
		for(int i = 0; i < tempFirstOnCPU.length; i++) {
			this.tempFirstOnCPU[i] = -1;
		}
		this.tempCompletion = new int[processList.size()];
		this.systemCounter = 0;
		this.cpuUtil = 0;

	}

	public void add() {
		for(Process i : processList) {
			if(i.getarrivalTime() == systemCounter) {
				this.readyQueue.add(new Process(i.getID(), i.getarrivalTime(), i.getCPUBurst()));
				this.tempArrival[i.getID()-1] = systemCounter;
			}
		}
	}

	public void remove(int index) {
		tempCompletion[readyQueue.get(index).getID()-1] = systemCounter;
		readyQueue.remove(index);
	}

	public void runFirstComeFirstServe() {
		int i = 0;
		System.out.println("Scheduling algorithm: First Come First Serve");
		System.out.println("============================================================");
		while(!readyQueue.isEmpty() && readyQueue.get(i).getCPUBurst() > 0) {
			if(tempFirstOnCPU[readyQueue.get(i).getID()-1] == -1) {
				tempFirstOnCPU[readyQueue.get(i).getID()-1] = systemCounter;
			}
			System.out.println("<System time " + systemCounter + "> process " + readyQueue.get(i).getID() + " is running");
			readyQueue.get(i).decrementCPUBurst();
			tempOnCPU[readyQueue.get(i).getID()-1]++;
			systemCounter++;
			cpuUtil++;
			this.add();
			if(readyQueue.get(i).getCPUBurst() == 0) {
				System.out.println("<System time " + systemCounter + "> process " + readyQueue.get(i).getID() + " is finished...");
				this.remove(i);
			}
		}

		if(this.readyQueue.isEmpty()){
			stats.setFirstArrival(tempArrival);
			stats.setCompletion(tempCompletion);
			stats.setFirstCPU(tempFirstOnCPU);
			stats.setTimeOnCPU(tempOnCPU);
			System.out.println("<System time " + systemCounter + "> All processes finished...");
			System.out.println("============================================================");
			System.out.println("Average CPU Utilization: " + (cpuUtil/systemCounter) * 100.0 + "%");
			System.out.println("Average waiting time: " + stats.averageWait());
			System.out.println("Average response time: " + stats.averageResponseTime());
			System.out.println("Average turnaround time: " + stats.averageTurnAroundTime());
			
		}
	}
}
