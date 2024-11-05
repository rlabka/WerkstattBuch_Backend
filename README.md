# WerkstattBuch Backend 

Dieses Projekt ist das Backend für einen Formularservice. Es handelt sich um eine Spring Boot-Anwendung mit einer REST-Schnittstelle, über die Aufträge verwaltet werden können.

## Funktionen

* Erfassen und Speichern von Aufträgen mit Kundendaten, Autoinformationen und Terminen.
* Automatische Vergabe von eindeutigen Auftragsnummern, um jeden Auftrag identifizierbar zu machen.
* Verwendung von MongoDB als Datenbank für die persistente Speicherung der Auftragsdaten.
* Verwaltung von Terminen, die im Zusammenhang mit den Aufträgen stehen.


## Technologien

* **Java:** Die Programmiersprache, in der das Backend entwickelt wurde.
* **Spring Boot:** Framework für die schnelle Entwicklung von Webanwendungen.
* **Spring Data MongoDB:**  Ermöglicht die einfache Integration mit MongoDB.
* **MongoDB:**  NoSQL-Datenbank zur Speicherung der Auftragsdaten.


## Installation und Starten

1. **Klonen des Repositorys:**  `git clone https://github.com/rlabka/WerkstattBuch_Backend.git`
2. **MongoDB konfigurieren:**  Richten Sie eine MongoDB-Instanz ein und passen Sie die Verbindungsdetails in der Datei `application.properties` an.
3. **Anwendung starten:** `mvn spring-boot:run`


## API-Endpunkte

Die REST-Schnittstelle bietet folgende Endpunkte:

* **`POST /auftrag/neu`:**  Erstellt einen neuen Auftrag.
* **`GET /auftrag/all`:**  Liefert eine Liste aller gespeicherten Aufträge.
* **`PUT /auftrag/{auftragsnummer}/status`:** Aktualisiert den Status eines Auftrags.


## Datenbank

Das Backend verwendet MongoDB zur Speicherung der Daten. Stellen Sie sicher, dass eine MongoDB-Instanz läuft und die Verbindungsdaten korrekt konfiguriert sind.

## Kontakt

Bei Fragen oder Problemen können Sie gerne ein Issue in diesem Repository erstellen.
