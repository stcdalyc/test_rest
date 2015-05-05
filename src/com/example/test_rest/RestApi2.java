package com.example.test_rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Rest(rootUrl = "http://121.201.13.25/dianzizhizao", converters = { GsonHttpMessageConverter.class })
public interface RestApi2 {
	@Get("/portal.php?mod=list&catid=1&mobile=1&uid=1")
	ModelList[] getModels();

	@Get("/portal.php?mod=list&catid=1&mobile=1&uid={uid}&collecttype={collecttype}&collectstatus={collectstatus}&colleague={colleague}&gender={gender}")
	ModelList[] getModels2(int collecttype, int collectstatus, String colleague, int gender, int uid);
	
	@Get("/portal.php?mod=list&catid=1&mobile=1&uid={uid}&collecttype={collecttype}&collectstatus={collectstatus}&gender={gender}&locationX={locationX}&locationY={locationY}")
	ModelList[] getModelsBylocation(int collecttype, int collectstatus, int gender, float locationX, float locationY, int uid);
	
	@Get("portal.php?mod=view&aid={aid}&mobile=1&uid={uid}")
	ModelDetail getDetail(int aid, int uid);
}
