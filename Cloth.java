package core;

import java.time.LocalDate;
import java.util.Objects;

public class Cloth {
	private static int cnt=0;
	private Integer Id;
	private Category category;
	private Double stock;
	private LocalDate updateDate;
	private Size size;
	private Double price;
	private String brand;
	private String color;
	private Double discount;
	public Cloth( Category category, Double stock, LocalDate updateDate, Size size, Double price,
			String brand, String color, Double discount) {
		super();
		Id = ++cnt;
		this.category = category;
		this.stock = stock;
		this.updateDate = updateDate;
		this.size = size;
		this.price = price;
		this.brand = brand;
		this.color = color;
		this.discount = discount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cloth) {
		Cloth other = (Cloth) obj;
		return Id.equals(other.Id);
		}
		return false;
	}
	@Override
	public String toString() {
		return "Cloth [Id=" + Id + ", category=" + category + ", stock=" + stock + ", updateDate=" + updateDate
				+ ", size=" + size + ", price=" + price + ", brand=" + brand + ", color=" + color + ", discount="
				+ discount + "]";
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.updateDate=LocalDate.now();
		this.stock = stock;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice() {
		this.price = this.price-this.price*this.discount/100;
		
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	

}
