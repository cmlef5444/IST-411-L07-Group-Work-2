/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cjani
 */
public class DataService {
    
    private List<Order> orderList = new ArrayList<>();
    
    private static DataService ourInstance = new DataService();
    
    public static DataService getInstance(){
        return ourInstance;
    }
    
    public int addOrder(Order order){
        int newId = (orderList.size() + 1);
        order.setOrderId(newId);
        orderList.add(order);
        return newId;
    }
    
    public List<Order> getOrderList(){
        return orderList;
    }
    
//    public Order getOrderById(int id){
//        for (Order order : orderList){
//            if(order.getOrderId().equals(id)){
//                return order;
//            }
//        }
//     return null;   
//    }
    
}
