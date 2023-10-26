package utility;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.Scanner;

import core.Category;
import core.Cloth;
import core.Size;
import exception.ClothException;

public interface FashionCompanyUtilityOperation {
            static void addCloth(Map<Integer,Cloth>clothMaps,Scanner sc) throws ClothException {
            	System.out.println("choose category as following : ");
            	for(Category c: Category.values()) {
            		System.out.println("Category "+c.name());
            	}
            	Category validCategory = Category.valueOf(sc.next().toUpperCase());
            	System.out.println("choose size as following");
            	for(Size s: Size.values()) {
            		System.out.println("size "+s.name());
            	}
            	Size validSize = Size.valueOf(sc.next().toUpperCase());
            	System.out.println("enter stock(>0) , date, price, brand, color, discount on this clothes");
            	double n = sc.nextDouble();
            	if(n<=0) {
            		throw new ClothException("stock must be greater than zero of newly added stock!!!!!");
            	}
            	Cloth newCloth = new Cloth(validCategory, n, LocalDate.parse(sc.next()), validSize, sc.nextDouble(), sc.next().toUpperCase(), sc.next(),sc.nextDouble());
            System.out.println("your stock details is : "+newCloth);
            	clothMaps.putIfAbsent(newCloth.getId(), newCloth);
            	
            }
            static void updateStock(Map<Integer,Cloth>clothMaps,Scanner sc) throws ClothException {
            	System.out.println("enter stock id and new update stock value");
            	Integer i = sc.nextInt();
            	if(clothMaps.containsKey(i)) {
            		Cloth c = clothMaps.get(i);
            		c.setStock(sc.nextDouble());
            		System.out.println("updated details are : "+c);
            		System.out.println("successfully update stock");
            	}else {
            		throw new ClothException("Invalid Stock id!!!");
            	}
            }
            static void setDiscount(Map<Integer,Cloth>clothMaps,Scanner sc) throws ClothException {
            	System.out.println("For set discount, choose category as following : ");
            	for(Category c: Category.values()) {
            		System.out.println("Category "+c.name());
            	}
            	Category validCategory = Category.valueOf(sc.next().toUpperCase());
            	System.out.println("choose available brand present in "+validCategory+" stock");
            	clothMaps.values().stream().filter(p->p.getCategory().equals(validCategory)).forEach(p->System.out.println(p.getBrand()));
            String chooseBrand = sc.next().toUpperCase();
            int i=0;
            for(Cloth c : clothMaps.values()) {
            	if(c.getCategory().equals(validCategory)) {
            	if(c.getBrand().equals(chooseBrand)) {
            		i=1;
            		System.out.println("enter new discount in precentage ");
            		c.setDiscount(sc.nextDouble());
            		c.setPrice();
            		System.out.println("now updated stock details is : "+c);
            		System.out.println("successfully updated discount and its price");
            	}
            	}
            }
            if(i==0) {
            	throw new ClothException("Brand not present of choosen category!!!");
            }
            
            }
            static void removeCLoth(Map<Integer,Cloth>clothMaps) throws ClothException {
            	for(Cloth c: clothMaps.values()) {
            		//System.out.println(c.getStock());
            		if(c.getStock().equals(0.0)) {
            		    if(Period.between(c.getUpdateDate(), LocalDate.now()).toTotalMonths()>=2) {
            		    	int i = c.getId();
            		    System.out.println("remove cloth stock information is "+clothMaps.remove(i));
            		    return;
            		    }
            		    else {
            		    	throw new ClothException("No stock found from last two months or more!!!");
            		    }
            		}
            		
            	}
            	
        			throw new ClothException("No out of stock found!!!!");
        		
            }
            static void displayOutOfStockToday(Map<Integer,Cloth>clothMaps) {
            	clothMaps.values().stream().filter(p->p.getStock().equals(0.0)).filter(p->p.getUpdateDate().equals(LocalDate.now())).forEach(System.out::println);
            }
            static void populatedStocks(Map<Integer,Cloth>clothMaps) {
//            	 Category category, Double stock, LocalDate updateDate, Size size, Double price,
//     			String brand, String color, Double discount
            	Cloth newCLoth = new Cloth(Category.MENS_SHIRT, 50.0, LocalDate.parse("2023-10-15"),Size.L, 200.0, "ADDIDASS", "white", 20.0);
            	clothMaps.putIfAbsent(newCLoth.getId(), newCLoth);
            	 newCLoth = new Cloth(Category.MENS_TSHRT, 40.0, LocalDate.parse("2023-07-15"),Size.M, 100.0, "PLASS", "black", 10.0);
            	clothMaps.putIfAbsent(newCLoth.getId(), newCLoth);
            	 new Cloth(Category.WOMENS_JEANS, 50.0, LocalDate.parse("2023-06-15"),Size.S, 300.0, "FAIRY", "pink", 15.0);
            	clothMaps.putIfAbsent(newCLoth.getId(), newCLoth);
            	newCLoth=  new Cloth(Category.WOMENS_SARI, 60.0, LocalDate.parse("2022-12-15"),Size.L,900.0, "BANARASI", "Red", 20.0);
            	clothMaps.putIfAbsent(newCLoth.getId(), newCLoth);
            	newCLoth = new Cloth(Category.MENS_SHIRT, 450.0, LocalDate.parse("2023-05-10"),Size.XL, 800.0, "ADDIDASS", "black", 50.0);
            	clothMaps.putIfAbsent(newCLoth.getId(), newCLoth);
            	 newCLoth = new Cloth(Category.MENS_TSHRT, 80.0, LocalDate.parse("2022-07-15"),Size.XLL, 400.0, "HOOK", "grey", 20.0);
            	clothMaps.putIfAbsent(newCLoth.getId(), newCLoth);
            	
            }
            
}
