package be.odisee.ti2.groep4.quatraplanning.dao;

import be.odisee.ti2.groep4.quatraplanning.domain.Chauffeur;
import org.springframework.data.repository.CrudRepository;


public interface ChauffeurRepository extends CrudRepository<Chauffeur, Long> {

    /**
     * The default findById would return Optional<Entry>
     * We want a Entry object as return
     * therefore we override this method
     * @param id
     * @return
     */
    public Chauffeur findById(long id);
}
