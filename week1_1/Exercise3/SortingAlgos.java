public class SortingAlgos {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot.getTotalPrice()) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 300.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 200.0),
            new Order(4, "Dave", 250.0),
            new Order(5, "Eve", 100.0)
        };

        bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Resetting the orders array
        orders = new Order[] {
            new Order(1, "Alice", 300.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 200.0),
            new Order(4, "Dave", 250.0),
            new Order(5, "Eve", 100.0)
        };

        quickSort(orders,0,orders.length-1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
