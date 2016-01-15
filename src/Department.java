import java.util.ArrayList;

/**
 * Created by nyefan on 1/14/16.
 */

public class Department {

    private ArrayList<Employee> Board;

    public Department() {
        Board = null;
    }

    public Department(Employee e) {
        Board = new ArrayList<Employee>();
        Board.add(e);
    }

    public Department(ArrayList<Employee> b) {
        Board = b;
    }

    public int getAllocation() {
        int localAllocation = 0;
        for (Employee e : Board) {
            localAllocation += e.getAllocation();
        }
        return localAllocation;
    }

    public int getAllocation(int depth) {
        int localAllocation = 0;
        for (Employee e : Board) {
            localAllocation += e.getAllocation(depth);
        }
        return localAllocation;
    }
}
