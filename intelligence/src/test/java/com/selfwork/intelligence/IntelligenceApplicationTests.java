package com.selfwork.intelligence;

import com.selfwork.intelligence.biz.ExchangeEtlBiz;
import com.selfwork.intelligence.biz.ResourceBiz;
import com.selfwork.intelligence.model.po.ExchangerEtlPO;
import com.selfwork.intelligence.model.po.ResourcePO;
import com.selfwork.intelligence.model.vo.BaseResultVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntelligenceApplicationTests {

	@Autowired
	private ResourceBiz resourceBiz;

	@Autowired
	private ExchangeEtlBiz exchangeEtlBiz;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testApplyDataExchange(){
		ResourcePO po =new ResourcePO();
		po.setSourceExchangerCode("EX001");
		po.setSourceExchangerName("EX001");
		po.setDatasetCode("qb_sj_rhmb");
		po.setDatasetName("情报_数据_融合目标表");
		po.setCommitUser("admin");
		po.setCommitUserName("系统管理员");


		BaseResultVo vo =resourceBiz.applyDataExchange(po);
		String a = "1";
	}

	@Test
	public void  testFindListByExchangeId(){

	}
}
