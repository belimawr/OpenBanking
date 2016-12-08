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
@WebServlet("/TransferConfirmServlet")
public class TransferConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			JSONObject jsonTransfer = (JSONObject) session.getAttribute("TransferObject");
			JSONObject jsonToken = JsonUtil.json(request);
			int token = jsonToken.getInt("token");

			String url = CONFIG.URL_TRANSFER.getValue();
			Builder accept = MyRestClient.createClientWithAuthentication(url);
			accept = accept.header("security-response", token);
			ClientResponse res = accept.put(ClientResponse.class, jsonTransfer);
			String resp = res.getEntity(String.class);
			JSONObject entity = new JSONObject(resp);
			System.out.println(entity);

			if (res.getStatus() == 200) {
				entity.put("account_number", jsonTransfer.getString("account_number"));
				entity.put("amount", jsonTransfer.getString("amount"));
			}

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

}
