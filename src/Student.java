
public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public void setName(String inputName)
	{
		this.name = inputName;
	}
	
	public void setScore(int inputScore)
	{
		this.score = inputScore;
	}
	
	public String toString()
	{
		return (this.name + " " + this.score);
	}
	
	@Override
	public int compareTo(Student other) {
		return Integer.compare(other.score, this.score);
	}
}
