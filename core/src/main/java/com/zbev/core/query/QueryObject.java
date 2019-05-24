package com.zbev.core.query;

import com.zbev.core.entity.Station;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xulm on  2019/4/3
 */
@Getter
public class QueryObject {

    private static final String GT = ">";
    private static final String LT = "<";
    private static final String NOT_TO = "<>";
    private static final String GT_TO = ">=";
    private static final String LT_TO = "<=";
    private static final String TO = "=";
    private static final String LIKE = " LIKE ";

    private static final String OR = "OR";
    private static final String AND = "AND";

    @Setter
    private String sort;
    @Setter
    private String order;
    @Setter
    private int offset;
    @Setter
    private int limit;

    private List<QueryParam> conditions = new ArrayList<>();


    public QueryObject() {

    }

    public QueryObject(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public QueryObject(String sort, String order, int offset, int limit) {
        this.sort = sort;
        this.order = order;
        this.offset = offset;
        this.limit = limit;
    }

    /**
     * 添加前缀为 and 表达式为 >
     *
     * @param field
     * @param value
     */
    public void addParamPrefixAndGt(String field, Object value) {
        createQueryParam(field, value, AND, GT);
    }

    public void addParamPrefixOrGt(String field, Object value) {
        createQueryParam(field, value, OR, GT);
    }

    /**
     * 添加前缀为 and 表达式为 >=
     *
     * @param field
     * @param value
     */
    public void addParamPrefixAndGtTo(String field, Object value) {
        createQueryParam(field, value, AND, GT_TO);
    }

    public void addParamPrefixOrGtTo(String field, Object value) {
        createQueryParam(field, value, OR, GT_TO);
    }

    /**
     * 添加前缀为 and 表达式为 <>
     *
     * @param field
     * @param value
     */
    public void addParamPrefixAndNotTo(String field, Object value) {
        createQueryParam(field, value, AND, NOT_TO);
    }


    public void addParamPrefixOrNotTo(String field, Object value) {
        createQueryParam(field, value, OR, NOT_TO);
    }

    /**
     * 添加前缀为 and 表达式为 <
     *
     * @param field
     * @param value
     */
    public void addParamPrefixAndLt(String field, Object value) {
        createQueryParam(field, value, AND, LT);
    }


    public void addParamPrefixOrLt(String field, Object value) {
        createQueryParam(field, value, OR, LT);
    }

    /**
     * 添加前缀为 and 表达式为 <=
     *
     * @param field
     * @param value
     */
    public void addParamPrefixAndLtTo(String field, Object value) {
        createQueryParam(field, value, AND, LT_TO);
    }


    public void addParamPrefixOrLtTo(String field, Object value) {
        createQueryParam(field, value, OR, LT_TO);
    }

    /**
     * 添加前缀为 and 表达式为 =
     *
     * @param field
     * @param value
     */
    public void addParamPrefixAndTo(String field, Object value) {
        createQueryParam(field, value, AND, TO);
    }


    public void addParamPrefixOrTo(String field, Object value) {
        createQueryParam(field, value, OR, TO);
    }


    public void addParamsAndLike(String field, Object value) {
        createQueryParam(field, value, AND, LIKE);
    }

    public void addParamsOrLike(String field, Object value) {
        createQueryParam(field, value, OR, LIKE);
    }

    public String appendStr(String value) {
        StringBuilder sb = new StringBuilder();
        return sb.append("'").append(value).append("'").toString();
    }

    private void createQueryParam(String field, Object value, String prefix, String exp) {
        if (StringUtils.isNotBlank(field) && StringUtils.isNotBlank(value.toString())) {
            QueryParam queryParam = new QueryParam(prefix, field, exp, value);
            conditions.add(queryParam);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(System.currentTimeMillis() / 1000);

        Class clazz = Station.class;

        Field[] fields = clazz.getDeclaredFields();

        List<String> props = new ArrayList<>();
        List<String> props1 = new ArrayList<>();
        List<String> props2 = new ArrayList<>();
        for (Field item : fields) {
            props.add(item.getName());
            props1.add("#{" + item.getName() + "}");
            props2.add(" <result column=\"" + item.getName() + "\" property=\"" + item.getName() + "\"/>");
        }
        System.out.println(StringUtils.join(props, ","));
        System.out.println(StringUtils.join(props1, ","));
        System.out.println(StringUtils.join(props2, "\n"));

    }
}
