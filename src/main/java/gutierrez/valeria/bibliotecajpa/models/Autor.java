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
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author valeria
 */
@Entity
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autor;
    
    @Column(name = "nombre", length = 100)
    private String nombre;
    
    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    public Autor() {
    }
    
    // Un autor tiene MUCHOS libros
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private Set<Libro> libros;

    public Autor(Long id_autor, String nombre, String nacionalidad) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    public Long getId() {
        return id_autor;
    }

    public void setId(Long id) {
        this.id_autor = id;
    }

    public Long getId_autor() {
        return id_autor;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_autor != null ? id_autor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.id_autor == null && other.id_autor != null) || (this.id_autor != null && !this.id_autor.equals(other.id_autor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gutierrez.valeria.bibliotecajpa.models.Autor[ id=" + id_autor + " ]";
    }
    
}
