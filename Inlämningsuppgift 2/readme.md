# Redovisning

## Tid nedlagt
### Joel: 25 timmar
### Max: 35-40 timmar
### Oskar: 30 timmar


## Några användningsfall
* A1 pekar på A2, och sedan skriver du in A1 i A2. Kasta "circular error" och fyll rutan med det gamla värdet. 
* A1 har värdet 0, och du försöker dividera 5 med A1. Kasta "division by zero error" och behåll gamla värdet.
* Dividera 5++ med 0. Kasta syntax-error och behåll gamla värdet.
* Multiplicera 5 med en kommentar. Evaluera uttrycket till noll.
* Spara en fil utan filändelse. Spara filen med filändelse.

## Frågor
1. Vilka klasser bör finnas för att representera ett kalkylark? 
En klass för att representera en enskild ruta. En klass för att representera många rutor (ett sheet). En klass för varje typ av värde; en text eller ett uttryck.


2. En ruta i kalkylarket skall kunna innehålla en text eller ett uttryck. Hur modellerar man detta?  
Vi har ett interface Cell som implementeras av VariableCell och ValueCell. 


3. Hur skall man hantera uppdragsgivarens krav på minnesresurser?
Spara undan storleken av sheetet, exempelvis 10x10. Spara även undan de minnesceller som har fått ett värde.

4. Vilka klasser skall vara observatörer och vilka skall observeras?
    * Observer: StatusLabel
    * Observable: XLList


5. Vilket paket och vilken klass skall hålla reda på vad som är "Current slot"? Klassen LoadMenuItem i paketet gui.menu ska hålla reda på "Current slot".
GUI, SlotLabels

6. Vilken funktionalitet är redan färdig och hur fungerar den? Titta på klasserna i view-paketet och testkör.
    * Uttryck kan redan evalueras. 
    * Värden kan sparas till rutor. 
    * Värden kan ersättas av rutor. 
    * Nya ark kan öppnas. 
    * Ark kan namnges. 
    * Ark kan skrivas ut.
    * Man kan byta ark.
    * Man kan stänga ark.

7. Det kan inträffa ett antal olika fel när man försöker ändra innehållet i ett kalkylark. Då skall undantag kastas. Var skall dessa undantag fångas och hanteras?
StatusLabel

8. Vilken klass används för att representera en adress i ett uttryck?
String i TestExpr. Vi kommer att använda Cell.

9. När ett uttryck som består av en adress skall beräknas används gränssnittet Environment. Vilken klass skall implementera gränssnittet? Varför använder man inte klassnamnet i stället för gränssnittet?  
För att enkelt kunna byta vilket Environment man vill använda. Klassen CellEnvironment ska implementera det. För att öka flexibilitet.  

10. Om ett uttryck i kalkylarket refererar till sig själv, direkt eller indirekt, så kommer det att bli bekymmer vid beräkningen av uttryckets värde. Föreslå något sätt att upptäcka sådana cirkulära beroenden! Det finns en elegant lösning med hjälp av strategimönstret som du får chansen att upptäcka. Om du inte hittar den så kommer handledaren att avslöja den.  
Att loopa igenom varje Cell och leta efter en referens till den egna cellen och isåfall returnera false. 


## Bilder
### Sheet
![Sheet](uml/Sheet.png)
### Expr
![Expr](uml/Expr.png)
### GUI
![GUI](uml/GUI.png)
### GUI.Menu
![GUI.Menu](uml/GUIMenu.png)
### Util
![Util](uml/Util.png)