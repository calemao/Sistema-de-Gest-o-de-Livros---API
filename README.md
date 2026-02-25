# Sistema de Gestão de Livros (Resumo de projeto)

Este repositório contém uma API REST em Spring Boot para gerenciamento de livros. O objetivo da atividade é implementar uma arquitetura em camadas (domain → repository → service → controller) com persistência em memória e sem uso de JPA, banco de dados externo ou Lombok.

Este README foi simplificado — consulte o arquivo de requisitos `ATIVIDADE__Sistema_de_Gesto_de_Livros.txt` para as regras completas.

Estado atual do projeto (após verificações rápidas):

- Main class: `br.com.christianamsberg.biblioteca.BibliotecaApplication` (presente)
- Domínio: `src/main/java/br/com/christianamsberg/biblioteca/model/Livro.java` (note: package is `model`; spec asks `domain`)
- Repository: `src/main/java/br/com/christianamsberg/biblioteca/repository/LivroRepository` (interface)
- Repository impl: `LivroRepositoryMemoria` (in-memory Map)
- Service: `LivroService` (business logic)
- Controller: `LivroController` (REST endpoints at `/livros`)

Key differences vs. activity requirements (actionable):
- The activity requires the domain package to be `domain` (currently `model`). Consider moving `Livro.java` to `domain` and updating imports.
- The activity forbids JPA, H2 and Lombok; currently the `pom.xml` includes `spring-boot-starter-data-jpa`, `h2` and `lombok` entries that were added earlier for compatibility. To be fully compliant remove those dependencies.

Quickstart

```bash
cd "C:\Users\Alemãozinho Te Ama\Documents\Engenharia de Software\5° Período\Construção de Software\biblioteca"
mvnw.cmd -Dspring-boot.run.fork=false spring-boot:run
```

If `spring-boot:run` still fails with ClassNotFoundException, build and run the jar:

```bash
mvnw.cmd clean package -DskipTests
java -jar target\biblioteca-0.0.1-SNAPSHOT.jar
```

Next steps I can do for you (choose):
1. Move `Livro.java` to `domain` package and update imports project-wide.
2. Remove JPA/H2/Lombok from `pom.xml` and clean up disabled legacy files.
3. Keep code as-is but update docs to explicitly reflect current state.

Tell me which option you prefer and I'll apply the changes and re-run checks.
