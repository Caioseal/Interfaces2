package application;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Type the contract's information");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Date (dd/mm/yyyy): ");
        Date date = simpleDateFormat.parse(scanner.next());
        System.out.print("Contract's value: ");
        double totalValue = scanner.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Number os installments: ");
        int installments = scanner.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, installments);

        System.out.println("Installments");
        for (Installment x : contract.getInstallmentList()) {
            System.out.println(x);
        }

        scanner.close();
    }
}
