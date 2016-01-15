import java.util.ArrayList;

/**
 * Created by nyefan on 1/14/16.
 */
public class Manager extends Employee {
    private static final int allocation = 300;

    public Manager() {
        directSubordinates = null;
    }

    public Manager(Employee e) {
        directSubordinates = new ArrayList<Employee>();
        directSubordinates.add(e);
    }

    public Manager(ArrayList<Employee> sub) {
        directSubordinates = sub; // the person passing the ArrayList is responsible for ensuring this is a valid hierarchy
    }

    @Override
    public int getLocalAllocation() {
        return allocation;
    }
}
