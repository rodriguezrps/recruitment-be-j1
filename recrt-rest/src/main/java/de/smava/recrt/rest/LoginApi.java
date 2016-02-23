package de.smava.recrt.rest;

import de.smava.recrt.service.resource.LoginResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by pvitic on 22.02.16.
 */
@RestController
@RequestMapping(value = "/rest/login" , produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
public class LoginApi {

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    public LoginResource getStatus() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !auth.getName().equals("anonymousUser") && auth.isAuthenticated()) {
            return new LoginResource(true, auth.getName());
        } else {
            return new LoginResource(false, null);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public LoginResource login(@RequestBody LoginResource request) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new LoginResource(auth.isAuthenticated(), auth.getName());
        } catch (BadCredentialsException e) {
            return new LoginResource(false, null);
        }
    }
}