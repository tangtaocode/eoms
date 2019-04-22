package eoms.cn.repository.common;

import java.util.List;

public interface CommonService<T> {
    int insertList(List<T> recordList);

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
