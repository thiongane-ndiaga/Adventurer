# Description
Un héros s'aventurait dans un monde dangereux, 
Frayant son passage dans les bois obscurs.
Il s'agit de modéliser les déplacements d'un personnage sur une carte.
L'application a été codée en sur la JVM 1.8

## 1. Conception objet

   ### Packages:
   - com.cirilgroup.adventurer : contient la classe d'application principale
   - com.cirilgroup.adventurer.world : contient les classes représentant les objets du jeu (héro, carte, position)
   - com.cirilgroup.adventurer.utils : contient les classes utilitaires
   - com.cirilgroup.adventurer.exceptions : contient les classes d'exception propres au programme
   
   ### Classes:
   - Map : Représente la carte du monde avec ses cases et ses obstacles (bois impénétrables).
   - Hero : Décrit le personnage avec ses coordonnées et ses déplacements.
   - Position : Modélise un la position personnage

   ### Diagrammes de classe:
    * Map :
      - cells : char[][]
      - width: int
      - height: int
    * Position :
      - x : int
      - y : int
    * Hero :
      - initialPosition : Position
      - finalPosition : Position
      - movements : String
        
## 2. Qualité de nommage
   - Les noms de classes, attributs et méthodes sont explicites et décrivent clairement leur rôle.
   - Les noms respectent les conventions Java (camelCase).

## 3. Qualité et concision de la documentation
   - Javadoc est utilisée pour documenter les classes, attributs et méthodes.
   - La documentation est concise et informative.

## 4. Tests
   - Un ensemble de tests unitaires est implémenté pour chaque classe.
   - Les tests couvrent différents cas de figure et scénarios d'utilisation.

# Déroulement du programme
Au lancement du programme, on a deux possibilités :
- fournir le nom du fichier pour la carte et/ou le héro; dans ce cas faudra mettre les fichiers dans le répertoire `src/main/resources` du projet
- laisser le programme continuer avec les fichiers par défaut

# Images du jeu
- Lancement du jeu, on voit qu'il y a une description des évenements lors du parcours du héro
  ![image](https://github.com/thiongane-ndiaga/Adventurer/assets/60078429/443ea05b-7072-4478-bc2f-8e33f3474c7e)

- (suite) Modélisation des déplacements du héro sur la carte
  ![image](https://github.com/thiongane-ndiaga/Adventurer/assets/60078429/c46e4e4c-384b-41f9-952e-118d503591e4)
  ### Légende:
  - \# : bois impénétrables
  - \* : position initiale du héro
  - \+ : déplacements du héro

