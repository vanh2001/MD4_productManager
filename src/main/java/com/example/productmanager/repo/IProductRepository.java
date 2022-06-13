package com.example.productmanager.repo;

import com.example.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    String FIND_TOP4_NEW = "select * from product order by id desc limit 4;";
    String FIND_PRODUCT_BY_CATEGORY_ID = "select * from product where category_id = ?1";

    Iterable<Product> findAllByNameContaining (String name);

    Iterable<Product> findAllByOrderByPriceAsc();

    @Query(nativeQuery = true, value = FIND_TOP4_NEW)
    Iterable<Product> findTop4New();

    @Query(nativeQuery = true, value = FIND_PRODUCT_BY_CATEGORY_ID)
    Iterable<Product> findProductByCategoryId(Long id);
}
