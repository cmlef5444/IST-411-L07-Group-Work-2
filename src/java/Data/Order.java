/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Orders")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT d FROM Orders d"),
    @NamedQuery(name = "Orders.findByOrderId", query = "SELECT d FROM Order d WHERE d.orderID = :orderId")
})

public class Order implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "sender_last_name")
    private String senderLastName;
    @Column (name = "sender_first_name")
    private String senderFirstName;
    @Column (name = "sender_ID")
    private int senderID;
    @Column (name = "recipient_last_name")
    private String recipientLastName;
    @Column (name = "recipient_first_name")
    private String recipientFirstName;
    @Column (name = "recipient_id")
    private int recipientID;
    @Column (name = "transaction_amount")
    private double transactionAmount;
     
    public Order() {

    }

    public Order(long orderId, String senderLastName, 
        String senderFirstName, int senderID, String recipientLastName, 
        String recipientFirstName, int recipientID, double transactionAmount) {
        
         this.orderId = orderId;
         this.senderLastName = senderLastName;
         this.senderFirstName = senderFirstName;
         this.senderID = senderID;
         this.recipientLastName = recipientLastName;
         this.recipientFirstName = recipientFirstName;
         this.recipientID = recipientID;
         this.transactionAmount = transactionAmount;
         
    }
    
//    /**
//     * @return the order_id
//     */
//    public int getOrder_id() {
//        return order_id;
//    }
//
//    /**
//     * @param order_id the order_id to set
//     */
//    public void setOrder_id(int order_id) {
//        this.order_id = order_id;
//    }

    /**
     * @return the senderLastName
     */
    public String getSenderLastName() {
        return senderLastName;
    }

    /**
     * @param senderLastName the senderLastName to set
     */
    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    /**
     * @return the senderFirstName
     */
    public String getSenderFirstName() {
        return senderFirstName;
    }

    /**
     * @param senderFirstName the senderFirstName to set
     */
    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    /**
     * @return the senderID
     */
    public int getSenderID() {
        return senderID;
    }

    /**
     * @param senderID the senderID to set
     */
    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    /**
     * @return the recipientLastName
     */
    public String getRecipientLastName() {
        return recipientLastName;
    }

    /**
     * @param recipientLastName the recipientLastName to set
     */
    public void setRecipientLastName(String recipientLastName) {
        this.recipientLastName = recipientLastName;
    }

    /**
     * @return the recipientFirstName
     */
    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    /**
     * @param recipientFirstName the recipientFirstName to set
     */
    public void setRecipientFirstName(String recipientFirstName) {
        this.recipientFirstName = recipientFirstName;
    }

    /**
     * @return the recipientID
     */
    public int getRecipientID() {
        return recipientID;
    }

    /**
     * @param recipientID the recipientID to set
     */
    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    /**
     * @return the transactionAmount
     */
    public double getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * @param transactionAmount the transactionAmount to set
     */
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    

    /**
     * @return the orderId
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
