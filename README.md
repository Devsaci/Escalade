******************PROJET ESCALADE******************

Ce projet est un site d'Escalalade avec différentes
fonctionalités:
* Site responsive permettant la lecture sur différents
support via navigateur.
* Informations sur le contenu stockées et accessible via 
une Bdd Mysql.
*Barre de recherche Multi-critères.
*Système de gestion de prêt Topo.
*Commentaires des utilisateurs pour le contenu.

Les technologies utilisé sont basés sur l'ecosystème
SPRING. Le projet est un projet Spring BOOT utilisant 
Spring Data (JPA, Hibernate) pour l'accès en base, et
Spring SECURITY pour la connexion. La vue repose sur 
le moteur de Template Thymeleaf.

Lien vers le github du projet :
https://github.com/Moorgtat/Escalade

************INSTALLATION VIA HIBERNATE:************

Réaliser un gitclone du projet dans votre repertoire 
de travail. L'importer dans IntelliJ Idea.

Allez dans le fichier application.properties , dans 
la ligne "spring.jpa.hibernate.ddl-auto=update" ,
passez la configuration en mode "create".

Creer une bdd vie un editeur Sql, puis dans le fichier
application.properties :
"spring.datasource.url=" entrez le lien vers votre BDD
"spring.datasource.username=" Votre username
"spring.datasource.password=" Votre Mot de passe

Enfin se rendre dans EscaladeApplication, décommentez tous
ce qui est en commentaire et lancer l'application.

Remettre en commentaire ce que vous avez décommenter dans
EscaladeApplication.
 
Repassez la configuration "spring.jpa.hibernate.ddl-auto=
create" en mode "update" dans le fichier 
application.properties.

Vous pouvez lancer l'appli, elle sera opérationnel et
peuplée.

************INSTALLATION VIA SCRIPT SQL :************

Réaliser un gitclone du projet dans votre repertoire 
de travail. L'importer dans IntelliJ Idea.

Executer le script SQL fourni vie un editeur SQL. La
BDD est créée ainsi que les tables du projet.

Modifier le fichier application .properties :
"spring.datasource.url=" entrez le lien vers la BDD créée
"spring.datasource.username=" Votre username
"spring.datasource.password=" Votre Mot de passe

Et lancer l'appli.

NOTE IMPORTANTE CONNEXION :

Nom d'utilisateur admin : Jimbo mdp: 1111
Nom d'utilisateur lamba : Elorna mdp: 1112

Pour se connecter avec d'autres utilisateur se 
référer à la table "user" dans la Bdd.

************************CREDITS :************************

Auteur: Mathieu Le Cardinal dans le cadre de sa formation
developpeur JAVA chez OpenClassroom.





 