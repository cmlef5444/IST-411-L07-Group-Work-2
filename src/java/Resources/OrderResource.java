package Resources;

import Data.Order;
import Data.OrderService;
import Data.Transaction;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Chris Lefebvre 
 * Kristina Mantha
 * Sam Janvey
 * Gregory Ramos
 */

/*
Required CRUD
 Create
 Login - Post: payme.com/auth/Token/v3/
 Logout - Post: payme.com/auth/logout
 Order - Post: payme.com/cart/v3/order/{order_id}
 Read
 Get: payme.com/paymentcheckout/v3/order/{order_id}
 Get: payme.com/paymentcheckout/v3/order/all
 Get: payme.com/transactions/v4/{Transaction_id}
 Get: payme.com/transactions/v4/all
 Update
 Put: payme.com/paymentcheckout/v3/order/{order_id}
 Delete
 Delete: payme.com/paymentCheckout/v3/order/{order_id}
 */

/*
The purpose of this program is to demonstrate the coding that would be used in a 
JAX-RS program, These methods are based off the RESTful API assignemnt from L05
where we created a peer-to-peer payment application.
*/
@Path("payme")
public class OrderResource {

//   @PersistenceContext(unitName = "Pack_war_1.0-SNAPSHOTPU")    
    private EntityManager entityManager;
    OrderService orderService = new OrderService();
    
    /**
     * @param args the command line arguments
     * The URLs below demonstrate the appearance of the URLs that would be seen in the database/website
     * @Param (unused) URL examples
     */
    public static void main(String[] args) {
        try {
            //CREATE
            URL loginURL = new URL("www.payme.com/auth/Token/v3");
            URL logoutURL = new URL("www.payme.com/auth/logout");
            URL orderURL = new URL("www.payme.com/cart/v3/order/48");
            //READ
            URL orderAllURL = new URL("www.payme.com/cart/v3/order/all");
            URL transactionURL = new URL("www.payme.com/transactions/v4/48");
            URL transactionAllURL = new URL("www.payme.com/transactions/v4/all");
            //UPDATE & DELETE
            URL paymentURL = new URL("www.payme.com/paymentcheckout/v3/order/48");
        } catch (MalformedURLException e) {
        }
//        System.out.println("Type in what you wish to test");
//        System.out.println("[1]CREATE order, [2] READ order, [3] UPDATE order, [4] DELETE order");
    }
    /*
    login() is a @GET method takes two parameters, user and password, 
    that both can only take certain kinds of characters through the use of PathParam
    Depending on if it is authenticated or not (method truncated) either the user
    can move forward or a notification is sent to the user and they must try again
    @param user
    @param password
    */
    @GET
    @Path("{user: [a-zA-Z][a-zA-Z_0-9]}/password:[a-zA-Z][a-zA-Z_0-9]")
    public void login(@PathParam("user") String user, @PathParam("password") String password) {
        if (authenticate(user, password) == true) {
            //authentication passed, continue on
            System.out.println("User Authenticated");
        } else {
            //authentication failed, notify user
            System.out.println(user + "cannot be authenticated.");
        }
    }
    
    /*
    createOrder() is a @POST method that creates an order entity through the use 
    of the @FormParam
    @param orderId
    */
//    @POST
//    @Path("form")
//    @Consumes("application/x-www-form-urlencoded")
//    public String createOrder(@PathParam("orderId") int orderId) {
////        Order entity = new Order();
////        entity.setOrderId(orderId);
////        entityManager.persist(entity);
//        
//        return"Post Works!";
//        
//    }
//    @POST
//    @Path("form")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String addMessage(){
//        
//        return "POST works!";
//    }
    
//    @POST
//    @Path("form")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)    
//    public Order addOrder(Order order){
//        
//        return orderService.addOrder(order);
//    }
//    
//    
//    @GET
//    @Path("paymentcheckout/v3/orderup/")
//    @Produces("text/html")
//    public String getHtml() {
//        String text = "Hello World!";
//        return "<html lang=\"en\"><body><h1>Hello, World!!</body?</h1></html>";
//    }
//    
    @GET
    @Path("order/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    
    @GET
    @Path("order/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getSingleOrder(@PathParam("orderId") long orderId){
        return orderService.getOrder(orderId);
    }
    
    @POST
    @Path("order/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order createOrder(Order order){
        return orderService.addOrder(order);
    }
    
    @PUT
    @Path("order/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order updateOrder(Order order){
        return orderService.updateOrder(order);
    }
    
    @DELETE
    @Path("order/delete/{orderId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteOrder(@PathParam("orderId") long id){
        orderService.removeOrder(id);
    }
    
    
   
    /*
    updateOrder() is a @PUT method that that allows the an instance of an Order to 
    be replaced with new data
    @param orderId
    @param entity
    */
    @PUT
    @Path("paymentcheckout/v3/order/")
    public void updateOrder(@PathParam("orderId") Short orderId, Order entity) {
        entityManager.merge(entity);
    }
    
    /*
    deleteOrder() is a @Delete Method that allows for an entity with the order the
    orderId number to be deleted.
    @param orderId
    */
    @DELETE
    @Path("paymentcheckout/v3/order/")
    public void deleteOrder(@PathParam("orderId") Short orderId) {
        //remove the order from the data store
        entityManager.remove(orderId);
    }
    
    
    /*
    readTransaction() is a @GET statement that outputs the value of a single transaction as a string
    @param transactionID
    */
    @GET
    @Path("transactionID")
    @Produces(MediaType.APPLICATION_JSON)
    public String readTransaction(@PathParam("transactionID)") Short transactionID) {
        //read transaction from the data store
        return entityManager.find(Transaction.class, transactionID).toString();
        
    }

    /*
    authenticate() reads data from the database and checks if the username and password are correct
    it then returns a boolean value based on that check
    @param user
    @param password
    */    
    public boolean authenticate(String user, String password) {
        boolean bol;
        /*
         Code to check database for user and password
        Requires Auth class to be implmented
         */
        if(user.equals(Auth.checkUser())){
           if(Auth.checkUserPassword(password)){
               bol = true;           
            }else{
               bol = false;
                System.out.println("Username and/orPassword is incorrect");
            }
        } else{
            bol = false;
            System.out.println("Username and/or password is incorrect");
        }        
        return bol;
    }
}
