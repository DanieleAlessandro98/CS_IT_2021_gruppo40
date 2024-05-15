## Progetto RadioPort

### Descrizione
RadioPort è un'applicazione progettata per consentire ai dipendenti di un'azienda di vendere radio portatili. Ogni vendita viene registrata insieme a informazioni dettagliate sulla radio venduta, la data di vendita, il prezzo di vendita e il dipendente responsabile della vendita.

### Design pattern utilizzati
- **Model View Controller (MVC)**
- **Observer pattern**
- **Data Access Object (DAO)**
- **Factory method**

### Caratteristiche Principali
- Registrazione delle vendite con dettagli completi sulle radio vendute.
- Limiti di vendita per dipendente: ogni dipendente può vendere un numero massimo di radio, specificato per semestre.
- Interfacce per l'acquisizione, la visualizzazione e la modifica dei dati.
- Persistenza dei dati su file system.

### Entità Coinvolte
- **Vendita**: contiene informazioni dettagliate su ogni vendita, inclusi dati sulla radio venduta, la data, il prezzo e il dipendente responsabile.
- **Dipendente**: ogni dipendente ha limiti di vendita stabiliti e è responsabile delle vendite effettuate.
- **Radio**: le radio vendute hanno attributi specifici come dimensioni, colore, opzionali, antenna, ecc.

### Tecnologie Utilizzate
- **Framework**: Java Spring
- **Design Pattern**: Model-view-controller (MVC), Observer pattern, Data Access Object (DAO), Factory method

### Dati di accesso
- username: admin
- password: 12345

### Requisiti del Progetto
- JavaSE-1.8
- Mysql
- Dati per l'accesso al database localizzati in:  DBConnection.java
