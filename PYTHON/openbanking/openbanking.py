# -*- encoding: utf-8 -*-
import requests
import config


def request_access_token(payload):
    '''
    Com o auth_code eu posso solicitar um access_token
    '''
    r = requests.post(config.access_token_url, json=payload)
    if r.status_code != 200:
        print 'Não foi possível autenticar a sua conta...'
        return None
    access_token_respose = r.json()
    print access_token_respose
    access_token = access_token_respose['access_token']
    print 'Access Token {0}'.format(access_token)
    return access_token


def balance(access_token, developer_key):
    '''
    Chamada para a API de saldo com o access_token em mãos
    '''
    r = requests.get(config.balance_url, headers={'Authorization': access_token, 'developer-key': developer_key})
    if r.status_code != 200:
        print 'Não foi possível obter seu saldo...'
        return None
    balance_respose = r.json()
    actual_balance = balance_respose['current_balance']
    print 'Saldo {0}'.format(actual_balance)
    return actual_balance
