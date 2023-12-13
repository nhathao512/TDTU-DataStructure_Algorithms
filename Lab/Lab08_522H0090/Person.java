public class Person implements Comparable<Person>
{
    String name;
    int priority;

    public Person(String name, int priority)
    {
        this.name = name;
        this.priority = priority;
    }

    public int compareTo(Person o)
    {
        if (priority < o.priority)
        {
            return -1;
        }
        else if (priority > o.priority)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public String toString()
    {
        return name + "(" + priority + ")";
    }
}
