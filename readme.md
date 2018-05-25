**simple authorization server

support only grant_type=client_credentials and password
default generated username is user, password is autogenerate

$ curl client:secret@localhost:8080/oauth/token -d grant_type=client_credentials -d username=user -d password=373eb60d-d8c1-4c50-bac6-41751278de27 -d scope=all