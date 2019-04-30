Projet 6 : OC Escalade

Mon site d'Escalade OC Escalade . Lien vers le github du projet :
https://github.com/Moorgtat/Escalade

#Features
* Site Web Responsive
* Connexion Utilisateur Sécurisé
* Barre de recherche Multi-critères
* Création de contenu Site/Secteur/Voie/Topo
* Système de gestion de prêt
* Système de Commentaires Utilisateurs

#Technologies
Les technologies utilisé pour ce projet sont basés sur 
l'ecosystème SPRING. 

* Spring BOOT
* Spring MVC
* Spring DATA/JPA/HIBERNATE
* Spring SECURITY
* Thymeleaf
* Bootstrap
* Html 5 
* CSS 3

#Installation

Réaliser un gitclone du projet dans votre repertoire 
de travail. L'importer dans IntelliJ Idea.

Allez dans le fichier application.properties , dans 
la ligne "spring.jpa.hibernate.ddl-auto=update" ,
passez la configuration en mode "create".

Creer une bdd via un editeur Sql, puis dans le fichier
application.properties :
"spring.datasource.url=" -> entrez le lien vers votre BDD
"spring.datasource.username=" -> Votre username
"spring.datasource.password=" -> Votre Mot de passe

Enfin se rendre dans EscaladeApplication, décommentez tous
ce qui est en commentaire et lancer l'application.

Remettre en commentaire ce que vous avez décommenter dans
EscaladeApplication.
 
Repassez la configuration "spring.jpa.hibernate.ddl-auto=
create" en mode "update" dans le fichier 
application.properties.

Vous pouvez lancer l'appli, la Bdd est opérationel.


#Auteur
Mathieu Le Cardinal dans le cadre de sa formation Développeur 
JAVA chez OpenClassroom.