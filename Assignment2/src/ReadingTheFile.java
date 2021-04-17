import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadingTheFile {
	private ArrayList<Process> processList;

	public ReadingTheFile() {
		try {
			FileInputStream fstream = new FileInputStream("assignment2.txt");
			InputStreamReader instream = new InputStreamReader(fstream);
			BufferedReader buffreader = new BufferedReader(instream);
			String current;
			this.processList = new ArrayList<>();
			
			String[] parsing;
			while((current = buffreader.readLine()) != null) {
				parsing = current.split(" ");
				int ID = Integer.parseInt(parsing[0]);
				int arrivalTime = Integer.parseInt(parsing[1]);
				int cpuBurst = Integer.parseInt(parsing[2]);
				processList.add(new Process(ID,arrivalTime,cpuBurst));
			}
			buffreader.close();
		}catch (IOException exception) {
			//exception.printStackTrace();
			System.out.print("File was not found");
		}
	}
	
	public ArrayList<Process> getProcessList(){
		return this.processList;
	}
}