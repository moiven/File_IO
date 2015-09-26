import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
	public ScoreTrakker()
	{
		students = new ArrayList<Student>();
	}
	
	public void loadDataFromFile(String filename) throws Exception
	{
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);
		
		while (in.hasNextLine()) {
			Student kid = new Student();

			String inputName = in.nextLine();
			kid.setName(inputName);
			String strNum = in.nextLine();
			int inputScore = Integer.parseInt(strNum);
			kid.setScore(inputScore);

			students.add(kid);
		}
	}
	
	public void printInOrder()
	{
		Collections.sort(students);
		System.out.println("Student Score List");
		for(Student stud: students)
		{
			System.out.println(stud.toString());
		}
	}
	
	public void processFiles(String filename) throws Exception
	{
		loadDataFromFile(filename);
		printInOrder();
	}
	
	public static void main(String[] args) throws Exception 
	{
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles("scoresPt1.txt");
	}
}