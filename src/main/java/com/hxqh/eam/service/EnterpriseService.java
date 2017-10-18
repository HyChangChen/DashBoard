
package com.hxqh.eam.service;


import com.hxqh.eam.model.dto.EntDto;
import com.hxqh.eam.model.dto.EnterpriseDto;

/**
 * Created by lh on 2017-6-27 .
 */
public interface EnterpriseService {


    EnterpriseDto getTopData(Integer show, String type);

    EntDto getEntData(String type);
}
