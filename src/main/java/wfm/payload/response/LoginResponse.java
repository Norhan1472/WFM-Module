package wfm.payload.response;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import wfm.models.SC_USER_MODULE;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
	
	 private String username;
	 private Collection<? extends GrantedAuthority> authorities;
	 private List<SC_USER_MODULE> userModules;

	 public LoginResponse(String username, Collection<? extends GrantedAuthority> authorities,List<SC_USER_MODULE> userModules ) { 
		    this.username = username;
		    this.authorities = authorities; 
		    this.userModules=userModules;
	 }

}
