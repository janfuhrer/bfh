# bfh-page-rank

## Task a

*Create a simple representation in code of a Directed Graph with weighted nodes.*

See [directed-graph-java](directed-graph-java/src/main/java/)

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

**Random Surfer Model**

Für die Berechnung der Gewichtung wird das sogenannten "Random Surfer Model" verwendet. Dabei beginnt der Surfer auf irgendeiner Webseite und gelangt über die Links auf eine andere Seite. Nach einer gewissen Zeit wird der Weg abgebrochen und neu begonnen. 
Berechnet wird anschliessend die Wahrscheinlichkeit, dass man auf eine Webseite stösst, wenn man sich zufällig durchs Web "klickt".

### Implementation

See [pageRank-java](pageRank-java/src/main/java/)

## Task c

*Apply your algorithm to a real world example, not being websites.*

tbd