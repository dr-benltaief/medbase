#Contribuer au projet MedBase

Vous êtes à la recherche de comment contribuer au projet MedBase? Voici comment vous pouvez aider.

Veuillez je vous prie prendre un moment pour lire ce document afin de rendre le processus de contribution aussi facile et efficace pour chaque participant à ce projet.

## Utilisation du système de suivi des problèmes

Le [système de suivi des problèmes](https://github.com/dr-benltaief/medbase/issues) (ou [issue tracker](https://github.com/dr-benltaief/medbase/issues)) est la voie préférée pour la rédaction de rapport de bugs, la demande de nouvelles fonctionnalités ou encore pour proposer votre contribution (envoi de pull requests).

## Envoi de pull requests

* Pour commencer créez un fork de ce dépôt en cliquant tout simplement sur [ce lien](https://github.com/dr-benltaief/medbase/fork) (ou bien celui en haut de cette page) puis clonez votre fork du dépôt:

    * via https:

    ```bash
    git clone https://github.com/[votre pseudo git]/medbase
    ```

    * ou si vous utilisez l'authentification en deux étapes de GitHub via ssh:

    ```bash
    git clone git@github.com:[votre pseudo git]/medbase.git
    ```

* Assignez le dépôt d'origine à un *remote* appelé *upstream*:

    ```bash
    git remote add upstream https://github.com/dr-benltaief/medbase.git
    ```

* Si vous avez cloné depuis un bout de temps mettez-à-jour votre copie locale depuis *upstream*:

    ```bash
    git checkout master
    git pull upstream master
    ```

* Créez une nouvelle branche pour contenir vos changements:

    ```bash
    git checkout -b [le nom de votre branche]
    ```

* Faîtes vos changements puis faîtes un push depuis votre branche vers votre fork:

    ```bash
    git push origin [le nom de votre branche]
    ```

* [Ouvrez un pull request](https://help.github.com/articles/using-pull-requests/) avec un nom et une description clairs dans le dépôt d'origine.

* Après que votre branche ait été acceptée:

    * Supprimez la branche nouvellement créée localement:

        ```bash
        git branch -d [le nom de votre branche]
        ```

        Et depuis votre fork:

        ```bash
        git push origin --delete [le nom de votre branche]
        ```

    * Mettez à jour votre copie locale:

        ```bash
        git pull upstream master
        ```

    * Puis faîtes un push vers votre fork:

        ```bash
        git push origin
        ```

## À propos du fichier *.gitignore*

Par souci d'organisation du code le fichier `.gitignore` a été écrit tel que ne soient gardés dans ce dépôt que les fichiers sources strictement nécessaires.

Voici l'architecture actuelle reflétée par le fichier `.gitignore`:
<a name="arch"></a>

```
medbase/
├── .gitignore
├── README.md
├── CONTRIBUTING.md
├── LICENSE
├── package.json
├── .bowerrc
├── bower.json
├── Gruntfile.js
├── base/
│   └── .gitkeep
├── inc/
│   ├── index.html
│   ├── css/
│   │   └── style.css
│   ├── js/
│   │   └── app.js
│   └── tpls/
│       ├── search.html
│       └── file.html
├── qt/
│   ├── medbase.pro
│   ├── medbase.cpp
│   ├── medbase.qrc
│   ├── linux/
│   │   ├ medbase.png
│   │   └ medbase.desktop
│   ├── macx/
│   │   └ medbase.icns
│   └── windows/
│       ├ windows.rc
│       ├ medbase16x16.ico
│       ├ medbase32x32.ico
│       ├ medbase48x48.ico
│       └ medbase256x256.ico
└── android/
    └── medbase
        ├── build.gradle
        └── src/
            └── main/
                ├── AndroidManifest.xml
                ├── java/
                │   └── tn/
                │       └── freemed/
                │           └── medbase/
                │               ├── MedBaseActivity.java
                │               └── MedBaseHelper.java
                └── res/
                    ├── drawable-hdpi/
                    │   └── ic_launcher.png
                    ├── drawable-mdpi/
                    │   └── ic_launcher.png
                    ├── drawable-xhdpi/
                    │   └── ic_launcher.png
                    ├── drawable-xxhdpi/
                    │   └── ic_launcher.png
                    ├── layout/
                    │   └── medbase.xml
                    └── values/
                        └── strings.xml
```

> Après avoir exécuté *npm*, *bower*, *grunt*, *qmake*, *make* ou encore  *Android Studio* ou *gradle* des tâches sont exécutées afin d'installer les différentes dépendances, arranger certains fichiers et dossiers et compiler l'application finale. Si lors de votre contribution vous ajoutez un fichier pensez à modifier le fichier `.gitignore` afin qu'il ne soit pas ignoré.

## License

En contribuant par votre code, vous acceptez de diffuser votre contribution sous la license [GNU GPL version 3](LICENSE).