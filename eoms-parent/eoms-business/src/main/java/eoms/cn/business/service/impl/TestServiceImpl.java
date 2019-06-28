 package eoms.cn.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import eoms.cn.business.model.dto.TestDTO;
import eoms.cn.business.service.TestService;
import eoms.cn.commons.component.UidService;
import eoms.cn.commons.response.EomsResponse;
import eoms.cn.repository.entity.EverydayEeveryseatAchievement;
import eoms.cn.repository.service.EverydayEeveryseatAchievementService;
@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    private EverydayEeveryseatAchievementService everydayEeveryseatAchievementService;
    @Autowired
    private UidService uidService;
    @Override
    public EomsResponse<?> test(TestDTO dto) {
        // TODO Auto-generated method stub
        EverydayEeveryseatAchievement record = new EverydayEeveryseatAchievement();
        record.setId(uidService.genId());
        record.setProductId(uidService.genId());
        record.setProjectId(uidService.genId());
        record.setDynamic1("dong1");
        record.setDynamic2("dong2");
        record.setDynamicn("dongn");
        everydayEeveryseatAchievementService.insert(record);
        PageHelper.startPage(dto.getPageNum(), dto.getSize());
        record = everydayEeveryseatAchievementService.selectByPrimaryKey(record.getId().toString());
        return EomsResponse.createOkEomsResponse(record);
    }

}
