/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gutierrez.valeria.bibliotecajpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author valeria
 */
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    
    @Column(name = "nombre", length = 100)
    private String nombre;
    
    // mappedBy: Esta relación ya está mapeada (configurada) por el atributo llamado 'jugadores' que está en la otra clase
    @ManyToMany(mappedBy = "categorias") // Un Jugador puede tener/jugar muchos Videojuegos.
    private Set<Libro> libros;
    

    public Categoria() {
    }
    
    public Categoria(Long id_categoria, String nombre, Set<Libro> libros) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.libros = libros;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_categoria != null ? id_categoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id_categoria == null && other.id_categoria != null) || (this.id_categoria != null && !this.id_categoria.equals(other.id_categoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gutierrez.valeria.bibliotecajpa.models.Categoria[ id=" + id_categoria + " ]";
    }
    
}
