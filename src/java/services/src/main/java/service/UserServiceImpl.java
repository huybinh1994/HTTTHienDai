package service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public String login(String user) {
		// check login
		//check ok
		return Sha256.convertSha256(user);
	}

}
