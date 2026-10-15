package package1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * COMPARATOR INTERFACE IN JAVA (java.util.Comparator)
 *
 * Why Comparator?
 * - Comparable allows only ONE natural sorting sequence (defined inside the class).
 * - Comparator allows MULTIPLE custom sorting sequences (defined outside the class),
 *   without modifying the original class.
 *
 * Method to implement:
 *   int compare(T o1, T o2)
 *     - returns negative if o1 < o2
 *     - returns zero     if o1 == o2
 *     - returns positive if o1 > o2
 */

// Sample Model Class (does NOT implement Comparable)
class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}

// -------------------------------------------------------------
// Approach 1: Separate class implementing Comparator
// Best for: Reusable sorting logic across multiple places
// -------------------------------------------------------------
class SortByPriceAscending implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.price, p2.price);
    }
}

public class ComparatorInterface {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(103, "Laptop", 65000.0));
        products.add(new Product(101, "Mouse", 800.0));
        products.add(new Product(104, "Keyboard", 2500.0));
        products.add(new Product(102, "Monitor", 18000.0));

        printList("--- Original List ---", products);

        // =========================================================
        // Example 1: Using a separate Comparator class
        // Sort by Price (Low to High)
        // =========================================================
        Collections.sort(products, new SortByPriceAscending());
        printList("--- 1. Sorted by Price (Low to High) [Separate Class] ---", products);

        // =========================================================
        // Example 2: Using an Anonymous Inner Class
        // Sort by Name (Alphabetical Order)
        // =========================================================
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        printList("--- 2. Sorted by Name (Alphabetical) [Anonymous Class] ---", products);

        // =========================================================
        // Example 3: Using Lambda Expression (Java 8+)
        // Sort by Price (High to Low / Descending)
        // =========================================================
        products.sort((p1, p2) -> Double.compare(p2.price, p1.price));
        printList("--- 3. Sorted by Price (High to Low) [Lambda Expression] ---", products);

        // =========================================================
        // Example 4: Using Comparator.comparing() (Java 8+ Modern Style)
        // Sort by ID (Ascending)
        // =========================================================
        products.sort(Comparator.comparingInt(p -> p.id));
        printList("--- 4. Sorted by ID (Ascending) [Comparator.comparingInt] ---", products);
    }

    // Helper method to print elements cleanly
    private static void printList(String title, List<Product> list) {
        System.out.println(title);
        for (Product p : list) {
            System.out.println("  " + p);
        }
        System.out.println();
    }
}
