package com.example.test_rest;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.RestService;

@EBean
public class ApiHelper implements RestApi2{
	@RestService
	RestApi2 api;

	public ModelList[] getModels() {
		return api.getModels();
	}

	public ModelList[] getModels2(int collecttype, int collectstatus,
			String colleague, int gender, int uid) {
		return api.getModels2(collecttype, collectstatus, colleague, gender, 1);
	}

	public ModelList[] getModelsBylocation(int collecttype, int collectstatus,
			int gender, float locationX, float locationY, int uid) {
		return api.getModelsBylocation(collecttype, collectstatus, gender, locationX, locationY, 1);
	}

	public ModelDetail getDetail(int aid, int uid) {
		return api.getDetail(aid, 1);
	}
}
