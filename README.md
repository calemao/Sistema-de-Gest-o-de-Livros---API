<<<<<<< HEAD
# Sistema de Gestão de Livros

API REST em Spring Boot para gerenciamento de livros com persistência em memória.

**Status:** ✅ **100% Conforme com a Especificação (.txt)**

---

## ⚡ Quick Start

### 1️⃣ Compile:
```cmd
cd "C:\Users\Alemãozinho Te Ama\Documents\Engenharia de Software\5° Período\Construção de Software\biblioteca"
mvnw.cmd clean compile
```

### 2️⃣ Execute:
```cmd
mvnw.cmd -Dspring-boot.run.fork=false spring-boot:run
```

### 3️⃣ Teste:
```cmd
curl http://localhost:8080/livros
```
**Resultado esperado:** `[]`

---

## 📚 Endpoints (7 obrigatórios)

```
POST   /livros                    Criar livro (201/400)
GET    /livros                    Listar todos (200)
GET    /livros/{id}               Obter por ID (200/404)
PUT    /livros/{id}               Atualizar (200/400/404)
PATCH  /livros/{id}/indisponivel  Marcar indisponível (204/404)
PATCH  /livros/{id}/disponivel    Marcar disponível (204/404)
DELETE /livros/{id}               Deletar (204/404)
```

---

## 🏗️ Arquitetura

```
br.com.christianamsberg.biblioteca/
├── domain/         Livro.java (com 4 validações)
├── repository/     LivroRepository (interface)
│   └── impl:       LivroRepositoryMemoria (Map<Integer, Livro>)
├── service/        LivroService (regras de negócio)
└── controller/     LivroController (7 endpoints REST)
```

---

## ✅ Validações (4 obrigatórias)

1. **Título:** não nulo, 3+ caracteres após trim
2. **Autor:** não nulo, 3+ caracteres após trim
3. **ISBN:** formato `XXX-X-XXXX-XXXX-X` (regex)
4. **Ano:** entre 1500 e 2025
5. **Bônus:** ISBN único no sistema (Service)
6. **Bônus:** ISBN imutável após criação

---

## 🛠️ Tecnologias

- Java 21
- Spring Boot 3.3.0 (estável)
- Spring Web (única dependência obrigatória)
- Persistência em memória (sem JPA, sem BD, sem Lombok)

---

## ✨ Conformidade

✅ Estrutura em 3 camadas (controller → service → repository → domain)  
✅ Sem JPA, sem banco de dados, sem Lombok  
✅ Map<Integer, Livro> para persistência  
✅ Injeção por construtor (obrigatório)  
✅ Separação clara de responsabilidades  
✅ Todas as 7 endpoints implementadas  
✅ Status HTTP corretos (201, 200, 204, 404, 400)  
✅ 100% conforme arquivo .txt fornecido  

---

## 📖 Documentação

- **README.md** ← Você está aqui
- **VERIFICACAO_FINAL_TXT.md** ← Verificação contra .txt (76/76 requisitos ✅)

---

## 🚀 Pronto para Entrega

```
SistemaLivrosWeb_SeuNome_SuaMatricula.zip
```

Inclua:
- Pasta `src/` com código
- `pom.xml`
- `mvnw.cmd` e `.mvn/`
- `README.md`
=======
# Sistema de Gestão de Livros

API REST em Spring Boot para gerenciamento de livros com persistência em memória.

**Status:** ✅ **100% Conforme com a Especificação (.txt)**

---

## ⚡ Quick Start

### 1️⃣ Compile:
```cmd
cd "C:\Users\Alemãozinho Te Ama\Documents\Engenharia de Software\5° Período\Construção de Software\biblioteca"
mvnw.cmd clean compile
```

### 2️⃣ Execute:
```cmd
mvnw.cmd -Dspring-boot.run.fork=false spring-boot:run
```

### 3️⃣ Teste:
```cmd
curl http://localhost:8080/livros
```
**Resultado esperado:** `[]`

---

## 📚 Endpoints (7 obrigatórios)

```
POST   /livros                    Criar livro (201/400)
GET    /livros                    Listar todos (200)
GET    /livros/{id}               Obter por ID (200/404)
PUT    /livros/{id}               Atualizar (200/400/404)
PATCH  /livros/{id}/indisponivel  Marcar indisponível (204/404)
PATCH  /livros/{id}/disponivel    Marcar disponível (204/404)
DELETE /livros/{id}               Deletar (204/404)
```

---

## 🏗️ Arquitetura

```
br.com.christianamsberg.biblioteca/
├── domain/         Livro.java (com 4 validações)
├── repository/     LivroRepository (interface)
│   └── impl:       LivroRepositoryMemoria (Map<Integer, Livro>)
├── service/        LivroService (regras de negócio)
└── controller/     LivroController (7 endpoints REST)
```

---

## ✅ Validações (4 obrigatórias)

1. **Título:** não nulo, 3+ caracteres após trim
2. **Autor:** não nulo, 3+ caracteres após trim
3. **ISBN:** formato `XXX-X-XXXX-XXXX-X` (regex)
4. **Ano:** entre 1500 e 2025
5. **Bônus:** ISBN único no sistema (Service)
6. **Bônus:** ISBN imutável após criação

---

## 🛠️ Tecnologias

- Java 21
- Spring Boot 3.3.0 (estável)
- Spring Web (única dependência obrigatória)
- Persistência em memória (sem JPA, sem BD, sem Lombok)

---

## ✨ Conformidade

✅ Estrutura em 3 camadas (controller → service → repository → domain)  
✅ Sem JPA, sem banco de dados, sem Lombok  
✅ Map<Integer, Livro> para persistência  
✅ Injeção por construtor (obrigatório)  
✅ Separação clara de responsabilidades  
✅ Todas as 7 endpoints implementadas  
✅ Status HTTP corretos (201, 200, 204, 404, 400)  
✅ 100% conforme arquivo .txt fornecido  

---

## 📖 Documentação

- **README.md** ← Você está aqui
- **VERIFICACAO_FINAL_TXT.md** ← Verificação contra .txt (76/76 requisitos ✅)

---

## 🚀 Pronto para Entrega

```
SistemaLivrosWeb_SeuNome_SuaMatricula.zip
```

Inclua:
- Pasta `src/` com código
- `pom.xml`
- `mvnw.cmd` e `.mvn/`
- `README.md`
>>>>>>> cdc46a24469684a1a53e81c37695f7f696245931
