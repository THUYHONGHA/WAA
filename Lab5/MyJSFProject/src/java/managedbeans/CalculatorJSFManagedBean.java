/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@RequestScoped
public class CalculatorJSFManagedBean {

    /**
     * Creates a new instance of CalculatorJSFManagedBean
     */
    private double firstNumber;
    private double secondNumber;
    private double result;
    public CalculatorJSFManagedBean() {
    }
    public double getFirstNumber(){
        return this.firstNumber;
    }
    public void setFirstNumber(double firstNumber){
        this.firstNumber = firstNumber;
    }
    public double getSecondNumber(){
        return this.secondNumber;
    }
    public void setSecondNumber(double secondNumber){
        this.secondNumber = secondNumber;
    }
    public double getResult(){
        return this.result;
    }
    public void setResult(double result){
        this.result = result;
    }
    public void add(){
        this.result = this.firstNumber + this.secondNumber;
    }
    public void subtract(){
        this.result = this.firstNumber - this.secondNumber;
    }
    public void multiple(){
        this.result = this.firstNumber * this.secondNumber;
    }
    public void divide(){
        try{
            if(this.secondNumber!=0){
                this.result = this.firstNumber / this.secondNumber;
            }
            throw new ArithmeticException("Could not divide by 0");
        }
        catch(ArithmeticException e){
            System.out.println("ArithmeticException" + e.getMessage());
        }
        
    }
}
