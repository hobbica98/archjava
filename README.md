# Personal Ledger
Il nostro progetto **Personal Ledger** prevede la creazione di una _web application_ per il rendiconto delle entrate e delle uscite di ogni utente.
L’utente finale potrà registrarsi (o fare il login) tramite una _pagina web_, per poi interagire con un suo bilancio personale contenente entrate e uscite. 
Tramite una _form_ l’utente potrà inserire nuovi movimenti all’interno del suo bilancio personale.
I dati relativi ai singoli movimenti e al login verranno infine salvati in un _database_.

## Pattern Utilizzati
Scelta dei pattern utilizzati all'interno del progetto.

### Pattern Façade
Consente l’utilizzo di una singola interfaccia per l’accesso a sottosistemi comprendenti interfacce complesse e diverse tra loro. Il **Pattern Façade** verrà applicato nel caso del _login_, tramite un’unica interfaccia che si occuperà di _connessione al DB, controllo credenziali, generazione cookie di sessione e caricamento dei dati_.

### Pattern Command
Permette di distaccare il codice che effettua un’azione dal codice che ne richiede l’esecuzione. 
Abbiamo scelto il **Pattern Command** per rendere il codice più comprensibile e migliorarne la facilità d’uso. 
