
# Personal Ledger
Il nostro progetto **Personal Ledger** prevede la creazione di una _web application_ per il rendiconto delle entrate e delle uscite di ogni utente.
L’utente finale potrà registrarsi (o fare il login) tramite una _pagina web_, per poi interagire con un suo bilancio personale contenente entrate e uscite. 
Tramite una _form_ l’utente potrà inserire nuovi movimenti all’interno del suo bilancio personale.
I dati relativi ai singoli movimenti e al login verranno infine salvati in un _database_.

## Pattern Utilizzati
Scelta dei pattern utilizzati all'interno del progetto.

### Pattern Façade
Consente l’utilizzo di una singola interfaccia per l’accesso a sottosistemi comprendenti interfacce complesse e diverse tra loro. Il **Pattern Façade** verrà applicato nel caso del _login_, tramite un’unica interfaccia che si occuperà di _connessione al DB, controllo credenziali, generazione cookie di sessione e caricamento dei dati_.

### ~~Pattern Command~~
Durante lo sviluppo del progetto ci siamo accorti che l'utilizzo del Pattern Command non era ideale, e un'implementazione forzata avrebbe solamente portato all'aggiunta di codice e complicazioni inutili.

### Data Access Object (DAO) Pattern
Dato l'utilizzo di Hibernate per la comunicazione con il database contenente i dati relativi alle transazioni di ogni utente, abbiamo scelto il DAO Pattern per separare la comunicazione con il database tramite linguaggio per Query dal codice java, tramite l'utilizzo dell'API delle classi TransactionDAO e UserDAO.

