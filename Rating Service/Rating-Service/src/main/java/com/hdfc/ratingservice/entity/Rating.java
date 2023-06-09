package com.hdfc.ratingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingid")
    private int ratingId;
    @Column(name = "customerid")
    private int customerId;
    @Column(name = "restaurantid")
    private int restaurantId;
    @Column(name = "rating")
    private int rating;
    @Column(name = "comments")

    private String comments;
}
