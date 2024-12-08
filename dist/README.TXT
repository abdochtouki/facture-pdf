========================
DESCRIPTION DE LA SORTIE DE CONSTRUCTION
Lorsque vous construisez un projet d'application Java qui possède une classe principale,
l'IDE copie automatiquement tous les fichiers JAR présents dans le classpath du projet
dans le dossier dist/lib de votre projet. L'IDE ajoute également chacun des fichiers JAR
à l'élément Class-Path du fichier manifeste JAR de l'application (MANIFEST.MF).

Pour exécuter le projet depuis la ligne de commande, allez dans le dossier dist et tapez la commande suivante :

java -jar "PdfTest.jar"
Pour distribuer ce projet, compressez le dossier dist (y compris le dossier lib) et distribuez le fichier ZIP.

Remarques :

Si deux fichiers JAR du classpath du projet ont le même nom, seul le premier fichier
JAR est copié dans le dossier lib.
Seuls les fichiers JAR sont copiés dans le dossier lib.
Si le classpath contient d'autres types de fichiers ou dossiers, ces fichiers (ou dossiers) ne sont pas copiés.
Si une bibliothèque du classpath du projet possède également un élément Class-Path spécifié dans son manifeste,
le contenu de l'élément Class-Path doit être présent dans le chemin d'exécution du projet.
Pour définir une classe principale dans un projet Java standard, faites
un clic droit sur le nœud du projet dans la fenêtre Projets et choisissez Propriétés.
Ensuite, cliquez sur Exécution et entrez le nom de la classe dans le champ Classe principale.
Alternativement, vous pouvez taper manuellement le nom de la classe dans
l'élément Main-Class du manifeste.