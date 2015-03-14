package br.ufrn.services.server.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class AmazonDynamoDBService {
	public String getItem(String accessKey, String secretKey, String keyItem){
		BasicAWSCredentials credentials=new BasicAWSCredentials(accessKey, secretKey);
		AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials);
		List<String> attributesToGet = new ArrayList<String>(
			    Arrays.asList("entryid", "entrylog", "date"));
			        
			HashMap<String, AttributeValue> key = new HashMap<String, AttributeValue>();
			key.put("entryid", new AttributeValue().withS(keyItem));
			String tableName="log";
			GetItemRequest getItemRequest = new GetItemRequest()
			    .withTableName(tableName)
			    .withKey(key)
			    .withAttributesToGet(attributesToGet)
			   ;

			GetItemResult result = client.getItem(getItemRequest);
			Map<String, AttributeValue> map = result.getItem();
			String res=map.get("entrylog").getS()+"-"+map.get("date").getS();
			return res;
	}
}
