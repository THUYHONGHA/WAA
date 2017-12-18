/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@RequestScoped
public class EmployeeLogic {

    /**
     * Creates a new instance of EmployeeLogic
     */
    private List<Employee> empList;
    private Employee selectedEmp;
    public EmployeeLogic() {
    }
    
   
    public List<Employee> getEmpList(){
        this.empList = new ArrayList<>();
        empList.add(new Employee("1432", "Frank Brown","625-345-2635",45089.5));
        empList.add(new Employee("1321", "John Doe","625-345-3321",56003.0));
        empList.add(new Employee("1634", "Marry Jones","625-345-3421",73998.3));       
        return empList;
    }
    public void setEmpList(List<Employee> empList){
        this.empList = empList;
    }

    public Employee getSelectedEmp() {
        return selectedEmp;
    }

    public void setSelectedEmp(Employee selectedEmp) {
        this.selectedEmp = selectedEmp;
    }
    
    
}
