package edu.eci.cvds.servlet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "CONFIGURATION")
public class Configuration {

    @Id
    @Column(name = "PROPIEDAD")
    private String propiedad;
    @Column(name = "VALOR")
    private String valor;

    public Configuration(String propiedad, String valor){
        this.propiedad = propiedad;
        this.valor = valor;
    }

    public Configuration(){
        
    }

    public void setValue(String valor){
        this.valor = valor;
    }

    public String getValue(){
        return this.valor;
    }

    public void setProperty(String propiedad){
        this.propiedad = propiedad;
    }

    public String getProperty(){
        return this.propiedad;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((propiedad == null) ? 0 : propiedad.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Configuration other = (Configuration) obj;
        if (propiedad == null) {
            if (other.propiedad != null)
                return false;
        } else if (!propiedad.equals(other.propiedad))
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Configuration [propiedad=" + propiedad + ", valor=" + valor + "]";
    }

    
}
