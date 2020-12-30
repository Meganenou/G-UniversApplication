# Projet 4A - Application mobile : G-Univers
## Étudiante : _MOORGHEN Mégane_
Découvrez l'_univers_ de différents jeux et admirez les nombreux paysages qu'ils peuvent offrir.

Ce projet utilise l'ensemble des notions vues en cours dans l'enseignement de la Programmation Mobile.
## Table des matières
* Liens GitHub
* Logiciels
* Consignes respectées
* Fonctionnalités
* Sources
## Liens Github
* Code : https://github.com/Meganenou/G-UniversApplication/tree/master/app
* API : https://github.com/Meganenou/G-UniversApplication/blob/master/gameAPI.json
## Logiciels
* <img src="https://user-images.githubusercontent.com/63911484/81506037-01e9da80-92f4-11ea-9fb5-2b05f7160a78.png" width="60" height="60">Android Studio

* <img src="https://user-images.githubusercontent.com/63911484/81506048-14fcaa80-92f4-11ea-83a5-efeee856df6b.png" width="60" height="60">Paint Tool SAI

## Consignes respectées
* Apprentissage du langage Kotlin
* Écran avec une liste d'éléments dans une RecyclerView
* Écran avec le détail d'un élément
* Appel WebService à une API Rest
* Mise en place d’une BDD avec Room
* Architecture : MVVM, Clean Architecture
* Design : Material Design (Android Studio), Paint Tool SAI, Pinterest
## Fonctionnalités
### Écran d'acceuil
Application développée en Kotlin
* _Login_ : champ de texte qui permet d'entrer un email.
* _Password_ : champ de texte qui permet d'entrer un mot de passe.
* _Sign in_ : bouton qui permet d'accéder à l'écran suivant après avoir saisi les deux champs précédents.
* _Sign in_ : bouton qui permet d'accéder à l'écran de création de compte.

<p align="center">
<img src="https://user-images.githubusercontent.com/63911484/103382256-9f498700-4aee-11eb-8768-4f42f45099b5.jpeg" width="270" height="480"">
</p>
                                                                                                                                       
### Écran de la liste des régions
Les régions du Monde Pokémon sont répertoriées.
* Utilisation de la `RecyclerView` et de l'[API Pokémon](https://github.com/Meganenou/MyFirstApplication/blob/master/MyAPI_pokemon.json).

<img src="https://user-images.githubusercontent.com/63911484/81502696-aca3ce00-92df-11ea-8261-cf760377a36e.png" width="270" height="480"> ![alt-text](https://media.giphy.com/media/lqGVHIODa5KYbe4Tuf/giphy.gif)

### Écran détail de la région
Description de la région et découverte de l'_Histoire_.

Pokémons Légendaires et Fabuleux associés à la région.
* Utilisation de l'[API Pokémon](https://github.com/Meganenou/MyFirstApplication/blob/master/MyAPI_pokemon.json) et de la `ScrollView`.

<img src="https://user-images.githubusercontent.com/63911484/81504221-47a0a600-92e8-11ea-9586-850ffd0c32b8.png" width="270" height="480"> ![alt-text](https://user-images.githubusercontent.com/63911484/81509451-19808d80-930b-11ea-903a-9e2dc70603f5.gif)

### Design & Création
* Logo

Arbore une forme de PokéBall dorée avec une esquisse de [Mew](https://www.pokepedia.fr/Mew) sous sa forme [Antique](https://www.pokepedia.fr/Mew_Antique_(Promo)).

<p align="center">
  <img src="https://user-images.githubusercontent.com/63911484/81501916-271e1f00-92db-11ea-9298-243f6d7047dc.png" width="150" height="150">
</p>

* Titre

Se trouve sur la première page.

<img src="https://user-images.githubusercontent.com/63911484/81504522-16c17080-92ea-11ea-8484-ab9c26f7ad3c.png" width="300" height="200">

* Bouton

Permet d'aller à la seconde page.

<img src="https://user-images.githubusercontent.com/63911484/81504474-bb8f7e00-92e9-11ea-905f-792fe7c74637.png" width="300" height="200">

* Quelques images des Pokémons Légendaires & Fabuleux :

**Image 1 :** _[Zekrom](https://www.pokepedia.fr/Zekrom) & [Reshiram](https://www.pokepedia.fr/Reshiram)_, _[Kuyrem Blanc](https://www.pokepedia.fr/Kyurem_Blanc) & [Kuyrem Noir](https://www.pokepedia.fr/Kyurem_Noir)_, _[Kuyrem](https://www.pokepedia.fr/Kyurem)_.

**Image 2 :** _[Silvallié](https://www.pokepedia.fr/Silvalli%C3%A9)_,  _[Divinités gardiennes d'Alola](https://www.pokepedia.fr/Divinit%C3%A9s_gardiennes_d%27Alola)_,  _[Zeraora](https://www.pokepedia.fr/Zeraora)_,  _[Magearna](https://www.pokepedia.fr/Magearna)_.

**Image 3 :** _[Xerneas](https://www.pokepedia.fr/Xerneas) & [Yveltal](https://www.pokepedia.fr/Yveltal) & [Zygarde](https://www.pokepedia.fr/Zygarde)_.

<img src="https://user-images.githubusercontent.com/63911484/81504745-4d4bbb00-92eb-11ea-8992-109a5f7c0129.png" width="270" height="480"> <img src="https://user-images.githubusercontent.com/63911484/81504769-6c4a4d00-92eb-11ea-850f-2a258f4a463a.png" width="270" height="480"> <img src="https://user-images.githubusercontent.com/63911484/81504792-8ab04880-92eb-11ea-9816-625878ca1564.png" width="270" height="480">


### Sources
<img src="https://user-images.githubusercontent.com/63911484/81506030-f7c7dc00-92f3-11ea-928e-77ff29f106e1.png" width="90" height="90"> Toutes les images proviennent de _[Pinterest](https://www.pinterest.fr/)_.

**Les informations ont été récupérées sur:**
* <img src="https://user-images.githubusercontent.com/63911484/81505968-84be6580-92f3-11ea-89ba-1681a1c5260a.png" width="100" height="110"> _[Poképédia](https://www.pokepedia.fr/Portail:Accueil)_, wiképédia version Pokémon.
* <img src="https://user-images.githubusercontent.com/63911484/81506297-9bfe5280-92f5-11ea-9023-0bace235feeb.png" width="110" height="90">_[Pokébip](https://www.pokebip.com/)_, site sur lequel on trouve toutes l'actualité Pokémon.
