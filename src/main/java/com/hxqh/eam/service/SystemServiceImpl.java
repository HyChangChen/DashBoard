package com.hxqh.eam.service;

import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.common.util.ListSortUtil;
import com.hxqh.eam.common.util.MailUtils;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.webService.model.RetrunVal;
import com.hxqh.webService.model.RoleSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    static Logger logger = Logger.getLogger(SystemServiceImpl.class);

    @Value("${hxqh.email.name}")
    private String serverName;
    @Value("${hxqh.email.username}")
    private String username;
    @Value("${hxqh.email.password}")
    private String password;
    @Value("${hxqh.email.path.name}")
    private String pathName;

    @Autowired
    private SfOrganizationAccountDao organizationAccountDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private SfOrganizationDepartmentDao sfOrganizationDepartmentDao;
    @Autowired
    private TbIocCustTop7Dao tbIocCustTop7Dao;
    @Autowired
    private TbIoccustomeruserDao ioccustomeruserDao;
    @Autowired
    private TbModelDao modelDao;
    @Autowired
    private TbRoleDao roleDao;
    @Autowired
    private TbRolemodelDao rolemodelDao;
    @Autowired
    private TbUserroleDao userroleDao;
    @Autowired
    private UserDao userDao;
    @Resource
    protected SessionFactory sessionFactory;

    @Override
    public List<SfOrganizationAccount> getLoginUserList(LoginDto loginDto) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", loginDto.getName());
        String where = "name=:name ";
        List<SfOrganizationAccount> accountList = organizationAccountDao.findAll(where, params, null);
        return accountList;
    }

    @Override
    public List<Menu> getMenuListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        //        params.put("name", "");
        //        String where = "name=:name ";
        //        List<Menu> menuList = menuDao.findAll(where, params, null);
        List<Menu> menuList = menuDao.findAll();
        return menuList;
    }

    @Override
    public void editMenu(Menu menu) throws Exception {
        menuDao.update(menu);
    }

    @Override
    public void addMenu(Menu menu) throws Exception {
        menuDao.save(menu);
    }

    @Override
    public void delMenu(String menuid) throws Exception {
        menuDao.delete(menuid);
    }

    @Override
    public UserDto getUserListData() {
        String sql = "select distinct (t1.userid) as id, t1.loginname as name, t3.rolename,t3.roleid,t1.userstatus as userstatus\n" +
                "  from TB_USER t1\n" +
                "  left join tb_userrole t2\n" +
                "    on t1.userid = t2.userid\n" +
                "  left join tb_role t3\n" +
                "    on t2.roleid = t3.roleid";
        List<UserRoleDto> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(UserRoleDto.class).list();
        return new UserDto(list);
    }

    @Override
    public List<TbRole> getRoleListData() {
        return roleDao.findAll();
    }

    @Override
    public List<TbIocCustTop7> custtop7ListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("custtype", "DWS");
        String where = "custtype<>:custtype";
        return tbIocCustTop7Dao.findAll(where, params, null);
    }

    @Override
    public List<TbIoccustomeruser> customeruserListData(String name, String div) {
        Map<String, Object> params = new HashMap<>();

        List<TbIoccustomeruser> ioccustomeruserList = new ArrayList<>();
        if (name.equals("") && div.equals("")) {
            ioccustomeruserList = ioccustomeruserDao.findAll();
        } else if (name.equals("")) {
            params.put("div", div);
            String where = "div=:div";
            ioccustomeruserList = ioccustomeruserDao.findAll(where, params, null);
        } else if (div.equals("")) {
            params.put("custName", name.trim());
            StringBuilder sb = new StringBuilder("");
            sb.append(" custName like '%'||").append(":custName").append("||'%' ");
            ioccustomeruserList = ioccustomeruserDao.findAll(sb.toString(), params, null);
        } else {
            params.put("custName", name.trim());
            StringBuilder sb = new StringBuilder("");
            sb.append(" custName like '%'||").append(":custName").append("||'%' ").append(" or div=:div ");
            ioccustomeruserList = ioccustomeruserDao.findAll(sb.toString(), params, null);
        }
        return ioccustomeruserList;
    }

    @Transactional
    @Override
    public void updateRank(Long ioccustomeruserid, String custid, String name) {
        TbIocCustTop7 iocCustTop7 = tbIocCustTop7Dao.find(custid);
        TbIoccustomeruser ioccustomeruser = ioccustomeruserDao.find(ioccustomeruserid);

        iocCustTop7.setCustid(String.valueOf(ioccustomeruser.getIoccustomeruserid()));
        iocCustTop7.setCustname(ioccustomeruser.getCustName());
        iocCustTop7.setName(name);

        tbIocCustTop7Dao.update(iocCustTop7);
        sessionFactory.getCurrentSession().createSQLQuery("{call p_custom_rank.pro_custom_rank()}");
    }


    @Transactional
    @Override
    public void callProcedure() {
        sessionFactory.getCurrentSession().createSQLQuery("{call p_custom_rank.pro_custom_rank()}");
    }

    @Override
    public TestDto testData() {
        return new TestDto();
    }

    @Override
    public void userRole(String id, BigDecimal roleid) {

//        TbUserrole userrole = new TbUserrole(id, roleid);
//        userroleDao.save(userrole);
    }

    @Override
    public UserObj findUserbyId(Long id) {
        return userDao.find(id);
    }

    @Override
    public ModelDto getModelListData() {
        //分别返回一级节点和二级节点
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("sortnum", "asc");
        List<TbModel> modelList = modelDao.findAll(null, null, orderby);
        for (TbModel model : modelList) {
            model.setTbRolemodels(null);
        }

        //对modelList分组
        Map<Integer, List<TbModel>> listMap = GroupListUtil.group(modelList, new GroupListUtil.GroupBy<Integer>() {
            @Override
            public Integer groupby(Object obj) {
                TbModel d = (TbModel) obj;
                return d.getIsmdeol();    // 分组依据为mdeol
            }
        });

        return new ModelDto(listMap);
    }

    @Override
    public void editrole(TbRole account) {
        roleDao.update(account);
    }


    @Override
    public int addrole(TbRole account) {
        //如果loginname重复不添加
        Map<String, Object> params = new HashMap<>();
        params.put("rolename", account.getRolename());
        String where = "rolename=:rolename ";
        List<TbRole> roleList = roleDao.findAll(where, params, null);
        if (roleList.size() > 0) {
            return 0;
        }
        // 写TB_Role表
        account.setSortnum(new BigDecimal(1));
        roleDao.save(account);
        return 1;
    }


    @Override
    public void delrole(Long id) {
        if (!(id == 1l)) {
            TbRole role = roleDao.find(id);
            List<TbRolemodel> rolemodelList = role.getTbRolemodels();
            for (TbRolemodel e : rolemodelList) {
                rolemodelDao.delete(e.getRolemodelid());
            }
            roleDao.delete(id);
        }
    }


    @Override
    public void editmodel(TbModel account) {
        modelDao.update(account);
    }

    @Override
    public void addmodel(TbModel account) {
        modelDao.save(account);
    }

    @Override
    public void delmodel(String id) {
        modelDao.delete(id);
    }

    @Override
    public void roleModel(String models, Long roleid) {
        TbRole role = roleDao.find(roleid);
        String[] split = models.split(",");
        List<TbModel> modelList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            modelList.add(modelDao.find(Long.valueOf(split[i])));
        }

        for (TbModel e : modelList) {
            TbRolemodel rolemodel = new TbRolemodel(e, role);
            rolemodelDao.save(rolemodel);
        }
    }

    @Override
    public ModelRoleDto getModelRoleData(Long roleid) {
        TbRole role = roleDao.find(roleid);
        List<TbModel> modelHaveList = new ArrayList<>();
        for (TbRolemodel rolemodel : role.getTbRolemodels()) {
            modelHaveList.add(modelDao.find(rolemodel.getTbModel().getModelid()));
        }
        Map<String, Object> params = new HashMap<>();
        params.put("ismdeol", 1);
        String where = "ismdeol=:ismdeol ";

        List<TbModel> modelNoList = modelDao.findAll(where, params, null);
        modelNoList.removeAll(modelHaveList);

        for (TbModel e : modelNoList) {
            e.setTbRolemodels(null);
        }
        for (TbModel e : modelHaveList) {
            e.setTbRolemodels(null);
        }

        return new ModelRoleDto(modelNoList, modelHaveList);
    }

    @Override
    public List<TbRole> findRoleList() {
        return roleDao.findAll();
    }

    @Override
    public List<UserObj> getUserList(LoginDto loginDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginDto.getName());
        String where = "loginname=:loginname ";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        return accountList;
    }

    @Override
    public int forgetPassword(String loginname, String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        params.put("email", email);
        String where = "loginname=:loginname and email=:email";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() == 1) {
            UserObj userObj = accountList.get(0);
            userObj.setUserstatus(0);
            userDao.save(userObj);
            return 1;
        }
        return 0;
    }

    @Override
    public int resetPassword(Long userid) {
        UserObj userObj = userDao.find(userid);
        //重置密码 初始密码123456
        String password = Account.encrypt("123456");
        userObj.setLoginpassword(password);
        userObj.setUserstatus(1);
        userDao.save(userObj);
        //发送邮件
        if (userObj.getLoginname() != null && userObj.getEmail() != null) {
            sendEmail(userObj.getLoginname(), userObj.getEmail());
        }
        return 0;
    }

    @Override
    public int sendEmail(String loginname, String email) {
        MailUtils cn = new MailUtils();

        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        params.put("email", email);
        String where = "loginname=:loginname and email=:email";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() == 1) {
            // 设置发件人地址、收件人地址和邮件标题
            cn.setAddress(username, accountList.get(0).getEmail(), "The password has been reset");
            // 设置要发送附件的位置和标题
            cn.setAffix(pathName, "attach.txt");

            /**
             * 设置smtp服务器以及邮箱的帐号和密码
             * 用QQ 邮箱作为发生者不好使 （原因不明）
             * 163 邮箱可以，但是必须开启  POP3/SMTP服务 和 IMAP/SMTP服务
             * 因为程序属于第三方登录，所以登录密码必须使用163的授权码
             */
            // 注意： [授权码和你平时登录的密码是不一样的]
            cn.send(serverName, username, password, "重置密码为123456");
            return 1;
        }
        return 0;
    }

    @Override
    public ModelIndexDto getModelIndex(String loginname) {
//        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
//        orderby.put("modelid", "asc");

        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        String where = "loginname=:loginname ";
        List<UserObj> userObjList = userDao.findAll(where, params, null);
        Set<TbModel> modelList = new LinkedHashSet<>();

        if (userObjList.size() == 1) {
            UserObj userObj = userObjList.get(0);
            List<TbUserrole> tbUserroles = userObj.getTbUserroles();

            List<TbRolemodel> tbRolemodels = new ArrayList<>();
            for (TbUserrole e : tbUserroles) {
                tbRolemodels.addAll(e.getTbRole().getTbRolemodels());
            }
            for (TbRolemodel e : tbRolemodels) {
                modelList.add(e.getTbModel());
            }
            for (TbModel e : modelList) {
                //#修改为&
                e.setTbRolemodels(null);
            }
        }

        //返回子节点信息, 并打包到父节点下
        for (TbModel e : modelList) {
            Map<String, Object> p = new HashMap<>();
            p.put("parentid", e.getModelid());
            String w = "parentid=:parentid ";

            List<TbModel> childlList = modelDao.findAll(w, p, null);
            for (TbModel ele : childlList) {
                if (ele.getMurl() != null) {
                    String s = ele.getMurl().replaceAll("#", "&");
                    ele.setMurl(s);
                }
            }
            e.setChildList(childlList);
        }
        List<TbModel> mList = new LinkedList<>();
        for (TbModel e : modelList) {
            mList.add(e);
        }
        //modelList排序
        ListSortUtil<TbModel> sortList = new ListSortUtil<TbModel>();
        sortList.sort(mList, "sortnum", "asc");


        return new ModelIndexDto(mList);
    }


    @Override
    public TbIocCustTop7 getrankDetail(String ioccustomerusertop7id) {
        return tbIocCustTop7Dao.find(ioccustomerusertop7id);
    }

    @Override
    public void editUser(UserObj account) {
        //查询TB_USERROLE  userid
        Map<String, Object> params = new HashMap<>();
        params.put("userid", account.getUserid());
//        params.put("roleid", account.getRoleid());
        String where = "userid=:userid";
        List<TbUserrole> userroleList = userroleDao.findAll(where, params, null);

        if (userroleList.size() == 1) {
            TbUserrole userrole = userroleList.get(0);
            TbRole role = roleDao.find(Long.valueOf(account.getRoleid()));
            userrole.setTbRole(role);
            userroleDao.update(userrole);
        }
        userDao.update(userroleList.get(0).getTbUser());
    }


    @Override
    public int addUser(UserObj account, Long roleid) {
        //如果loginname重复不添加
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", account.getLoginname().toLowerCase());
        String where = "loginname=:loginname ";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() > 0) {
            return 0;
        }
        // 写TB_USER表
        //设置密码 初始密码123456
        String password = Account.encrypt("123456");
        account.setLoginpassword(password);
        account.setLoginname(account.getLoginname().toLowerCase());
        account.setUserstatus(1);

        userDao.save(account);
        // 写TB_USERROLE表
        TbUserrole urobj = new TbUserrole();
        urobj.setTbRole(roleDao.find(roleid));
        urobj.setTbUser(account);
        userroleDao.save(urobj);
        return 1;
    }

    @Override
    public void delUser(Long id) {
        if (!(id == 1)) {
            userDao.delete(id);
        }
    }


    @Override
    public List<SfOrganizationAccount> findOnlineUserList() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", new BigDecimal(1));
        String where = "login=:login ";
        List<SfOrganizationAccount> organizationAccountList = organizationAccountDao.findAll(where, params, null);
        return organizationAccountList;
    }

    @Override
    public List<SfOrganizationDepartment> getDepartmentList() {
        return sfOrganizationDepartmentDao.findAll();
    }


    /**********************WebService Interface Impl************************************/
    @Override
    public RetrunVal editUser(List<UserObj> objList) {
        RetrunVal r = new RetrunVal();
        String msg = "";
        int updateSuccessNum = 0;
        if (objList.size() < 0) {
            msg = "不存在修改的用户";
            r.setReturnCode(0);
            r.setReturnMess(msg);
        } else {
            for (UserObj u : objList) {
                Map<String, Object> params = new HashMap<>();
                params.put("sourceuserId", u.getSourceuserid());
                String where = "sourceuserid=:sourceuserId";
                List<UserObj> userObjs = userDao.findAll(where, params, null);
                if (userObjs.size() > 0) {
                    u.setUserid(Long.valueOf(userObjs.get(0).getUserid()));
                  /*  if (null != u.getLoginpassword() && !"".equals(u.getLoginpassword())) {
                       // String newPwd = Account.encrypt(u.getLoginpassword());
                        u.setLoginpassword(newPwd);
                    }*/
                    userDao.update(u, null, null, null);
                    String whereRole = "userid=:userid";
                    Map<String, Object> paramsrole = new HashMap<>();
                    paramsrole.put("userid", userObjs.get(0).getUserid());
                    List<TbUserrole> userroleList = userroleDao.findAll(whereRole, paramsrole, null);
                    if (userroleList.size() > 0) {
                        for (TbUserrole t : userroleList) {
                            TbRole role = roleDao.find(Long.valueOf(u.getRoleid()));
                            t.setTbRole(role);
                            userroleDao.update(t, null, null, null);
                        }
                    }
                    msg = "用户信息修改成功！";
                }
            }
            updateSuccessNum++;
            r.setReturnCode(1);
            r.setReturnMess(msg + updateSuccessNum);
        }
        return r;
    }

    /**
     * 验证用户的完整性
     *
     * @param userObjList
     * @return
     */
    @Override
    public RetrunVal validUser(List<UserObj> userObjList) {
        RetrunVal r = new RetrunVal();
        for (UserObj userObj : userObjList) {
            Map<String, Object> params = new HashMap<>();
            params.put("sourceuserId", userObj.getSourceuserid());
            params.put("loginname", userObj.getLoginname());
            params.put("loginpassword", userObj.getLoginpassword());
            params.put("userstatus", userObj.getUserstatus());
            String where = "sourceuserid=:sourceuserId and loginname=:loginname and loginpassword=:loginpassword and  userstatus:userstatus ";
            List<UserObj> userObjs = userDao.findAll(where, params, null);
            if (userObjs.size() > 0) {
                r.setReturnMess("共检测到用户个数：" + userObjs);
                r.setReturnCode(1);
            } else {
                r.setReturnMess("未检测到账号：" + userObj.getLoginname());
                r.setReturnCode(0);
            }
        }
        return r;
    }

    /**
     * 接口删除用户 add Ocean_hy
     *
     * @param userObjList
     */
    @Override
    public RetrunVal delUser(List<UserObj> userObjList) {
        RetrunVal r = new RetrunVal();
        String msg = "";
        for (UserObj u : userObjList) {
            //查找用户
            Map<String, Object> params = new HashMap<>();
            params.put("sourceuserId", u.getSourceuserid());
            String where = "sourceuserid=:sourceuserId";
            List<UserObj> userObjs = userDao.findAll(where, params, null);
            //查找用户拥有的角色
            Long userId = userObjs.get(0).getUserid();
            if (userId == 1) {
                r.setReturnMess("内置管理员账户禁止删除");
                r.setReturnCode(0);
            } else {
                String whereRole = "userid=:userid";
                Map<String, Object> paramsrole = new HashMap<>();
                paramsrole.put("userid", userId);
                List<TbUserrole> userroleList = userroleDao.findAll(whereRole, paramsrole, null);
                for (TbUserrole tbu : userroleList) {
                    userroleDao.delete(tbu.getUserroleid());
                }
                userDao.delete(userId);
                r.setReturnMess("用户删除成功！");
                r.setReturnCode(1);
            }
        }
        return r;
    }

    /**
     * add hy
     *
     * @param objList
     * @return
     */
    @Override
    public RetrunVal addUser(List<UserObj> objList) {
        RetrunVal r = new RetrunVal();
        int addSuccessNum = 0;
        int addErrorNum = 0;
        String msg = "";
        if (objList.size() < 0) {
            r.setReturnMess("推送的用户数据为空！");
            r.setReturnCode(0);
        } else {
            for (UserObj u : objList) {
                Map<String, Object> params = new HashMap<>();
                params.put("loginname", u.getLoginname().toLowerCase());
                String where = "loginname=:loginname ";
                List<UserObj> accountList = userDao.findAll(where, params, null);
                boolean isAdd = accountList.size() == 0 ? true : false;
                if (isAdd) {
                    if (null == u.getLoginpassword()) {
                        String newPwd = Account.encrypt("123456");
                        u.setLoginpassword(newPwd);
                    } else {
                        u.setLoginpassword(u.getLoginpassword());
                    }
                    u.setLoginname(u.getLoginname().toLowerCase());
                    userDao.save(u);
                    //add Role
                    if (null != u.getRoleid()) {
                        TbUserrole urobj = new TbUserrole();
                        urobj.setTbRole(roleDao.find(Long.valueOf(u.getRoleid())));
                        urobj.setTbUser(u);
                        userroleDao.save(urobj);
                    }
                    addSuccessNum++;
                } else {
                    addErrorNum++;
                    msg += u.getLoginname().toLowerCase() + ",";
                }
            }
            if (addErrorNum > 0)
                msg = "SUCCESS:" + addSuccessNum + "ERRORS:" + addErrorNum + "账户名" + msg + "已存在！";
            else {
                msg = "SUCCESS:" + addSuccessNum + "ERRORS:" + addErrorNum;
            }
            r.setReturnMess(msg);
            r.setReturnCode(1);

        }
        return r;
    }

    /**
     * 批量编辑角色 add Ocean_hy
     *
     * @param tbRoleList
     * @return
     */
    public RetrunVal editrole(List<TbRole> tbRoleList) {
        for (TbRole tbRole : tbRoleList) {
            Map<String, Object> params = new HashMap<>();
            params.put("sourceId", tbRole.getSourceid());
            String where = "sourceid=:sourceId";
            List<TbRole> roleObjs = roleDao.findAll(where, params, null);
            if (roleObjs.size() == 1) {
                List<UserObj> userObjList = new ArrayList<>();
                tbRole.setRoleid(roleObjs.get(0).getRoleid());
                roleDao.update(tbRole, null, null, null);
            } else {
                roleDao.delete(roleObjs.get(0).getRoleid());
                roleDao.save(tbRole);
            }
        }

        return null;
    }

    /**
     * 添加角色与用户的关系
     * @param tbRoleList
     * @return
     */

    @Override
    public RetrunVal addRoleSource(List<RoleSource> tbRoleList) {
        RetrunVal r = new RetrunVal();
        String msg = "";
        if (tbRoleList.size() > 0) {
            for (RoleSource roleSource : tbRoleList) {
                //查找角色
                TbRole tbRole = roleDao.find(Long.valueOf(roleSource.getRoleId()));
                //通过来源id查找用户信息
                Map<String, Object> params = new HashMap<>();
                params.put("sourceuserId", roleSource.getSourceId());
                String where = "sourceuserid=:sourceuserId";
                List<UserObj> userObjs = userDao.findAll(where, params, null);
                if (userObjs.size() == 1) {
                    UserObj userObj = userDao.find(userObjs.get(0).getUserid());
                    TbUserrole tbUserrole = new TbUserrole();
                    tbUserrole.setTbUser(userObj);
                    tbUserrole.setTbRole(tbRole);
                    //删除改用户下的所有角色关联关系
                    Long userId =userObj.getUserid();
                    //确保一个用户只拥有一个角色（参照林海的逻辑）
                    String whereRole = "userid=:userid";
                    Map<String, Object> paramsrole = new HashMap<>();
                    paramsrole.put("userid", userId);
                    List<TbUserrole> userroleList = userroleDao.findAll(whereRole, paramsrole, null);
                    for (TbUserrole tbu : userroleList) {
                        userroleDao.delete(tbu.getUserroleid());
                    }
                    //保存关联关系
                    userroleDao.save(tbUserrole);
                    msg = "用户角色变更成功";
                    r.setReturnMess(msg);
                    r.setReturnCode(1);
                    return r;
                } else if (userObjs.size() > 1) {
                    msg = "找到多个匹配用户，请联系管理员！";
                    r.setReturnMess(msg);
                    r.setReturnCode(0);
                    return r;

                } else {
                    msg = "未找到匹配用户！";
                    r.setReturnMess(msg);
                    r.setReturnCode(0);
                    return r;
                }

            }
        } else {
            msg = "不存在操作数据";
            r.setReturnMess(msg);
            r.setReturnCode(0);
            return r;
        }
        return r;
    }

    @Override
    public RetrunVal delRoleSource(List<RoleSource> tbRoleList) {
        RetrunVal r = new RetrunVal();
        String msg = "";
        if (tbRoleList.size() > 0) {
            for (RoleSource roleSource : tbRoleList) {
                Map<String, Object> params = new HashMap<>();
                params.put("sourceuserId", roleSource.getSourceId());
                String where = "sourceuserid=:sourceuserId";
                List<UserObj> userObjs = userDao.findAll(where, params, null);
                //删除改用户下的所有角色关联关系
                Long userId = userObjs.get(0).getUserid();
                if (userId == 1) {
                    msg = "内置管理员" + roleSource.getSourceId() + "账户禁止删除";
                } else {
                    //确保一个用户只拥有一个角色（参照林海的逻辑）
                    String whereRole = "userid=:userid";
                    Map<String, Object> paramsrole = new HashMap<>();
                    paramsrole.put("userid", userId);
                    List<TbUserrole> userroleList = userroleDao.findAll(whereRole, paramsrole, null);
                    for (TbUserrole tbu : userroleList) {
                        userroleDao.delete(tbu.getUserroleid());
                    }
                }
            }
        } else {
            msg = "不存在操作数据";
        }
        return r;
    }

    /**
     * 批量删除角色
     * add Ocean
     *
     * @param tbRoleList
     * @return
     */
    @Override
    public RetrunVal delrole(List<TbRole> tbRoleList) {
        RetrunVal r = new RetrunVal();
        int delNum = 0;
        for (TbRole tr : tbRoleList) {
            TbRole role = roleDao.find(tr.getRoleid());
            List<TbRolemodel> rolemodelList = role.getTbRolemodels();
            for (TbRolemodel e : rolemodelList) {
                rolemodelDao.delete(e.getRolemodelid());
            }
            List<TbUserrole> tbUserroleList = role.getTbUserroles();
            for (TbUserrole e : tbUserroleList) {
                userroleDao.delete(e.getUserroleid());
            }
            delNum++;
            roleDao.delete(tr.getRoleid());
        }


        return r;
    }
}
