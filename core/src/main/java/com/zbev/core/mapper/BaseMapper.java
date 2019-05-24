package com.zbev.core.mapper;

import com.zbev.core.query.QueryObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xlm on  2019/5/24
 */
public interface BaseMapper<T> {

    /**
     *  保存一条记录
     * @param entity
     */
    public void insert(T entity);

    /**
     *  根据参数更新数据
     * @param query
     */
    public void update(QueryObject query);

    /**
     *  根据id删除一条数据
     * @param id
     */
    public void deleteByKey(Serializable id);

    /**
     *  根据参数删除数据
     * @param query
     */
    public void delete(QueryObject query);

    /**
     *  统计数据条数
     * @return
     */
    public Long count();

    /**
     *  根据条件统计数据条数
     * @param query
     * @return
     */
    public Long queryCount(QueryObject query);

    /**
     *  根据id获取一条数据
     * @param id
     * @return
     */
    public T getRecord(Serializable id);

    /**
     *  根据参数获取一条数据
     * @param query
     * @return
     */
    public T queryRecord(QueryObject query);

    /**
     *  获取数据集合
     * @return
     */
    public List<T> listResult();

    /**
     *  根据参数获取数据集合
     * @param query
     * @return
     */
    public List<T> queryListResult(QueryObject query);
}
