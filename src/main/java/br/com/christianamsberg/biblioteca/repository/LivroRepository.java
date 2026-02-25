package br.com.christianamsberg.biblioteca.repository;

import br.com.christianamsberg.biblioteca.domain.Livro;
import java.util.List;
import java.util.Optional;

/**
 * Interface do Repositório de Livros
 * Define os métodos obrigatórios para persistência
 */
public interface LivroRepository {
    
    /**
     * Salva um livro no repositório
     */
    Livro salvar(Livro livro);
    
    /**
     * Lista todos os livros
     */
    List<Livro> listarTodos();
    
    /**
     * Busca um livro por ID
     */
    Optional<Livro> buscarPorId(int id);
    
    /**
     * Busca um livro por ISBN
     */
    Optional<Livro> buscarPorIsbn(String isbn);
    
    /**
     * Atualiza um livro existente
     */
    Livro atualizar(Livro livro);
    
    /**
     * Deleta um livro pelo ID
     */
    void deletar(int id);
    
    /**
     * Conta o total de livros no repositório
     */
    int contar();
}
