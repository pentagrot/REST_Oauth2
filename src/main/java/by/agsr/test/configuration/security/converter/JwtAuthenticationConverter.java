package by.agsr.test.configuration.security.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class JwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt source) {
        return new JwtAuthenticationToken(source, getAuthorities(source));
    }

    private List<SimpleGrantedAuthority> getAuthorities(Jwt source) {
        Map<String, Object> realmAccess = (Map<String, Object>) source.getClaims().getOrDefault("realm_access", Map.of());
        Collection<String> realmRoles = (Collection<String>) realmAccess.getOrDefault("roles", List.of());
        return realmRoles.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
}
