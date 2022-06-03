package com.example.User.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.Model.User;
import com.example.User.Repository.UserRepository;

@Service
public class UserServicesImps implements UserServices {

	EntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void CreateUser(User user) {
		User fromDb = new User();
		fromDb.setIdNumber(user.getIdNumber());
		fromDb.setCountry(user.getCountry());
		fromDb.setAddress(user.getAddress());
		fromDb.setDateBirthDay(user.getDateBirthDay());
		fromDb.setFirstName(user.getFirstName());
		fromDb.setLastName(user.getLastName());
		fromDb.setGender(user.getGender());
		fromDb.setMarialStatus(user.getMarialStatus());
		fromDb.setSalutation(user.getSalutation());
//		DataResponse dataResponse = new DataResponse();
//		dataResponse.setData(userRepository.save(fromDb));
		userRepository.save(fromDb);
	}

	@Override
	public void EditUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void saveUser(User user) {

		userRepository.save(user);
	}

	@Override
	public Optional<User> findByUserId(Long id) {
		return userRepository.findById(id);

	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);

	}

	public UserServicesImps(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<User> findAllUser() {

		return userRepository.findAll();
	}

	
}
