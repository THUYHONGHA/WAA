/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
    private Employee selEmp = new Employee("1432", "Frank Brown", "625-345-2635", 45089.5);

    public EmployeeLogic() {
        this.empList = new ArrayList<>();
        empList.add(new Employee("1432", "Frank Brown", "625-345-2635", 45089.5));
        empList.add(new Employee("1321", "John Doe", "625-345-3321", 56003.0));
        empList.add(new Employee("1634", "Marry Jones", "625-345-3421", 73998.3));
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public Employee getSelEmp() {
        return selEmp;
    }

    public void setSelEmp(Employee selEmp) {
        this.selEmp = selEmp;
    }

    public String getInfo() {
        Map<String, String> infos = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String selId = infos.get("selId");
        String selName = infos.get("selName");
        String selPhone = infos.get("selhone");
        double selSalary = Double.parseDouble(infos.get("selSalary"));

        this.selEmp.setId(selId);
        this.selEmp.setName(selName);
        this.selEmp.setPhone(selPhone);
        this.selEmp.setSalary(selSalary);

        return "Main";
    }

    public String showAll() {
        return "ShowAll";
    }

}
