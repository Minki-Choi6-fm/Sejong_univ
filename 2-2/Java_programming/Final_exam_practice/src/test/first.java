package test;

class Order {
    String customerName;
    double basePrice;

    Order(String customerName, double basePrice) {
        this.customerName = customerName;
        this.basePrice = basePrice;
    }

    double calculateTotal() {
        return basePrice;
    }
}

class DomesticOrder extends Order {
    DomesticOrder(String customerName, double basePrice) {
        super(customerName, basePrice);
    }
    double calculateTotal() {
        return super.basePrice + 5; // 배송비 $5 추가
    }
}

class InternationalOrder extends Order {
    InternationalOrder(String customerName, double basePrice) {
        super(customerName, basePrice);
    }
    double calculateTotal() {
        return (super.basePrice * 1.1) + 20; // 세금 10% + 배송비 $20
    }
}

public class first {
    public static void main(String[] args) {
        Order[] orders = new Order[2];
        orders[0] = new DomesticOrder("Alice", 50);
        orders[1] = new InternationalOrder("Bob", 50);

        for (Order o : orders) {
            System.out.println("Customer: " + o.customerName + " | Total: $" + o.calculateTotal());
        }
    }
}