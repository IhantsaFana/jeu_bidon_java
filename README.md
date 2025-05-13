# Énigme des Bidons

**Un casse-tête classique... codé en Java.**

Ce projet est une implémentation interactive en Java de l’énigme bien connue des bidons : comment mesurer exactement **4 litres d’eau** à partir d’un **bidon de 3L** et un **bidon de 5L**, avec une source d’eau illimitée ?  
Grâce au **pattern Command**, chaque action devient un objet que l’on peut exécuter, annuler… et combiner pour résoudre le puzzle.

---

## Fonctionnalités

- **Simulation interactive** de l’énigme des bidons
- **Objectif configurable** (par défaut : 4L)
- Actions disponibles :
  - Remplir un bidon
  - Vider un bidon
  - Transvaser de l’eau d’un bidon à l’autre
  - **Annuler la dernière action**
- Affichage de l’**historique des actions réussies** à la fin du jeu

---

## Prérequis

- Java JDK **8 ou supérieur**
- Un terminal ou un IDE (Eclipse, IntelliJ IDEA, VS Code…)

---

## Installation

```bash
# Clonez le dépôt
git clone https://github.com/votre-utilisateur/enigme-des-bidons.git

# Accédez au dossier
cd enigme-des-bidons

# Assurez-vous que les fichiers sources sont dans src/water
```

---

Exécution

# Compilez les sources
```bash
javac src/water/*.java
```

# Lancez le programme principal
```bash
java -cp src water.JeuBidons
```

Suivez les instructions à l’écran pour interagir avec les bidons.


---

Comment jouer

Objectif : obtenir exactement 4L dans un des deux bidons.

Actions disponibles :

1. Remplir le bidon de 3L


2. Remplir le bidon de 5L


3. Vider le bidon de 3L


4. Vider le bidon de 5L


5. Transvaser 3L → 5L


6. Transvaser 5L → 3L


7. Annuler la dernière action



L’état des bidons est affiché à chaque tour (ex. : Bidon 5L : 2L | Bidon 3L : 0L).
Tapez un chiffre pour choisir votre action, jusqu’à atteindre l’objectif.


---

Exemple de solution

1. Remplir le bidon de 5L        → (5L, 0L)
2. Transvaser 5L → 3L            → (2L, 3L)
3. Vider le bidon de 3L          → (2L, 0L)
4. Transvaser 5L → 3L            → (0L, 2L)
5. Remplir le bidon de 5L        → (5L, 2L)
6. Transvaser 5L → 3L            → (4L, 3L) ✅


---

Structure du code

Le projet utilise le pattern Command pour encapsuler les actions comme objets exécutables et annulables.

Principales classes :

Bidon : représente un bidon avec sa capacité et son volume courant.

Commande : interface avec executer() et annuler().

Commandes concrètes :

RemplirBidonCommande

ViderBidonCommande

TransvaserBidonCommande


GestionnaireCommandes : exécute les commandes et gère les annulations.

JeuBidons : point d’entrée principal, gère l’interaction avec l’utilisateur.



---

Structure du projet
```
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
```

---

À propos du Pattern Command

Le pattern Command est utilisé pour :

Encapsuler chaque action (remplir, vider, transvaser)

Découpler la logique de l’interface utilisateur

Permettre l’annulation en restaurant les états précédents

Tracer l’historique des étapes de résolution


Inspiré du livre Design Patterns: Elements of Reusable Object-Oriented Software (pages 139–145).


---

Contributions

Les contributions sont les bienvenues !
Idées d’amélioration :

Support de plusieurs bidons

Interface graphique (Swing, JavaFX ?)

Générateur automatique de solution


Ouvrez une issue ou une pull request pour proposer vos idées.


---

Licence

Ce projet est sous licence MIT.
Voir le fichier LICENSE pour plus d’infos (à créer si besoin).


---

Développé pour pratiquer le pattern Command… et dompter l’eau !
