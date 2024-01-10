package michald.springframework.msscbeerservice.web.mappers;

import michald.springframework.msscbeerservice.domain.Beer;
import michald.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class}, componentModel = "spring")
public interface BeerMapper {
    BeerDto map(Beer beer);

    Beer map(BeerDto dto);
}
