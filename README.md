# [Semesteroppgave 2: Fire på rad og Tripp-trapp-tresko]



* **README**
* [Oppgavetekst](SEM-2.md)
* [Tips for å komme i gang](Tips.md)
* [Advanced](Advanced.md)

**Innleveringsfrist:** Hele oppgaven skal være ferdig og levert via din private gitlab-repositorie til **Fredag 24. april kl. 2359** ([AoE](https://www.timeanddate.com/worldclock/fixedtime.html?msg=4&iso=20180427T2359&p1=3399)).  

### Innlevering 
 Du finner koden din i repositoriet med URIen:

    https://retting.ii.uib.no/<sit006>/inf101.v20.sem2.git

Oppgaven leveres inn ved å pushe til retting.ii.uib.no, [slik du har gjort med alle tidligere INF101-oppgaver](https://retting.ii.uib.no/inf101/inf101.v20/wikis/hente-levere-oppgaver). Husk å få med eventuelle nye filer du har opprettet.

**VIKTIG:** *Sjekk kvitteringssiden som kommer opp når du pusher, i tilfelle det skjer feil!* 

Vi anbefaler at du gjør commit hver dag, eller hver gang du er ferdig med en
deloppgave, i tilfelle du mister det du jobber med på din egen maskin. Du kan levere inn så mye og ofte du vil. Versjonen som teller er den **siste du pushet før innleveringsfristen**.

Denne oppgaven teller på din endelige vurdering i faget. Maks poeng er 100. Du kan få opp til 120 totalt, inkludert ekstrapoeng. 

# Fyll inn egne svar/beskrivelse/kommentarer til prosjektet under
* Levert av:   *Sandra Solberg* (*sit006*)
* [x] hele semesteroppgaven er ferdig og klar til retting!
* Code review:
   * [X] jeg har fått tilbakemelding underveis fra @brukernavn, Gruppeleder Brigt
   * [ ] jeg har gitt tilbakemelding underveis til @brukernavn, ...
* Sjekkliste:
   * [x] Kjørbart Fire på Rad-spill
	   * [x] Funksjonelt spill 
	   * [x] Fungerende user interface
	   * [x] Støtter AI 
   * [x] Kjørbart Tripp-trapp-tresko-spill
	   * [x] Funksjonelt spill 
	   * [x] Fungerende user interface
	   * [x] Støtter AI 
   * [x] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [/] Tester
   * [x] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [x] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [x] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
*(oversikt over koden din og det du har gjort)*

Denne koden har to interface som spillene arver fra: plastRamme (denne inneholder metoder om brettet og hvordan hente elementer og opprette brettet. )
IGame: inneholder metoder for regler, metoder som henter Player objekter og holder styr på hvem sin tur det er og hvilke metode for å legge ut brikke.
IRute og Rute er et objekt som gridet til spillene holder på. plastRammen sammen med IGrid/Grid holde på Rute objektet. Rutevalg er enumet Rute har. RuteValg har en value som gir PLAYER1, PLAYER2 og EMPTY.
Et game objekt vil bruke valuen til RuteValg for å finne ut hvilket Player Objekt som spiller og hva som skal fylles når de legger ut et objekt.
RuteException er en egenlaget exception for Rute-behnalding hvor en Rute er opptatt.

Player en en abstraksjon med de mest grunnlegende verdiene for en player. AIPlayer og personPlayer er to subklasser som oppføer seg litt ulikt. Hvor personPlayer bygger på å behandle user input, mens AI velger en Rute i gridet når den spiller.
GridRetninger inneholder enums med verdier for ulike retninger på et brett. Litt lik GridDirection fra semester oppgave 2.


(Kladd: Setter opp likheter og ulikheter hos spillene for å se hvordan de kan implementeres
        Likheter:                 
        1.Begge grids som holder på "brikker" i dette Ruter med RuteValg enum
        2.Det er et two player game, så enten (Alene med AI) eller (to-players mot hverandre)
        3. Man vinner på samme måte (enten diagonalt, vertikalt eller horisontalt)
        Ulikheter:
        1.Tripp Trapp Tresko gir spillere muligheten til å velge hele brettet, mens Fire på rad bare kolonner
        2.Tripp Trapp Tresko har 3x3 matrise mens fire på rad har 6x7
        3. Det er også en forskjell på en brikke fra eller til på seieren mellom disse. 
        
        )

### Bruk

For å starte programmet kjør: inf101.v20.games.Main (her vil du få velge hvilket av spillene du vil spille basert din input)
(PS ta gjerne en tit på inf101.v20.GUIMain() for å se hvordan den er satt opp, der kan man legge til "X" på brettet. Ved å klikke med musen, men den er ikke helt ferdig enda) 
(For å legge til brikker: skrive inn rad nr, trykk enter. så skriv inn kolonne også trykk enter)   
(Hva skjer når noen har vunnet ? Avsluttes spillet automatisk med en beskjed til hvilke spiller som har vunnet) 
(Spillet avsluttes når: enten brettet blir fult eller en spiller vinner (har metode for reset som bør legges inn))  
(...etc...)   

## Designvalg
*(hvordan du har valgt å løse oppgaven)*

 1. Jeg lagde en oversikt over hvilke Objekter/klasser som burde være med.
 2. Dermed prøvde jeg å tenke enklest mulig og lage Interfaces med hvilke egenskape som burde være med.
 
 Ps: Player AIen oppretter en itertor over ledige celler i gridet og legger til posisjoner på next ledig. veldig forutsigbart, men jeg ville heller øve meg på å bruke iterators enn
 og bare legge til en random posisjon i trippTrappTreSko game. 
 
 Detaljer:
 1. Først satt jeg opp plastRamme (Et interface med hvordan et brett bør opprettes og hvordan man henter verdier fra et brett)
 2. plastRammen var veldig lett å implementere siden mye av brettet lager seg selv i Grid-klassen og IGrid 
 3. Jeg lagde er Rute objekt som gridet skal holde på. Dette Rute objektet bruker enum RuteValg (PLAYER1(1), PLAYER2(2), EMPTY(0). Disse skal ha en Value som man kan bruke senere til å finne objektet på brettet.)
 4. Dermed satt jeg opp et interface IGame som extender plastRamme (siden begge er interfacer kan de det. Litt som Iitem og IActor i forrige semesteroppgave ))
 5. Planen er å lage en abstraktGame klasse etter jeg har kommet i gang og laget et av spillene. Slik ser hva som kommer til å gå igjen i begge spillene og slippe gjentagelser)
 6. Så trengte jeg å sette opp en abstrakt Player som skal inneholde Player informasjon. Her skal jeg lage er personPlayer og en AIplayer som skal ha to ulike roller i spillet.
 7. For å lett finne vinner-muligheter lagde jeg enum GridRetninger som inneholder lister med muligheter for å vinne i de ulike retningene. Samt poisjoner for hvor disse retningene befinner seg. 
 8. Jeg lagde også en egen RuteException som skal kastes i plastRammen.
 9. Spillene blir i seperate foldere en firePaaRad og den andre trippTrappSpill begge bruker terminal i main
 
 GUI: DET NESTEN FUNGERENDE MEN IKKE HELT FUNGERENDE prosjektet (må endre slik at Framet tegner et game objekt istedenfor en helt ny )
 1. Delt det hittil opp i trippTrappJFrame() som henter PlayerPanel() og trippTrappGUI() sine panel
 

 1.Her vil det være greit å bruke ActionListner slik at spillere kan bruke musen for å velge
 2. Jeg vil ha en ramme som popper opp (JFrame?? RougeApplication?? ??)
    Inspirasjon fra lab4 CelleGUI LayOut?? 
 3.   

### Bruk av abstraksjon
*(I denne oppgaven har jeg brukt abstraksjon for players i form av en Abstrakte Player klassen
 Her skal de mest vesentlige tingene med Player objektene skrives: slik som at alle Playerene har et navn -> getPlayeName(), id -> getPlayerID(), og et av de to player merkene getPlayerMark(), altså enten RUTEVALG.PLAYER1 eller RUTEVALG.PLAYER2
 subklassene personPlayer() og AIplayer() har likevel litt andre behov for hva som utgjør en AI og hva som utgjør en personPlayer()
AI() for eksempel er en player, men den har en annen oppførsel. For eksempel vil den hente spill data fra IGame game klassen som vil føre til at den publiserer sine enums (RuteValg) på en ledig plass i gridet. Mens en player vil gi sin egen input fra terminalen
 
 //Målet var å flytte en del logikk til abstrakt gameklass litt fordi også heller overføre en del logikk til plastrammen (interface for oppsett) ettersom interface plastramme innholder metoder for hvordan et brett skal utformes som er hvor største forskjellen mellom spillene.
 Her burde jeg flyttet addMark ect
 
 
 
 )*

### Erfaring – hvilke valg viste seg å være gode / dårlige?
*(designerfaringer – 
   1. gode valg har vært å begynne med å tegne opp MVP (mål for hvilke egenskaper som spillene må møte
   2. Jobbe med større komponenter separert GUI paneler (Player Panel(), trippTrapp GUI)))/ JFrame for spillet og Game application hver for seg. 
      Ettersom mange av komponentene i GUIen (som panel størrelse ect) blir implementert i IGame game spillene.
   3. Et annet godt valg var å tidlig abstrahere klassene slik at jeg skrev interfaces og abstrakte klassene før jeg skrev subklassene. 
      Slik fikk jeg skrevet "konstrakter for klassene som jeg ønsket å bruke i spill-logikken"      )

## Testing
*(1. Deler opp testing av objekter i mapper som skal samsvare med hvor objekene i src er lagret. 
  2.Jeg tester egenskaper ved spillet som om det opprettes riktig, at jeg får de forventede verdiene.
  3. Tester også fuksjonaliteten av metoder, at jeg får forventet resultat om jeg legger til rute enum ect
  4. Her valgte jeg å teste de egenskapene ved spillene som er viktig for dens funksjonalitet.

## Funksjonalitet, bugs
*(hva virker / virker ikke
1. Bug i terminal: når en spiller vinner kommer det en referranse til spillObjektet og getValue() verdien til brikken som vant. 
Dette kommer fra IGrid<T> copy() som også blir implementert i trippTrappTreSkoGame.
2.  Display input kommer ut for både Current og for player.


## Evt. erfaring fra code review
*(Jeg fikk tilbakemeldinger på hvordan JFramet må blir utformet fra et spillobjekt og at ikke fra JPanelene.
 Dessuten hvordan man jobber strukturert og setter mål)*

## Annet
*(Begynt på noe annet en GUIen som jeg brukte lang tid på men ikke fikk brukt. Jeg burde også skrevet tester for hver metode jeg lager istedenfor å skrive de etter en klasse er ferdig implementert.)*
