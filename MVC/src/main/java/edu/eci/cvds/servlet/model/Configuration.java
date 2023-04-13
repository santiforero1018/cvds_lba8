package edu.eci.cvds.servlet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long configurationId;
    private String propiedad;
    private String valor;

    public Configuration(String propiedad, String valor){
        this.propiedad = propiedad;
        this.valor = valor;
    }

    public Long getId(){
        return this.configurationId;
    }

    public void setId(Long configurationId){
        this.configurationId = configurationId;
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
        result = prime * result + ((configurationId == null) ? 0 : configurationId.hashCode());
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
        if (configurationId == null) {
            if (other.configurationId != null)
                return false;
        } else if (!configurationId.equals(other.configurationId))
            return false;
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
}
