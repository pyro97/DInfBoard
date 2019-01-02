CREATE TABLE Preferenze(
    ID_Preferenza int PRIMARY KEY,
    Nome_Preferenza varchar(25)
);

CREATE TABLE Studenti (
    Username varchar(25) PRIMARY KEY,
    Password varchar(50) NOT NULL,
    Valutazione int DEFAULT 0,
    Nome varchar(25) NOT NULL,
    Cognome varchar(25) NOT NULL,
    Email varchar(50)  NOT NULL,
    isAdmin Boolean,
    isSospeso Boolean,
    Preferenza int,
    FOREIGN KEY (Preferenza) REFERENCES Preferenze(ID_Preferenza) 
);

CREATE TABLE Annunci (
    ID int PRIMARY KEY AUTO_INCREMENT,
    Titolo varchar(25) NOT NULL,
    Descrizione varchar(555) NOT NULL,
    Immagine varchar(555),
    Partecipanti int NOT NULL,
    Preferenza int NOT NULL,
    isVisible boolean NOT NULL DEFAULT TRUE,
    FOREIGN KEY (Preferenza) REFERENCES Preferenze(ID_Preferenza)
);

CREATE TABLE Partecipazione (
    Username_Studente VARCHAR(25),
    ID_Annuncio int,
    PRIMARY KEY (Username_Studente,ID_Annuncio),
    FOREIGN KEY (Username_Studente) REFERENCES Studenti(Username) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ID_Annuncio) REFERENCES Annunci(ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Organizzazione (
    Username_Studente VARCHAR(25),
    ID_Annuncio int,
    PRIMARY KEY (Username_Studente,ID_Annuncio),
    FOREIGN KEY (Username_Studente) REFERENCES Studenti(Username) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ID_Annuncio) REFERENCES Annunci(ID) ON DELETE CASCADE ON UPDATE CASCADE
);
