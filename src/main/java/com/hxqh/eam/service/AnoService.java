package com.hxqh.eam.service;

import com.hxqh.eam.model.ComplaintData;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.VAno81;
import com.hxqh.eam.model.view.VAno82;
import com.hxqh.eam.model.view.VMapOpenmappoint;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface AnoService {

    List<VAno81> getAno81Data();

    List<VAno82> getAno82Data();

    IndiHomeDto getIndiHomeData();

    List<VMapOpenmappoint> getOpenMapPointsList();

    OpenMapLinesDto getOpenMapLinesData();

    OpenMapTableDto getOpenMapTableData();

    VoiceDto getVoiceTrafficData();

    List<VMapOpenmappoint> mapPointsList(String mtype, String treg);

    List<VMapOpenmappoint> getRedPoint();

    SolutionDto getSolutionData();

    RealtimeData realtimeData();

    MonthlyData monthlyData();

    Per7xData getPer7xData();

    ComplaintData getComplaintData();

    SrviewDto getSrviewData();
}
