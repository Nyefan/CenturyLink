import java.util.ArrayList;

/**
 * Created by nyefan on 1/14/16.
 */
public abstract class Employee {
    
    //TODO: check that this can be changed to private/protected, and do so, if possible
    public abstract int getLocalAllocation();

    public ArrayList<Employee> directSubordinates = null;

    public int getAllocation() {
        int localAllocation = getLocalAllocation();
        if(directSubordinates != null) {
            for (Employee e : directSubordinates) {
                localAllocation += e.getAllocation();
            }
        }
        return localAllocation;
    }

    public int getAllocation(int depth) {
        int localAllocation = getLocalAllocation();
        if(directSubordinates != null && !(depth < 0)) {
            for (Employee e : directSubordinates) {
                localAllocation += e.getAllocation(depth - 1);
            }
        }
        return localAllocation;
    }
}
