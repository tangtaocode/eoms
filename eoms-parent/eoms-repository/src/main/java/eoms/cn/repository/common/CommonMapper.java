package eoms.cn.repository.common;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

@RegisterMapper
public interface CommonMapper<T> extends Mapper<T>,IdsMapper<T> {
    /**
     * 可批量插入预创建id集合
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = SpecialBatchInsert.class, method = "dynamicSQL")
    int insertBatchList(List<T> recordList);
}
