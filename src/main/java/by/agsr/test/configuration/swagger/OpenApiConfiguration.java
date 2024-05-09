package by.agsr.test.configuration.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Nikita",
                        email = "random@gmail.com"
                ),
                description = "Open API documentation for REST service with OAuth2",
                title = "REST service spec",
                version = "0.1"
        ),
        servers = {
                @Server(
                        description = "Local development server",
                        url = "http://localhost:8181"
                )
        },
        security = {
                @SecurityRequirement(name = "globalSecurity")
        }
)
@SecurityScheme(
        name = "globalSecurity",
        description = "OAuth2 authorisation",
        type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                password = @OAuthFlow(
                        tokenUrl = "${springdoc.oAuthFlow.tokenUrl}")
        )
)
public class OpenApiConfiguration {
}
