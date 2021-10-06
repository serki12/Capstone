package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_VENDINGMACHINE = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, EXIT_VENDINGMACHINE };
	private static final String FEED_MONEY_OPTION = "Feed Money";
	private static final String PURCHASE_OPTION = "Select Product";
	private static final String END_TRANSACTION = "Finish Transaction";
	private static final String []PURCHASE_MENU_OPTION = {FEED_MONEY_OPTION,PURCHASE_OPTION,END_TRANSACTION};
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";



	Scanner input = new Scanner(System.in);
	VendingMachine vendingMachine = new VendingMachine();

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		vendingMachine.establishInventory();
	}

	public void run ()throws NumberFormatException {
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS) || choice.equals("1")) {
				DisplayMenuItem(vendingMachine);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				mainMenuOptionPurchase();
			} else if (choice.equals(EXIT_VENDINGMACHINE) || choice.equals("3")) {
				System.exit(1);
			}
		}
	}

	private void mainMenuOptionPurchase() {
		String select = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTION);
		if (select.equals(FEED_MONEY_OPTION) || select.equals("1")) {
			System.out.println("Enter Amount ");
			double amount = input.nextDouble();
			input.nextLine();
			vendingMachine.feedMoney(amount);
		} else if (select.equals(PURCHASE_OPTION) || select.equals("2")) {
			purchaseOption();
		} else if (select.equals("Finish Transaction") || select.equals("3")) {
			vendingMachine.change();
		}
	}

	private void purchaseOption() {
		DisplayMenuItem(vendingMachine);
		System.out.println("Select Product");
		String productId = input.nextLine();
		if (vendingMachine.getItems().containsKey(productId)){
			if(vendingMachine.getItems().get(productId).getItems_quantity() >= 1){
				if(vendingMachine.getBalance() >= vendingMachine.getItems().get(productId).getPrice()){
					vendingMachine.purchaseValidation(productId);
				}else{
					System.out.println(ANSI_RED + "Insufficient Funds" + ANSI_RESET);
				}
			}else {
				System.out.println(vendingMachine.getItems().get(productId).getName()+ ANSI_RED + " SOLD OUT" + ANSI_RESET );
			}
		} else {
			System.out.println("This product is not available");
		}
	}

	private void DisplayMenuItem(VendingMachine vendingMachine) {
		System.out.println(ANSI_GREEN + "*******************************************************************************************" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "*******************************************************************************************" + ANSI_RESET);
		for (Map.Entry<String, Product> item : vendingMachine.getItems().entrySet()) {
			System.out.println("Option: " + ANSI_YELLOW + item.getKey() + ANSI_RESET + ANSI_PURPLE + "   -> " + ANSI_RESET  + item.getValue().getName() + ANSI_PURPLE + "   -> " + ANSI_RESET +" Price: $" + item.getValue().getPrice() + ANSI_PURPLE + "   -> " + ANSI_RESET +" Remaining Quantity: "  + ANSI_RED + item.getValue().getItems_quantity() + ANSI_RESET);
			System.out.println("");
		}
		System.out.println(ANSI_GREEN + "*******************************************************************************************" + ANSI_RESET);
		System.out.println( ANSI_GREEN + "*******************************************************************************************" + ANSI_RESET);
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


}
