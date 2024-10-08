package com.example.ShoppingMall.Market.shop.entity;

import com.example.ShoppingMall.Market.item.entity.ItemEntity;
import com.example.ShoppingMall.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Shops")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ShopCategory category;
    @Enumerated(EnumType.STRING)
    private ShopStatus status;
    private LocalDateTime lastPurchased;

    //Owner of the shop
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    // Business registration associated with this shop
    private String businessNum;

    // List of close requests associated with this shop
    @OneToMany(mappedBy = "shop")
    private List<ShopCloseRequest> closeRequests;

    //List of items in the shop
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> items; // List of items associated with this shop

}
