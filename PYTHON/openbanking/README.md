Rodando o exemplo
=================


Crie um [virtualenvironment](http://docs.python-guide.org/en/latest/dev/virtualenvs/) com Python 3.
Subistitua ``/usr/bin/python3`` pelo caminho do seu Python 3.
```
virtualenv -p /usr/bin/python3 venv
source venv/bin/activate
```

Instale as dependências:
```
pip install -r requirements.txt
```

Rode o servidor:
```
python server.py
```

Abra o browser em ``http://localhost:8000/`` e divirta-se!
