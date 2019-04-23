 package eoms.cn.business.service;

import eoms.cn.business.model.dto.TestDTO;
import eoms.cn.commons.response.EomsResponse;

public interface TestService {
 /**
  * 测试使用   
  * @param dto
  * @return
  */
 EomsResponse<?> test(TestDTO dto);
}
