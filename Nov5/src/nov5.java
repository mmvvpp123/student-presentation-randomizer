import java.util.*;
public class nov5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the start time: ");
		
		int startTime = extractor(scan.nextLine());
		
		String time [] = timeSlots(startTime, 12);
		
		char students [] = studentCreator(12);
		
		students = randomStudent(students);
		
		
		System.out.println("Time    |    Students");
		System.out.println("---------------------");
		
		for(int i = 0; i < students.length; i++) {
			System.out.printf("%5s %10s", time[i], students[i]);
			System.out.println();
		}
				
	}
	
	public static int extractor(String time) {
		
		int semiColon = time.indexOf(":");
		
		int hour = Integer.parseInt(time.substring(0, semiColon));
		int min = Integer.parseInt(time.substring(semiColon+1, time.length()));
		
		return (hour * 60) + min;
		
	}
	
	public static String [] timeSlots(int startTime, int numOfSlots) {
		
		String [] time = new String [numOfSlots];
		time[0] = timeToString(startTime);
		
		
		
		for(int i = 1; i < numOfSlots; i++) {
			
			startTime += 10;
			time[i] = timeToString(startTime);
			
		}
		return time;
		
	}
	
	public static String timeToString(int time) {
				
		String hour = Integer.toString(time/60);
		String mins = Integer.toString(time - ((time/60) * 60));
		
		if(mins.length() < 2)
			mins += "0";
		
		return hour + ":" + mins;
		
	}
	
	public static char [] studentCreator(int slots) {
		char [] students = new char [slots];
		
		char first = 'A';
		
		for(int i = 0; i < slots; i++) {
			students[i] = first++;
		}
		
		return students;
	}
	
	public static char[] randomStudent(char [] students) {
		
		Random rndm = new Random();
		for(int i = 0; i < students.length; i++) {
			int randomStu = rndm.nextInt(students.length-1);
			char temp = students[i];
			students[i] = students[randomStu];
			students[randomStu] = temp;
		}
		return students;
		
	}
}
