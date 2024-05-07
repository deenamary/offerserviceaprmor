package com.example.offerserviceaprmor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductofferRepository extends JpaRepository<Productoffer, String> {

    List<Productoffer> findBySellername(String sellername);

}
