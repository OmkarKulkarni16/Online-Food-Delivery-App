package com.hdfc.restaurantservice.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "restaurantid")
    private int restaurantId;
    @Column(name = "menuitemid")
    private int menuItemId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "restaurantname")
    private String restaurantName;
    @Column(name = "menuitemname")
    private String menuItemName;
    @Column(name = "amount")
    private float amount;


    public Cart(int id, int restaurantId, int menuItemId, int quantity) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.menuItemId = menuItemId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", menuItemId=" + menuItemId +
                ", quantity=" + quantity +
                '}';
    }
}
