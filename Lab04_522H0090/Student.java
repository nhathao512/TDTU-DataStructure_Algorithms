import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
class Student 
{
    private String name;
    private double mathematics;
    private double programing;
    private double DSA1;

    public Student()
    {
        this.name = "";
        this.mathematics = 0.0;
        this.programing = 0.0;
        this.DSA1 = 0.0;
    }

    public Student(String name, double mathematics, double programing, double DSA1)
    {
        this.name = name;
        this.mathematics = mathematics;
        this.programing = programing;
        this.DSA1 = DSA1;
    }

    public String getName()
    {
        return this.name;
    }

    public double getAverage()
    {
        return (mathematics + programing + DSA1) / 3;
    }

    public static class AverageComparator implements Comparator<Student>
    {
        public int compare(Student s1, Student s2)
        {
            if (s1.getAverage() < s2.getAverage())
            {
                return -1;
            }
            else if (s1.getAverage() > s2.getAverage())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }

    public static void main(String[] args)
    {
        List<Student> student = new ArrayList<>();
        student.add(new Student("Hao", 9.0, 8.0, 9.5));
        student.add(new Student("Tri", 8.0, 7.0, 6.5));
        student.add(new Student("Nhan", 7.0, 7.5, 8.5));

        Comparator<Student> s1 = new AverageComparator();
        student.sort(s1);

        for(Student students : student)
        {
            System.out.println(students.getName() + ":" + students.getAverage());
        }
    }
}


    


