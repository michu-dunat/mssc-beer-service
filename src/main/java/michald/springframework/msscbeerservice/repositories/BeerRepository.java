package michald.springframework.msscbeerservice.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import michald.springframework.msscbeerservice.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>, CrudRepository<Beer, UUID>
{
}
