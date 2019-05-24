package com.zbev.core.entity;

import com.zbev.core.enums.global.CLOSE_ORDER_STRATEGY;
import com.zbev.core.enums.global.OWNER_TYPE;
import com.zbev.core.enums.station.STATION_STATUS;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by xlm on  2019/5/24
 */
@Alias("Station")
@Getter@Setter
public class Station {

    private Long stationId;
    private String companyCode;					            //所属公司, VARCHAR(10)
    private OWNER_TYPE ownerType;				            //所有者类型, VARCHAR(30)
    private String stationName;					            //电站名称, VARCHAR(50)
    private Double latitude;					            //纬度数据
    private Double longitude;					            //经度数据
    private STATION_STATUS stationStatus;		            //电站状态，维护电站生命周期，VARCHAR(30)
    private Boolean allowSearch;				            //允许被搜索
    private Long elecFeeModelId;				            //充电收费模板ID
    private Long parkFeeModelId;				            //停车收费模板ID
    private String location;					            //电站位置, VARCHAR(255)
    private String contact;						            //联系人-管理人员, VARCHAR(30)
    private String contactPhoneNum;				            //联系人电话, VARCHAR(20)
    private String maintainer;					            //维护人员, VARCHAR(30)
    private String maintainerPhoneNum;			            //维护人员电话, VARCHAR(20)
    private Date createTime;					            //建站或计划建站时间
    private String platformCompanyCode;			            //平台商编码
    private Long bookStrategyId;                            //预约充电策略
    private CLOSE_ORDER_STRATEGY closeOrderStrategy;		//订单关闭策略
    private Integer stationStatisticStrategy;				//电站统计策略，统计结束时间点 —— 默认为0，即为按自然日统计，也可选择统计结束时间

    private Boolean smsWarningNotice;						//是否短信告警通知
    private Boolean wechatWarningNotice;					//是否微信告警通知
    private Boolean smsErrorNotice;							//是否短信告警通知
    private Boolean wechatErrorNotice;						//是否微信告警通知
    private Boolean test;                                 //测试站点
    private String imageId;                               //图片ID
}
