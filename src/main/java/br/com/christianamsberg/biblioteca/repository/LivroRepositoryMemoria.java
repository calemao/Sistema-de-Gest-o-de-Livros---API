package br.com.christianamsberg.biblioteca.repository;

import br.com.christianamsberg.biblioteca.domain.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implementação em memória do repositório de Livros
 * Utiliza um Map<Integer, Livro> para persistência
 */
@Repository
public class LivroRepositoryMemoria implements LivroRepository {
    
    private final Map<Integer, Livro> livros = new HashMap<>();
    
    @Override
    public Livro salvar(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        livros.put(livro.getId(), livro);
        return livro;
    }
    
    @Override
    public List<Livro> listarTodos() {
        // Retorna uma nova lista para evitar modificações externas
        return new ArrayList<>(livros.values());
    }
    
    @Override
    public Optional<Livro> buscarPorId(int id) {
        return Optional.ofNullable(livros.get(id));
    }
    
    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {
        // Buscar utilizando stream
        return livros.values()
                .stream()
                .filter(livro -> livro.getIsbn().equals(isbn))
                .findFirst();
    }
    
    @Override
    public Livro atualizar(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        if (!livros.containsKey(livro.getId())) {
            throw new IllegalArgumentException("Livro com ID " + livro.getId() + " não existe");
        }
        livros.put(livro.getId(), livro);
        return livro;
    }
    
    @Override
    public void deletar(int id) {
        if (!livros.containsKey(id)) {
            throw new IllegalArgumentException("Livro com ID " + id + " não existe");
        }
        livros.remove(id);
    }
    
    @Override
    public int contar() {
        return livros.size();
    }
}
