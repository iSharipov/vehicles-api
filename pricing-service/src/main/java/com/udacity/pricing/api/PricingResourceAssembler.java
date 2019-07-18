package com.udacity.pricing.api;

import com.udacity.pricing.domain.price.Price;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Maps the CarController to the Car class using HATEOAS
 */
@Component
public class PricingResourceAssembler implements ResourceAssembler<Price, Resource<Price>> {

    @Override
    public Resource<Price> toResource(Price price) {
        return new Resource<>(price,
                linkTo(methodOn(PricingController.class).get(price.getId())).withSelfRel());
    }
}