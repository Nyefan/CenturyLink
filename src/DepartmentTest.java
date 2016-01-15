import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;

/**
 * Created by nyefan on 1/14/16.
 */
public class DepartmentTest extends TestCase {

    private HashMap<Employee, Integer> employeeTestCases;
    private HashMap<ArrayList<Employee>, Integer> arrTestCases;

    protected void setUp() {
        employeeTestCases = new HashMap<>();
        arrTestCases = new HashMap<>();

        employeeTestCases.put(new Manager(), 300);
        employeeTestCases.put(new QATester(), 500);
        employeeTestCases.put(new Developer(), 1000);

        ArrayList<Employee> testDept = new ArrayList<>();
        testDept.add(new Manager(new Manager(new Developer())));                      //+1600
        testDept.add(new Manager(new Manager(new QATester())));                       //+1100
        testDept.add(new Manager(new Developer()));                                   //+1300
        testDept.add(new Manager(new QATester()));                                    //+ 800
        testDept.add(
            new Manager(                                                              //+ 300
                new ArrayList<>(
                    Arrays.asList(
                        new Developer(),                                              //+1000
                        new QATester()))));                                           //+ 500

        testDept.add(
                new Manager(                                                          //+ 300
                        new ArrayList<>(
                                Arrays.asList(
                                        new Developer(),                              //+1000
                                        new QATester(),                               //+ 500
                                        new Manager(                                  //+ 300
                                                new ArrayList<>(
                                                        Arrays.asList(
                                                                new Developer(),      //+1000
                                                                new QATester(),       //+ 500
                                                                new Manager()))))))); //+ 300

        employeeTestCases.put(new Manager(testDept), 10800);
        arrTestCases.put(testDept, 10500);

    }

    public void testGetAllocation() {

        int i = 0;
        for (HashMap.Entry<Employee, Integer> test : employeeTestCases.entrySet()) {
            Department caseDept = new Department(test.getKey());
            assertEquals(
                    "The allocation for test " + i + " should be $" + test.getValue(),
                    test.getValue().intValue(),
                    caseDept.getAllocation()
            );
            i++;
        }
        for (HashMap.Entry<ArrayList<Employee>, Integer> test1 : arrTestCases.entrySet()) {
            Department caseDept = new Department(test1.getKey());
            assertEquals(
                    "The allocation for test " + i + " should be $" + test1.getValue(),
                    test1.getValue().intValue(),
                    caseDept.getAllocation()
            );
            i++;
        }
    }

    public void testGetAllocation1() {

    }
}