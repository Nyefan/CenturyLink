import java.util.ArrayList;

/**
 * Created by nyefan on 1/14/16.
 */
public abstract class Employee {
    private static final int allocation = 0;

    public static ArrayList<Employee> directSubordinates = null;
    public int getAllocation() {
        int localAllocation = allocation;
        for (Employee e : directSubordinates) {
            localAllocation += e.getAllocation();
        }
        return localAllocation;
    }

    public int getAllocation(int depth) {
        int localAllocation = allocation;
        for (Employee e : directSubordinates) {
            localAllocation += e.getAllocation(depth-1);
        }
        return localAllocation;
    }
}