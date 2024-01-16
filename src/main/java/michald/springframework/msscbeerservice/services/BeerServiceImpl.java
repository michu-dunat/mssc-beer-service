package michald.springframework.msscbeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import michald.springframework.msscbeerservice.domain.Beer;
import michald.springframework.msscbeerservice.repositories.BeerRepository;
import michald.springframework.msscbeerservice.web.controller.NotFoundException;
import michald.springframework.msscbeerservice.web.mappers.BeerMapper;
import michald.springframework.msscbeerservice.web.model.BeerDto;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService
{
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override public BeerDto getById(UUID beerId)
    {
        return beerMapper.map(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override public BeerDto saveNewBeer(BeerDto beerDto)
    {
        return beerMapper.map(beerRepository.save(beerMapper.map(beerDto)));
    }

    @Override public BeerDto updateBeer(UUID beerId, BeerDto beerDto)
    {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.map(beerRepository.save(beer));
    }
}
