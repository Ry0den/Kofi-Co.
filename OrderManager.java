package Kofi_Co;

import java.util.ArrayList;

public class OrderManager {
    private static OrderManager instance;
    private ArrayList<OrderItem> currentOrder;
    
    private OrderManager() {
        currentOrder = new ArrayList<>();
    }
    
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
    
    public void addToOrder(String name, String price) {
        if (currentOrder == null) {
            currentOrder = new ArrayList<>();
        }
        OrderItem newItem = new OrderItem(name, price);
        currentOrder.add(newItem);
        System.out.println("Added to order: " + name + " - " + price); // Debug line
    }
    
    public ArrayList<OrderItem> getCurrentOrder() {
        if (currentOrder == null) {
            currentOrder = new ArrayList<>();
        }
        return currentOrder;
    }
    
    public void clearOrder() {
        if (currentOrder != null) {
            currentOrder.clear();
        }
    }
} 