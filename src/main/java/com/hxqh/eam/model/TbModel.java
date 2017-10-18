package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TB_MODEL database table.
 */
@Entity
@Table(name = "TB_MODEL")
public class TbModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TB_MODEL_MODELID_GENERATOR", allocationSize = 1, sequenceName = "SEQ_MODEL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MODEL_MODELID_GENERATOR")
    private Long modelid;

    private Integer ismdeol;

    private String modeldesc;

    private String modelname;

    private BigDecimal modelstatus;

    private Long parentid;

    private String remark;

    private BigDecimal sortnum;

    private String murl;

    private Integer isurl;

    // bi-directional many-to-one association to RolemodelObj
    @OneToMany(mappedBy = "tbModel")
    private List<TbRolemodel> tbRolemodels;

    @Transient
    private List<TbModel> childList;

    public TbModel() {
    }

    public Integer getIsurl() {
        return isurl;
    }

    public void setIsurl(Integer isurl) {
        this.isurl = isurl;
    }

    public List<TbModel> getChildList() {
        return childList;
    }

    public void setChildList(List<TbModel> childList) {
        this.childList = childList;
    }

    public List<TbRolemodel> getTbRolemodels() {
        return tbRolemodels;
    }

    public void setTbRolemodels(List<TbRolemodel> tbRolemodels) {
        this.tbRolemodels = tbRolemodels;
    }

    public Long getModelid() {
        return modelid;
    }

    public void setModelid(Long modelid) {
        this.modelid = modelid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getIsmdeol() {
        return this.ismdeol;
    }

    public void setIsmdeol(Integer ismdeol) {
        this.ismdeol = ismdeol;
    }

    public String getModeldesc() {
        return this.modeldesc;
    }

    public void setModeldesc(String modeldesc) {
        this.modeldesc = modeldesc;
    }

    public String getModelname() {
        return this.modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public BigDecimal getModelstatus() {
        return this.modelstatus;
    }

    public void setModelstatus(BigDecimal modelstatus) {
        this.modelstatus = modelstatus;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getSortnum() {
        return this.sortnum;
    }

    public void setSortnum(BigDecimal sortnum) {
        this.sortnum = sortnum;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }
}