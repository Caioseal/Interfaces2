package service;

import entities.Contract;
import entities.Installment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ContractService {

    //Attribute
    private OnlinePaymentService onlinePaymentService;

    //Constructor
    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicValue = contract.getTotalValue() / months;

        for (int i = 1; i <= months ; i++) {
            Date date = addMonths(contract.getDate(), i);
            double updatedValue = basicValue + onlinePaymentService.interest(basicValue, i);
            double fullValue = updatedValue + onlinePaymentService.paymentFee(updatedValue);

            contract.addInstallment(new Installment(date, fullValue));
        }
    }
    private Date addMonths(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, n);
        return calendar.getTime();
    }
}
