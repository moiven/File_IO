import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private static String[] files = {"scoresPt1.txt", "badscore.txt", "nofile.txt", "badname.txt"};
	
	public ScoreTrakker()
	{
		students = new ArrayList<Student>();
	}
	
	public void loadDataFromFile(String filename) throws Exception
	{
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);
		
		while (in.hasNextLine()) 
		{
			Student kid = new Student();
			
			//modified to catch errors in student scores
			String strNum = null;
			String inputName = null;
			try
			{
				inputName = in.nextLine();
				//check if students are missing last names or first names
				//checks for whitespace between names
				if(inputName.indexOf(' ') == -1)
				{
					throw new Exception("\n'" + inputName + "' does not include a first and last name");
				}
				kid.setName(inputName);
				
				strNum = in.nextLine();
				int inputScore = Integer.parseInt(strNum);
				kid.setScore(inputScore);
				students.add(kid);
			}
			catch (NumberFormatException e)
			{
				System.out.println("\nIncorrect format for " + inputName + " not a valid score: " + strNum + "\n");
			}
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
		students.clear();
	}
	
	public void processFiles(String[] filename) throws Exception
	{
		for(String file : filename)
		{
			try
			{
				loadDataFromFile(file);
				printInOrder();
			}
			//catch exception if there is no file found
			catch (FileNotFoundException e)
			{
				System.out.println("\nCan't open file: " + file);
			}
			//added catch for the exception in loadDataFromFile
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return;
			}
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
			ScoreTrakker tracker = new ScoreTrakker();
			tracker.processFiles(files);
	}
}