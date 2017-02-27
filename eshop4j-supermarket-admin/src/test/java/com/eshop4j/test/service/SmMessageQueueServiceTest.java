package com.eshop4j.test.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.eshop4j.test.TestSupport;
import com.eshop4j.web.enums.AppTypeEnum;
import com.eshop4j.web.enums.MsgModuleEnum;
import com.eshop4j.web.enums.PersonalMsgTypeEnum;
import com.eshop4j.web.response.CommonTCSResult;
import com.eshop4j.web.service.SmMessageQueueService;

public class SmMessageQueueServiceTest extends TestSupport{
	@Resource
	private SmMessageQueueService smMessageQueueService;
	
	  @Test
	    public void testSysMsgPage() throws Exception {
	    	start();
	    	System.out.println(smMessageQueueService.sendSingleMessage("18822898541", AppTypeEnum.INVESTOR, MsgModuleEnum.REGISTER,  "456789").getMessage());
	        end();
	    }
	  
	  @Test
	    public void testBatchSend() throws Exception {
	    	start();
	    	ImmutableList<String> of = ImmutableList.of("18576651144", "10000000004", "10000000003", "10000000002");
	    	CommonTCSResult relt =  smMessageQueueService.batchSendMessage(of, AppTypeEnum.INVESTOR, MsgModuleEnum.RECIVEREDPAPERBYLCS, "100");
	    	System.out.println(relt.getCode());
	    	System.out.println(relt.getMessage());
	    	
	        end();
	    }
	  
	  @Test
	    public void testBatchSend2() throws Exception {
	    	start();
	    	//List<String> mobils = new ArrayList<String>();
	    	//mobils.add("18822898541");
	    	//mobils.add("15818691769");
	    	ImmutableList<String> of = ImmutableList.of("18822898541", "18576651144");
	    	ImmutableList<String> userIds = ImmutableList.of("1d06a0942eb54adfa6eafabf2f959033", "5eb56d12c3ff4fd5b585350637bf67fd");
	    	CommonTCSResult relt =  smMessageQueueService.batchSendSmMessageAndPersonalMsg(of, AppTypeEnum.INVESTOR, MsgModuleEnum.RECIVEREDPAPERBYLCS,true,userIds,PersonalMsgTypeEnum.REDPACKET_INV,"100");
	    	System.out.println(relt.getCode());
	    	System.out.println(relt.getMessage());
	    	
	    	/*System.out.println(CharMatcher.inRange('a', 'z'));
	    	
	    	int[] numbers = { 1, 2, 3, 4, 5 };	    	
	    	String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
	    	
	    	System.out.println("result:"+numbersAsString);*/
	        end();
	    }
}
