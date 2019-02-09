package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product{
		 
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {

		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		
		  if (name == null) {
			    throw new IllegalArgumentException("name must not be null");
			}
		  
		  if (name == "") {
			    throw new IllegalArgumentException("price must not be empty");
			}
		  
		  if (price == null) {
			    throw new IllegalArgumentException("price must not be null");
			}
		  
		  if (price.compareTo(BigDecimal.ZERO) < 0) {
			    throw new IllegalArgumentException("price must be positive");
			}
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return price.add(this.price.multiply(this.taxPercent));
	}
}
