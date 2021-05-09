package be.odisee.ti2.groep4.quatraplanning.dao;

import be.odisee.ti2.groep4.quatraplanning.domain.Planner;
import org.springframework.data.repository.CrudRepository;


public interface PlannerRepository extends CrudRepository<Planner, Long> {

    /**
     * The default findById would return Optional<Entry>
     * We want a Entry object as return
     * therefore we override this method
     * @param id
     * @return
     */
    public Planner findById(long id);
}
