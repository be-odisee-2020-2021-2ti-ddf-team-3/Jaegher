# [Quatra Planning App](https://quatra-planning-app.herokuapp.com/)

## Bestanden en informatie op de [SharePoint](https://hubkaho.sharepoint.com/sites/BATeam4-Quatra)

## Taken op de [Kanban](https://kanbanflow.com/board/HfXiEi1)

## Werkwijze voor uploaden op [Toledo](https://p.cygnus.cc.kuleuven.be/webapps/tol-web-rs-bb-bb_bb60/goto_lu.do?batchUid=B-ODISEE-OBI39a-2021&entityId=urn%3Amace%3Akuleuven.be%3Akulassoc%3Akuleuven.be&userId=q1263808)

Enkel src folder en pom.xml file samen zippen

```
DDF-Team4-OpdrachtX-code-YYMMDD.zip
├── pom.xml
└── src
     └── ...
```

## Handige bronnen
[Materialize CSS](https://materializecss.com/)

[Material Icons](https://fonts.google.com/icons)

[jQuery](https://api.jquery.com/)

[Hoe werken constructors met Lombok annotations?](https://projectlombok.org/features/constructor)

[Hoe @JoinColumn gebruiken bij het leggen van relaties tussen klassen?](https://www.baeldung.com/jpa-join-column)

## Vaak voorkomende errors
### Cannot resolve symbol "[class]"
Oplossing: https://stackoverflow.com/a/5905931/14369350

### Cannot resolve table "[name]"
Nog niet gezocht naar een oplossing, maar app werkt nog wel

### org.h2.jdbc.JdbcSQLNonTransientException: General error: "java.lang.IllegalStateException: Unable to read the page at position ...
Browse naar `C:\Users\[huidige_gebruiker]` en verwijder `.h2.server.properties`, `test.trace.db`, & `test.mv.db`
