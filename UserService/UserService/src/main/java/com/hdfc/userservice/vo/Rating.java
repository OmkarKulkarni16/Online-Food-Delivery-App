package com.hdfc.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private int ratingId;
    private int customerId;
    private int restaurantId;
    private int rating;
    private String comments;

    private Restaurant restaurant;
}
