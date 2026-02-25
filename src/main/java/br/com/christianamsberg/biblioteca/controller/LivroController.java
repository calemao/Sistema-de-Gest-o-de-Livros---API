package br.com.christianamsberg.biblioteca.controller;

import br.com.christianamsberg.biblioteca.domain.Livro;
import br.com.christianamsberg.biblioteca.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para Livros
 * Endpoints: POST, GET, PUT, PATCH, DELETE
 * Apenas recebe requisição, chama service e retorna resposta
 */
@RestController
@RequestMapping("/livros")
public class LivroController {
    
    private final LivroService livroService;
    
    /**
     * Injeção via construtor
     */
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    /**
     * POST /livros
     * Cria um novo livro
     */
    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
        try {
            Livro livroSalvo = livroService.cadastrarLivro(livro);
            return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    /**
     * GET /livros
     * Lista todos os livros
     */
    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }
    
    /**
     * GET /livros/{id}
     * Obtém um livro por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Livro> obterPorId(@PathVariable int id) {
        return livroService.buscarLivroPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    /**
     * PUT /livros/{id}
     * Atualiza um livro existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable int id, @RequestBody Livro livroAtualizado) {
        try {
            livroAtualizado.setId(id); // Garante que o ID seja o mesmo
            Livro livroAtualizadoRetorno = livroService.atualizarLivro(id, livroAtualizado);
            return ResponseEntity.ok(livroAtualizadoRetorno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    /**
     * PATCH /livros/{id}/indisponivel
     * Marca um livro como indisponível
     */
    @PatchMapping("/{id}/indisponivel")
    public ResponseEntity<Void> marcarComoIndisponivel(@PathVariable int id) {
        try {
            livroService.marcarComoIndisponivel(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    /**
     * PATCH /livros/{id}/disponivel
     * Marca um livro como disponível
     */
    @PatchMapping("/{id}/disponivel")
    public ResponseEntity<Void> marcarComoDisponivel(@PathVariable int id) {
        try {
            livroService.marcarComoDisponivel(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    /**
     * DELETE /livros/{id}
     * Deleta um livro
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        try {
            livroService.removerLivro(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
