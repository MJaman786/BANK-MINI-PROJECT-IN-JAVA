import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bank {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> acc_list = new ArrayList<>();
	
	public static void createAccount() {
		Person person;
		String name1, aadhar1, pan1, acc1;
		int age1;
		double balance1;
		System.out.println("================================");
		System.out.print("Enter your name: ");
		name1 = sc.next();
		System.out.print("Enter your age: ");
		age1 = sc.nextInt();
		System.out.print("Enter your aadhar card: ");
		aadhar1 = sc.next();
		System.out.print("Enter your pan number: ");
		pan1 = sc.next();
		//Assigning account number
		String AlphaNumericString = "0123456789";
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		acc1 = sb.toString();
		System.out.println("Your account number is: " + acc1);
		System.out.println("================================");
		balance1 = 0.0;
		
		person = new Person();
		person.name = name1;
		person.age = age1;
		person.aadharCard = aadhar1;
		person.balance = balance1;
		person.panNo = pan1;
		person.accNo = acc1;
		acc_list.add(person);
	}
	
	public static void displayAccountInfo() {
		System.out.println("================================");
		System.out.print("Enter your account number: ");
		String scrapaccno = sc.next();
		for(int i = 0; i < acc_list.size(); i++) {
			if(acc_list.get(i).accNo.equals(scrapaccno)) {
				System.out.println("Account found!");
				System.out.println("Account holder's name: " + acc_list.get(i).name);
				System.out.println("pan number: " + acc_list.get(i).panNo);
				System.out.println("aadhar: " +acc_list.get(i).aadharCard);
				System.out.println("Avail. Balance: " + acc_list.get(i).balance);
			} 
		}
		System.out.println("================================");
	}
	
	public static void displayAccountList() {
		for(int i = 0; i < acc_list.size(); i++) {
			System.out.println(i + acc_list.get(i).accNo);
		}
	}
	
	public static void deposit() {
		
		System.out.print("Enter Account number you want to deposit:");
		String input = sc.next();
		
		System.out.println("================================");
		for(int i=0; i<acc_list.size(); i++) {
			if(acc_list.get(i).accNo.equals(input)) {
				
				System.out.println("Enter Ammount to deposit: ");
				double depo = sc.nextDouble();
				acc_list.get(i).balance=depo+acc_list.get(i).balance; 
			}
		}
		System.out.println("================================");
	}
	
public static void withdraw() {
		
	System.out.println("================================");
		System.out.print("Enter Account number you want to withdraw:");
		String input1 = sc.next();
		for(int i=0; i<acc_list.size(); i++) {
			if(acc_list.get(i).accNo.equals(input1)) {
				
				System.out.println("Enter Ammount to deposit: ");
				double with = sc.nextDouble();
				if(acc_list.get(i).balance>with) {
				acc_list.get(i).balance=acc_list.get(i).balance-with; 
				
				}else {
					System.out.println("INSUFFICIENT BALANCE");
				}
		
			}
		}
		System.out.println("================================");
			 	
	}

public static void transfer() {
	System.out.println("================================");
	
	System.out.print("Enter your Account number :");
	String tr = sc.next();

	System.out.print("Enter Ammount to send: ");
	double amt = sc.nextDouble();
	
	System.out.println("Enter Account number you want to transfer: ");
	String tr1 = sc.next();
	
	String transferaccount, recieveaccount;
	
	System.out.println("================================");
	
	for(int i=0; i<acc_list.size(); i++) {
		if(acc_list.get(i).accNo.equals(tr)) {
			acc_list.get(i).balance-=amt;
			transferaccount = tr;
		}
	}
	
	for(int i=0; i<acc_list.size(); i++) {
		if(acc_list.get(i).accNo.equals(tr1)) {
			acc_list.get(i).balance+=amt;
			recieveaccount = tr1;
		}
	}
	
	System.out.println("Do you want recipt of transfer (y/n) ?");
	String ch = sc.next();
	Date current_date = new Date();
	if(ch.equals("y")||ch.equals("Y")) {
		System.out.println("Money is been transfer from this "+"''"+tr+"''"); 
		System.out.println("To this account "+"''"+tr1+"''"+" Successfully");
		System.out.println(current_date);
		System.out.println("================================");
	}
	else {
		return ;
	}
	
	
	
}
	
	
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("Enter your choice: ");
			System.out.println("1.Create account");
			System.out.println("2.Deposit money");
			System.out.println("3.Withdraw money");
			System.out.println("4.Transfer money");
			System.out.println("5.Display account info");
			System.out.println("6.Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				createAccount();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				transfer();
				break;
			case 5:
				displayAccountInfo();
				break;
				
			}
		} while(choice > 0 && choice <= 6);
		displayAccountList();
	}
}