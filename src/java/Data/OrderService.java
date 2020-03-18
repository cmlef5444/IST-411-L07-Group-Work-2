/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chris Lefebvre
 */

/**
 * This class acts as the backbone coding for the GET, POST, PUT, and DELETE Methods
 * Each instance of Order is passed through a hash map and this class also has
 * two instances of Order hard coded in.
 * 
 */
public class OrderService {
    
    private List<Order> orderList = new ArrayList<>();
    

    private Map<Long, Order> orders = DatabaseClass.getOrders();
    
    public OrderService(){
        orders.put(1L, new Order(1, "Lefebvre", "Chris", 1, "Janvey", "Sam", 2, 50.00));
        orders.put(2L, new Order(2, "Janvey", "Sam", 2, "Lefebvre", "Chris", 1, 25.00));
    }
    public List<Order> getAllOrders(){
        return new ArrayList<Order>(orders.values());
    }
    
    public Order getOrder(long id){
        return orders.get(id);
    }
    
    public Order addOrder(Order order){
        int i = (orders.size() + 1);
        long num = i;
        order.setOrderId(num);
        orders.put(order.getOrderId(), order);
        return order;        
    }
    
    public Order updateOrder(Order order){
        if(order.getOrderId() <= 0){
            return null;
        }
        orders.put(order.getOrderId(), order);
        return order;
    }
    
    public Order removeOrder(long id){
        return orders.remove(id);
    }        
}
