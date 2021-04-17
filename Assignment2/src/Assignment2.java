
public class Assignment2 {
	public static void main(String args[]) {
		ReadingTheFile readThisFile = new ReadingTheFile();
		if(args[0].equals("FCFS")) {
			FCFS firstComeFirstServe = new FCFS(readThisFile.getProcessList());
			firstComeFirstServe.add();
			firstComeFirstServe.runFirstComeFirstServe();
		}else {
			if(args[0].equals("SRTF")) {
				SRTF SRT = new SRTF(readThisFile.getProcessList());
				SRT.add();
				SRT.runShortestRemainingTimeFirst();
			}else {
				String argument1 = args[1];
				if(args[0].equals("RR") && args[1].equals(argument1)) {
					RR roundrobin = new RR(readThisFile.getProcessList(), Integer.parseInt(argument1));
					roundrobin.add();
					roundrobin.runRoundRobin();
				}
			}
		}
	}
}
