package eoms.cn.repository.common;

import java.util.List;
/**
 * 通用数据层接口
 * @author TTCODE
 * @date 2019/04/23
 */
public interface CommonService<T> {
    int insertBatchList(List<T> recordList);

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
