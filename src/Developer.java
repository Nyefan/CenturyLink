/**
 * Created by nyefan on 1/14/16.
 */
public class Developer extends Employee {

    private static final int allocation = 1000;

    public Developer() {
        directSubordinates = null;
    }

    @Override
    public int getLocalAllocation() {
        return allocation;
    }
}
