# Projet test

## La carte au trésors (étapes du programme)
#Lire le fichier d’entrée

Le programme doit être capable de lire le fichier d’entrée de l’exercice.

Note : une ligne débutant par un ‘#’ est un commentaire et doit être ignorée.
Exemple :

C - 3 - 4

M - 1 - 0

M - 2 - 1

T - 0 - 3 - 2

T - 1 - 3 - 3

A - Lara - 1 - 1 - S - AADADAGGA
Que l’on peut représenter sous la forme suivante :
. M .
. A (Lara) M
. . .
T(2) T(3) .
#Simuler les mouvements des aventuriers
Le programme doit être capable d’exécuter les mouvements des différents aventuriers en respectant
les contraintes de l’exercice, de gérer la collecte des trésors et de restituer le résultat final de la
simulation.
Dans l’exemple précédent, Lara collecte 3 trésors et finit son parcours en (0 - 3).
Ecrire le fichier de sortie
Le programme doit être capable d’écrire un fichier contenant le résultat final de la simulation.
Note : une ligne débutant par un ‘#’ est un commentaire et doit être ignorée.
#Voici le format de sortie :
C - 3 - 4
M - 1 - 0
M - 2 - 1
{T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors
restants}
T - 1 - 3 - 2
{A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe
vertical} - {Orientation} - {Nb. trésors ramassés}
A - Lara - 0 - 3 - S - 3
#Que l’on peut représenter sous la forme suivante :
. M .
. . M
. . .
A (Lara) T(2) .

## Environnement de développement

L'application java est packagée par le fichier pom.xml. Vous pouvez installer le programme grâce à maven ou dans votre IDE
*   `mvn clean install` : Génération du war


## Contributeurs
 
Maximilien LeBoiteux alias ToySuRusse : https://github.com/Toysurusse
 
Ce projet est libre de droit et disponible gratuitement : https://github.com/Toysurusse/Project-6/
 
## License
 
 This project is open source
 
