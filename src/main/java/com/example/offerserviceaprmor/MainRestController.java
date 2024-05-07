package com.example.offerserviceaprmor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class MainRestController {

    ProductofferRepository productofferRepository;
    ProductofferstatusRepository productofferstatusRepository;

    MainRestController(ProductofferRepository productofferRepository,
                       ProductofferstatusRepository productofferstatusRepository) {
        this.productofferRepository = productofferRepository;
        this.productofferstatusRepository = productofferstatusRepository;
    }

    @PostMapping("save/product/offer")
    public ResponseEntity<Productoffer> createOffer(@RequestBody Productoffer offer,
                                                    Productofferstatus productofferstatus)
    {
        offer.setId(String.valueOf(UUID.randomUUID()));
        productofferRepository.save(offer);


        productofferstatus.setId(String.valueOf(UUID.randomUUID()));
        productofferstatus.setOfferid(offer.getId());
        productofferstatus.setStatus("OPEN");
        productofferstatusRepository.save(productofferstatus);

        return ResponseEntity.ok(offer);
    }
}
