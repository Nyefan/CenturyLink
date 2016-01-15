/**
 * Created by nyefan on 1/14/16.
 */
public class QATester extends Employee {

    private static final int allocation = 500;

    public QATester() {
        directSubordinates = null;
    }

    @Override
    public int getLocalAllocation() {
        return allocation;
    }
}
