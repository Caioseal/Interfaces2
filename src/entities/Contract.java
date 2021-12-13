package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    //Attributes
    private int contractNumber;
    private Date date;
    private Double totalValue;
    private List<Installment> installmentList = new ArrayList<>();

    //Constructor
    public Contract(int contractNumber, Date date, Double totalValue) {
        this.contractNumber = contractNumber;
        this.date = date;
        this.totalValue = totalValue;
    }

    //Getters and Setters
    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallmentList() {
        return installmentList;
    }

    public void setInstallmentList(List<Installment> installmentList) {
        this.installmentList = installmentList;
    }

    //Functions
    public void addInstallment(Installment installment) {
        installmentList.add(installment);
    }
    public void removeInstallment(Installment installment) {
        installmentList.remove(installment);
    }
}
