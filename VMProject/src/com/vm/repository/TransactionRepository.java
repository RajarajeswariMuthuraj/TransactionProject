package com.vm.repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vm.model.Transaction;

public class TransactionRepository {

	public static List<Transaction> getTransactions() {
		return Arrays.asList(new Transaction(LocalDate.of(2020, 11, 1), "Morrisons", "card", 10.40, "Groceries"),
				new Transaction(LocalDate.of(2020, 10, 28), "CYBG", "direct debit", 600, "MyMonthlyDD"),
				new Transaction(LocalDate.of(2020, 10, 28), "PureGym", "direct debit", 40, "MyMonthlyDD"),
				new Transaction(LocalDate.of(2020, 10, 1), "M&S", "card", 5.99, "Groceries"),
				new Transaction(LocalDate.of(2020, 9, 30), "McMillan", "internet", 10, null));
	}
}
