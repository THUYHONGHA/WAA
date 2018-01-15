/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@RequestScoped
public class CountryManagedBean {

    private String searchString;
    private Collection<String> countriesList = new ArrayList();
    private Collection<String> resultSearchList = new ArrayList<String>();

    public CountryManagedBean() {
        countriesList.add("Afghanistan");
        countriesList.add("Albania");
        countriesList.add("Algeria");
        countriesList.add("Andorra");
        countriesList.add("Angola");
        countriesList.add("Antarctica");
        countriesList.add("Argentina");
        countriesList.add("Armenia");
        countriesList.add("Aruba");
        countriesList.add("Australia");
        countriesList.add("Austria");
        countriesList.add("Azerbaijan");
        countriesList.add("Azerbaijan");
        
    }

    public void search(AjaxBehaviorEvent e) {
        if (searchString != null && searchString.trim() != "") {
            resultSearchList.clear();
            for (String c : countriesList) {
                if (c.startsWith(searchString)) {
                    resultSearchList.add(c);
                }
            }
        }
    }

    public Collection<String> getResultSearchList() {
        return resultSearchList;
    }

    public void setResultSearchList(Collection<String> resultSearchList) {
        this.resultSearchList = resultSearchList;       
    }

    public Collection<String> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(Collection<String> countriesList) {
        this.countriesList = countriesList;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

}
