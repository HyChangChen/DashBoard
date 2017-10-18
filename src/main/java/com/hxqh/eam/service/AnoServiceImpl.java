package com.hxqh.eam.service;

import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.*;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Service("anoService")
public class AnoServiceImpl implements AnoService {

    static Logger logger = Logger.getLogger(AnoServiceImpl.class);


    private static final String[] PILLLIST = {"R1", "R2", "R3", "R4", "R5", "R6", "R7"};
   // private static final String[] LINELIST = {"A", "B", "C", "D", "E", "F"};
    private static final String[] LINELIST = {"A", "B", "C", "D", "E"};
    @Autowired
    private VAno81Dao ano81Dao;
    @Autowired
    private VAno82Dao ano82Dao;
    @Autowired
    private VHomeImpactDao homeImpactDao;
    @Autowired
    private VHomeRegularDao homeRegularDao;
    @Autowired
    private VHomeTotalDao homeTotalDao;
    @Autowired
    private VMapOpenmaplineDao mapOpenmaplineDao;
    @Autowired
    private VMapOpenmaplinesLinecolorDao mapOpenmaplinesLinecolorDao;
    @Autowired
    private VMapOpenmappointDao mapOpenmappointDao;
    @Autowired
    private VMapOpenmaptableDao mapOpenmaptableDao;
    @Autowired
    private VMapOpenmaptableRighttableDao mapOpenmaptableRighttableDao;
    @Autowired
    private TbIocConsumerVoiceTrafficDao tbIocConsumerVoiceTrafficDao;
    @Autowired
    private TbIocProTicketFfmResultDao tbIocProTicketFfmResultDao;
    @Autowired
    private TbIocProTicketResultDao tbIocProTicketResultDao;
    @Autowired
    private TbIocProIndihomeDao proIndihomeDao;
    @Autowired
    private TbIocConsSrviewDao tbIocConsSrviewDao;
    @Autowired
    private TbIocProMonthlyDao iocProMonthlyDao;
    @Autowired
    private TbIocConsSrMoningDao iocConsSrMoningDao;
    @Autowired
    private TbIocProInstallDao iocProInstallDao;
    @Resource
    protected SessionFactory sessionFactory;

    @Override
    public List<VAno81> getAno81Data() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("ioc1", "desc");
        return ano81Dao.findAll(null,null,orderby);
    }

    @Override
    public List<VAno82> getAno82Data() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("ioc3", "desc");
        return ano82Dao.findAll(null,null,orderby);
    }

    @Override
    public IndiHomeDto getIndiHomeData() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("sh", "asc");


        List<VHomeImpact> homeImpact = homeImpactDao.findAll(null, null, orderby);
        List<VHomeRegular> homeRegular = homeRegularDao.findAll(null, null, orderby);
        List<VHomeTotal> homeTotal = homeTotalDao.findAll(null, null, orderby);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss", Locale.UK);
        String sDate = sdf.format(date);

        IndiHomeDto indiHomeDto = new IndiHomeDto(homeImpact, homeRegular, homeTotal, sDate);
        return indiHomeDto;
    }

    @Override
    public List<VMapOpenmappoint> getOpenMapPointsList() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("type", "asc");
        return mapOpenmappointDao.findAll(null, null, linkedHashMap);
    }

    @Override
    public List<VMapOpenmappoint> getRedPoint() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("type", "asc");

        Map<String, Object> params = new HashMap<>();
        params.put("status", "Down");
        String where = "status=:status";
        return mapOpenmappointDao.findAll(where, params, orderby);
    }

    @Override
    public OpenMapLinesDto getOpenMapLinesData() {
        List<VMapOpenmapline> mapOpenmapline = mapOpenmaplineDao.findAll();
        List<VMapOpenmaplinesLinecolor> mapOpenmaplinesLinecolor = mapOpenmaplinesLinecolorDao.findAll();
        OpenMapLinesDto mapLinesDto = new OpenMapLinesDto(mapOpenmapline, mapOpenmaplinesLinecolor);
        return mapLinesDto;
    }

    @Override
    public OpenMapTableDto getOpenMapTableData() {
        List<VMapOpenmaptable> mapOpenmaptable = mapOpenmaptableDao.findAll();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("dates", "desc");
        List<VMapOpenmaptableRighttable> mapOpenmaptableRighttable = mapOpenmaptableRighttableDao.findAll(null,null,orderby);
        //对mapOpenmaptable分组
        Map<String, List<VMapOpenmaptable>> mapOpenmaptableMap = GroupListUtil.group(mapOpenmaptable, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VMapOpenmaptable d = (VMapOpenmaptable) obj;
                return d.getType();    // 分组依据为Type
            }
        });
        Map<BigDecimal, List<VMapOpenmaptable>> tregMap = GroupListUtil.group(mapOpenmaptable, new GroupListUtil.GroupBy<BigDecimal>() {
            @Override
            public BigDecimal groupby(Object obj) {
                VMapOpenmaptable d = (VMapOpenmaptable) obj;
                return d.getTreg();    // 分组依据为Treg
            }
        });


        Map<String, List<BigDecimal>> mttrM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VMapOpenmaptable>> m : mapOpenmaptableMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VMapOpenmaptable l : m.getValue()) {
                mttrs.add(l.getNum());
            }
            mttrM.put(m.getKey(), mttrs);
        }
        Map<BigDecimal, List<BigDecimal>> tregM = new LinkedHashMap<>();
        for (Map.Entry<BigDecimal, List<VMapOpenmaptable>> m : tregMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VMapOpenmaptable l : m.getValue()) {
                mttrs.add(l.getNum());
            }
            tregM.put(m.getKey(), mttrs);
        }


        //对mttrM各组求和
        for (Map.Entry<String, List<BigDecimal>> m : mttrM.entrySet()) {
            BigDecimal sum = new BigDecimal(0);
            for (BigDecimal b : m.getValue()) {
                sum = sum.add(b);
            }
            List<BigDecimal> value = m.getValue();
            value.add(sum);
            mttrM.put(m.getKey(), value);
        }

        List<BigDecimal> columnSum = new LinkedList<>();
        for (Map.Entry<BigDecimal, List<BigDecimal>> m : tregM.entrySet()) {
            BigDecimal sumCol = new BigDecimal(0);
            for (BigDecimal b : m.getValue()) {
                sumCol = sumCol.add(b);
            }
            columnSum.add(sumCol);
        }

        //对columnSum求和
        BigDecimal sumCol = new BigDecimal(0);
        for (BigDecimal b : columnSum) {
            sumCol = sumCol.add(b);
        }
        columnSum.add(sumCol);

        mttrM.put("columnSum", columnSum);

        OpenMapTableDto openMapTableDto = new OpenMapTableDto(mttrM, mapOpenmaptableRighttable);
        return openMapTableDto;
    }

    @Override
    public VoiceDto getVoiceTrafficData() {
        List<TbIocConsumerVoiceTraffic> consumerVoiceTrafficList = tbIocConsumerVoiceTrafficDao.findAll();
        //对consumerVoiceTrafficList分组
        Map<String, List<TbIocConsumerVoiceTraffic>> listMap = GroupListUtil.group(consumerVoiceTrafficList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocConsumerVoiceTraffic d = (TbIocConsumerVoiceTraffic) obj;
                return d.getNode();    // 分组依据为Node
            }
        });

        Map<String, List<BigDecimal>> seizM = new LinkedHashMap<>();
        Map<String, List<BigDecimal>> answM = new LinkedHashMap<>();
        for (Map.Entry<String, List<TbIocConsumerVoiceTraffic>> m : listMap.entrySet()) {
            List<BigDecimal> seiz = new LinkedList<>();
            List<BigDecimal> answ = new LinkedList<>();

            for (TbIocConsumerVoiceTraffic l : m.getValue()) {
                seiz.add(l.getSeiz());
                answ.add(l.getAnsw());
            }
            seizM.put(m.getKey(), seiz);
            answM.put(m.getKey(), answ);
        }

        //获取nameliet
        String nameSQL = "select to_char(t.date_times,'yyyy-mm-dd') as name from TB_IOC_CONSUMER_VOICE_TRAFFIC t  where t.node = 'BD1S' order by t.voic_id";
        List<EnterpriseNameDto> nameList = sessionFactory.getCurrentSession().createSQLQuery(nameSQL).addEntity(EnterpriseNameDto.class).list();
        List<String> nList = new LinkedList<>();
        for (EnterpriseNameDto nameDto : nameList) {
            nList.add(nameDto.getName());
        }
        VoiceDto voiceDto = new VoiceDto(seizM, answM, nList);
        return voiceDto;
    }

    @Override
    public List<VMapOpenmappoint> mapPointsList(String mtype, String treg) {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("type", "asc");

        Map<String, Object> params = new HashMap<>();
        params.put("mtype", mtype);
        params.put("treg", treg);

        if ("TOTAL".equals(mtype)) {
            String where = "treg=:treg ";
            return mapOpenmappointDao.findAll(where, params, orderby);
        } else if (treg.equals("8")) {
            String where = "type=:mtype";
            return mapOpenmappointDao.findAll(where, params, orderby);
        } else {
            String where = "type=:mtype and treg=:treg";
            return mapOpenmappointDao.findAll(where, params, orderby);
        }

    }


    @Override
    public SolutionDto getSolutionData() {
        List<TbIocConsSrMoning> iocConsSrMoningList = iocConsSrMoningDao.findAll();
        //对iocConsSrMoningList分组
        Map<String, List<TbIocConsSrMoning>> listMap = GroupListUtil.group(iocConsSrMoningList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocConsSrMoning d = (TbIocConsSrMoning) obj;
                return d.getTitleType();    // 分组依据为TitleType
            }
        });

        String sql = "select t.regional,sum(t.ttl) as allttl from V_IOC_CONS_SR_MONING t group by t.REGIONAL order by  t.REGIONAL ";
        List<SrMoningDto> moningDtoList = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(SrMoningDto.class).list();

        String sqlSr = "select distinct(t.regional) ,t.SMS_OPEN as smsopen,t.SMS_BACKEND as smsbackend,t.EMAIL_OPEN as emailopen,t.EMAIL_BACKEND as emailbackend,t.REOPEN as reopen from V_IOC_CONS_SR_MONING t order by t.REGIONAL";
        List<SrDto> srDtoList = sessionFactory.getCurrentSession().createSQLQuery(sqlSr).addEntity(SrDto.class).list();
        //求和放入map中
        Map<String, TbIocConsSrMoning> sumMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<TbIocConsSrMoning>> map : listMap.entrySet()) {
            TbIocConsSrMoning sum = new TbIocConsSrMoning(0l, 0l, 0l, 0l, 0l, 0l,0l);
            for (TbIocConsSrMoning ele : map.getValue()) {
                sum.setA(sum.getA() + ele.getA());
                sum.setB(sum.getB() + ele.getB());
                sum.setC(sum.getC() + ele.getC());
                sum.setD(sum.getD() + ele.getD());
                sum.setE(sum.getE() + ele.getE());
                sum.setF(sum.getF() + ele.getF());
                sum.setTtl(sum.getTtl() + ele.getTtl());
            }
            sumMap.put(map.getKey(), sum);
        }
        //计算moningDtoList和
        Long sumtota = 0l;
        for (SrMoningDto s : moningDtoList) {
            sumtota += s.getAllttl();
        }
        SrTmpDto sum = new SrTmpDto(0, 0, 0, 0, 0);
        for (SrDto s : srDtoList) {
            sum.setEmailbackend(sum.getEmailbackend() + Integer.valueOf(s.getEmailbackend()));
            sum.setEmailopen(sum.getEmailopen() + Integer.valueOf(s.getEmailopen()));
            sum.setReopen(sum.getReopen() + Integer.valueOf(s.getReopen()));
            sum.setSmsbackend(sum.getSmsbackend() + Integer.valueOf(s.getSmsbackend()));
            sum.setSmsopen(sum.getSmsopen() + Integer.valueOf(s.getSmsopen()));
        }
        //返回sum List
        List<Object> sumList = new LinkedList<>();
        sumList.add(sumMap.get("DES"));
        sumList.add(sumMap.get("DBS"));
        sumList.add(sumMap.get("DCS_PLATINUM"));
        sumList.add(sumMap.get("DCS_GOLD"));
        sumList.add(sumMap.get("DCS_SILVER"));
        sumList.add(sumtota);
        sumList.add(sum);

        SolutionDto solutionDto = new SolutionDto(listMap, moningDtoList, srDtoList, sumList);
        return solutionDto;
    }


    @Override
    public RealtimeData realtimeData() {
        List<TbIocProTicketResult> ticketResults = tbIocProTicketResultDao.findAll();
        //对ticketResults分组
        Map<String, List<TbIocProTicketResult>> proactiveTicketMap = GroupListUtil.group(ticketResults, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocProTicketResult d = (TbIocProTicketResult) obj;
                return d.getChartType();    // 分组依据为ChartType
            }
        });

        /**************右上 完成**********************/
        List<TbIocProTicketResult> pieList = proactiveTicketMap.get("PIE");
        Map<String, List<TbIocProTicketResult>> pieMap = GroupListUtil.group(pieList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocProTicketResult d = (TbIocProTicketResult) obj;
                return d.getChartType();    // 分组依据为ChartType
            }
        });
        /**************右上 完成**********************/


        /**************左上 完成**********************/
        Map<String, List<Integer>> pillartM = new LinkedHashMap<>();
        //获取PILLAR信息再分组
        List<TbIocProTicketResult> pillartList = proactiveTicketMap.get("PILLAR");
        if (null != pillartList) {
            //对pillartList分组
            Map<String, List<TbIocProTicketResult>> pillartMap = GroupListUtil.group(pillartList, new GroupListUtil.GroupBy<String>() {
                @Override
                public String groupby(Object obj) {
                    TbIocProTicketResult d = (TbIocProTicketResult) obj;
                    return d.getTicketStatus();    // 分组依据为TicketStatus
                }
            });


            for (Map.Entry<String, List<TbIocProTicketResult>> m : pillartMap.entrySet()) {
                List<Integer> mttrs = new LinkedList<>();
                for (TbIocProTicketResult l : m.getValue()) {
                    mttrs.add(Integer.valueOf(l.getJumlah()));
                }
                pillartM.put(m.getKey(), mttrs);
            }
        }
        //pillartM返回
        /**************左上 完成**********************/


        /**************左下 完成**********************/
        List<TbIocProTicketFfmResult> ticketFfmResultDaoAll = tbIocProTicketFfmResultDao.findAll();

        List<String> name3List = new ArrayList<>();
        List<Integer> value3List = new ArrayList<>();
        for (int i = 0; i < ticketFfmResultDaoAll.size(); i++) {
            name3List.add(ticketFfmResultDaoAll.get(i).getTicketHourrs());
            value3List.add(Integer.valueOf(ticketFfmResultDaoAll.get(i).getJumlah()));
        }
        /**************左下 完成**********************/


        /**************右下完成**********************/
        //获取PILLAR信息
        List<TbIocProTicketResult> arcList = proactiveTicketMap.get("ARC");


        //获取name2List
        List<String> name2List = new LinkedList<>();
        if (null != pillartList) {
            for (int i = 0; i < pillartList.size(); i++) {
                if (pillartList.get(i).getTicketStatus().equals("OPEN")) {
                    name2List.add(pillartList.get(i).getXValue());
                }
            }
        }
        /**************右下完成**********************/

        RealtimeData realtimeData = new RealtimeData(name3List, value3List, pillartM, name2List, pieMap, arcList);
        return realtimeData;
    }

    @Override
    public MonthlyData monthlyData() {
        List<TbIocProMonthly> iocProMonthlyList = iocProMonthlyDao.findAll();
        MonthlyData monthlyData = new MonthlyData(iocProMonthlyList);
        return monthlyData;
    }

    @Override
    public Per7xData getPer7xData() {
        List<TbIocProIndihome> indihomeList = proIndihomeDao.findAll();
        //对proactiveTicketTktList1分组
        Map<String, List<TbIocProIndihome>> proactiveTicketMap = GroupListUtil.group(indihomeList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocProIndihome d = (TbIocProIndihome) obj;
                return d.getRegional();    // 分组依据为Regional
            }
        });
        Per7xData per7xData = new Per7xData(proactiveTicketMap);
        return per7xData;
    }

    @Override
    public ComplaintData getComplaintData() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("installId", "asc");
        List<TbIocProInstall> iocProInstallList = iocProInstallDao.findAll(null, null, orderby);
        //对iocProInstallList分组
        Map<String, List<TbIocProInstall>> listMap = GroupListUtil.group(iocProInstallList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocProInstall d = (TbIocProInstall) obj;
                return d.getTreg();    // 分组依据为Treg
            }
        });
        Map<String, List<BigDecimal>> listM = new LinkedHashMap<>();
        for (Map.Entry<String, List<TbIocProInstall>> m : listMap.entrySet()) {
            List<BigDecimal> numList = new LinkedList<>();
            for (int i = 0; i < m.getValue().size(); i++) {
                numList.add(m.getValue().get(i).getJmlPsb());
            }
            listM.put(m.getKey(), numList);
        }

        return new ComplaintData(listM);
    }

    @Override
    public SrviewDto getSrviewData() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("srviewId", "asc");

        List<TbIocConsSrview> consSrviewList = tbIocConsSrviewDao.findAll(null, null, orderby);
        Map<String, List<TbIocConsSrview>> stringListMap = GroupListUtil.group(consSrviewList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocConsSrview d = (TbIocConsSrview) obj;
                return d.getCharsType();    // 分组依据为CharsType
            }
        });

        //返回PILL
        //namePilllist
        Map<String, List<TbIocConsSrview>> pillMap = GroupListUtil.group(stringListMap.get("PILL"), new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocConsSrview d = (TbIocConsSrview) obj;
                return d.getServiceType();    // 分组依据为ServiceType
            }
        });

        Map<String, List<BigDecimal>> pillM = new LinkedHashMap<>();
        for (Map.Entry<String, List<TbIocConsSrview>> m : pillMap.entrySet()) {
            List<BigDecimal> numList = new LinkedList<>();
            for (int i = 0; i < m.getValue().size(); i++) {
                numList.add(m.getValue().get(i).getLevCount());
            }
            pillM.put(m.getKey(), numList);
        }


        //返回LINE

        //nameLineList
        //按照treg分组
        Map<String, List<TbIocConsSrview>> lineMap = GroupListUtil.group(stringListMap.get("LINE"), new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbIocConsSrview d = (TbIocConsSrview) obj;
                return d.getRegional();    // 分组依据为ServiceType
            }
        });

        Map<String, Map<String, List<TbIocConsSrview>>> mapMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<TbIocConsSrview>> m : lineMap.entrySet()) {
            Map<String, List<TbIocConsSrview>> tmp = GroupListUtil.group(m.getValue(), new GroupListUtil.GroupBy<String>() {
                @Override
                public String groupby(Object obj) {
                    TbIocConsSrview d = (TbIocConsSrview) obj;
                    return d.getServiceType();    // 分组依据为ServiceType
                }
            });
            mapMap.put(m.getKey(), tmp);
        }


        Map<String, Map<String, List<BigDecimal>>> lineM = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, List<TbIocConsSrview>>> entry : mapMap.entrySet()) {
            Map<String, List<BigDecimal>> tmp = new LinkedHashMap<>();
            for (Map.Entry<String, List<TbIocConsSrview>> m : entry.getValue().entrySet()) {
                List<BigDecimal> lineList = new LinkedList<>();
                for (int i = 0; i < m.getValue().size(); i++) {
                    lineList.add(m.getValue().get(i).getLevCount());
                }
                tmp.put(m.getKey(), lineList);
            }
            lineM.put(entry.getKey(), tmp);
        }

        SrviewDto srviewDto = new SrviewDto(PILLLIST, pillM, LINELIST, lineM);
        return srviewDto;
    }

}
