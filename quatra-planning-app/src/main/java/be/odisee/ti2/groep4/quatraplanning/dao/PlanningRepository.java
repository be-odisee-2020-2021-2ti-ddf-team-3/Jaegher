package be.odisee.ti2.groep4.quatraplanning.dao;

import be.odisee.ti2.groep4.quatraplanning.domain.Afspraak;
import be.odisee.ti2.groep4.quatraplanning.domain.Planning;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PlanningRepository extends CrudRepository<Planning, Long> {

    @Query("SELECT a from Planning p JOIN p.m_Afspraken a WHERE p.id = :id")
    List<Afspraak> geefAfsprakenInPlanning(@Param("id") long id);
}
