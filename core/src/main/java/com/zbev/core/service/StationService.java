package com.zbev.core.service;

import com.zbev.core.entity.Station;
import com.zbev.core.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlm on  2019/5/24
 */
@Service
public class StationService {

    @Autowired
    private StationMapper stationMapper;

    public List<Station> getStationList(){
        return stationMapper.listResult();
    }
}
