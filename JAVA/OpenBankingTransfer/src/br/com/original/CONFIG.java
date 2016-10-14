package br.com.original;

public enum CONFIG {

	URL_OAUTH("https://sb-autenticacao-api.original.com.br/OriginalConnect"),
	URL_ACCESS_TOKEN("https://sb-autenticacao-api.original.com.br/OriginalConnect/AccessTokenController"),
	URL_CALLBACK("http://localhost:9090/OpenBankingTransfer/OAuthController"),

	DEV_APP_KEY(""),
	DEV_APP_SECRET_KEY(""),

	URL_TRANSFER("https://sandbox.original.com.br/payments/v1/money-transfer/between-accounts");

	private String value;

	private CONFIG(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
