package se.ifmo.web.model;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Bean for date generation
 */
@Named(value = "date")
@ViewScoped
public class DateBean implements Serializable {
    private final SimpleDateFormat simpleDateFormat;
    private Date date;

    /**
     * Public constructor
     */
    public DateBean() {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
    }

    /**
     * Get current date
     * @return current date
     */
    public String getCurrentDate() {
        return simpleDateFormat.format(date);
    }

    public void updateDate() {
        date = new Date();
    }
}
