/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hong Ha
 */
public class Person {
    private Integer key;
    private String firstName;
    private String lastName;
    
    public Person (Integer key, String firstName, String lastName){
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;                
    }
    
    public Person (String firstName, String lastName){        
        this.firstName = firstName;
        this.lastName = lastName;                
    }
    public void setKey(Integer key){
        this.key = key;
    }
    
    public int getKey(){
        return this.key;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
}
