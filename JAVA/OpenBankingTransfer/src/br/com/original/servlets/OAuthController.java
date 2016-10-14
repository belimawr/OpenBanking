package br.com.original.servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;

import br.com.original.CONFIG;
import br.com.original.database.FakeDatabase;
import br.com.original.restclient.MyRestClient;

@WebServlet("/OAuthController")
public class OAuthController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * OAuth callback
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getSession().invalidate();
			HttpSession session = request.getSession(true);
			String queryString = request.getQueryString();
			String[] split = queryString.split("&");
			for (String string : split) {
				if(string.split("=").length > 1) {
					session.setAttribute(string.split("=")[0], string.split("=")[1]);
				}
			}

			OpenBankingToken bankingToken = new OpenBankingToken();
			bankingToken.authCode = (String) session.getAttribute("auth_code");
			bankingToken.uid = (String) session.getAttribute("uid");

			Builder client = MyRestClient.createClient(CONFIG.URL_ACCESS_TOKEN.getValue());
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("uid", bankingToken.uid);
			jsonObject.put("auth_code", bankingToken.authCode);
			jsonObject.put("developer_key", CONFIG.DEV_APP_KEY.getValue());
			jsonObject.put("secret_key", CONFIG.DEV_APP_SECRET_KEY.getValue());

			ClientResponse post = client.post(ClientResponse.class, jsonObject);
			JSONObject entity = post.getEntity(JSONObject.class);
			String accessToken = entity.getString("access_token");
			bankingToken.accessToken = accessToken;
			bankingToken.serialize();
			System.out.println(bankingToken);
			FakeDatabase.attributes.put("ACCESSTOKEN", bankingToken.accessToken);
			response.sendRedirect("/OpenBankingTransfer/transferencia.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/OpenBankingTransfer/500.jsp");
		}
	}

	/**
	 * Redirect to OAuth2.0
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StringBuilder r = new StringBuilder();
			r.append("?callback_url=" + URLEncoder.encode(CONFIG.URL_CALLBACK.getValue(), "UTF-8"));
			r.append("&scopes=account,transfer");
			r.append("&developer_key=" + CONFIG.DEV_APP_KEY.getValue());
			response.sendRedirect(CONFIG.URL_OAUTH.getValue() + r.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/OpenBankingTransfer/500.jsp");
		}
	}

}
