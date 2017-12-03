/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@RequestScoped
public class LoginApp {

    /**
     * Creates a new instance of LoginApp
     */
    private String userID;
    private String password;
    private String welcomeName;
    public LoginApp() {
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserID(){
        return this.userID;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setWelcomeName(String welcomeName){
        this.welcomeName = welcomeName;
    }
    public String getWelcomeName(){
        return this.welcomeName;
    }
    public String CheckValidation(){
        if (this.userID.equals("kl01") && this.password.equals("yoyo")){
            this.welcomeName = "Frank Brown";
            return "LoginSuccess";
        }
            return "LoginFail";
    }
}
