import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    public static Product linearSearch(Product[] products, String targetName){
        for(Product p : products ){
            if(p.productName.equalsIgnoreCase(targetName)){
                return p;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Phone", "Electronics"),
                new Product(3, "top", "Clothes")
        };

        // Sort array by productName for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("Linear Search Result: " + linearSearch(products, "Camera"));
        System.out.println("Binary Search Result: " + binarySearch(products, "phone"));
    }
}

