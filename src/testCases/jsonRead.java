package testCases;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import driver.IOSLaunch;


public class jsonRead extends IOSLaunch {
	
	
	private static String filePath;
	
	private static Accounts account;
	private static MVPD mvp;
	
	public jsonRead(String filePath) {
		this.filePath = filePath;
		
	}
	
	
	public void readJsonFromFile(){
		
		try {
			
			FileReader reader = new FileReader(filePath);
		    JSONParser jsonParser = new JSONParser();
		    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		    JSONArray mvpds = (JSONArray) jsonObject.get("mvpds");
		    Iterator i= mvpds.iterator();
		    while ( mvpds.iterator().hasNext()) {
		    	
		    	JSONObject mvpJsonObject = (JSONObject)i.next();
		    	mvp = new MVPD(mvpJsonObject.get("name").toString());
		    	JSONObject accounts = (JSONObject) mvpJsonObject.get("accounts");
		    	JSONArray stage = (JSONArray) accounts.get("stage");
		    	JSONArray prod = (JSONArray) accounts.get("prod");
		    	Iterator j = stage.iterator();
		    	while (j.hasNext()){
		    	
		    		JSONObject obj = (JSONObject) j.next();
		    		account = new Accounts(obj.get("username").toString(),obj.get("password").toString());
		    		mvp.addAccounts(account);
		    	}	
		    	j = prod.iterator();
		    	while (j.hasNext()) {
		    	
		    		JSONObject obj = (JSONObject) j.next();
		    		account = new Accounts(obj.get("username").toString(),obj.get("password").toString());
		    		mvp.addAccounts(account);	
		    	}
		    	mvpd.add(mvp);    		
		    }
		    
		} catch (Exception e){
		        	System.out.println(e.getStackTrace().toString());
		}
		 
	}

}
