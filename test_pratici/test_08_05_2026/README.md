## Sistema Gestione Ticket

Applicazione console in Java per la gestione di ticket di richiesta.

### Avvio

Compilare:

```powershell
javac -d bin (Get-ChildItem -Recurse -Filter *.java -Path src,test).FullName
```

Eseguire l'app:

```powershell
java -cp bin App
```

Eseguire i test:

```powershell
java -cp bin TestRunner
```

### Utenti iniziali

- User: `mario`, `luigi`
- Admin: `anna`, `rossi`
