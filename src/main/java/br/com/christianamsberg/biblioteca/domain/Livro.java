package br.com.christianamsberg.biblioteca.domain;

/**
 * Entidade Livro - Representa um livro no sistema
 * Atributos obrigatórios: id, titulo, autor, isbn, anoPublicacao, disponivel
 */
public class Livro {
    
    // Contador estático para auto-incremento manual
    private static int proximoId = 1;
    
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private boolean disponivel;
    
    /**
     * Construtor com validações
     */
    public Livro(String titulo, String autor, String isbn, int anoPublicacao) {
        this.id = proximoId++;
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setAnoPublicacao(anoPublicacao);
        this.disponivel = true;
    }
    
    // GETTERS
    
    public int getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public boolean isDisponivel() {
        return disponivel;
    }
    
    // SETTERS COM VALIDAÇÕES
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().length() < 3) {
            throw new IllegalArgumentException("Título deve ter no mínimo 3 caracteres após trim");
        }
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        if (autor == null || autor.trim().length() < 3) {
            throw new IllegalArgumentException("Autor deve ter no mínimo 3 caracteres após trim");
        }
        this.autor = autor;
    }
    
    public void setIsbn(String isbn) {
        if (isbn == null || !validarFormatoIsbn(isbn)) {
            throw new IllegalArgumentException("ISBN deve estar no formato: XXX-X-XXXX-XXXX-X");
        }
        this.isbn = isbn;
    }
    
    public void setAnoPublicacao(int ano) {
        if (ano < 1500 || ano > 2025) {
            throw new IllegalArgumentException("Ano de publicação deve estar entre 1500 e 2025");
        }
        this.anoPublicacao = ano;
    }
    
    // MÉTODOS DE VALIDAÇÃO
    
    /**
     * Valida o formato do ISBN: XXX-X-XXXX-XXXX-X
     */
    private static boolean validarFormatoIsbn(String isbn) {
        String padraoIsbn = "^\\d{3}-\\d{1}-\\d{4}-\\d{4}-\\d{1}$";
        return isbn.matches(padraoIsbn);
    }
    
    // MÉTODOS DE NEGÓCIO
    
    public void marcarComoDisponivel() {
        this.disponivel = true;
    }
    
    public void marcarComoIndisponivel() {
        this.disponivel = false;
    }
    
    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", disponivel=" + disponivel +
                '}';
    }
}
