package be.odisee.ti2.groep4.quatraplanning.dao;

import be.odisee.ti2.groep4.quatraplanning.domain.Afspraak;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;


public interface AfspraakRepository extends CrudRepository<Afspraak, Long> {

    @Query("SELECT a from Afspraak a WHERE a.planning is null")
    List<Afspraak> geefAfsprakenZonderPlanning();

    @Query("SELECT a from Afspraak a WHERE a.gewensteDatum = :datum AND a.planning is null " )
    List<Afspraak> geefAfsprakenZonderPlanningOpGeselecteerdeDatum(@Param("datum") Date gewensteDatum);
}
