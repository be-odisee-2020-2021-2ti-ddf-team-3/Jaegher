package be.odisee.ti2.groep4.quatraplanning;

import be.odisee.ti2.groep4.quatraplanning.dao.*;

import be.odisee.ti2.groep4.quatraplanning.domain.*;

import be.odisee.ti2.groep4.quatraplanning.service.QuatraPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class QuatraPlanningApplicationInitDB implements CommandLineRunner{

    @Autowired
    protected QuatraPlanningService quatraPlanningService = null;

    @Autowired
    KlantRepository klantRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PlannerRepository plannerRepository;

    @Autowired
    ChauffeurRepository chauffeurRepository;

    @Autowired
    AfspraakRepository afspraakRepository;

    @Autowired
    PlanningRepository planningRepository;

    @Autowired
    VrachtwagenRepository vrachtwagenRepository;

    @Autowired
    ProbleemoplosserRepository probleemoplosserRepository;

    @Autowired
    ProbleemRepository probleemRepository;

    @Autowired
    UserRepository userRepository;


    public void run(String... args) throws Exception{
        List<User> users = Arrays.asList(
                new User(1, "imke",
                        "{bcrypt}$2a$10$3xNfFbSc5dmzcgCnECAnt.RmzVcZaP6RLzAJZz1zAE3NyxUrMsQqm",
                        "ROLE_USER","Imke", "Courtois","imke@courtois.be"),
                new User(2,"baran",
                        "{bcrypt}$2a$10$DJBQIHeu7U/o4cJLH6UpQOq901Mded2TyxrFRnV.n9Ve9eMKjedY2",
                        "ROLE_ADMIN","Baran", "Akat", "barab@akat.be"),
                new User(3, "louka",
                        "{bcrypt}$2a$10$/XWDi72xvDIjIAEosARYE.pF1aVY67ddxuXP6e3o9m9MrLqnLlfCa",
                        "ROLE_ADMIN","Louka", "Octave", "louka@octave.be"),
                new User(4, "redon",
                        "{bcrypt}$2a$10$nrgqPk3H8cdyFehnX6Hb5uAkKVNZXy8k2ftpgP5APugiZJg60S.nK",
                        "ROLE_ADMIN","Redon", "Miftari","redon@miftari.com"),
                new User(5, "sabrina",
                        "{bcrypt}$2a$10$/o.LZUQplheh85HRnLc63.WLR1VfQskQJVpvMEnlifwa9m5jdyGyK",
                        "ROLE_ADMIN","Sabrina", "Pevenage","sabrina@pevenage.com"),
                new User(6, "samy",
                        "{bcrypt}$2a$10$.KFZ14HGHDNcxCMEJVZmlemA7w0lG68aH5utxVJuDKrBMGRzYwbJe",
                        "ROLE_ADMIN","Samy", "Sah","samy@sah.com"),
                new User(7, "sander",
                        "{bcrypt}$2a$10$153vNqqpgX.YPBtObBwFguGeawzXWpXtInm3Dj.oSURu6GK5Z7pPi",
                        "ROLE_ADMIN","Sander", "Deneyer","sander@deneyer.com")
        );
        for(User user: users){
            userRepository.save(user);
        }

        List<Klant> klanten = Arrays.asList(
                new Klant(1, "Jos", "De Gouden Friet", "Halle", "gouden.friet@gmail.com", "+32/452746521"),
                new Klant(2,"Jef","De Dikke Saté", "Bxl", "dikke.sate@outlook.be", "+32/456723410"),
                new Klant(3,"De Mulder", "De Zwaan", "Oostende","de.zwaan@hotmail.com","0401398324"),
                new Klant(4, "Jael Gill","Ridiculus Mus Donec Incorporated","Keiem","lectus.Cum.sociis@Sedpharetrafelis.co.uk",	"+32/475246975"),
                new Klant(5,"Wylie Witt","Sem Inc.","Buizingen","in.molestie@acfacilisis.net","+32/460189047"),
                new Klant(6,"Damian Aguilar", "Cras Interdum Nunc Company","Bellevue","aliquam@convallisest.org","+32/493326393"),
                new Klant(7, "Harland ", "Realbab","Andelecht", "hwhoolehan6@shinystat.com", "+46 724 504 2000"),
                new Klant(8, "Cassy", "Tropicshot","Herent", "cassy@tropicshot.be", "+32 252 35 45"),
                new Klant(9, "Eolande", "Fliptune", "Leuven", "flip@tune.com", "02 452 21 37"),
                new Klant(10, "Cedric", "Bij Cedric", "Aarschot", "bijCedric@hotmail.be", "0489 251 223")
                );

        for(Klant klant: klanten){
            klantRepository.save(klant);
        }

        List<Planner> planners = Arrays.asList(
                new Planner(1,"Bob","Bonniswaar","bob.bonniswaar@quatra.be","+32/412573285"),
                new Planner(2,"Barry","Beethoven","barry.beethoven@quatra.be","+32/412573286")
        );

        for (Planner planner: planners){
            plannerRepository.save(planner);
        }

        List<Vrachtwagen> vrachtwagens = Arrays.asList(
                new Vrachtwagen(1, "1 AUN 542", "Vrachtwagen", 6000),
                new Vrachtwagen(2, "1 ZEH 123", "Vrachtwagen met oplegger", 9000),
                new Vrachtwagen(3, "1 LDK 716", "Vrachtwagen", 6000)
        );

        for (Vrachtwagen vrachtwagen: vrachtwagens){
            vrachtwagenRepository.save(vrachtwagen);
        }

        List<Chauffeur> chauffeurs = Arrays.asList(
                new Chauffeur (1, vrachtwagenRepository.findById(1), "Kamil", "Mountain", "C", "0487452531"),
                new Chauffeur (2, vrachtwagenRepository.findById(2), "Faysall", "Coudron", "C", "0487123531"),
                new Chauffeur (3, vrachtwagenRepository.findById(3), "Manon", "Boudoire", "C", "0487473191"),
                new Chauffeur (4, vrachtwagenRepository.findById(2), "Hans", "Vandenbogaerde", "C", "0486568897"),
                new Chauffeur (5, vrachtwagenRepository.findById(1), "Alistair", "Boudoire", "C", "0484485525"),
                new Chauffeur (6, vrachtwagenRepository.findById(3), "Nathan", "De Wever", "C", "0498536322")
        );

        for (Chauffeur chauffeur: chauffeurs){
            chauffeurRepository.save(chauffeur);
        }

        List<Afspraak> afspraken = Arrays.asList(
                new Afspraak(1, klantRepository.findById(1), Date.valueOf("2021-04-19")),
                new Afspraak(2, klantRepository.findById(2), Date.valueOf("2021-04-20")),
                new Afspraak(3, klantRepository.findById(3), Date.valueOf("2021-04-21")),
                new Afspraak(4, klantRepository.findById(4), Date.valueOf("2021-04-19")),
                new Afspraak(5, klantRepository.findById(5), Date.valueOf("2021-04-20")),
                new Afspraak(6, klantRepository.findById(6), Date.valueOf("2021-04-22")),
                new Afspraak(7, klantRepository.findById(7), Date.valueOf("2021-04-20")),
                new Afspraak(8, klantRepository.findById(8), Date.valueOf("2021-04-19")),
                new Afspraak(9, klantRepository.findById(9), Date.valueOf("2021-04-21")),
                new Afspraak(10, klantRepository.findById(10), Date.valueOf("2021-04-20")),
                new Afspraak(11, klantRepository.findById(2), Date.valueOf("2021-04-23")),
                new Afspraak(12, klantRepository.findById(9), Date.valueOf("2021-04-24")),
                new Afspraak(13, klantRepository.findById(7), Date.valueOf("2021-04-24")),
                new Afspraak(14, klantRepository.findById(8), Date.valueOf("2021-04-25")),
                new Afspraak(15, klantRepository.findById(6), Date.valueOf("2021-04-24"))

                );

        for (Afspraak afspraak: afspraken){
            afspraakRepository.save(afspraak);
        }

        List<Planning> plannings = Arrays.asList(
                new Planning(quatraPlanningService.krijgIngelogdePlanner(), new Date(System.currentTimeMillis()))
        );

        for (Planning planning: plannings){
            planningRepository.save(planning);
        }

        List<Probleemoplosser> probleemoplossers = Arrays.asList(
                new Probleemoplosser(1, "Kevin", "De Mol", "kevin.demol@quatra.be", "32/475126985")
        );

        for (Probleemoplosser probleemoplosser: probleemoplossers){
                probleemoplosserRepository.save(probleemoplosser);
        };
    }
}
