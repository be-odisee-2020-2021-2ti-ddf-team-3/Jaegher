package be.odisee.ti2.groep4.quatraplanning.service;

import be.odisee.ti2.groep4.quatraplanning.domain.*;
import be.odisee.ti2.groep4.quatraplanning.dao.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("quatraPlanningService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class QuatraPlanningServiceImpl implements QuatraPlanningService {

    public QuatraPlanningServiceImpl(){}

    /************
     * PLANNING *
     ************/
    @Autowired
    private PlanningRepository planningRepo = null;

    private Planning createPlanning(Planner planner, Date datum) { return new Planning(planner, datum); }

    private Planning processPlanning(Planning planningData) {
        // Als de planning al bestaat
        if (zoekPlanningMetId((int) planningData.getId()) != null) { return planningRepo.save(planningData); }
        // Als de planning nog niet bestaat
        else { return planningRepo.save(createPlanning(planningData.getPlanner(), planningData.getDatum())); }
    }

    public List<Planning> geefAllePlannings() { return (List<Planning>) planningRepo.findAll(); }

    public Planning voegPlanningToe(Planning planning) { return processPlanning(planning); }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Planning zoekPlanningMetId(long id) {
        Planning planning;
        Optional<Planning> optionalPlanning = planningRepo.findById(id);
        if (optionalPlanning.isPresent()) planning = optionalPlanning.get();
        else planning = null;
        return planning;
    }

    public Planning pasPlanningAan(Planning planning) { return processPlanning(planning); }

    public void verwijderPlanning(long id) {
        planningRepo.deleteById(id);
    }

    public Planning processPlanningAfspraken(Planning planning, List<Afspraak> toeTeVoegenAfspraken, List<Afspraak> wegTeHalenAfspraken) {
        if (toeTeVoegenAfspraken != null) {
            for (Afspraak ttva : toeTeVoegenAfspraken) { planning.voegAfspraakToe(ttva); }
        }
        if (wegTeHalenAfspraken != null) {
            for (Afspraak wtha : wegTeHalenAfspraken) { planning.haalAfspraakWeg(wtha); }
        }
        return planning;
    }


    /************
     * PROBLEEM *
     ************/
    @Autowired
    private ProbleemRepository probleemRepo = null;

    private Probleem createProbleem(Probleemoplosser probleemoplosser, String probleemstelling) { return new Probleem(probleemoplosser, probleemstelling); }

    private Probleem processProbleem(Probleem probleemData) {
        // Als de Probleem al bestaat
        if (zoekProbleemMetId((int) probleemData.getId()) != null) { return probleemRepo.save(probleemData); }
        // Als de Probleem nog niet bestaat
        else { return probleemRepo.save(createProbleem(probleemData.getProbleemoplosser(), probleemData.getProbleemstelling())); }
    }

    public List<Probleem> geefAlleProblemen() { return (List<Probleem>) probleemRepo.findAll(); }

    public Probleem voegProbleemToe(Probleem probleem) { return processProbleem(probleem); }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Probleem zoekProbleemMetId(long id) {
        Probleem probleem;
        Optional<Probleem> optionalProbleem = probleemRepo.findById(id);
        if (optionalProbleem.isPresent()) probleem = optionalProbleem.get();
        else probleem = null;
        return probleem;
    }

    public Probleem pasProbleemAan(Probleem probleem) { return processProbleem(probleem); }

    public void verwijderProbleem(long id) {
        probleemRepo.deleteById(id);
    }

    /************
     * AFSPRAAK *
     ************/
    @Autowired
    private AfspraakRepository afspraakRepo = null;

    public List<Afspraak> geefAlleAfspraken() { return (List<Afspraak>) afspraakRepo.findAll(); }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public List<Afspraak> geefAfsprakenInPlanning(long id){ return planningRepo.geefAfsprakenInPlanning(id); }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public List<Afspraak> geefAfsprakenZonderPlanning(){
        return afspraakRepo.geefAfsprakenZonderPlanning();
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Afspraak zoekAfspraakMetId(long id) {
        Afspraak afspraak;
        Optional<Afspraak> optionalAfspraak = afspraakRepo.findById(id);
        if (optionalAfspraak.isPresent()) afspraak = optionalAfspraak.get();
        else afspraak = null;
        return afspraak;
    }

    public List<Afspraak> geefAfsprakenZonderPlanningOpGeselecteerdeDatum(Date datum){return (List<Afspraak>) afspraakRepo.geefAfsprakenZonderPlanningOpGeselecteerdeDatum(datum);}

    /******************
     * AUTHENTICATION *
     ******************/
    @Autowired
    private UserRepository userRepository;

    // Had to be public to be used in postAuthorized
    public String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    private User findAuthenticatedUser() { return userRepository.findByUsername(getAuthenticatedUsername()); }

    @Override
    public String getAuthenticatedFullname() {
        User theUser = findAuthenticatedUser();
        return theUser.getFirstName() +' '+ theUser.getLastName();
    }

    //TODO
    public Planner krijgIngelogdePlanner() {
        return plannerRepo.findById(1); //TODO: Verander hardcoded planner id naar ingelogde planner id
    }

    /*************
     * CHAUFFEUR *
     *************/
    @Autowired
    private ChauffeurRepository chauffeurRepo = null;

    public List<Chauffeur> geefAlleChauffeurs() { return (List<Chauffeur>) chauffeurRepo.findAll(); }

    /***********
     * PLANNER *
     ***********/
    @Autowired
    private PlannerRepository plannerRepo = null;

    public List<Planner> geefAllePlanners() { return (List<Planner>) plannerRepo.findAll(); }

    /***********
     * Probleemoplosser *
     ***********/
    @Autowired
    private ProbleemoplosserRepository  ProbleemoplosserRepo = null;

    public List< Probleemoplosser> geefAlleProbleemoplossers() { return (List< Probleemoplosser>) ProbleemoplosserRepo.findAll(); }

}
