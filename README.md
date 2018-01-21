# Übung zu Formularen mit Spring Boot

Starte die Applikation:

    mvn spring-boot:run
    
Du kannst nun die Applikation unter folgender URL aufrufen: http://localhost:8080/employees

Erweitere das Projekt um folgende Fähigkeiten:

- Füge einen neue Methode `saveEmployee` im Controller `EmployeeController` hinzu.
Klickt der Benutzer im Formular http://localhost:8080/employee?id=1 auf den Save-Button, 
  soll die neue Methode den Mitarbeiter speichern.
  - Der neuen Methode soll eine Employee-Entity übergeben werden.
  - Die neue Methode soll den Employee im Repository speichern.
  - Die neue Methode soll zur `employee`-View weiterleiten.
  
- Erweitere das Formular um Validierung.
  - Erweitere die Employee-Entity um die Constraints, dass jeweils der Vor- und Nachname 
  zwischen 2 und 20 Zeichen enthalten dürfen (`@Size`).
  - Erweitere die `saveEmployee`-Methode um die `@Valid`-Annotation, um die Validierung zu aktivieren. 
  Füge zudem das `BindingResult` als Parameter hinzu, mit dessen Hilfe die Methode via `hasErrors` nur 
  gültige Employees im Repository speichern soll.
  - Erweitere das Formular im `employee.html` um die Anweisungen für Thymeleaf, die Validierungsfehler anzuzeigen.

- Erweitere die Message Resource Bundles um eine deutsche Übersetzung.
