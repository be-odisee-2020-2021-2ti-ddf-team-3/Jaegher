package be.odisee.ti2.groep4.quatraplanning.dao;

import be.odisee.ti2.groep4.quatraplanning.domain.Vrachtwagen;
import org.springframework.data.repository.CrudRepository;


public interface VrachtwagenRepository extends CrudRepository<Vrachtwagen, Long> {

    /**
     * The default findById would return Optional<Entry>
     * We want a Entry object as return
     * therefore we override this method
     * @param id
     * @return
     */
    public Vrachtwagen findById(long id);
}
