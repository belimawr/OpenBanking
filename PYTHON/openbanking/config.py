import os

#OAuth
developer_key = os.getenv('DEVELOPER_KEY')
secret_key = os.getenv('SECRET_KEY')
callback_url = "http://localhost:8000/callback"
callback_id = "xyz"


#URLs
oauth_url = 'https://sb-autenticacao-api.original.com.br/OriginalConnect?developer_key={0}&callback_url={1}&callback_id={2}'
access_token_url = 'https://sb-autenticacao-api.original.com.br/OriginalConnect/AccessTokenController'
balance_url = 'https://sandbox.original.com.br/accounts/v1/balance'
