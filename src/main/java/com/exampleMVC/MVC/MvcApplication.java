package com.exampleMVC.MVC;

import com.exampleMVC.MVC.DAO.Account;
import com.exampleMVC.MVC.DAO.AccountDAO;
import com.exampleMVC.MVC.DAO.MembershipDAO;
import com.exampleMVC.MVC.DAO.TrafficFortuneService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {

		ApplicationContext ctx= SpringApplication.run(MvcApplication.class, args);

		//Llamar a AccoundDao y llamar al método
		AccountDAO accountDao= (AccountDAO) ctx.getBean("accountDAO");
		List<Account> listAccounts= accountDao.findAccounts(false);
		for(Account ac: listAccounts){
			System.out.println(ac);
		}

		/*System.out.println("------------ASPECTS IMPLEMENTATIONS --------------");
		accountDao.addAccount("Texto de Input", "otro input message");
		accountDao.findAccount();

		MembershipDAO membershipDAO= (MembershipDAO) ctx.getBean("membershipDAO");
		membershipDAO.addMember();

		System.out.println("-------------Aspect Around -------------");
		TrafficFortuneService trafficFortuneService= (TrafficFortuneService) ctx.getBean("trafficFortuneService");
		String prediction= trafficFortuneService.getFortune(false);
		System.out.println(prediction);*/
	}

}
