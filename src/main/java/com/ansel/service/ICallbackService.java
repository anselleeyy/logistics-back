package com.ansel.service;

import com.ansel.bean.CallbackInfo;

public interface ICallbackService {
	
	public boolean addInfo(CallbackInfo callbackInfo);
	
	public CallbackInfo findDetail(String goodsBillId, String type);

}
