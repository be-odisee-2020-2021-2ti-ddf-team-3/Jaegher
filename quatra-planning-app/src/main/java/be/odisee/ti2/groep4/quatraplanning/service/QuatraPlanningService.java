package be.odisee.ti2.groep4.quatraplanning.service;

import be.odisee.ti2.groep4.quatraplanning.domain.*;

import java.sql.Date;
import java.util.List;

public interface QuatraPlanningService {

    /************
     * PLANNING *
     ************/
    public List<Planning> geefAllePlannings();
    public Planning voegPlanningToe(Planning planning);
    public Planning zoekPlanningMetId(long id);
    public Planning pasPlanningAan(Planning planning);
    public void verwijderPlanning(long id);

    public Planning processPlanningAfspraken(Planning planning, List<Afspraak> toeTeVoegenAfspraken, List<Afspraak> wegTeHalenAfspraken);


    /************
     * PROBLEEM *
     ************/
    public List<Probleem> geefAlleProblemen();
    public Probleem voegProbleemToe(Probleem probleem);
    public Probleem zoekProbleemMetId(long id);
    public Probleem pasProbleemAan(Probleem probleem);
    public void verwijderProbleem(long id);

    /************
     * AFSPRAAK *
     ************/
    public List<Afspraak> geefAlleAfspraken();
    public List<Afspraak> geefAfsprakenInPlanning(long id);
    public List<Afspraak> geefAfsprakenZonderPlanning();
    public List<Afspraak> geefAfsprakenZonderPlanningOpGeselecteerdeDatum(Date datum);
    public Afspraak zoekAfspraakMetId(long id);

    /******************
     * AUTHENTICATION *
     ******************/
    public String getAuthenticatedFullname();
    public Planner krijgIngelogdePlanner();

    /*************
     * CHAUFFEUR *
     *************/
    public List<Chauffeur> geefAlleChauffeurs();

    /***********
     * PLANNER *
     ***********/
    public List<Planner> geefAllePlanners();

    /***********
     * Probleemoplosser *
     ***********/
    public List<Probleemoplosser> geefAlleProbleemoplossers();

}
