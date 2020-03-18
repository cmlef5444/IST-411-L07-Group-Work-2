/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Chris Lefebvre
 */
public class DatabaseClass {
    
    private static Map<Long, Order> orders = new HashMap<>();
    
    public static Map<Long, Order> getOrders(){
        return orders;
    }
    
}
