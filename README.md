# Java-Lernrepository

Dieses Repository dokumentiert meine praktische Java-Weiterbildung und eigene
Übungen – von den Grundlagen der Sprache bis zu Datenbankzugriffen mit JDBC und
objektrelationaler Abbildung mit JPA/Hibernate.

> **English summary:** A collection of hands-on Java exercises covering Java SE,
> object-oriented programming, collections, streams, concurrency, testing, SQL,
> JDBC, JPA, and Hibernate. The modules document my continuous learning progress
> and are intended as focused examples rather than one production application.

## Inhalt

| Bereich | Themen | Module |
| --- | --- | --- |
| Java-Grundlagen | Variablen, Operatoren, Kontrollstrukturen, Methoden und Arrays | `java-02` bis `java-07` |
| Objektorientierung | Klassen, Komposition, Kapselung, Vererbung, Polymorphie, Interfaces und abstrakte Klassen | `java-08` bis `java-15` |
| Java SE | Collections, Generics, Streams, Optional, Exceptions und Nebenläufigkeit | `java-16` bis `java-21` |
| Datenbanken | SQL, PostgreSQL, MySQL und JDBC | `java-22` und `java-23` |
| JPA/Hibernate | ORM-Grundlagen, Embeddables, Beziehungen, HQL und Vererbungsstrategien | `java-24` bis `java-33` |
| Testen | JUnit sowie Property-based Testing mit jqwik und junit-quickcheck | `UnitTest_PropertyBasedTest` |

## Ausgewählte Beispiele

- [Collections](java-16-collections/) – zentrale Collection-Typen und typische
  Operationen
- [Streams](java-18-stream-api/) – Verarbeitung von Daten mit der Stream API
- [Nebenläufigkeit](java-21-concurrency-multi-thread/) – Threads und parallele
  Abläufe
- [JDBC](java-23-JDBC/) – Datenbankzugriffe mit PostgreSQL und MySQL
- [JPA/Hibernate](java-24-jpa-hibernate-orm/) – Einstieg in ORM und persistente
  Entitäten
- [Hibernate-Beziehungen](java-30-hibernate-many-to-many-java-config/) –
  Many-to-many-Mapping
- [HQL](java-31-hibernate-query-language/) – Abfragen mit der Hibernate Query
  Language
- [Unit- und Property-Tests](UnitTest_PropertyBasedTest/) – beispielbasierte und
  generative Tests

## Technologien

- Java SE
- Maven und Gradle
- JUnit, jqwik und junit-quickcheck
- SQL, JDBC, PostgreSQL und MySQL
- JPA und Hibernate ORM
- Git und GitHub

## Verwendung

Repository klonen:

```bash
git clone https://github.com/hakanmtn/Java-2024.git
cd Java-2024
```

Die Verzeichnisse sind eigenständige Lernmodule. Ein Maven-Modul kann separat
geöffnet oder ausgeführt werden, zum Beispiel:

```bash
cd java-21-concurrency-multi-thread
mvn test
```

Die verwendete Java-Version kann je nach Entstehungszeit des Moduls abweichen.
Vor dem Start sollte deshalb die im jeweiligen `pom.xml` konfigurierte Version
als Project SDK ausgewählt werden.

Die JDBC- und Hibernate-Beispiele benötigen zusätzlich eine lokale PostgreSQL-
oder MySQL-Datenbank. Die benötigten Umgebungsvariablen und sicheren lokalen
Konfigurationsschritte sind in der
[Datenbankkonfiguration](DATABASE_SETUP.md) beschrieben.

## Einordnung

Dieses Repository ist bewusst als Lernverlauf aufgebaut. Die Module sind keine
zusammenhängende Produktionsanwendung, sondern konzentrieren sich jeweils auf
ein einzelnes Sprachmerkmal oder Framework-Konzept. Varianten mit dem Zusatz
`_v1` dokumentieren unterschiedliche Übungs- oder Entwicklungsstände.

Mein aktueller Weiterbildungsschwerpunkt liegt auf Spring Boot, Spring Data und
Spring Cloud. Größere Anwendungen werden als eigenständige Projekte geführt,
damit dieses Repository übersichtlich als Java-Lernsammlung erhalten bleibt.
