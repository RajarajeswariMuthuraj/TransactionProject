package com.vm.service;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vm.model.Transaction;

public class TransactionService {
	public static List<Transaction> getTransactionsByCategory(String category, List<Transaction> transactions) {
		return transactions.stream().filter(t -> category.equals(t.getCategory()))
				.sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate())).collect(Collectors.toList());
	}

	public static double getTotalOutgoingByCategory(String category, List<Transaction> transactions) {
		return transactions.stream().filter(t -> category.equals(t.getCategory())).mapToDouble(Transaction::getAmount)
				.sum();
	}

	public static double getMonthlyAverageByCategory(String category, List<Transaction> transactions) {
		Map<YearMonth, Double> monthlyTotals = transactions.stream().filter(t -> category.equals(t.getCategory()))
				.collect(Collectors.groupingBy(t -> YearMonth.from(t.getDate()),
						Collectors.summingDouble(Transaction::getAmount)));

		double total = monthlyTotals.values().stream().mapToDouble(Double::doubleValue).sum();
		return total / monthlyTotals.size(); // Average = total sum divided by the number of months
	}

	public static double getHighestSpendInCategoryForYear(String category, int year, List<Transaction> transactions) {
		return transactions.stream().filter(t -> category.equals(t.getCategory()) && t.getDate().getYear() == year)
				.mapToDouble(Transaction::getAmount).max().orElse(0); // Return 0 if no transactions found
	}

	public static double getLowestSpendInCategoryForYear(String category, int year, List<Transaction> transactions) {
		return transactions.stream().filter(t -> category.equals(t.getCategory()) && t.getDate().getYear() == year)
				.mapToDouble(Transaction::getAmount).min().orElse(0); // Return 0 if no transactions found
	}
}
