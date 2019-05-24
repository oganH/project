package com.zbev.core.query;

import lombok.Data;

/**
 * Created by Xulm on  2019/4/4
 */
@Data
public class QueryParam {
    private String prefix;           //前缀 AND 或 OR
    private String field;           //查询条件
    private String expression;      //表达式  > 或 LIKE
    private Object value;           //查询参数

    public QueryParam(String prefix, String field, String expression, Object value) {
        this.prefix = prefix;
        this.field = field;
        this.expression = expression;
        this.value = value;
    }
}
