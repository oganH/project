package com.zbev.core.enums.global;

/**
 * 订单关闭策略
 * @author 杨龙
 *
 */
public enum CLOSE_ORDER_STRATEGY {
	
	/**
	 * 正常默认结算策略：
	 * 1. 拔枪
	 * 2. 桩状态转变为空闲
	 */
	NORMAL {
		public String getNameResourceId() {
			return "phrase.close.order.strategy.normal";
		}
	},
	
	/**
	 * 适用于插拔枪时充电桩未上电的特殊结算策略：
	 * 1. NORMAL策略所有适用情况
	 * 2. 90秒未有数据通讯则结算订单
	 */
	POWEROFF {
		public String getNameResourceId() {
			return "phrase.close.order.strategy.poweroff";
		}
	};
	
	/**
	 * 获取枚举名称资源KEY
	 * @return
	 */
	public abstract String getNameResourceId();

}
