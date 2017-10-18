
package com.hxqh.eam.dao;

import com.hxqh.eam.common.basedao.DaoSupport;
import com.hxqh.eam.model.UserObj;
import org.springframework.stereotype.Repository;


/**
 *
 * @author lh
 *
 */
@Repository("userDao")
public class UserDaoImpl extends DaoSupport<UserObj> implements UserDao {

}
