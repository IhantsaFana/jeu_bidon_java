Énigme des Bidons
Ce projet est une implémentation en Java d'une célèbre énigme mathématique : obtenir un volume d'eau précis (par exemple, 4L) en utilisant des bidons de capacités fixes (3L et 5L) et une source d'eau inépuisable. Les actions possibles incluent remplir un bidon, le vider, ou transvaser de l'eau d'un bidon à un autre, avec la possibilité d'annuler les actions. Le programme utilise le pattern Command pour structurer les actions et gérer les annulations.
Fonctionnalités

Simulation interactive de l'énigme des bidons.
Supporte deux bidons (3L et 5L) pour atteindre un objectif de 4L (configurable).
Actions : remplir un bidon, vider un bidon, transvaser l'eau entre bidons.
Annulation de la dernière action effectuée.
Affichage de l'historique des actions réussies une fois l'objectif atteint.

Prérequis

Java Development Kit (JDK) 8 ou supérieur.
Un terminal ou un IDE (ex. : Eclipse, IntelliJ IDEA) pour compiler et exécuter le programme.

Installation

Clonez ce dépôt sur votre machine :git clone https://github.com/votre-utilisateur/enigme-des-bidons.git


Accédez au dossier du projet :cd enigme-des-bidons


Assurez-vous que les fichiers sources sont dans le dossier src/water.

Exécution

Compilez les fichiers Java :javac src/water/*.java


Exécutez le programme principal :java -cp src water.JeuBidons


Suivez les instructions à l'écran pour jouer.

Comment jouer

Objectif : Obtenir exactement 4L d'eau dans l'un des bidons (3L ou 5L).
Actions disponibles :
Remplir le bidon de 3L.
Remplir le bidon de 5L.
Vider le bidon de 3L.
Vider le bidon de 5L.
Transvaser du bidon de 3L vers le bidon de 5L.
Transvaser du bidon de 5L vers le bidon de 3L.
Annuler la dernière action.


Instructions :
À chaque tour, l'état des bidons est affiché (ex. : "Bidon de 5L contenant 2L d'eau").
Entrez un numéro (1 à 7) pour choisir une action.
Continuez jusqu'à atteindre 4L dans un bidon.
Une fois l'objectif atteint, le programme affiche la séquence des actions effectuées (sans les annulations).



Exemple de solution :

Remplir le bidon de 5L (5L, 0L).
Transvaser du bidon de 5L au bidon de 3L (2L, 3L).
Vider le bidon de 3L (2L, 0L).
Transvaser du bidon de 5L au bidon de 3L (0L, 2L).
Remplir le bidon de 5L (5L, 2L).
Transvaser du bidon de 5L au bidon de 3L (4L, 3L).

Structure du code
Le projet utilise le pattern Command (inspiré de Design Patterns, pages 139-145) pour encapsuler les actions comme des objets, permettant leur exécution et annulation.
Classes principales

Bidon : Représente un bidon avec une capacité maximale et un volume d'eau actuel. Méthodes : remplir(), vider(), transvaser().
Commande : Interface avec executer() et annuler().
RemplirBidonCommande, ViderBidonCommande, TransvaserBidonCommande : Commandes concrètes pour chaque action, stockant l'état pour l'annulation.
GestionnaireCommandes : Stocke l'historique des commandes, exécute les nouvelles commandes, et annule la dernière.
JeuBidons : Classe principale, gère l'interaction avec l'utilisateur et configure le jeu.

Structure des dossiers
enigme-des-bidons/
├── src/
│   └── water/
│       ├── Bidon.java
│       ├── Commande.java
│       ├── RemplirBidonCommande.java
│       ├── ViderBidonCommande.java
│       ├── TransvaserBidonCommande.java
│       ├── GestionnaireCommandes.java
│       └── JeuBidons.java
└── README.md

Pattern Command
Le pattern Command est utilisé pour :

Encapsuler chaque action (remplir, vider, transvaser) dans un objet Commande.
Découpler l'interface utilisateur (JeuBidons) des actions sur les bidons.
Permettre l'annulation en restaurant l'état précédent des bidons.
Journaliser les actions pour afficher la séquence finale.

Contributions
Les contributions sont les bienvenues ! Si vous souhaitez ajouter des fonctionnalités (ex. : support de plus de bidons, interface graphique), ouvrez une issue ou soumettez une pull request.
Licence
Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails (à créer si nécessaire).

Développé pour pratiquer le pattern Command et résoudre l'énigme des bidons.
