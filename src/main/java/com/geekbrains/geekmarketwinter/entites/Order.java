package com.geekbrains.geekmarketwinter.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
//    @JsonBackReference
    private User user;



    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus status;

    @Column(name = "price")
    private Double price;

    @Column(name = "delivery_price")
    private Double deliveryPrice;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private DeliveryAddress deliveryAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column(name = "update_at")
    @CreationTimestamp
    private LocalDateTime updateAt;

    @Override
    public String toString() {
        return "Order{" +
                "user='" + user.getId() + '\'' +
                "status='" + status.getId() + '\'' +
                "price='" + price + '\'' +
                "deliveryPrice='" + deliveryPrice + '\'' +
                "deliveryAddress='" + deliveryAddress.getId() + '\'' +
                "phoneNumber='" +  phoneNumber  + '\'' +
                "deliveryDate='" + deliveryDate + '\'' +
                "orderItems'" + orderItems + '\'' +
                ", createAt='" + createAt + '\'' +
                ", updateAt=" + updateAt +
                '}';
    }

    @JsonIgnore
    @Transient
    private boolean confirmed;
}