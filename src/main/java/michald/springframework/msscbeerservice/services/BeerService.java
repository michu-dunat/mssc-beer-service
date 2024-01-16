package michald.springframework.msscbeerservice.services;

import java.util.UUID;

import michald.springframework.msscbeerservice.web.model.BeerDto;

public interface BeerService
{
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
