import java.util.ArrayList;

class EmptyCartException extends Exception {

    EmptyCartException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}


class Cart {

    ArrayList<Double> price = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();

    void addItem(double p, int q) {
        price.add(p);
        quantity.add(q);
    }

    void checkout(double balance)
            throws EmptyCartException, InsufficientBalanceException {

        if (price.size() == 0) {
            throw new EmptyCartException("Cart is empty");
        }

        double total = 0;

        for (int i = 0; i < price.size(); i++) {
            total = total + price.get(i) * quantity.get(i);
        }

        if (total > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance"
            );
        }

        System.out.println("Total cost: " + total);
        System.out.println("Checkout successful");
    }
}


public class customExe{

    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.addItem(100, 2);
        cart.addItem(50, 3);

        try {
            cart.checkout(500);
        }
        catch (EmptyCartException e) {
            System.out.println(e.getMessage());
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
