package test;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DataService {
    INSTANCE;
    private List<Employee> employeeList = new ArrayList<>();
    List<String> departments = Arrays.asList("HR", "Admin", "IT", "Sales");

    DataService() {
        DataFactory dataFactory = new DataFactory();

        for (int i = 1; i < 50; i++) {
            Employee employee = new Employee();
            employee.setId(i);
            employee.setName(dataFactory.getName());
            employee.setPhoneNumber(String.format("%s-%s-%s", dataFactory.getNumberText(3),
                    dataFactory.getNumberText(3),
                    dataFactory.getNumberText(4)));
            employee.setAddress(dataFactory.getAddress() + "," + dataFactory.getCity());
            employee.setDepartment(dataFactory.getItem(departments));
            employeeList.add(employee);
        }
    }

    public List<String> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}