package vttp.batch5.ssf.noticeboard.services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.validation.Valid;
import vttp.batch5.ssf.noticeboard.Constants.Constant;
import vttp.batch5.ssf.noticeboard.models.Notice;
import vttp.batch5.ssf.noticeboard.repositories.NoticeRepository;

@Service
public class NoticeService {

	// TODO: Task 3
	// You can change the signature of this method by adding any number of parameters
	// and return any type

    RestTemplate restTemplate = new RestTemplate(); 
	public List<Notice> postToNoticeServer(Notice entity) {
		String noticeRawData = restTemplate.getForObject(Constant.noticeUrl, String.class);
		JsonReader jReader = Json.createReader(new StringReader(noticeRawData));  
		
        JsonObject jObject = jReader.readObject();  
		JsonObject jResultObject = jObject.getJsonObject("result");  
        JsonArray jArray = jResultObject.getJsonArray("records");

		List<Notice> notice = new ArrayList<>();

		for (int i = 0; i < jArray.size(); i++) {  
            JsonObject j = jArray.get(i).asJsonObject();

			Notice n = new Notice();
	
	notice.add(n);
	}
	return notice;
}
	public List<Notice> postToNoticeServer() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'postToNoticeServer'");
	}

}
