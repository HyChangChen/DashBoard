package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_ROLEMODEL database table.
 */
@Entity
@Table(name = "TB_ROLEMODEL")
public class TbRolemodel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TB_ROLEMODEL_ROLEMODELID_GENERATOR", allocationSize = 1, sequenceName = "SEQ_ROLEMODEL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ROLEMODEL_ROLEMODELID_GENERATOR")
    private long rolemodelid;

    //bi-directional many-to-one association to ModelObj
    @ManyToOne
    @JoinColumn(name = "MODELID")
    private TbModel tbModel;

    //bi-directional many-to-one association to RoleObj
    @ManyToOne
    @JoinColumn(name = "ROLEID")
    private TbRole tbRole;

    public TbRolemodel() {
    }

    public TbRolemodel(TbModel tbModel, TbRole tbRole) {
        this.tbModel = tbModel;
        this.tbRole = tbRole;
    }

    public long getRolemodelid() {
        return this.rolemodelid;
    }

    public void setRolemodelid(long rolemodelid) {
        this.rolemodelid = rolemodelid;
    }

    public TbModel getTbModel() {
        return tbModel;
    }

    public void setTbModel(TbModel tbModel) {
        this.tbModel = tbModel;
    }

    public TbRole getTbRole() {
        return tbRole;
    }

    public void setTbRole(TbRole tbRole) {
        this.tbRole = tbRole;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TbRolemodel{");
        sb.append("rolemodelid=").append(rolemodelid);
        sb.append(", tbModel=").append(tbModel);
        sb.append(", tbRole=").append(tbRole);
        sb.append('}');
        return sb.toString();
    }
}