/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gutierrez.valeria.bibliotecajpa.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author valeria
 */
@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_libro;
    
    @Column(name = "titulo", length = 150)
    private String titulo;
    
    private int inioPublicacion;
    
    @OneToOne(cascade = CascadeType.ALL) // Un libro tiene un unico autor
    @JoinColumn(name = "id_autor", referencedColumnName = "id_autor")
    private Autor autor;
    
    @ManyToMany // 
    @JoinTable( // Dueño de la relación
            name = "libro_categoria", // Crea una tabla intermedia con ese nombre
            joinColumns = @JoinColumn(name = "id_libro"), // Es para anotar el ID del juego
            inverseJoinColumns = @JoinColumn(name = "id_categoria") // Es para anotar el ID del jugador.
    )
    private Set<Categoria> categorias;
    

    public Libro() {
    }

    public Libro(Long id_libro, String titulo, int inioPublicacion, Set<Categoria> categorias) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.inioPublicacion = inioPublicacion;
        this.categorias = categorias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getInioPublicacion() {
        return inioPublicacion;
    }

    public void setInioPublicacion(int inioPublicacion) {
        this.inioPublicacion = inioPublicacion;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Long getId_libro() {
        return id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_libro != null ? id_libro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.id_libro == null && other.id_libro != null) || (this.id_libro != null && !this.id_libro.equals(other.id_libro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gutierrez.valeria.bibliotecajpa.models.Libro[ id=" + id_libro + " ]";
    }
    
}
