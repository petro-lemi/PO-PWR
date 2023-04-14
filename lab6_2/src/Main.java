import java.util.ArrayList;
import java.util.Arrays;

class Shop {
    public static void main(String[] args) {
        // objects created "separately"
        Item itemBlad = new Item();
        Item itemTomato = new Item("Tomato", 2.5);
        Item itemPomidorGalazka = new Item(itemTomato);

        // display objects
        itemBlad.display();
        itemTomato.display();
        itemPomidorGalazka.display();

        // use an array
        Item[] tab = new Item[3];
        Arrays.fill(tab, new Item());
        for (Item item : tab) {
            item.display();
        }

        // use the collection
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item());
        list.add(new Item("Carrot", 1.8));
        list.add(new Item(itemTomato));
        for (Item item : list) {
            item.display();
        }

        // display static fields
        System.out.println("Number of items created: " + Item.countStatic_);
        System.out.println("Next item ID: " + Item.idStatic_);
    }
}

class Item {
    // fields
    static int countStatic_ = 0;
    private int countNonStatic_ = 0;
    static int idStatic_ = 0;
    private int idNonStatic_ = 0;
    private String name_;
    private double price_;
    private ExpirationDate expirationDate_;

    // constructors
    public Item() {
        this("ERROR", -1);
    }

    public Item(String name, double price) {
        name_ = name;
        price_ = price;
        countStatic_++;
        countNonStatic_++;
        idStatic_++;
        idNonStatic_ = idStatic_;
    }

    public Item(Item other) {
        name_ = other.name_;
        price_ = other.price_;
        countStatic_++;
        countNonStatic_++;
        idStatic_++;
        idNonStatic_ = idStatic_;
    }

    // methods
    public void display() {
        System.out.println("Item ID: " + idNonStatic_);
        System.out.println("Name: " + name_);
        System.out.println("Price: " + price_);
        if (expirationDate_ != null) {
            expirationDate_.display();
        }
        System.out.println("Number of items created: " + countNonStatic_);
        System.out.println();
    }

    // inner class
    private class ExpirationDate {
        // fields
        private int year_;
        private int month_;
        private int day_;

        // constructors
        public ExpirationDate(int year, int month, int day) {
            year_ = year;
            month_ = month;
            day_ = day;
        }

        // methods
        public void display() {
            System.out.println("Expiration date: " + year_ + "-" + month_ + "-" + day_);
        }
    }
}
