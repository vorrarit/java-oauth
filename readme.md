**simple authorization server

support only grant_type=client_credentials, password
default generated username is user, password is autogenerate

$ curl client:secret@localhost:8080/oauth/token -d grant_type=client_credentials -d username=user -d password=373eb60d-d8c1-4c50-bac6-41751278de27 -d scope=all

**test calling resource api
$ curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user1 -d password=password -d scope=all
{"access_token":"fd131318-357a-48da-af82-185c09492ce7","token_type":"bearer","refresh_token":"3b140f4d-10ee-4583-b757-932bf6c672b3","expires_in":43199,"scope":"all"}

$ curl localhost:8080/user/me -H "Authorization: Bearer fd131318-357a-48da-af82-185c09492ce7" 
{"authorities":[{"authority":"ROLE_USER"}],"details":{"remoteAddress":"127.0.0.1","sessionId":null,"tokenValue":"fd131318-357a-48da-af82-185c09492ce7","tokenType":"Bearer","decodedDetails":null},"authenticated":true,"userAuthentication":{"authorities":[{"authority":"ROLE_USER"}],"details":{"grant_type":"password","username":"user1","scope":"all"},"authenticated":true,"principal":{"password":null,"username":"user1","authorities":[{"authority":"ROLE_USER"}],"accountNonExpired":true,"accountNonLocked":true,"credentialsNonExpired":true,"enabled":true},"credentials":null,"name":"user1"},"oauth2Request":{"clientId":"client","scope":["all"],"requestParameters":{"grant_type":"password","username":"user1","scope":"all"},"resourceIds":[],"authorities":[],"approved":true,"refresh":false,"redirectUri":null,"responseTypes":[],"extensions":{},"grantType":"password","refreshTokenRequest":null},"principal":{"password":null,"username":"user1","authorities":[{"authority":"ROLE_USER"}],"accountNonExpired":true,"accountNonLocked":true,"credentialsNonExpired":true,"enabled":true},"credentials":"","clientOnly":false,"name":"user1"}

**simple oauth client
browse https://rta-center.pakgon.com:8443 will automatically redirect to facebook for login / authorization

Spring Boot attaches a special meaning to a WebSecurityConfigurer on the class that carries the @EnableOAuth2Sso annotation: 
it uses it to configure the security filter chain that carries the OAuth2 authentication processor. 
So all we need to do to make our home page visible is to explicitly authorizeRequests() to the home page 
and the static resources it contains (we also include access to the login endpoints which handle the 
authentication). All other requests (e.g. to the /user endpoint) require authentication.