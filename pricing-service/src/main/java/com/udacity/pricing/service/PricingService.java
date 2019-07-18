package com.udacity.pricing.service;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.springframework.stereotype.Service;

/**
 * Implements the pricing service to get prices for each vehicle.
 */
@Service
public class PricingService {

    private final PriceRepository repository;

    public PricingService(PriceRepository repository) {
        this.repository = repository;
    }

    /**
     * If a valid vehicle ID, gets the price of the vehicle from the stored array.
     *
     * @param vehicleId ID number of the vehicle the price is requested for.
     * @return price of the requested vehicle
     * @throws PriceException vehicleID was not found
     */
    public Price findById(Long vehicleId) {
        /**
         * TODO: Implement the findById function, which uses the `PRICES`
         *   mapping above to access the price for the requested vehicleID.
         *   Make sure it can handle exceptions, either here or in the PricingController!
         *   The below code should be removed.
         */
        return repository.findById(vehicleId).orElseThrow(() -> new PriceException(String.format("Price for vehicleId: %s not found", vehicleId)));
    }
}
