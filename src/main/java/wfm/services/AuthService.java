package wfm.services;

import java.net.SocketException;
import wfm.payload.request.LoginRequest;
import wfm.payload.response.LoginResponse;

public interface AuthService {

	public LoginResponse authenticateUser(LoginRequest loginRequest)throws SocketException;
	public void Logout();
	public String retUserName();

	
}
