package user.registration.service;

import java.util.List;

import user.registration.model.Users;

/*Interface representing CRUD opertaions*/
public interface UserService {
	
	public boolean addUser(Users user);
	
	public List<Users> findAll();
	
	public Users find(String id);
	
	public void delete(Users user);
	
	public void edit(Users user);
	
	
	
	

}
