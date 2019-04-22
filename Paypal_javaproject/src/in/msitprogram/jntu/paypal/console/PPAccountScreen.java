package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.util.Scanner;
import java.io.Serializable;
import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;

public class PPAccountScreen{
	static PPAccount account;
	Scanner scan;
    static String email;
    static float balance;
    static float creditbal;
    static float debitbal;
	
	public PPAccountScreen(String email) throws Exception {
		scan = new Scanner(System.in);
		account = DataStore.lookupAccount(email);
		this.email=email;
	}

	public static void show() throws Exception
	{
		System.out.println(account.getstatus());
		if(account.getstatus())
		{
			System.out.println("Welcome to personal account");
			System.out.println("1.Credit\n 2.Debit\n 3.Balance\n 4.Exit\n");
			System.out.println("Enter your choice");
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("Credit");
					System.out.println("Enter amount:");
					float c=sc.nextFloat();
					credit(c);
					PPAccountScreen.show();
					break;
			case 2:System.out.println("Debit");
					System.out.println("Enter amount to debit:");
					float d=sc.nextFloat();
					debit(d);
					PPAccountScreen.show();
					break;
			case 3:System.out.println("Balance");
					balance=account.getintial();
					System.out.println(balance);
					PPAccountScreen.show();
					break;
			case 4:System.out.println("Exit");
					MainMenu.show();
					break;
			default:System.out.println("Enter choice:");
			
			}
		}
		else
		{
			PPAccountActivationScreen.show(email);
		}				
	}
	public static void credit(float credit) throws Exception
	{
		balance=account.getintial();
		creditbal=balance+credit;
		account.setintial(creditbal);
		System.out.println("Credit ammount:"+creditbal);
		DataStore.writeAccount(account);
	}
	public static void debit(float debit) throws Exception
	{
		balance=account.getintial();
		debitbal=balance-debit;
		account.setintial(debitbal);
		System.out.println("Debit ammount:"+debitbal);
		DataStore.writeAccount(account);

	}
	private void withdrawFunds() throws IOException 
	{
		
		// implement the withdraw funds user interface here
		
		//use the account object as needed for withdraw funds
		
	}

	private void requestMoney() 
	{
		
		
		//use the account object as needed for request money funds
	}

	private void sendMoney() {
		// implement the send moeny user interface here
		
		//use the account object as needed for send money funds
	}

	private void addFunds() throws IOException {
		// implement the add funds user interface here
		
		//use the account object as needed for add funds
	}

}