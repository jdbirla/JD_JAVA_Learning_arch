package streams.world;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filtering Collection by using Stream:
 * 
 * Here, we are filtering data by using stream. You can see that code
 * is optimized and maintained. Stream provides fast execution.
 *
 */
public class MapDemo1 {

	public static void main(String[] args) {
		List<Product> productList = new ArrayList<Product>();

        // Adding Products
        productList.add(new Product(1, "Sony mobile", 25000));
        productList.add(new Product(2, "Lenovo mobile", 15000));
        productList.add(new Product(3, "Nokia mobile", 10000));
        productList.add(new Product(4, "Samsung mobile", 40000));

        List<String> filteredProductList = productList.stream()
                .filter(p -> p.getPrice() < 20000)// Filter the product, whose price is less than 20000
                .map(p -> p.toString()) // fetching Name
                .collect(Collectors.toList()); // collecting as list

        System.out.println(filteredProductList);
	}

}
