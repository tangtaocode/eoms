package eoms.cn.repository.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eoms.cn.repository.entity.EverydayEeveryseatAchievement;
import eoms.cn.repository.mapper.EverydayEeveryseatAchievementMapper;
import eoms.cn.repository.service.EverydayEeveryseatAchievementService;

@Repository
public class EverydayEeveryseatAchievementServiceImpl implements EverydayEeveryseatAchievementService {
    @Autowired
    private EverydayEeveryseatAchievementMapper everydayEeveryseatAchievementMapper;

    @Override
    public int insertList(List<EverydayEeveryseatAchievement> recordList) {
        // TODO Auto-generated method stub
        return everydayEeveryseatAchievementMapper.insertList(recordList);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return everydayEeveryseatAchievementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EverydayEeveryseatAchievement record) {
        // TODO Auto-generated method stub
        return everydayEeveryseatAchievementMapper.insert(record);
    }

    @Override
    public int insertSelective(EverydayEeveryseatAchievement record) {
        // TODO Auto-generated method stub
        return everydayEeveryseatAchievementMapper.insertSelective(record);
    }

    @Override
    public EverydayEeveryseatAchievement selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return everydayEeveryseatAchievementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EverydayEeveryseatAchievement record) {
        // TODO Auto-generated method stub
        return everydayEeveryseatAchievementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(EverydayEeveryseatAchievement record) {
        // TODO Auto-generated method stub
        return everydayEeveryseatAchievementMapper.updateByPrimaryKey(record);
    }

}
