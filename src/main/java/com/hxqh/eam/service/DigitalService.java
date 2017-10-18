package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.Dig13141718Dto;
import com.hxqh.eam.model.view.VDig13;
import com.hxqh.eam.model.view.VDig14;
import com.hxqh.eam.model.view.VDig17;
import com.hxqh.eam.model.view.VDig18;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface DigitalService {

    List<VDig13> digital13Data();

    List<VDig14> vDig14Data();

    List<VDig17> vDig17Data();

    List<VDig18> vDig18Data();

    Dig13141718Dto vDig13141718Data();

}
