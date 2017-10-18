package com.hxqh.eam.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_USERROLE database table.
 */
@Entity
@Table(name = "TB_USERROLE")
public class TbUserrole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TB_USERROLE_USERROLEID_GENERATOR", allocationSize = 1, sequenceName = "SEQ_USERROLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_USERROLE_USERROLEID_GENERATOR")
    private Long userroleid;

    //bi-directional many-to-one association to RoleObj
    @ManyToOne
    @JoinColumn(name = "ROLEID")
    private TbRole tbRole;

    //bi-directional many-to-one association to UserObj
    @ManyToOne
    @JoinColumn(name = "USERID")
    private UserObj tbUser;

    public TbUserrole() {
    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    public TbRole getTbRole() {
        return tbRole;
    }

    public void setTbRole(TbRole tbRole) {
        this.tbRole = tbRole;
    }

    public UserObj getTbUser() {
        return this.tbUser;
    }

    public void setTbUser(UserObj tbUser) {
        this.tbUser = tbUser;
    }


}