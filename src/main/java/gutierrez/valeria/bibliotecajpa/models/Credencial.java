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
import jakarta.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author valeria
 */
@Entity
public class Credencial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_credencial;
    
    @Column(name = "username", length = 50)
    private String username;
    
    @Column(name = "password", length = 100)
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL) // Un jugador tiene una única dirección
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
    
    

    public Credencial() {
    }

    public Credencial(Long id_credencial, String username, String password, Usuario usuario) {
        this.id_credencial = id_credencial;
        this.username = username;
        this.password = password;
        this.usuario = usuario;
    }

    public Long getId_credencial() {
        return id_credencial;
    }

    public void setId_credencial(Long id_credencial) {
        this.id_credencial = id_credencial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_credencial != null ? id_credencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credencial)) {
            return false;
        }
        Credencial other = (Credencial) object;
        if ((this.id_credencial == null && other.id_credencial != null) || (this.id_credencial != null && !this.id_credencial.equals(other.id_credencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gutierrez.valeria.bibliotecajpa.models.Credencial[ id=" + id_credencial + " ]";
    }
    
}
