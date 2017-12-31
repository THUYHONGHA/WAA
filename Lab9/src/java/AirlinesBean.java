/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@RequestScoped
public class AirlinesBean implements ValueChangeListener {

    private List<Airline> flightByAirline;
    private List<Airline> allFlight;

    public AirlinesBean() {
        this.allFlight = new ArrayList<>();

        this.allFlight.add(new Airline("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "KLM", 790.80));
        this.allFlight.add(new Airline("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "NorthWest", 795.55));
        this.allFlight.add(new Airline("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "KLM", 820.00));
        this.allFlight.add(new Airline("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "United Airlines", 825.50));
        this.allFlight.add(new Airline("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "NorthWest", 875.00));
        this.allFlight.add(new Airline("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "KLM", 989.00));
        this.allFlight.add(new Airline("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "United Airlines", 1050.00));

        this.flightByAirline = this.allFlight;
    }

    public List<Airline> airlineChange(ValueChangeEvent e) {
        String airline = e.getNewValue().toString();
        if (airline.equals("All")) {
            return getAllFlight();
        } else {
            flightByAirline = getAllFlight().stream().filter(a -> a.getAirline().equals(airline)).collect(Collectors.toList());
            return flightByAirline;
        }
    }

    public List<Airline> getFlightByAirline() {
        return flightByAirline;
    }

    public void setFlightByAirline(List<Airline> flightByAirline) {
        this.flightByAirline = flightByAirline;
    }

    public List<Airline> getAllFlight() {
        return allFlight;
    }

    public void setAllFlight(List<Airline> allFlight) {
        this.allFlight = allFlight;
    }

    @Override
    public void processValueChange(ValueChangeEvent vce) throws AbortProcessingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
