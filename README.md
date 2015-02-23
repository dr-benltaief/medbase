# MedBase: Application base de données des médicaments en Tunisie

<p align="center"><img src="https://rawgithub.com/dr-benltaief/medbase/master/qt/linux/medbase.png" alt="MedBase: Application base de données des médicaments en Tunisie" title="MedBase: Application base de données des médicaments en Tunisie"/></p>

> Ce projet est en cours de conception **ET N'EST DONC PAS ENCORE OPÉRATIONNEL**; votre [contribution](#contrib) est la bienvenue. :wink:

## À propos de ce projet

Ce projet est une initiative en vue de la création d'une application multiplateforme pour la recherche sur [la base de données des médecaments de la DPM](http://www.dpm.tn/Francais/ind_med.html) en hors ligne.

## <a name="contrib"></a> Contribution au projet

Si vous voulez contribuer à améliorer ce projet veuillez s'il vous plaît lire attentivement [ce guide](CONTRIBUTING.md).

## Compilation de l'application

> Vous devez avoir [Git](http://git-scm.com/downloads), [Node.js](http://nodejs.org), [Bower](http://bower.io) et [Grunt](http://gruntjs.com) pour poursuivre.

Faîtes un clone du dépôt:

    git clone https://github.com/dr-benltaief/medbase

Dirigez vous vers le dossier `medbase` nouvellement créé

    cd medbase

> Vous aurez cette [architecture](CONTRIBUTING.md#arch)

Installez les dépendances Node.js et Bower puis exécutez les tâches Grunt:

    npm install
    bower install
    grunt

> Il s'agit d'une application HTML5 utilisant comme interface le framework CSS [BootStrap](http://getbootstrap.com), le framework Javascript [AngularJS](https://angularjs.org) et selon la plateforme la classe QWebView du framework C++ Qt pour Windows, Mac Os X et Linux et la classe java WebView pour Android.

### Préparation de la base de données

L'application utilise [la base de données des médeciaments de la DPM](http://www.dpm.tn/Francais/ind_med.html) comme source de données; **cette base de données ne sera pas mise sur ce dépôt: vous devez la générer par vous même**. L'application [`getbase`](https://github.com/dr-benltaief/getbase) peut vous aider à cet effet. Mettez le fichier SQLite généré sous le nom `medbase.db` dans le dossier `html`.

### Compilation de l'application Linux/Windows/Mac

> Il s'agit pour Linux, Mac Os X et Windows d'une application Qt écrite en C++ utilisant le module webkitwidgets. Vous devez donc installer [le framework Qt](http://qt-project.org).

Dirigez-vous vers le dossier `qt`:

    cd qt

#### Sous Linux

> Sous Ubuntu 14.04 voici les commandes pouvant aboutir à l'installation de toutes les dépendances pour la compilation de l'application:

>     sudo add-apt-repository ppa:ubuntu-sdk-team/ppa
>     sudo apt-get update
>     sudo apt-get install git ubuntu-sdk
>     curl -sL https://deb.nodesource.com/setup | sudo bash - && sudo apt-get install -y nodejs
>     sudo -H npm install -g bower grunt-cli

Faîtes un `qmake` puis `make` pour compiler l'application:

    qmake
    make

Vous pouvez lancer l'application par:

    ./medbase

Vous pouvez installer l'application sur votre système par un simple:

    make install

ou:

    sudo make install

en fonction des permissions accordées à votre utilisateur et la désinstaller via:

    make uninstall

ou:

    sudo make uninstall

#### Sous Mac

La procédure est comparable:

    qmake
    make

et pour la déployer:

    macdeployqt

#### Sous Windows

Faîtes un `qmake` puis `mingw32-make` pour compiler l'application:

> Si vous avez installé un autre compilateur que MinGW ([MSVC](http://www.visualstudio.com) ou autre) vous devez adapter à votre propre configuration.

    qmake
    mingw32-make

Déployez les dépendances à votre application via:

    windeployqt release

> Vous trouverez l'application compilée avec ses dépendances dans le dossier `release` nouvellement créé.

### Compilation de l'application Android

> Il s'agit pour Android d'une application utilisant la classe WebView.

> Vous devez installer [Android Studio](http://developer.android.com/sdk/index.html) (ou bien [les outils du Sdk Android sans Android Studio](http://developer.android.com/sdk/index.html#Other)).

Ouvrez  le projet `medbase` (qui se trouve dans le dossier `android`) dans Android Studio ou compilez-le directement en ligne de commande via `gradle`.

## License

Ce code est distribué sous la [license GNU GPL version 3](https://github.com/dr-benltaief/medbase/blob/master/LICENSE).

L'icône [Pills red Icon](http://www.iconarchive.com/show/medical-icons-by-medicalwp/Pills-red-icon.html) par [MedicalWP](http://www.iconarchive.com/artist/medicalwp.html) est sous license [CC Attribution 4.0](http://creativecommons.org/licenses/by/4.0/).