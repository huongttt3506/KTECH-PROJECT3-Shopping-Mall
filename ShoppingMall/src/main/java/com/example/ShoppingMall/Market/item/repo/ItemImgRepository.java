package com.example.ShoppingMall.Market.item.repo;

import com.example.ShoppingMall.Market.item.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);
    List<ItemImg> findByItemId(Long itemId);
}
