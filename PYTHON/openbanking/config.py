
#OAuth
developer_key = ""
secret_key = ""
scopes = "account,transfer,investment"
callback_url = "http://localhost:8000/callback"
callback_id = "xyz"


#URLs
oauth_url = 'https://sb-autenticacao-api.original.com.br/OriginalConnect?developer_key={0}&scopes={1}&callback_url={2}&callback_id={3}'
access_token_url = 'https://sb-autenticacao-api.original.com.br/OriginalConnect/AccessTokenController'
balance_url = 'https://sandbox.original.com.br/accounts/v1/balance'
