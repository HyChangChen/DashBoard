package com.hxqh.eam.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TB_USER database table.
 */
@Entity
@Table(name = "TB_USER")
public class UserObj implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TB_USER_USERID_GENERATOR", allocationSize = 1, sequenceName = "SEQ_USER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_USER_USERID_GENERATOR")
    private Long userid;

    private String address;

    @Column(name = "\"DESCRIBE\"")
    private String describe;

    private String email;

    private String loginname;

    private String loginpassword;


    private String mobile;

    private String sex;

    private String username;

    private BigDecimal usernum;

    private Integer userstatus;

    private String department;

    @Transient
    private String roleid;


    //bi-directional many-to-one association to UserroleObj
    @OneToMany(mappedBy = "tbUser")
    @XStreamOmitField
    private List<TbUserrole> tbUserroles;

    private String sourceuserid;//HR系统的ID

    public UserObj() {
    }

    public String getSourceuserid() {
        return sourceuserid;
    }

    public void setSourceuserid(String sourceuserid) {
        this.sourceuserid = sourceuserid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getUsernum() {
        return usernum;
    }

    public void setUsernum(BigDecimal usernum) {
        this.usernum = usernum;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public List<TbUserrole> getTbUserroles() {
        return tbUserroles;
    }

    public void setTbUserroles(List<TbUserrole> tbUserroles) {
        this.tbUserroles = tbUserroles;
    }
}