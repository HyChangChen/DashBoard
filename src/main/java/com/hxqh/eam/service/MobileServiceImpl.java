package com.hxqh.eam.service;

import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.TbIocMobileBackhaulTtc;
import com.hxqh.eam.model.view.TbIocMobileIpTransit;
import com.hxqh.eam.model.TbIocMobilePerfor;
import com.hxqh.eam.model.TbIocMobilePerforBadMsg;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Service("mobileService")
public class MobileServiceImpl implements MobileService {
    static Logger logger = Logger.getLogger(MobileServiceImpl.class);

    private static final String[] RF = {"RADIO ACCESS", "FO ACCESS"};
    private static final String[] RFS = {"RADIO ACCESS", "FO ACCESS", "SL_D"};

    @Autowired
    private VMob86Dao vMob86Dao;
    @Autowired
    private VMob87Dao vMob87Dao;
    @Autowired
    private VMob91Dao vMob91Dao;
    @Autowired
    private VMob92Dao vMob92Dao;
    @Autowired
    private VMob88MttiDao mob88MttiDao;
    @Autowired
    private VMob88MttrDao mob88MttrDao;
    @Autowired
    private VMob88PerformanceDao mob88PerformanceDao;
    @Autowired
    private TbIocMobileIpTransitDao tbIocMobileIpTransitDao;
    @Autowired
    private TbIocMobileBackhaulTtcDao mobileBackhaulTtcDao;
    @Autowired
    private TbIocMobilePerforDao tbIocMobilePerforDao;
    @Autowired
    private TbIocMobilePerforBadMsgDao tbIocMobilePerforBadMsgDao;

    @Override
    public Mob91Dto vMob91Data() {
        List<VMob91> vMob91List = vMob91Dao.findAll();

        List<VMob91> mob91LeftList = new LinkedList<>();
        List<VMob91> mob91RightList = new LinkedList<>();
        for (int i = 0; i < vMob91List.size(); i++) {
            if (i < 8) {
                mob91LeftList.add(vMob91List.get(i));
            } else {
                mob91RightList.add(vMob91List.get(i));
            }
        }
        Mob91Dto mob91Dto = new Mob91Dto(mob91LeftList, mob91RightList);
        return mob91Dto;
    }

    @Override
    public Moblie92 vMob92Data() {
        List<VMob92> mob92List = vMob92Dao.findAll();
        Collections.reverse(mob92List);
        // mob92List进行分组
        Map<String, List<VMob92>> map = GroupListUtil.group(mob92List, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VMob92 d = (VMob92) obj;
                return d.getKpitype();  // 分组依据为Kpitype
            }
        });

        Map<String, Mob92Dto> dtoMap = new HashMap<>();
        for (Map.Entry<String, List<VMob92>> entry : map.entrySet()) {
            Mob92Dto mob92Dto = getMob92Dto(entry.getValue());
            dtoMap.put(entry.getKey(), mob92Dto);
        }
        Moblie92 moblie92 = new Moblie92(dtoMap);
        return moblie92;
    }

    private Mob92Dto getMob92Dto(List<VMob92> mob92List) {
        // 百分比
        List<Mob92PercentDto> percentMob92List = new LinkedList<>();
        for (VMob92 mob92 : mob92List) {
            Double sum = mob92.getGreennum().doubleValue() + mob92.getOrangenum().doubleValue() + mob92.getRednum().doubleValue();
            //如果sum不等于0
            Mob92PercentDto vMob92 = null;
            if (sum != 0) {
                DecimalFormat df = new DecimalFormat(".");

                double green = mob92.getGreennum().doubleValue() / sum * 1000;
                double orange = mob92.getOrangenum().doubleValue() / sum * 1000;
                double red = mob92.getRednum().doubleValue() / sum * 1000;
                if (green + orange + red <= 1000) {
                    vMob92 = new Mob92PercentDto(df.format(green).trim(),
                            mob92.getTreg(),
                            df.format(orange).trim(),
                            df.format(red).trim());
                } else {
                    if (green > 1)
                        green = green - 1;
                    vMob92 = new Mob92PercentDto(df.format(green).trim(),
                            mob92.getTreg(),
                            df.format(orange).trim(),
                            df.format(red).trim());
                }
            } else {
                vMob92 = new Mob92PercentDto(new Double(0).toString(),
                        mob92.getTreg(),
                        new Double(0).toString(),
                        new Double(1000).toString());
            }
            percentMob92List.add(vMob92);
        }

        //原始数据
        List<BigDecimal> green = new LinkedList<>();
        List<BigDecimal> orange = new LinkedList<>();
        List<BigDecimal> red = new LinkedList<>();
        for (VMob92 mob92 : mob92List) {
            green.add(mob92.getGreennum());
            orange.add(mob92.getOrangenum());
            red.add(mob92.getRednum());
        }
        // 百分比数据
        List<Double> greenPercent = new LinkedList<>();
        List<Double> orangePercent = new LinkedList<>();
        List<Double> redPercent = new LinkedList<>();
        for (Mob92PercentDto mob92 : percentMob92List) {
            greenPercent.add(Double.valueOf(mob92.getGreennum()));
            orangePercent.add(Double.valueOf(mob92.getOrangenum()));
            redPercent.add(Double.valueOf(mob92.getRednum()));
        }
        return new Mob92Dto(green, orange, red, greenPercent, orangePercent, redPercent);
    }

    @Override
    public Mob86Dto vMob86Data() {
        List<VMob86> vMob86List = vMob86Dao.findAll();
        List<VMob86> mob86List = vMob86Dao.findAll("ioc1='TREG-1'", null, null);
        Mob86Dto mob86Dto = new Mob86Dto(vMob86List, mob86List.get(0).getWeek1(), mob86List.get(0).getWeek2());
        return mob86Dto;
    }

    @Override
    public VMob87Dto vMob87Data() {
        List<VMob87> mob87List = vMob87Dao.findAll();

        // 进行分组
        Map<String, List<VMob87>> map = GroupListUtil.group(mob87List, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VMob87 d = (VMob87) obj;
                return d.getRegional();    // 分组依据为Regional
            }
        });

        VMob87Dto vMob87Dto = new VMob87Dto(map);
        return vMob87Dto;
    }

    @Override
    public Mob88Dto getMob88Data() {
        List<VMob88Mtti> mob88Mtti = mob88MttiDao.findAll();
        List<VMob88Mttr> mob88Mttr = mob88MttrDao.findAll();
//        List<VMob88Performance> mob88Performance = mob88PerformanceDao.findAll();
        List<TbIocMobilePerfor> perforList = tbIocMobilePerforDao.findAll();

        Mob88Dto mob88Dto = new Mob88Dto(mob88Mtti, mob88Mttr, perforList);
        return mob88Dto;
    }

    @Override
    public ThroughtputDto throughtputData() {
        //第一部分数据用于2组折线图展示
        List<TbIocMobileIpTransit> mobileIpTransits = tbIocMobileIpTransitDao.findAll();

        // mobileIpTransits进行分组
        Map<String, List<TbIocMobileIpTransit>> map = GroupListUtil.group(mobileIpTransits, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocMobileIpTransit d = (TbIocMobileIpTransit) obj;
                return d.getAgte();    // 分组依据为Agte
            }
        });

        Map<String, ThroughtputAgte> agteMap = new HashMap<>();
        for (Map.Entry<String, List<TbIocMobileIpTransit>> m : map.entrySet()) {
            List<TbIocMobileIpTransit> mValue = m.getValue();
            List<BigDecimal> in = new ArrayList<>();
            List<BigDecimal> out = new ArrayList<>();
            List<BigDecimal> opers = new ArrayList<>();
            List<BigDecimal> wrong = new ArrayList<>();
            for (int i = 0; i < mValue.size(); i++) {
                in.add(mValue.get(i).getSumIn());
                out.add(mValue.get(i).getSumOut());
                opers.add(mValue.get(i).getOpers());
                wrong.add(mValue.get(i).getWrong());
            }
            BigDecimal maxVal = (Collections.max(in).compareTo(Collections.max(out)) == -1) ? Collections.max(out) : Collections.max(in);

            ThroughtputAgte throughtputAgte = new ThroughtputAgte(in, out, opers, wrong, maxVal);
            agteMap.put(m.getKey(), throughtputAgte);
        }
        List<String> namelist = new LinkedList<>();
        for (int i = 0; i < map.get("JAKARTA").size(); i++) {
            namelist.add(map.get("JAKARTA").get(i).getDataTimes());
        }


        ThroughtputDto throughtputDto = new ThroughtputDto(agteMap, namelist);
        return throughtputDto;
    }

    @Override
    public TopologicalDto topologicalData() {

        List<TbIocMobileBackhaulTtc> allNode = mobileBackhaulTtcDao.findAll();
        List<TbIocMobileBackhaulTtc> root7List = new LinkedList<>();
        //先遍历获取顶级节点
        for (int i = 0; i < allNode.size(); i++) {
            if (null == allNode.get(i).getParentId()) {
                root7List.add(allNode.get(i));
            }
        }

        Map<String, List<TbIocMobileBackhaulTtc>> map = new LinkedHashMap<>();
        for (int i = 0; i < root7List.size(); i++) {
            List<TbIocMobileBackhaulTtc> backhaulTtcs2 = new LinkedList<>();
            backhaulTtcs2.add(root7List.get(i));

            List<TbIocMobileBackhaulTtc> twoLevelList = treeMenuList(allNode, root7List.get(i));
            backhaulTtcs2.addAll(twoLevelList);
            //增加二级节点所有孩子节点至backhaulTtcs2集合中
            for (TbIocMobileBackhaulTtc e : twoLevelList) {
                List<TbIocMobileBackhaulTtc> tbIocMobileBackhaulTtcs = new LinkedList<>();
                tbIocMobileBackhaulTtcs = treeMenuList(allNode, e);
                backhaulTtcs2.addAll(tbIocMobileBackhaulTtcs);
            }

            map.put(root7List.get(i).getTitle(), backhaulTtcs2);
        }

        //求节点间的连线
        Map<String, List<TbIocMobileBackhaulTtc>> linkMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<TbIocMobileBackhaulTtc>> en : map.entrySet()) {
            List<TbIocMobileBackhaulTtc> enValue = new LinkedList<>();
            enValue.addAll(en.getValue());
            enValue.remove(0);
            linkMap.put(en.getKey(), enValue);
        }
        TopologicalDto dto = new TopologicalDto(linkMap, map);
        return dto;
    }


    public static List<TbIocMobileBackhaulTtc> treeMenuList(List<TbIocMobileBackhaulTtc> menuList, TbIocMobileBackhaulTtc mobileBackhaulTtc) {
        List<TbIocMobileBackhaulTtc> childMenu = new LinkedList<>();

        for (TbIocMobileBackhaulTtc mu : menuList) {
            //遍历出父id等于参数的id，add进子节点集合
            if (mobileBackhaulTtc.getTtcId().equals(mu.getParentId())) {
                //递归遍历下一级
                treeMenuList(menuList, mu);
                childMenu.add(mu);
            }
        }
        return childMenu;
    }

    @Override
    public List<TbIocMobilePerforBadMsg> badmsgData(String treg, String type) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("treg", treg);
        params.put("type", type);
        String where = "treg=:treg and perforType =:type ";
        return tbIocMobilePerforBadMsgDao.findAll(where, params, null);
    }
}
