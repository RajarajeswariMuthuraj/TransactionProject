package com.vm.main;

import java.util.List;

import com.vm.model.Transaction;
import com.vm.repository.TransactionRepository;
import com.vm.service.TransactionService;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {

		List<Transaction> transactions = TransactionRepository.getTransactions();

		// 1. All transactions for a given category (Groceries), latest first
		System.out.println("Transactions for Groceries:");
		List<Transaction> groceriesTransactions = TransactionService.getTransactionsByCategory("Groceries",
				transactions);
		groceriesTransactions.forEach(System.out::println);

		// 2. Total outgoing for 'MyMonthlyDD'
		double totalMonthlyDD = TransactionService.getTotalOutgoingByCategory("MyMonthlyDD", transactions);
		System.out.println("\nTotal outgoing for MyMonthlyDD: £" + totalMonthlyDD);

		// 3. Monthly average spend for 'Groceries'
		double monthlyAverageGroceries = TransactionService.getMonthlyAverageByCategory("Groceries", transactions);
		System.out.println("\nMonthly average for Groceries: £" + monthlyAverageGroceries);

		// 4. Highest spend in 'Groceries' for 2020
		double highestGroceries2020 = TransactionService.getHighestSpendInCategoryForYear("Groceries", 2020,
				transactions);
		System.out.println("\nHighest spend in Groceries for 2020: £" + highestGroceries2020);

		// 5. Lowest spend in 'Groceries' for 2020
		double lowestGroceries2020 = TransactionService.getLowestSpendInCategoryForYear("Groceries", 2020,
				transactions);
		System.out.println("\nLowest spend in Groceries for 2020: £" + lowestGroceries2020);

	}
}
