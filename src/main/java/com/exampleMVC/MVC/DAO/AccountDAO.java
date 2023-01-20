package com.exampleMVC.MVC.DAO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public List<Account> findAccounts(boolean error){

        if(error){
            throw new RuntimeException("Ha ocurrido un error!");
        }

        List<Account> listAccounts = new ArrayList<>();
        Account account1= new Account("Rita", "Skater");
        Account account2= new Account("Harry", "Potter");
        Account account3= new Account("Artemis", "Fowl");
        listAccounts.add(account1);
        listAccounts.add(account2);
        listAccounts.add(account3);

        return listAccounts;
    }

    public Integer addAccount(String s, String m){
        System.out.println("ADDING ACCOUNT...");
        return 1;
    }

    public void findAccount(){
        System.out.println("FINDING ACCOUNT...");
    }
}
