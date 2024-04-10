package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.TestCV;
import org.springframework.data.repository.CrudRepository;

public interface CvRepository extends CrudRepository<TestCV, Integer> {
}
