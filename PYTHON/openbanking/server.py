# -*- encoding: utf-8 -*-

from bottle import route, run, redirect, template, request
import openbanking, config


@route('/')
def index():
    return ('<a href="/connect">Olá...veja seu saldo</a>')

@route('/connect')
def connect():
    url = config.oauth_url.format(config.developer_key, config.callback_url, config.callback_id)
    return redirect(url)

@route('/callback')
def callback():
    uid = request.query.uid
    auth_code = request.query.auth_code
    callback_id = request.query.callback_id

    payload = {'uid': uid, 'auth_code': auth_code, 'developer_key': config.developer_key, 'secret_key': config.secret_key}
    access_token = openbanking.request_access_token(payload)

    balance = openbanking.balance(access_token, config.developer_key)
    return ('Seu saldo atual é de {0}'.format(balance))

run(host='localhost', port=8000)

