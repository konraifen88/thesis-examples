# Thesis Examples

In diesem Projekt befinden sich einige Beispielkonfigurationen zu meiner Abschlussarbeit.
Die Abschlussarbeit kann [hier](https://github.com/konraifen88/thesis) gefunden werden.

Die Services können mithilfe der mitgelieferten [devBox](#devbox) betrieben werden, 
daneben sind allerdings noch Konfigurationen für den Einsatz innerhalb der "Bosch IOT Cloud" verfügbar.

## Starten der Beispielapplikationen

Um diese Applikationen starten zu Nutzen werden folgende Schritte benötigt:

1. Starten von [devBox](/devBox)
1. Erst wenn die devBox vollständig gestartet ist, können die Services gestartet werden!
1. Verbinden zu Gateway mit:

   localhost:8080

## Inhalt dieses Projektes

### devBox

Eine Entwicklungsumgebung für lokales testen von Microservices.

Folgende Services können mithilfe von Vagrant gestartet werden:
    * Oracle DB

Siehe [hier](/devBox) für weitere Informationen und Installationsanweisungen.

### gateway

Eine Applikation unter Einsatz des von Spring Boot mit Einsatz von verschiedenen externen Komponenten.
Durch den Einsatz von Oracle muss allerding noch die 'ojdbc7.jar' selbst bereitgestellt werden. 
Diese ist hierfür innerhalb des 'libs' Verzeichnisses abzulegen.

Verwendete Komponenten:
    * Redis, um Sessions von Spring Security zu speichern.
    * Oracle DB, für die Überprüfung der Userdaten bei Login.
    
Verfügbare Endpunkte: 
    * '/'
    * '/login'
    * Darüber hinaus noch einige welche über '/name/*' erreichbar sind, siehe [nameservice](#nameservice)

### nameservice

Spring Boot Applikation, welche alle Zugriffe auf den Endpunkt '/name/*' des Gateways entgegen nimmt.

Verwendete Externe Komponenten:
    * Redis, um Sessions welche der Gateway erstellt hat abzurufen.
    * RabbitMQ, um Nachrichten zu dem reverse-service zu senden und dessen Antwort wieder zu empfangen.

Verfügbare Endpunkte
    * '/admin', auf welchen nur ein Nutzer der Rolle ADMIN Zugriff hat.
    * '/user', auf welchen Authentifizierte Nutzer Zugriff haben.
    * '/unchecked', auf welchen auch nicht Authentifizierte Nutzer Zugriff haben
    * '/reverse/{string}', zum versenden einer Nachricht an den 'reverse-service'. 
        Sobald die Nachricht bearbeitet wurde, der unter {string} angegebene wert in umgekehrter Reihenfolge zurückgegeben.
   
### reverse-service

Weitere Spring Boot Applikation für das Empfangen und zurücksenden von Nachrichten mittels RabbitMQ.
 
Verwendete Externe Komponenten:
 * RabbitMQ, um Nachrichten von dem nameservice zu empfangen und den String in der enthaltenen Nachricht umgekehrt wieder zurückzusenden.
