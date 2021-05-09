package be.odisee.ti2.groep4.quatraplanning.controllers;

import be.odisee.ti2.groep4.quatraplanning.domain.Planning;
import be.odisee.ti2.groep4.quatraplanning.service.QuatraPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(path="/quatraplanningrest", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins="http://localhost:8888",
        maxAge = 3600, allowCredentials = "true")
public class PlanningRestController {

    @Autowired
    protected QuatraPlanningService quatraPlanningService = null;

    @RequestMapping("/pickitup.html")
    public String pickitup() {
        return "pickitup";
    }

    /********
     * LIST *
     ********/
    // REST GET, breng de toestand van een bestaande resource van de server nar de client (lijst van objecten)
    @RequestMapping(value = "/plannings", method = RequestMethod.GET)
    public @ResponseBody List<Planning> getPlannings() {
        return quatraPlanningService.geefAllePlannings();
    }

    /**********
     * CREATE *
     **********/
    // REST POST, daarmee wordt een resource aangemaakt
    @RequestMapping(value = "/plannings", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Planning createPlanning(@RequestBody Planning planning, HttpServletResponse response)
            throws BindException {
        // TODO: verander naar voegPlanningToe()
        quatraPlanningService.voegPlanningToe(planning);
        response.setHeader("Location", "/plannings/" + planning.getId());
        return planning;
    }

    /********
     * READ *
     ********/
    // REST GET, breng de toestand van een bestaande resource van de server nar de client (1 object)
    @RequestMapping(value="/planning/{id}", method = RequestMethod.GET)
    public @ResponseBody Planning getPlanning(@PathVariable("id") long id) {
        return quatraPlanningService.zoekPlanningMetId(id);
    }

    /**********
     * UPDATE *
     **********/
    // REST PUT, breng de toestand van een bestaande resource van de client naar de server
    @RequestMapping(value="/planning/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putPlanning(@PathVariable("id") long id, @RequestBody Planning planning) {
       planning.setId(id);
       quatraPlanningService.pasPlanningAan(planning);
    }

    /**********
     * DELETE *
     **********/
    // REST DELETE, daarmee wordt een resource verwijderd
    @RequestMapping(value = "/planning/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void planningVerwijderen(@PathVariable("id") long id) {
        quatraPlanningService.verwijderPlanning(id);
    }
}