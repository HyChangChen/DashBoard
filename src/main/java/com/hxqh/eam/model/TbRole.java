package com.hxqh.eam.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TB_ROLE database table.
 */
@Entity
@Table(name = "TB_ROLE")
public class TbRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TB_ROLE_ROLEID_GENERATOR", allocationSize = 1, sequenceName = "SEQ_ROLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ROLE_ROLEID_GENERATOR")
    private Long roleid;

    private String roledesc;

    private String rolename;

    private BigDecimal rolestatus;

    private BigDecimal sortnum;
    private String sourceid;

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    //bi-directional many-to-one association to UserroleObj
    @OneToMany(mappedBy = "tbRole")
    @XStreamOmitField
    private List<TbUserrole> tbUserroles;

    //bi-directional many-to-one association to RolemodelObj
    @OneToMany(mappedBy = "tbRole")
    @XStreamOmitField
    private List<TbRolemodel> tbRolemodels;


    public TbRole() {
    }

    public List<TbUserrole> getTbUserroles() {
        return tbUserroles;
    }

    public void setTbUserroles(List<TbUserrole> tbUserroles) {
        this.tbUserroles = tbUserroles;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRoledesc() {
        return this.roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public BigDecimal getRolestatus() {
        return this.rolestatus;
    }

    public void setRolestatus(BigDecimal rolestatus) {
        this.rolestatus = rolestatus;
    }

    public BigDecimal getSortnum() {
        return this.sortnum;
    }

    public void setSortnum(BigDecimal sortnum) {
        this.sortnum = sortnum;
    }

    public List<TbRolemodel> getTbRolemodels() {
        return tbRolemodels;
    }

    public void setTbRolemodels(List<TbRolemodel> tbRolemodels) {
        this.tbRolemodels = tbRolemodels;
    }
}