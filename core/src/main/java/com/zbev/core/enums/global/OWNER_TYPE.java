package com.zbev.core.enums.global;

/**
 * 所有者类型
 * 涉及到最终费用结算
 * @author 杨龙
 *
 */
public enum OWNER_TYPE {
	
	/**
	 * 用户自有
	 */
	SELF_USER {
		public String getNameResourceId() {
			return "phrase.station.owner.type.self.user";
		}
	},
	
	/**
	 * EN+公司自有
	 */
	SELF_COMPANY {
		public String getNameResourceId() {
			return "phrase.station.owner.type.self.company";
		}
	},
	
	/**
	 * 其他公司所有
	 */
	OTHER_COMPANY {
		public String getNameResourceId() {
			return "phrase.station.owner.type.other.company";
		}
	},
	
	/**
	 * 其他云平台所有
	 */
	OTHER_PLATFORM {
		public String getNameResourceId() {
			return "phrase.station.owner.type.other.platform";
		}
	};
	
	/**
	 * 获取枚举名称资源ID
	 * @return
	 */
	public abstract String getNameResourceId();

}
