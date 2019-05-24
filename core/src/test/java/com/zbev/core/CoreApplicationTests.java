package com.zbev.core;

import com.zbev.core.entity.Station;
import com.zbev.core.mapper.StationMapper;
import com.zbev.core.query.QueryObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

    @Autowired
    private StationMapper stationMapper;

    @Test
    public void contextLoads() {
        List<Station> stationList = stationMapper.listResult();

        for (Station station:stationList){
            System.out.println(station.getStationName());
        }

    }

    @Test
    public void test(){
        QueryObject query = new QueryObject();
        query.addParamPrefixAndTo("companyCode",query.appendStr("GDZBKJ"));
        List<Station> stationList1 = stationMapper.queryListResult(query);

        System.out.println(stationList1.size());

    }

}
