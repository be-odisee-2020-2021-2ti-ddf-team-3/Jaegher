package be.odisee.ti2.groep4.quatraplanning.controllers;
import be.odisee.ti2.groep4.quatraplanning.domain.Probleem;
import be.odisee.ti2.groep4.quatraplanning.service.QuatraPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProbleemController {

    @Autowired
    protected QuatraPlanningService quatraPlanningService = null;
    /********
     *     @RequestMapping("/pickitup.html")
     *     public String pickitup() {
     *         return "pickitup";
     *     } *
     ********/

    /********
     * LIST *
     ********/
    // REST GET, breng de toestand van een bestaande resource van de server nar de client (lijst van objecten)
    @RequestMapping(value = "/problemen", method = RequestMethod.GET)
    public @ResponseBody List<Probleem> getProblemen() {
        return quatraPlanningService.geefAlleProblemen();
    }

    /**********
     * CREATE *
     **********/
    // REST POST, daarmee wordt een resource aangemaakt
    @RequestMapping(value = "/problemen", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Probleem createProbleem(@RequestBody Probleem probleem, HttpServletResponse response)
            throws BindException {
        // TODO: verander naar voegPlanningToe()
        quatraPlanningService.voegProbleemToe(probleem);
        response.setHeader("Location", "/problemen/" + probleem.getId());
        return probleem;
    }

    /********
     * READ *
     ********/
    // REST GET, breng de toestand van een bestaande resource van de server nar de client (1 object)
    @RequestMapping(value="/probleem/{id}", method = RequestMethod.GET)
    public @ResponseBody Probleem getProbleem(@PathVariable("id") long id) {
        return quatraPlanningService.zoekProbleemMetId(id);
    }

    /**********
     * UPDATE *
     **********/
    // REST PUT, breng de toestand van een bestaande resource van de client naar de server
    @RequestMapping(value="/probleem/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putProbleem(@PathVariable("id") long id, @RequestBody Probleem probleem) {
        probleem.setId(id);
        quatraPlanningService.pasProbleemAan(probleem);
    }

    /**********
     * DELETE *
     **********/
    // REST DELETE, daarmee wordt een resource verwijderd
    @RequestMapping(value = "/probleem/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void probleemVerwijderen(@PathVariable("id") long id) {
        quatraPlanningService.verwijderProbleem(id);
    }
}
