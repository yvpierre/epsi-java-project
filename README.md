# epsi-java-project

Pierre Yvenou
Pablo Foucher
Abdel Maha

# hooks présents dans le projet
- Commit : 
  - On affiche le message du commit
  - On affiche le nombre de caractères
- Pre-push : 
  - IMPORTANT, il faut renseigner nom identifiant Github dans le fichier .git/hooks/PrePush.java
  - On vérifie donc si le push est demandé par ce même utilisateur, si oui, on accepte le push et on envoie une notification dans le terminal