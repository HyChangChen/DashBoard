package com.hxqh.eam.service;

import com.hxqh.eam.dao.VDig13Dao;
import com.hxqh.eam.dao.VDig14Dao;
import com.hxqh.eam.dao.VDig17Dao;
import com.hxqh.eam.dao.VDig18Dao;
import com.hxqh.eam.model.base.Status;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.VDig13;
import com.hxqh.eam.model.view.VDig14;
import com.hxqh.eam.model.view.VDig17;
import com.hxqh.eam.model.view.VDig18;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
@Service("digitalService")
public class DigitalServiceImpl implements DigitalService {
    static Logger logger = Logger.getLogger(DigitalServiceImpl.class);

    @Autowired
    private VDig13Dao vDig13Dao;
    @Autowired
    private VDig14Dao vDig14Dao;
    @Autowired
    private VDig17Dao vDig17Dao;
    @Autowired
    private VDig18Dao vDig18Dao;

    @Override
    public List<VDig13> digital13Data() {
        return vDig13Dao.findAll();
    }

    @Override
    public List<VDig14> vDig14Data() {
        return vDig14Dao.findAll();
    }

    @Override
    public List<VDig17> vDig17Data() {
        return vDig17Dao.findAll();
    }

    @Override
    public List<VDig18> vDig18Data() {
        return vDig18Dao.findAll();
    }

    //TODO  暂时未处理
    @Override
    public Dig13141718Dto vDig13141718Data() {
        List<VDig13> dig13List = vDig13Dao.findAll();
        Dig13Dto dig13Dto = new Dig13Dto(dig13List, Status.IOC13);

        List<VDig14> dig14List = vDig14Dao.findAll();
        Dig14Dto dig14Dto = new Dig14Dto(dig14List,Status.IOC14);

        List<VDig17> dig17List = vDig17Dao.findAll();
        Dig17Dto dig17Dto = new Dig17Dto(dig17List, Status.IOC17);

        List<VDig18> dig18List = vDig18Dao.findAll();
        Dig18Dto dig18Dto = new Dig18Dto(dig18List, Status.IOC18);

        Dig13141718Dto dig13141718Dto = new Dig13141718Dto(dig13Dto,dig14Dto,dig17Dto,dig18Dto);
        return dig13141718Dto;
    }
}
