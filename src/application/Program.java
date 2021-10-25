package application;

import java.util.LinkedList;
import java.util.List;

import entities.Account;
import entities.CSV;
import entities.Checking;
import entities.Savings;

public class Program {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();
        //Read a CSV File then create new account based on that data
        List<String[]> newAccounteHolder = CSV.read("C:\\temp\\Savings.txt");
        for(String[] s: newAccounteHolder){
            String name = s[0];
            String sSN = s[1];
            String accountType = s[2];
            double initDeposit = Double.valueOf(s[3]);
            //System.out.println(name + " " + sSN + " "+ accountType + " $" + initDeposit);
            if(accountType.equals("Savings")){
                accounts.add(new Savings (name,sSN,initDeposit));
            }
            else if(accountType.equals("Checking")) {
                accounts.add(new Checking (name,sSN,initDeposit));
            }
            else{
                System.out.println("Error reading account type");
            }
        }
        for(Account acc: accounts){
            acc.showInfo();
            System.out.println("*****************");
        }
    }
}
