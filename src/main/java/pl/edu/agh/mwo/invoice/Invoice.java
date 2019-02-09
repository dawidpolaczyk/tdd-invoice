package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<Product>();

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity == 0) {
			throw new IllegalArgumentException("price must not be zero");
		}

		if (quantity < 0) {
			throw new IllegalArgumentException("price must be positive");
		}

		for (int i = 0; i < quantity; i++) {
			this.products.add(product);
		}
	}

	public BigDecimal getSubtotal() {

		BigDecimal subTotal = new BigDecimal("0");
		for (Product product : products) {
			subTotal = subTotal.add(product.getPrice());
		}
		return subTotal;

	}

	public BigDecimal getTax() {

		BigDecimal totalTax = new BigDecimal("0");
		for (Product product : products) {
			totalTax = totalTax.add(product.getTax());
		}
		return totalTax;
	}

	public BigDecimal getTotal() {
		BigDecimal Total = new BigDecimal("0");
		for (Product product : products) {
			Total = Total.add(product.getPriceWithTax());
		}
		return Total;

	}
}
