package de.smava.recrt.rest.security;

import de.smava.recrt.persistence.model.AppUser;
import de.smava.recrt.persistence.model.AppUserRole;
import de.smava.recrt.persistence.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null){
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = getRoles(appUser);
        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }

    private List<GrantedAuthority> getRoles(AppUser appUser){
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<AppUserRole> roles = appUser.getAppUserRoles();
        if (roles !=null && !roles.isEmpty()){
            for (AppUserRole role : roles){
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return  authorities;
    }
}
