package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

    //Attributes
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date dueDate;
    private Double amount;

    //Constructor
    public Installment(Date dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    //Getters and Setters
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }



    @Override
    public String toString() {
        return simpleDateFormat.format(dueDate) +
                " - " + String.format("%.2f", amount);
    }
}
