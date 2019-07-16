package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian.stoica
 */
@Entity
@Table(name = "applicationrole")
@XmlRootElement
public class ApplicationRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SCHEMA_NAME = "projappdb";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "idapp", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApplicationEntity app;

    @JoinColumn(name = "idrole", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RoleEntity role;
    
    @OneToMany(mappedBy = "applicationRole",  cascade = ALL) 
    private List<ApplicationRolesTechnologiesEntity> technologies = new ArrayList<ApplicationRolesTechnologiesEntity>();

    public ApplicationRoleEntity() {
    }

    public ApplicationRoleEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationEntity getApp() {
        return app;
    }

    public void setApp(ApplicationEntity app) {
        this.app = app;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<ApplicationRolesTechnologiesEntity> getTechnologies() {
        if(technologies == null) {
           technologies = new ArrayList<ApplicationRolesTechnologiesEntity>();
        }
        return technologies;
    }

    public void setTechnologies(List<ApplicationRolesTechnologiesEntity> technologies) {
        this.technologies = technologies;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationRoleEntity)) {
            return false;
        }
        ApplicationRoleEntity other = (ApplicationRoleEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttdata.practicadevara.projapp.db.ApplicationroleEntity[ id=" + id + " ]";
    }
}
