package user.registration.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import user.registration.model.Users;

/*Class implementing CRUD operations on mongo database*/
@Repository("userServiceImpl")
public class UsersServiceImpl implements UserService {

	protected static Logger logger = Logger.getLogger("userServiceImpl");

	@Autowired
	private MongoTemplate mongoTemplate;

	// adding a new user
	@Override
	public boolean addUser(Users user) {

		try {
			if (user.getId() == null && user.getId() == "") {

				// generate a random id and insert in db
				user.setId(UUID.randomUUID().toString());

			}

			mongoTemplate.insert(user);

			return true;
		} catch (Exception e) {
			logger.debug("Insertion into db failed");
			return false;
		}
	}

	//find all users
	@Override
	public List<Users> findAll() {
		try {
			return mongoTemplate.findAll(Users.class);
		} catch (Exception e) {
			logger.debug("retrieval from db failed");
			return null;
		}
	}

	//find a user by id
	@Override
	public Users find(String id) {
		try {
			return mongoTemplate.findById(id, Users.class);
		} catch (Exception e) {
			logger.debug("retrieval from db failed");
			return null;
		}
	}

	//delete a user
	@Override
	public void delete(Users user) {
		mongoTemplate.remove(user);
		
	}

	//edit user details
	@Override
	public void edit(Users user) {
		mongoTemplate.save(user);
		
	}

}
