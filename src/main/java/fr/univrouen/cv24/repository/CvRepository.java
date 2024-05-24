package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Cv24;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CvRepository extends CrudRepository<Cv24, Long> {

    List<Cv24> findAllByIdIsNotNull();
}
