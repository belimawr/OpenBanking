package br.com.original.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

class JsonUtil {

	static JSONObject json(HttpServletRequest request){
		BufferedReader reader = null;
		try {
			reader = request.getReader();
			StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	        String json = sb.toString();
	    	System.out.println(json);
	    	reader.close();
	    	JSONObject jsonObject = new JSONObject(json);
	    	return jsonObject;
		} catch (IOException e) {
			e.printStackTrace();
	    } catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
