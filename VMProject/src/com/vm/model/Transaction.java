package com.vm.model;

import java.time.LocalDate;

public class Transaction {
	private LocalDate date;
	private String vendor;
	private String type;
	private double amount;
	private String category;

	public Transaction(LocalDate date, String vendor, String type, double amount, String category) {
		this.date = date;
		this.vendor = vendor;
		this.type = type;
		this.amount = amount;
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getVendor() {
		return vendor;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Transaction{" + "date=" + date + ", vendor='" + vendor + '\'' + ", type='" + type + '\'' + ", amount="
				+ amount + ", category='" + category + '\'' + '}';
	}
}
