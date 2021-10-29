# bfh-page-rank

## Task a

*Create a simple representation in code of a Directed Graph with weighted nodes.*

### Implementation

* Vertex: [Class Vertex](page-rank-fuhrj2/src/main/java/Vertex.java)
* Graph: [Class Graph](page-rank-fuhrj2/src/main/java/Graph.java)
* TaskA: [Class TaskA](page-rank-fuhrj2/src/main/java/TaskA.java)

## Task b

*Describe in your own word and implement the algorithm for computing the page rank of a small example graph.*

### PageRank Algorithmus
Der PageRank-Algorithmus wurde von Larry Page und Sergei Brin an der Standford University entwickelt, 1997 wurde dieser patentiert. Der Algorithmus diente als Grundlage der Suchmaschiene Google für die Bewertung und Indexierung der einzelnen Webseiten. Die inhaltliche Qualität einer Webseite spielt jedoch keine Rolle.

**Aufbau**

Jede Webseite stellt einen Knoten mit einem Gewicht (PageRank) in einem *gewichteten Graphen* dar. Das Gewicht einer Seite wird umso grösser, desto mehr Seiten (mit einem möglichst hohem eigenen Gewicht) auf diese Seite verweisen. 
* Grundsätzlich wird somit eine Webseite mit vielen eingehenden Links höher gewichtet als eine mit wenigen. Ausschlaggebend ist jedoch auch das Gewicht der Seite, welche auf eine andere verlinkt. 
* Eine Seite wird besser bewertet, wenn wichtige andere Seiten auf diese verlinken.
* Das eigene Gewicht gibt die Seite anteilsmässig an alle verlinkenden Seiten weiter (Gewicht durch Anzahl ausgehenden Links).
* Der sogenannte Dämpfungsfaktor wurde eingefügt, damit das Gewicht nicht zu Seiten abfliesst, welche auf keine anderen verweisen.

**Algorithmus**

Der PageRank eines Knoten in einem Graph ist wie folgt definiert:

![algo](https://latex.codecogs.com/gif.latex?PR_i&space;=&space;%5Cfrac&space;%7B1-d%7D&space;%7Bn%7D&space;&plus;&space;d&space;%5C,&space;%5Csum_%7Bj&space;=&space;1%7D%5En&space;%5Cfrac&space;%7BPR_j%7D&space;%7Bc_j%7D)

* *n*: Anzahl Knoten im Graph
* *d*: Dämpfungsfaktor
* *PR(i)*: PageRank einer Seite
* *PR(j)*: PageRank der auf i verlinkenden Seiten
* *c(j)*: Anzahl ausgehende Links auf der Seite *j*

**Random Surfer Model**

Ein alternative Interpretation des PageRank-Algorithmus ist das *Random Surfer Model*. In diesem Modell beginnt der Surfer auf irgendeiner Webseite und gelangt über die Links auf eine andere Seite. Nach einer gewissen Zeit wird der Weg abgebrochen und neu begonnen. 
Berechnet wird anschliessend die Wahrscheinlichkeit, dass man auf eine Webseite stösst, wenn man sich zufällig durchs Web "klickt".

### Implementation

* PageRank Algorithmus: [Class PageRank](page-rank-fuhrj2/src/main/java/PageRank.java)
* TaskB: [Class TaskB](page-rank-fuhrj2/src/main/java/TaskB.java)

## Task c

*Apply your algorithm to a real world example, not being websites.*

### Implementation

Für das Beispiel wurden Personen, unterteilt in berühmten Politiker und Freunde gewählt. Der PageRank ermittelt hier die "Bekanntheit" der einzelnen Personen in der gesamten Auswahl an Personen. Je höher der PageRank, desto bekannter ist die Person in der Gruppe.

* TaskC: [Class TaskC](page-rank-fuhrj2/src/main/java/TaskC.java)

## Sources
- https://www.suchmaschinen-doktor.de/algorithmen/pagerank.html
- http://www.javased.com/index.php?source_dir=gs-algo/src/org/graphstream/algorithm/PageRank.java
- https://sebastianviereck.de/pagerank-algorithmus-java/