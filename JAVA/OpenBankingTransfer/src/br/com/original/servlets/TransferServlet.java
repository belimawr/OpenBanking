package br.com.original.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;

import br.com.original.CONFIG;
import br.com.original.restclient.MyRestClient;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = CONFIG.URL_TRANSFER.getValue();
			Builder accept = MyRestClient.createClientWithAuthentication(url);
			JSONObject jsonObject = JsonUtil.json(request);
			
			ClientResponse res = accept.post(ClientResponse.class, jsonObject);
			String resp = res.getEntity(String.class);
			JSONObject entity = new JSONObject(resp);
			entity.put("account_number", jsonObject.getString("account_number"));
			entity.put("amount", jsonObject.getString("amount"));
			entity.put("comments", jsonObject.getString("comments"));
			System.out.println(entity);

			setSession(request, jsonObject);

			response.setContentType("application/json");
			response.setStatus(res.getStatus());
			PrintWriter out = response.getWriter();
			out.print(entity);
			out.flush();
		} catch (IllegalStateException e) {
			e.printStackTrace();
			response.setStatus(400);
		} catch (JSONException e) {
			e.printStackTrace();
			response.setStatus(500);
		}
	}

	private void setSession(HttpServletRequest request, JSONObject jsonObject) throws JSONException {
		HttpSession session = request.getSession(false);
		session.setAttribute("TransferObject", jsonObject);
	}

}
