
class Pizza {

    
    private String size;
    private int cheese;
    private int pepperoni;
    private int ham;

    // Constructor
    Pizza(String size, int cheese, int pepperoni, int ham) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
    }


    public String getSize() {
        return size;
    }

    public int getCheese() {
        return cheese;
    }

    public int getPepperoni() {
        return pepperoni;
    }

    public int getHam() {
        return ham;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public void setPepperoni(int pepperoni) {
        this.pepperoni = pepperoni;
    }

    public void setHam(int ham) {
        this.ham = ham;
    }

    
    public double calcCost() {

        double cost;

        if (size.equalsIgnoreCase("small")) {
            cost = 10;
        }
        else if (size.equalsIgnoreCase("medium")) {
            cost = 12;
        }
        else {
            cost = 14;
        }

        int totalToppings = cheese + pepperoni + ham;

        cost = cost + (totalToppings * 2);

        return cost;
    }

    
    public String getDescription() {

        return "Size: " + size
                + ", Cheese: " + cheese
                + ", Pepperoni: " + pepperoni
                + ", Ham: " + ham
                + ", Cost: $" + calcCost();
    }
}



class PizzaOrder {

    private Pizza[] pizzas;
    private int count;

    // Constructor
    PizzaOrder() {
        pizzas = new Pizza[3];
        count = 0;
    }

    
    public void addPizza(Pizza pizza) {

        if (count < 3) {
            pizzas[count] = pizza;
            count++;
        }
        else {
            System.out.println("Maximum 3 pizzas allowed.");
        }
    }


    public double calcTotal() {

        double total = 0;

        for (int i = 0; i < count; i++) {
            total = total + pizzas[i].calcCost();
        }

        return total;
    }
}



public class pizza {

    public static void main(String[] args) {

    
        Pizza pizza1 = new Pizza("large", 1, 1, 2);
        Pizza pizza2 = new Pizza("medium", 2, 1, 0);

    
        System.out.println(pizza1.getDescription());
        System.out.println(pizza2.getDescription());

        
        PizzaOrder order = new PizzaOrder();

    
        order.addPizza(pizza1);
        order.addPizza(pizza2);

        
        System.out.println("Total Order Cost: $" + order.calcTotal());
    }
}