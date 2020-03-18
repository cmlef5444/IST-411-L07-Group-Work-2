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
@Table(name = "Transactions")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT d FROM Transactions d"),
    @NamedQuery(name = "Transactions.findByOrderId", query = "SELECT d FROM Transactions d WHERE d.transactionID = :transactionID")
})
public class Transaction implements Serializable{
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private short transactionID;
    
    /*
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
     */
    public Transaction(){
        
    }
    public Transaction(short transactionID /*, String senderLastName, 
     String senderFirstName, int senderID, String recipientLastName, 
     String recipientFirstName, int recipientID, double transactionAmount*/) {
        /* 
         this.order_id = order_id;
         this.senderLastName = senderLastName;
         this.senderFirstName = senderFirstName;
         this.senderID = senderID;
         this.recipientLastName = recipientLastName;
         this.recipientFirstName = recipientFirstName;
         this.recipientID = recipientID;
         this.transactionAmount = transactionAmount;
         */
    }
}
