package br.com.christianamsberg.biblioteca.service;

import br.com.christianamsberg.biblioteca.domain.Livro;
import br.com.christianamsberg.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço de Livros - Centraliza a lógica de negócio
 * Regras: Validar ISBN único, delegar persistência, tratar exceções
 */
@Service
public class LivroService {
    
    private final LivroRepository livroRepository;
    
    /**
     * Injeção via construtor (obrigatória)
     */
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    
    /**
     * Cadastra um novo livro
     * Valida ISBN único e delega persistência ao repository
     */
    public Livro cadastrarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        
        // Validar ISBN único
        if (livroRepository.buscarPorIsbn(livro.getIsbn()).isPresent()) {
            throw new IllegalArgumentException("Já existe um livro com este ISBN");
        }
        
        return livroRepository.salvar(livro);
    }
    
    /**
     * Lista todos os livros
     */
    public List<Livro> listarLivros() {
        return livroRepository.listarTodos();
    }
    
    /**
     * Busca um livro por ID
     */
    public Optional<Livro> buscarLivroPorId(int id) {
        return livroRepository.buscarPorId(id);
    }
    
    /**
     * Atualiza um livro existente
     * Não permite alterar ISBN
     */
    public Livro atualizarLivro(int id, Livro livroAtualizado) {
        if (livroAtualizado == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        
        // Validar existência
        Livro livroExistente = livroRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro com ID " + id + " não existe"));
        
        // Não permitir alterar ISBN
        if (!livroExistente.getIsbn().equals(livroAtualizado.getIsbn())) {
            throw new IllegalArgumentException("Não é permitido alterar o ISBN de um livro");
        }
        
        return livroRepository.atualizar(livroAtualizado);
    }
    
    /**
     * Remove um livro existente
     * Lança exceção se não existir
     */
    public void removerLivro(int id) {
        if (livroRepository.buscarPorId(id).isEmpty()) {
            throw new IllegalArgumentException("Livro com ID " + id + " não existe");
        }
        livroRepository.deletar(id);
    }
    
    /**
     * Marca um livro como indisponível
     */
    public void marcarComoIndisponivel(int id) {
        Livro livro = livroRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro com ID " + id + " não existe"));
        livro.marcarComoIndisponivel();
        livroRepository.atualizar(livro);
    }
    
    /**
     * Marca um livro como disponível
     */
    public void marcarComoDisponivel(int id) {
        Livro livro = livroRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro com ID " + id + " não existe"));
        livro.marcarComoDisponivel();
        livroRepository.atualizar(livro);
    }
}
