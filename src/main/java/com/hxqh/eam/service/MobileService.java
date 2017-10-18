package com.hxqh.eam.service;

import com.hxqh.eam.model.TbIocMobilePerforBadMsg;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.VMob86;
import com.hxqh.eam.model.view.VMob87;
import com.hxqh.eam.model.view.VMob87Class;
import com.hxqh.eam.model.view.VMob92;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface MobileService {

    Mob91Dto vMob91Data();

    Moblie92 vMob92Data();

    Mob86Dto vMob86Data();

    VMob87Dto vMob87Data();

    Mob88Dto getMob88Data();

    ThroughtputDto throughtputData();

    TopologicalDto topologicalData();

    List<TbIocMobilePerforBadMsg> badmsgData(String treg, String type);
}
