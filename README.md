## REST service with CRUD operations with Oauth2 authorization
### Application setup
Application consists of 3 parts : 
  - REST service (Sping Boot web application)
  - Database (PostgreSQL)
  - Authorisation server (Keycloak)

### Start with docker-compose
Application can be started with docker-compose file located in src/main/docker/docker-compose.yml.<br>
Before starting docker-compose you need to build application and put artifacts in src/main/docker frolder.<br>
You can start application from src/main/docker directory with folowing command :
```
docker-compose up
```

### Keycloak setup

#### Default configuration
Keycloak web console interface can be accessed with admin/admin credentials!<br>
Application works with Keycloak realm 'test_realm'. <br>
Default configuration for 'test_realm' located in src/main/docker/imports/realm-export.json file.<br>
Configuration will by imported by default, when docker container with Keycloak server starts.<br>

#### Users setup
This configuration inports 'test_realm' with roles and 'test_clien' client, but without users! Users must be created mannualy.<br>
For authorization purposes evry created user must have non-temporary password!

### Database population
For database pupulation simple console application [REST_Oauth2_Populator](https://github.com/pentagrot/REST_Oauth2_Populator/tree/main) can be used.
