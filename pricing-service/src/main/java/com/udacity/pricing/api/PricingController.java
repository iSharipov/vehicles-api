package com.udacity.pricing.api;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PricingService;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements a REST-based controller for the pricing service.
 */
@RestController
@RequestMapping("/price")
public class PricingController {

    private final PricingService pricingService;
    private final PricingResourceAssembler assembler;

    public PricingController(PricingService pricingService, PricingResourceAssembler assembler) {
        this.pricingService = pricingService;
        this.assembler = assembler;
    }

    /**
     * Gets the price for a requested vehicle.
     *
     * @param vehicleId ID number of the vehicle for which the price is requested
     * @return price of the vehicle, or error that it was not found.
     */
    @GetMapping
    public Resource<Price> get(@RequestParam Long vehicleId) {
        /**
         * TODO: Use the PricingService to handle a GET request for price
         *   based on a vehicleID input. Make sure it can handle exceptions,
         *   either here or in the PricingService.
         *   The below code should be removed.
         */
        return assembler.toResource(pricingService.findById(vehicleId));
    }
}
