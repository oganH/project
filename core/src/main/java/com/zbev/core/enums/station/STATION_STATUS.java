package com.zbev.core.enums.station;

/**
 * 电站状态
 * 只有状态为NORMAL的电站才可能被寻桩搜索到
 * @author 杨龙
 *
 */
public enum STATION_STATUS {
	
	/**
	 * 规划
	 */
	PLAN {
		public String getNameResourceId() {
			return "phrase.station.status.plan";
		}
		public boolean isBookable() {
			return false;
		}
	},
	
	/**
	 * 修建
	 */
	BUILD {
		public String getNameResourceId() {
			return "phrase.station.status.build";
		}
		public boolean isBookable() {
			return true;
		}
	},
	
	/**
	 * 不受EN+后台控制的电站，提供用户查看
	 */
	VIEW_ONLY {
		public String getNameResourceId() {
			return "phrase.station.status.view.only";
		}
		public boolean isBookable() {
			return false;
		}
	},
	
	/**
	 * 正常运营
	 */
	WORKING {
		public String getNameResourceId() {
			return "phrase.station.status.working";
		}
		public boolean isBookable() {
			return true;
		}
	},
	
	/**
	 * 故障
	 */
	FAULT {
		public String getNameResourceId() {
			return "phrase.station.status.fault";
		}
		public boolean isBookable() {
			return true;
		}
	},
	
	/**
	 * 维护，维修
	 */
	MAINTAIN {
		public String getNameResourceId() {
			return "phrase.station.status.maintain";
		}
		public boolean isBookable() {
			return false;
		}
	},
	
	/**
	 * 停用
	 */
	DEACTIVATED {
		public String getNameResourceId() {
			return "phrase.station.status.deactivated";
		}
		public boolean isBookable() {
			return false;
		}
	},

	TEST {
		public String getNameResourceId() {
			return "phrase.station.status.test";
		}
		public boolean isBookable() {
			return true;
		}
	};
	
	/**
	 * 获取枚举名字资源ID
	 * @return
	 */
	public abstract String getNameResourceId();
	
	/**
	 * 当前电站状态下是否可预约充电
	 * @return
	 */
	public abstract boolean isBookable();

}
