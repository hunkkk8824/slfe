package com.selfwork.intelligence;

import com.selfwork.intelligence.biz.ResourceBiz;
import com.selfwork.intelligence.model.po.ResourcePO;
import com.selfwork.intelligence.model.vo.BaseResultVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntelligenceApplicationTests {

	@Autowired
	private ResourceBiz resourceBiz;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testApplyDataExchange(){
		ResourcePO po =new ResourcePO();
		po.setSourceExchangerCode("EX001");
		po.setSourceExchangerName("前置机001");
		po.setDatasetCode("DT001");
		po.setDatasetName("数据集001");
		po.setCommitUser("admin");
		po.setCommitUserName("系统管理员");


		BaseResultVo vo =resourceBiz.applyDataExchange(po);
		String a = "1";
	}
}
