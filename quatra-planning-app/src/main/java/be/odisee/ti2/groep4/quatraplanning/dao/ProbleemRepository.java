package be.odisee.ti2.groep4.quatraplanning.dao;

import be.odisee.ti2.groep4.quatraplanning.domain.Afspraak;
import be.odisee.ti2.groep4.quatraplanning.domain.Planning;
import be.odisee.ti2.groep4.quatraplanning.domain.Probleem;
import be.odisee.ti2.groep4.quatraplanning.domain.Probleemoplosser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProbleemRepository extends CrudRepository<Probleem, Long> {

    @Query("SELECT a from Probleem p JOIN p.probleemoplosser a WHERE p.id = :id")
    List<Probleemoplosser> geefProbleemoplosserInProbleem(@Param("id") long id);
}
