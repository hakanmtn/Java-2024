# Lokale Datenbankkonfiguration

Die JDBC- und Hibernate-Beispiele verwenden lokale PostgreSQL- oder
MySQL-Datenbanken. Zugangsdaten werden nicht im Repository gespeichert.

## JDBC-Beispiele

Die Module `java-23-JDBC` und `java-23-JDBC_v1` lesen ihre Verbindung aus
Umgebungsvariablen.

Für PostgreSQL:

```bash
export POSTGRES_URL="jdbc:postgresql://localhost:5432/postgres"
export POSTGRES_USER="postgres"
export POSTGRES_PASSWORD="mein_lokales_passwort"
```

Für MySQL:

```bash
export MYSQL_URL="jdbc:mysql://localhost:3306/my_company_db"
export MYSQL_USER="root"
export MYSQL_PASSWORD="mein_lokales_passwort"
```

In IntelliJ IDEA können dieselben Werte unter **Run → Edit Configurations →
Environment variables** für die jeweilige Startkonfiguration eingetragen
werden.

## Hibernate-Beispiele

Jedes Hibernate-Modul enthält eine Datei `hibernate.cfg.example.xml`. Vor dem
ersten Start muss sie im selben Verzeichnis als `hibernate.cfg.xml` kopiert
werden, zum Beispiel:

```bash
cp java-24-jpa-hibernate-orm/src/main/resources/hibernate.cfg.example.xml \
   java-24-jpa-hibernate-orm/src/main/resources/hibernate.cfg.xml
```

Anschließend werden in der lokalen `hibernate.cfg.xml` diese Platzhalter
ersetzt:

```text
YOUR_DATABASE_USER
YOUR_DATABASE_PASSWORD
```

Je nach Modul muss außerdem die PostgreSQL- oder MySQL-URL an die lokale
Datenbank angepasst werden. Die Datei `hibernate.cfg.xml` wird von Git
ignoriert; nur die sichere Beispielkonfiguration wird versioniert.

## Hinweis

Die Konfigurationen sind ausschließlich für lokale Lern- und Testdatenbanken
vorgesehen. Für produktive Anwendungen sollten Zugangsdaten über ein
Secret-Management-System oder die Konfiguration der Laufzeitumgebung
bereitgestellt werden.
