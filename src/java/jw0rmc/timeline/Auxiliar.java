package jw0rmc.timeline;
// Generated 28/08/2013 03:43:13 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Auxiliar generated by hbm2java
 */
public class Auxiliar  implements java.io.Serializable {


     private long id;
     private String descripcion;
     private Set elementoses = new HashSet(0);

    public Auxiliar() {
    }

	
    public Auxiliar(long id) {
        this.id = id;
    }
    public Auxiliar(long id, String descripcion, Set elementoses) {
       this.id = id;
       this.descripcion = descripcion;
       this.elementoses = elementoses;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getElementoses() {
        return this.elementoses;
    }
    
    public void setElementoses(Set elementoses) {
        this.elementoses = elementoses;
    }




}

