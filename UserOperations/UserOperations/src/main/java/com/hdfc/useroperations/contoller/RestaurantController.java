package com.hdfc.useroperations.contoller;

import com.hdfc.useroperations.entity.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/customer-op")
public class RestaurantController {

    String baseUrl = "http://localhost:8082/restaurants";

    WebClient webClient = WebClient.create(baseUrl);


    @GetMapping("/getAll")
    public Mono<List<ResponseEntity<Restaurant>>> getAll() {

        Flux<ResponseEntity<Restaurant>> flux = webClient.get()
                .uri("/getAllRestaurant")
                .retrieve()
                .bodyToFlux(Restaurant.class)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK));
//              .map(e->new ResponseEntity<List<Restaurant>>((List<Restaurant>) e,HttpStatus.OK));

//              .map(e->new ResponseEntity<List<Restaurant>>( e, HttpStatus.OK));
        Mono<List<ResponseEntity<Restaurant>>> mono = flux.collectList();

        return mono;
    }

    @GetMapping("/get-by-location/{location}")
    public Mono<List<Restaurant>> getRestaurantByLocation(@PathVariable String location){
                Flux<Restaurant> flux = webClient.get()
                        .uri("/get-by-location/"+location)
                        .retrieve()
                        .bodyToFlux(Restaurant.class);

                Mono<List<Restaurant>> mono = flux.collectList();

                return mono;
    }

    @GetMapping("/get-by-restaurant/{restaurantName}")
    public Mono<List<Restaurant>> searchByRestaurantName(@PathVariable String restaurantName){
        Flux<Restaurant> flux = webClient.get()
                .uri("/get-by-restaurant/"+restaurantName)
                .retrieve()
                .bodyToFlux(Restaurant.class);

        Mono<List<Restaurant>> mono = flux.collectList();

        return mono;

    }
}
