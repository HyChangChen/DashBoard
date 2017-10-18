package com.hxqh.eam.service;


import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.TbIocCustTop7Dao;
import com.hxqh.eam.dao.VEnterpriseTicketDao;
import com.hxqh.eam.model.TbIocCustTop7;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.sqlquery.EnterpriseKTK;
import com.hxqh.eam.model.view.VEnterpriseTicket;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by lh on 2017-6-27 .
 */
@Transactional
@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {

    static Logger logger = Logger.getLogger(EnterpriseServiceImpl.class);

    private static final List<String> DAILY = Arrays.asList("DBS", "DES", "DGS");

    @Resource
    protected SessionFactory sessionFactory;

    @Autowired
    private VEnterpriseTicketDao vEnterpriseTicketDao;
    @Autowired
    private TbIocCustTop7Dao tbIocCustTop7Dao;


    @Override
    public EnterpriseDto getTopData(Integer show, String type) {

        //查询左侧RIGHTNOW PROACTIVE
        Map<String, Object> params = new HashMap<>();
        params.put("rightnow", "RIGHTNOW");
        params.put("roactive", "PROACTIVE");
        params.put("type", type);

        String where1 = " source_type=:rightnow and customer_segment=:type ";
        String where2 = " source_type=:roactive and customer_segment=:type ";

        String rightnowWhere, roactiveWhere;
        Integer integer = Integer.valueOf(show);
        //实现方法返回一个list，其中有2个或者多个对象EnterpriseTopDto

        if (integer == 1 && DAILY.contains(type)) {
            params.put("custrank", 1);
            rightnowWhere = where1 + "and custrank=:custrank";
            roactiveWhere = where2 + "and custrank=:custrank";
            //处理一个Dto

            EnterpriseTopDto enterpriseTopDto = generateEnterpriseDto(show, type, params, rightnowWhere, roactiveWhere);
            Map<String, EnterpriseTopDto> enterpriseMap = new HashMap<>();
            enterpriseMap.put(String.valueOf(integer), enterpriseTopDto);

            EnterpriseDto enterpriseDto = new EnterpriseDto(enterpriseMap);
            return enterpriseDto;
        } else if ((integer == 2 && DAILY.contains(type)) || (type.equals("DWS") && integer % 2 == 0 && integer != 18)) {
            //处理两个Dto
            String rank2 = "and (custrank=:custrank2)";
            String rank3 = "and (custrank=:custrank3)";
            if (!type.equals("DWS")) {
                params.put("custrank2", integer);
                params.put("custrank3", integer + 1);
            } else {
                params.put("custrank2", integer);
                params.put("custrank3", integer - 1);
            }

            String rightnowWhere2, roactiveWhere2, rightnowWhere3, roactiveWhere3;
            rightnowWhere2 = where1 + rank2;
            roactiveWhere2 = where2 + rank2;
            rightnowWhere3 = where1 + rank3;
            roactiveWhere3 = where2 + rank3;


            Map<String, EnterpriseTopDto> enterpriseMap = new HashMap<>();
            if (!type.equals("DWS")) {
                EnterpriseTopDto enterpriseTopDto2 = generateEnterpriseDto(show, type, params, rightnowWhere2, roactiveWhere2);
                EnterpriseTopDto enterpriseTopDto3 = generateEnterpriseDto(show + 1, type, params, rightnowWhere3, roactiveWhere3);
                enterpriseMap.put(String.valueOf(integer), enterpriseTopDto2);
                enterpriseMap.put(String.valueOf(integer + 1), enterpriseTopDto3);
            } else {
                EnterpriseTopDto enterpriseTopDto2 = generateEnterpriseDto(show, type, params, rightnowWhere2, roactiveWhere2);
                EnterpriseTopDto enterpriseTopDto3 = generateEnterpriseDto(show - 1, type, params, rightnowWhere3, roactiveWhere3);
                enterpriseMap.put(String.valueOf(integer), enterpriseTopDto2);
                enterpriseMap.put(String.valueOf(integer - 1), enterpriseTopDto3);
            }
            EnterpriseDto enterpriseDto = new EnterpriseDto(enterpriseMap);
            return enterpriseDto;
        } else {

            String rank4 = "and (custrank=:custrank4)";
            String rank5 = "and (custrank=:custrank5)";
            String rank6 = "and (custrank=:custrank6)";
            String rank7 = "and (custrank=:custrank7)";

            if (integer == 4 && DAILY.contains(type)) {
                params.put("custrank4", integer);
                params.put("custrank5", integer + 1);
                params.put("custrank6", integer + 2);
                params.put("custrank7", integer + 3);
            } else {//(type.equals("DWS") && integer == 18)
                params.put("custrank4", integer - 3);
                params.put("custrank5", integer - 2);
                params.put("custrank6", integer - 1);
                params.put("custrank7", integer);
            }
            String rightnowWhere4, roactiveWhere4, rightnowWhere5, roactiveWhere5, rightnowWhere6, roactiveWhere6, rightnowWhere7, roactiveWhere7;
            rightnowWhere4 = where1 + rank4;
            roactiveWhere4 = where2 + rank4;
            rightnowWhere5 = where1 + rank5;
            roactiveWhere5 = where2 + rank5;
            rightnowWhere6 = where1 + rank6;
            roactiveWhere6 = where2 + rank6;
            rightnowWhere7 = where1 + rank7;
            roactiveWhere7 = where2 + rank7;

            Map<String, EnterpriseTopDto> enterpriseMap = new HashMap<>();
            if (integer == 4 && DAILY.contains(type)) {
                EnterpriseTopDto enterpriseTopDto4 = generateEnterpriseDto(show, type, params, rightnowWhere4, roactiveWhere4);
                EnterpriseTopDto enterpriseTopDto5 = generateEnterpriseDto(show + 1, type, params, rightnowWhere5, roactiveWhere5);
                EnterpriseTopDto enterpriseTopDto6 = generateEnterpriseDto(show + 2, type, params, rightnowWhere6, roactiveWhere6);
                EnterpriseTopDto enterpriseTopDto7 = generateEnterpriseDto(show + 3, type, params, rightnowWhere7, roactiveWhere7);
                enterpriseMap.put(String.valueOf(integer), enterpriseTopDto4);
                enterpriseMap.put(String.valueOf(integer + 1), enterpriseTopDto5);
                enterpriseMap.put(String.valueOf(integer + 2), enterpriseTopDto6);
                enterpriseMap.put(String.valueOf(integer + 3), enterpriseTopDto7);
            } else {//(type.equals("DWS") && integer == 18)
                EnterpriseTopDto enterpriseTopDto4 = generateEnterpriseDto(show, type, params, rightnowWhere4, roactiveWhere4);
                EnterpriseTopDto enterpriseTopDto5 = generateEnterpriseDto(show - 1, type, params, rightnowWhere5, roactiveWhere5);
                EnterpriseTopDto enterpriseTopDto6 = generateEnterpriseDto(show - 2, type, params, rightnowWhere6, roactiveWhere6);
                EnterpriseTopDto enterpriseTopDto7 = generateEnterpriseDto(show - 3, type, params, rightnowWhere7, roactiveWhere7);
                enterpriseMap.put(String.valueOf(integer), enterpriseTopDto4);
                enterpriseMap.put(String.valueOf(integer - 1), enterpriseTopDto5);
                enterpriseMap.put(String.valueOf(integer - 2), enterpriseTopDto6);
                enterpriseMap.put(String.valueOf(integer - 3), enterpriseTopDto7);
            }

            EnterpriseDto enterpriseDto = new EnterpriseDto(enterpriseMap);

            return enterpriseDto;
        }
    }


    private EnterpriseTopDto generateEnterpriseDto(Integer show, String type, Map<String, Object> params, String rightnowWhere, String roactiveWhere) {

        Integer rownumkey1 = show * 10000;
        Integer rownumkey2 = show * 90000;
        /*************************************饼图************************************************/

        List<VEnterpriseTicket> rightnowList = vEnterpriseTicketDao.findAll(rightnowWhere, params, null);
        List<VEnterpriseTicket> proactiveList = vEnterpriseTicketDao.findAll(roactiveWhere, params, null);
        /*************************************饼图************************************************/


        /*************************************KTK折线图************************************************/
        String sqlrightnowSql = "select f.*, rownum + " + rownumkey1 + " rn\n" +
                "  from (select tbe.echars_id as eid,\n" +
                "       tbe.echars_lable as mon,\n" +
                "       tbe.echars_legend as regional,\n" +
                "       nvl(countval, 0) as countval\n" +
                "  from tb_ioc_config_echars tbe\n" +
                "  left join (select mon, regional, sum(countval) as countval\n" +
                "               from tb_ioc_data_bgew_ticket_tkt tkt\n" +
                "              where tkt.customer_segment =:CUSTOMERSEGMENT \n" +
                "                and tkt.sourcetype = :SOURCETYPE \n" +
                "                and tkt.custrank = :custrank \n" +
                "              group by mon, regional) rs\n" +
                "    on tbe.echars_lable = rs.mon\n" +
                "   and tbe.echars_legend = rs.regional\n" +
                "   where tbe.ECHARS_TYPE = 'BEFORE30DAYS'\n" +
                " order by tbe.echars_id) f";
        List<EnterpriseKTK> rightnowTicketTktList = sessionFactory.getCurrentSession().createSQLQuery(sqlrightnowSql).addEntity(EnterpriseKTK.class).
                setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE", "RIGHTNOW").setString("custrank", String.valueOf(show)).list();


        String sqlproactiveSql = "select f.*, rownum + " + rownumkey2 + " rn\n" +
                "  from (select tbe.echars_id as eid,\n" +
                "               tbe.echars_lable as mon,\n" +
                "               tbe.echars_legend as regional,\n" +
                "               nvl(countval, 0) as countval\n" +
                "          from tb_ioc_config_echars tbe\n" +
                "          left join (select mon, regional, sum(countval) as countval\n" +
                "                      from tb_ioc_data_bgew_ticket_tkt tkt\n" +
                "                     where tkt.customer_segment = :CUSTOMERSEGMENT\n" +
                "                       and tkt.sourcetype = :SOURCETYPE\n" +
                "                       and tkt.custrank = :custrank\n" +
                "                     group by mon, regional) rs\n" +
                "            on tbe.echars_lable = rs.mon\n" +
                "           and tbe.echars_legend = rs.regional\n" +
                "           where tbe.ECHARS_TYPE = 'BEFORE30DAYS'\n" +
                "         order by tbe.echars_id) f\n";
        List<EnterpriseKTK> proactiveTicketTktList1 = sessionFactory.getCurrentSession().createSQLQuery(sqlproactiveSql).addEntity(EnterpriseKTK.class).
                setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE", "PROACTIVE").setString("custrank", String.valueOf(show)).list();

        // 对rightnowTicketTktList分组
        Map<String, List<EnterpriseKTK>> rightnowTicketMap = GroupListUtil.group(rightnowTicketTktList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                EnterpriseKTK d = (EnterpriseKTK) obj;
                return d.getRegional();    // 分组依据为Regional
            }
        });

        //对proactiveTicketTktList1分组
        Map<String, List<EnterpriseKTK>> proactiveTicketMap = GroupListUtil.group(proactiveTicketTktList1, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                EnterpriseKTK d = (EnterpriseKTK) obj;
                return d.getRegional();    // 分组依据为Regional
            }
        });

        Map<String, List<Integer>> rightnowTicketM = new LinkedHashMap<>();
        extractNumberList(rightnowTicketMap, rightnowTicketM);

        Map<String, List<Integer>> proactiveTicketM = new LinkedHashMap<>();
        extractNumberList(proactiveTicketMap, proactiveTicketM);


        //KTK nameList
        String nameListSQL = "select t.echars_lable as name  from TB_IOC_CONFIG_ECHARS t where t.echars_legend = 'NAS' and t.echars_type ='BEFORE30DAYS' order by t.echars_id";
        List<EnterpriseNameDto> nameList = sessionFactory.getCurrentSession().createSQLQuery(nameListSQL).addEntity(EnterpriseNameDto.class).list();
        List<String> nList = new LinkedList<>();
        for (EnterpriseNameDto nameDto : nameList) {
            nList.add(nameDto.getName());
        }

        /*************************************KTK折线图************************************************/


        /*************************************右上角 TB_IOC_DATA_BGEW_SLA   三色*****************************/
        String scolorSql = "select m.*, rownum +" + rownumkey2 + "  as colorid\n" +
                "  from (select t.customer_sement as cust,\n" +
                "               sum(t.gt) as gt,\n" +
                "               sum(t.eq) as eq,\n" +
                "               sum(t.lt) as lt\n" +
                "          from TB_IOC_DATA_BGEW_SLA t\n" +
                "         where t.customer_sement = :CUSTOMERSEGMENT\n" +
                "           and t.custrank = :custrank\n" +
                "         group by t.customer_sement) m\n";
        List<EnterpriseThreeColor> colorList = sessionFactory.getCurrentSession().createSQLQuery(scolorSql).addEntity(EnterpriseThreeColor.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        EnterpriseThreeColor threeColor = new EnterpriseThreeColor();
        if (colorList.size() > 0) {
            threeColor = colorList.get(0);
        }
        /*************************************右上角 TB_IOC_DATA_BGEW_SLA   三色*****************************/


        /*************************************select * from tb_ioc_cust_top7 显示名称*****************************/
        Map<String, Object> nameparams = new HashMap<>();
        nameparams.put("type", type);
        nameparams.put("show", String.valueOf(show));

        String nameWhere = " custtype =:type and custrank =:show";

        List<TbIocCustTop7> iocCustTop7s = tbIocCustTop7Dao.findAll(nameWhere, nameparams, null);

        String name = iocCustTop7s.get(0).getName();

        /*************************************select * from tb_ioc_cust_top7 显示名称*****************************/

        /*************************************TB_IOC_ENT_CUST_SERVICE   左下角显示图标*****************************/
        String iconSql = "select t.service_lay as lay,t.status from TB_IOC_ENT_CUST_SERVICE t  where t.cust_type = :CUSTOMERSEGMENT and t.cust_rank =:custrank";
        List<EnterpriseIconDto> iconList = sessionFactory.getCurrentSession().createSQLQuery(iconSql).addEntity(EnterpriseIconDto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        /*************************************TB_IOC_ENT_CUST_SERVICE   左下角显示图标*****************************/

        /*************************************event*****************************/
        String eventSql = "select t.service_affecting as affevent,rownum rn  from TB_IOC_ENT_CUST_EVENT t where t.cust_type = :CUSTOMERSEGMENT and t.cust_rank = :custrank and rownum<4";
        List<EnterpriseEventDto> eventList = sessionFactory.getCurrentSession().createSQLQuery(eventSql).addEntity(EnterpriseEventDto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        /*************************************event*****************************/

        /*************************************6:Tb_Ioc_Ent_Bge_Region*****************************/
        String enter6SQL = "select w.*, rownum+" + rownumkey1 + " regionrn\n" +
                "  from (select r.treg, r.dh as dh, nvl(t.personsum, 0) as personsum\n" +
                "          from (select * from tb_ioc_config_region_product x where x.cata = 0) r\n" +
                "          left join (select d.link_times,\n" +
                "                           d.treg,\n" +
                "                           sum(d.sum_persion_in) as personsum\n" +
                "                      from TB_IOC_ENT_BGE_region d\n" +
                "                     where d.cust_type = :CUSTOMERSEGMENT\n" +
                "                       and d.custrank = :custrank\n" +
                "                     group by d.link_times, d.treg) t\n" +
                "            on t.link_times = r.dtime\n" +
                "           and t.treg = r.treg\n" +
                "         order by r.configregionid) w";
        List<Enterprise67Dto> dto6List = sessionFactory.getCurrentSession().createSQLQuery(enter6SQL).addEntity(Enterprise67Dto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();

        // 对dto6List分组
        Map<String, List<Enterprise67Dto>> enterprise6Map = GroupListUtil.group(dto6List, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                Enterprise67Dto d = (Enterprise67Dto) obj;
                return d.getTreg();    // 分组依据为Regional
            }
        });

        //分组并存入List<Integer>
        Map<String, List<Double>> enterpriseRegionMap = new LinkedHashMap<>();
        extractRegionProductList(enterprise6Map, enterpriseRegionMap);

        //获取regionNameList
        String regionSQL = "select  x.dh as name  from tb_ioc_config_region_product x where x.cata = 0 and x.treg = 'NAS' order by x.configregionid";
        List<String> regionNameList = getNameList(regionSQL);

        /*************************************6:Tb_Ioc_Ent_Bge_Region*****************************/


        /*************************************7:TB_IOC_ENT_BGE_PRODUCT*****************************/
        String enter7SQL = "select w.*, rownum+" + rownumkey2 + " regionrn\n" +
                "  from (select r.treg, r.dh as dh, nvl(t.personsum, 0) as personsum\n" +
                "          from (select * from tb_ioc_config_region_product x where x.cata = 1) r\n" +
                "          left join (select d.lay, d.link_times, sum(d.sum_in) as personsum\n" +
                "                      from TB_IOC_ENT_BGE_product d\n" +
                "                     where d.cust_type = :CUSTOMERSEGMENT\n" +
                "                       and d.custrank = :custrank\n" +
                "                     group by d.lay, d.link_times) t\n" +
                "            on t.link_times = r.dtime\n" +
                "           and t.lay = r.treg\n" +
                "         order by r.configregionid) w";

        List<Enterprise67Dto> dto7List = sessionFactory.getCurrentSession().createSQLQuery(enter7SQL).addEntity(Enterprise67Dto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();


        Map<String, List<Enterprise67Dto>> enterprise7Map = GroupListUtil.group(dto7List, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                Enterprise67Dto d = (Enterprise67Dto) obj;
                return d.getTreg();    // 分组依据为Regional
            }
        });
        Map<String, List<Double>> enterpriseProductMap = new LinkedHashMap<>();
        extractRegionProductList(enterprise7Map, enterpriseProductMap);

        //获取ProductNameList
        String productSQL = "select  x.dh as name from tb_ioc_config_region_product x where x.cata = 1 and x.treg = 'ASTINET' order by x.configregionid";
        List<String> productNameList = getNameList(productSQL);

        /*************************************7:TB_IOC_ENT_BGE_PRODUCT*****************************/

        return new EnterpriseTopDto(rightnowList, proactiveList, nList, rightnowTicketM, proactiveTicketM, threeColor, name, iconList, eventList, enterpriseRegionMap, regionNameList, enterpriseProductMap, productNameList);
    }

    private List<String> getNameList(String regionProductSQL) {
        List<EnterpriseNameDto> regionProductList = sessionFactory.getCurrentSession().createSQLQuery(regionProductSQL).addEntity(EnterpriseNameDto.class).list();
        List<String> nRegionProductList = new LinkedList<>();
        for (EnterpriseNameDto nameDto : regionProductList) {
            nRegionProductList.add(nameDto.getName());
        }
        return nRegionProductList;
    }

    private void extractRegionProductList(Map<String, List<Enterprise67Dto>> enterprise7Map, Map<String, List<Double>> enterprise7M) {
        for (Map.Entry<String, List<Enterprise67Dto>> m : enterprise7Map.entrySet()) {
            List<Double> mttrs = new LinkedList<>();
            for (Enterprise67Dto l : m.getValue()) {
                mttrs.add(l.getPersonsum());
            }
            enterprise7M.put(m.getKey(), mttrs);
        }
    }

    private void extractNumberList(Map<String, List<EnterpriseKTK>> proactiveTicketMap, Map<String, List<Integer>> proactiveTicketM) {
        for (Map.Entry<String, List<EnterpriseKTK>> m : proactiveTicketMap.entrySet()) {
            List<Integer> mttrs = new LinkedList<>();
            for (EnterpriseKTK l : m.getValue()) {
                mttrs.add(l.getCountval());
            }
            proactiveTicketM.put(m.getKey(), mttrs);
        }
    }

    //Enterprise Government Business 数据接口
    @Override
    public EntDto getEntData(String type) {
        //获取左侧饼状图   RIGHTNOW     PROACTIVE_TICKET
        String pieRightnowSQL = "select w.*,rownum rn from (select t.CUSTOMER_SEGMENT as ctype,sum(t.OPENNUMS) as OPENNUMS,sum(t.CLOSENUMS) as CLOSENUMS  " +
                "from V_ENTERPRISE_TICKET t where t.CUSTOMER_SEGMENT = :CUSTOMERSEGMENT  and t.SOURCE_TYPE = :SOURCETYPE  group by t.CUSTOMER_SEGMENT) w";

        String pieProactiveSQL = "select w.*,rownum rn from (select t.CUSTOMER_SEGMENT as ctype,sum(t.OPENNUMS) as OPENNUMS,sum(t.CLOSENUMS) as CLOSENUMS  " +
                "from V_ENTERPRISE_TICKET t where t.CUSTOMER_SEGMENT =:CUSTOMERSEGMENT and t.SOURCE_TYPE =:SOURCETYPE  group by t.CUSTOMER_SEGMENT) w";

        List<EnterprisePieDto> pieRightnowList = sessionFactory.getCurrentSession().createSQLQuery(pieRightnowSQL).addEntity(EnterprisePieDto.class).
                setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE", "RIGHTNOW").list();

        List<EnterprisePieDto> pieProactiveList = sessionFactory.getCurrentSession().createSQLQuery(pieProactiveSQL).addEntity(EnterprisePieDto.class).
                setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE", "PROACTIVE_TICKET").list();

        /*******************************************KTK数据***************************************************/
        String ktkRightnowSQL = "select  w.*,rownum+20000 rn from ( select  u1.echars_lable as mon ,u1.echars_legend as etype ,nvl(u2.countval,0) as enternum from (select * from tb_ioc_config_echars e where e.echars_type = 'BEFORE30DAYS' order by e.echars_id) u1 left join" +
                "(select t.mon,t.REGIONAL, sum(t.COUNTVAL) as COUNTVAL from V_ENTERPRISE_TICKET_TKT t where t.CUSTOMER_SEGMENT =:CUSTOMERSEGMENT and t.source_type = 'RIGHTNOW' group by t.mon,t.REGIONAL) u2 on u1.echars_lable = u2.mon  and u1.echars_legend = u2.REGIONAL) w";
        List<EnterpriseKtkDto> ktkRightnowList = sessionFactory.getCurrentSession().createSQLQuery(ktkRightnowSQL).addEntity(EnterpriseKtkDto.class).
                setString("CUSTOMERSEGMENT", type).list();


        String ktkProactiveSQL = "select  w.*,rownum+3000 rn from ( select  u1.echars_lable as mon ,u1.echars_legend as etype ,nvl(u2.countval,0) as enternum from (select * from tb_ioc_config_echars e where e.echars_type = 'BEFORE30DAYS' order by e.echars_id) u1 left join" +
                "(select t.mon,t.REGIONAL, sum(t.COUNTVAL) as COUNTVAL from V_ENTERPRISE_TICKET_TKT t where t.CUSTOMER_SEGMENT =:CUSTOMERSEGMENT and t.source_type = 'PROACTIVE_TICKET' group by t.mon,t.REGIONAL) u2 on u1.echars_lable = u2.mon  and u1.echars_legend = u2.REGIONAL) w";
        List<EnterpriseKtkDto> ktkProactiveList = sessionFactory.getCurrentSession().createSQLQuery(ktkProactiveSQL).addEntity(EnterpriseKtkDto.class).
                setString("CUSTOMERSEGMENT", type).list();
        //nameList
        String nameListSQL = "select t.echars_lable as name from TB_IOC_CONFIG_ECHARS t where t.echars_legend = 'NAS' and t.echars_type ='BEFORE30DAYS' order by t.echars_id";
        List<EnterpriseNameDto> nameList = sessionFactory.getCurrentSession().createSQLQuery(nameListSQL).addEntity(EnterpriseNameDto.class).list();
        List<String> nList = new LinkedList<>();
        for (EnterpriseNameDto nameDto : nameList) {
            nList.add(nameDto.getName());
        }

        //对pktkRightnowSQL分组
        Map<String, List<EnterpriseKtkDto>> rightnowTicketMap = GroupListUtil.group(ktkRightnowList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                EnterpriseKtkDto d = (EnterpriseKtkDto) obj;
                return d.getEtype();    // 分组依据为Regional
            }
        });
        Map<String, List<EnterpriseKtkDto>> proactiveTicketMap = GroupListUtil.group(ktkProactiveList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                EnterpriseKtkDto d = (EnterpriseKtkDto) obj;
                return d.getEtype();    // 分组依据为Regional
            }
        });

        Map<String, List<Integer>> rightnowTicketM = new LinkedHashMap<>();
        extractTicketNumberList(rightnowTicketMap, rightnowTicketM);
        Map<String, List<Integer>> proactiveTicketM = new LinkedHashMap<>();
        extractTicketNumberList(proactiveTicketMap, proactiveTicketM);
        /*******************************************KTK数据***************************************************/

        /*************************************右上角 TB_IOC_DATA_BGEW_SLA   三色*****************************/

        String scolorSql = "select x.*,rownum colorid  from ( \n" +
                "select t.customer_sement as cust,\n" +
                "       sum(t.gt) as gt,\n" +
                "       sum(t.eq) as eq,\n" +
                "       sum(t.lt) as lt\n" +
                "  from TB_IOC_DATA_BGEW_SLA t\n" +
                " where t.customer_sement = :CUSTOMERSEGMENT\n" +
                " group by t.customer_sement) x\n";
        List<EnterpriseThreeColor> colorList = sessionFactory.getCurrentSession().createSQLQuery(scolorSql).addEntity(EnterpriseThreeColor.class).
                setString("CUSTOMERSEGMENT", type).list();
        EnterpriseThreeColor threeColor = new EnterpriseThreeColor();
        if (colorList.size() > 0) {
            threeColor = colorList.get(0);
        }
        /*************************************右上角 TB_IOC_DATA_BGEW_SLA   三色*****************************/


        /*******************************************Tb_Ioc_Ent_Bge_Region*************************************/
        String ent6SQl = "select w.*, rownum + 5000 regionrn\n" +
                "  from (select r.treg, r.dh as dh, nvl(t.sum_persion_in, 0) as personsum\n" +
                "          from (select * from tb_ioc_config_region_product x where x.cata = 0) r\n" +
                "          left join (   select d.link_times,d.treg,\n" +
                "                           sum(d.sum_persion_in) as sum_persion_in\n" +
                "                      from TB_IOC_ENT_BGE_REGION d\n" +
                "                     where d.cust_type = :CUSTOMERSEGMENT\n" +
                "                     group by d.link_times,d.treg ) t\n" +
                "            on t.link_times = r.dtime and t.treg=r.treg\n" +
                "         order by r.configregionid) w";
        List<Enterprise67Dto> dto6List = sessionFactory.getCurrentSession().createSQLQuery(ent6SQl).addEntity(Enterprise67Dto.class).
                setString("CUSTOMERSEGMENT", type).list();

        // dto6List分组
        Map<String, List<Enterprise67Dto>> enterprise6Map = GroupListUtil.group(dto6List, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                Enterprise67Dto d = (Enterprise67Dto) obj;
                return d.getTreg();    // 分组依据为Regional
            }
        });
        Map<String, List<Double>> enterpriseRegionMap = new LinkedHashMap<>();
        extractRegionProductList(enterprise6Map, enterpriseRegionMap);

        //获取regionNameList
        String regionSQL = "select  x.dh as name  from tb_ioc_config_region_product x where x.cata = 0 and x.treg = 'NAS' order by x.configregionid";
        List<String> regionNameList = getNameList(regionSQL);

        /*******************************************Tb_Ioc_Ent_Bge_Region*************************************/

        /*******************************************TB_IOC_ENT_BGE_PRODUCT************************************/
        String ent7SQl = "select w.*, rownum + 6000 regionrn\n" +
                "  from (select r.treg, r.dh as dh, nvl(t.sum_in, 0) as personsum\n" +
                "          from (select * from tb_ioc_config_region_product x where x.cata = 1) r\n" +
                "          left join (select d.link_times,d.lay,sum(d.sum_in) as sum_in\n" +
                "                      from TB_IOC_ENT_BGE_PRODUCT d\n" +
                "                     where d.cust_type = :CUSTOMERSEGMENT\n" +
                "                     group by  d.link_times,d.lay) t\n" +
                "            on t.link_times = r.dtime and t.lay=r.treg\n" +
                "         order by r.configregionid) w";
        List<Enterprise67Dto> regionProductList = sessionFactory.getCurrentSession().createSQLQuery(ent7SQl).addEntity(Enterprise67Dto.class).
                setString("CUSTOMERSEGMENT", type).list();

        Map<String, List<Enterprise67Dto>> enterprise7Map = GroupListUtil.group(regionProductList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                Enterprise67Dto d = (Enterprise67Dto) obj;
                return d.getTreg();    // 分组依据为Regional
            }
        });
        Map<String, List<Double>> enterpriseProductMap = new LinkedHashMap<>();
        extractRegionProductList(enterprise7Map, enterpriseProductMap);

        //获取ProductNameList
        String productSQL = "select  x.dh as name from tb_ioc_config_region_product x where x.cata = 1 and x.treg = 'ASTINET' order by x.configregionid";
        List<String> productNameList = getNameList(productSQL);

        /*******************************************TB_IOC_ENT_BGE_PRODUCT************************************/

        EntDto entDto = new EntDto(pieRightnowList, pieProactiveList, rightnowTicketM, proactiveTicketM, nList, enterpriseRegionMap, regionNameList, enterpriseProductMap, productNameList, threeColor);
        return entDto;
    }


    private void extractTicketNumberList(Map<String, List<EnterpriseKtkDto>> rightnowTicketMap, Map<String, List<Integer>> proactiveTicketM) {
        for (Map.Entry<String, List<EnterpriseKtkDto>> m : rightnowTicketMap.entrySet()) {
            List<Integer> mttrs = new LinkedList<>();
            for (EnterpriseKtkDto l : m.getValue()) {
                mttrs.add(l.getEnternum());
            }
            proactiveTicketM.put(m.getKey(), mttrs);
        }
    }


}
