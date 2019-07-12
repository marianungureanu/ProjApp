package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sebastian.stoica
 */
@Entity
@Table(name = "applicationrolestechnologies", schema = ApplicationRolesTechnologiesEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = ApplicationRolesTechnologiesEntity.FIND_ALL, query = "SELECT ar FROM ApplicationRolesTechnologiesEntity ar")
})
public class ApplicationRolesTechnologiesEntity implements Serializable {

    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "application_roles_technologies_findAllQuery";
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "idapplicationrole", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApplicationRoleEntity applicationRole;

    @JoinColumn(name = "idtechnology", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TechnologyEntity technology;

    @JoinColumn(name = "idlevelmin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LevelEntity levelMin;

    public ApplicationRolesTechnologiesEntity() {
    }

    public ApplicationRolesTechnologiesEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationRoleEntity getIdApplicationRole() {
        return applicationRole;
    }

    public void setApplicationRole(ApplicationRoleEntity idApplicationRole) {
        this.applicationRole = idApplicationRole;
    }

    public TechnologyEntity getTechnology() {
        return technology;
    }

    public void setTechnology(TechnologyEntity idTechnology) {
        this.technology = idTechnology;
    }

    public LevelEntity getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(LevelEntity idLevelMin) {
        this.levelMin = idLevelMin;
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
        if (!(object instanceof ApplicationRolesTechnologiesEntity)) {
            return false;
        }
        ApplicationRolesTechnologiesEntity other = (ApplicationRolesTechnologiesEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttdata.practicadevara.projapp.db.ApplicationrolestechnologiesEntity[ id=" + id + " ]";
    }
}
