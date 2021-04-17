import java.util.ArrayList;

public class RR {
	private ArrayList<Process> processList;
	private CircularlyLinkedList readyQueueLinkedList;
	private SchedulingStatistics stats = new SchedulingStatistics();
	int timeQuantum, timeQuantumChecker, systemCounter , cpuUtil;
	private int[] tempArrival, tempOnCPU, tempFirstOnCPU, tempCompletion;
	
	public RR(ArrayList<Process> processList, int timeQuantum) {
		this.readyQueueLinkedList = new CircularlyLinkedList();
		this.processList = processList;
		this.timeQuantum = timeQuantum;
		this.timeQuantumChecker = 0;
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
				readyQueueLinkedList.addLast(i.getID(), i.getarrivalTime(),i.getCPUBurst());
				this.tempArrival[i.getID()-1] = systemCounter;
			}
		}
	}
	
	public void remove() {
		tempCompletion[readyQueueLinkedList.getHead().getID()-1] = systemCounter;
		readyQueueLinkedList.removeFirst();
	}
	
	public void runRoundRobin() {
		System.out.println("Scheduling algorithm: Round Robin ");
		System.out.println("============================================================");
		while(!this.readyQueueLinkedList.isEmpty()) {
			if(tempFirstOnCPU[readyQueueLinkedList.getHead().getID()-1] == -1) {
				tempFirstOnCPU[readyQueueLinkedList.getHead().getID()-1] = systemCounter;
			}
			System.out.println("<System time " + systemCounter + "> process " + readyQueueLinkedList.getHead().getID() + " is running");
			this.readyQueueLinkedList.getHead().decrementProcessNode();
			tempOnCPU[readyQueueLinkedList.getHead().getID()-1]++;
			this.systemCounter++;
			cpuUtil++;
			this.add();
			this.timeQuantumChecker++;
			
			if(this.readyQueueLinkedList.getHead().getCPUBurst() == 0) {
				System.out.println("<System time " + systemCounter + "> process " + readyQueueLinkedList.getHead().getID() + " is finished...");
				this.remove();
				this.timeQuantumChecker = 0;
			}
			
			if(this.timeQuantumChecker == this.timeQuantum) {
				readyQueueLinkedList.rotateProcess();
				this.timeQuantumChecker = 0;
			}
			
			if(this.readyQueueLinkedList.isEmpty()) {
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
}
