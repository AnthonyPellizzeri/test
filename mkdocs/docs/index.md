
![](images/logo-Univ.png)
# Documentation TP1

Ce TP à été réalisé en Master 1 MIAGE Nancy lors du cours Programmation avancée Orienté Objet.
Cela a pour but de prendre en main:  

- l'outil de gestion et d'automatisation: MAVEN 
- le framework orienté interface utilisateur: JavaFX

## Que fait ce programme
### Description
Le but de cette applicatione est d’établir des indicateurs de participation en ligne des apprenants inscrits à un cours.
Pour cela nous avons recuperé les logs de la plateforme web d’apprentissage.

A partir d'une date de début et de fin, il va calculer et afficher le nombre d'actions, de sessions et la durée de ces sessions, pour chaque étudiant.

Si une periode se coupe en plein milieu d'une session, la durée totale de la session sera quand même comptabilisée.

Une interface JavaFX est présente pour une meilleure lisibilité.
De plus, il est possible de trier en fonction de chacun des colonnes du tableau

### API Tiers
L'application utilise les API Apache suivantes : 

- Apache Commons CLI 
- Apache Commons CSV.

### Licence
gratuite

### Auteurs
Anthony PELLIZZERI - étudiant MIAGE M1 Nancy
