package com.javatechie.azure.demo;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@SpringBootApplication
@RestController
@EnableJpaRepositories("com.javatechie.azure.demo")
public class RBMDonationApplication {
	static RBMDonationService rbmDonation;

	@Autowired
	RBMDonationService rbmDonationService;

	@Autowired
	RBMDonationService service;

	@PostConstruct
	private void init() {
		rbmDonation = this.rbmDonationService;
	}
	public static void main(String[] args) {
		SpringApplication.run(RBMDonationApplication.class, args);
		//rbmDonationService = new RBMDonationServiceImpl();
		//rbmDonationService.save();
		//demo();
	}

	@CrossOrigin
	@GetMapping("/getusers")
	ResponseEntity getusers(){
//		UserEntity devote1 = new UserEntity(null, "Shri", "Akash", null, "Saha","345, Bhuiadih P.O. Agrico",
//				"Jamshedpur-831009, Jharkhand",43545346L,"Jamshedpur","Jharkhand",9431755184L,"akashsaha@gmil.com",
//				"AADHAR","354576582323543");
//		UserEntity devote2 = new UserEntity(null, null, "Puja", null, "Singh","6-1/2, Vaisali Hsg. Complex, Tentultala, P.O.R- Gopalpur",
//				"",235346L,"Kolkata","West Bengal",9163697077L,null,null,null);
//		ArrayList<UserEntity> devotes = new ArrayList<>();
//		devotes.add(devote1);
//		devotes.add(devote2);

		return new ResponseEntity(service.getUserList(), HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/getuser")
	ResponseEntity getuser(@RequestParam("id") long id){
//		UserEntity devote1 = new UserEntity(null, "Shri", "Akash", null, "Saha","345, Bhuiadih P.O. Agrico",
//				"Jamshedpur-831009",235346L,"Jamshedpur","Jharkhand",9431755184L,"akashsaha@gmil.com",
//				"AADHAR","354576582323543");
		return new ResponseEntity(service.getUser(id), HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/searchUser")
	ResponseEntity searchUser(@RequestParam("searchString") String searchString){
//		UserEntity devote1 = new UserEntity(null, "Shri", searchString, null, "Saha","345, Bhuiadih P.O. Agrico",
//				"Jamshedpur-831009, Jharkhand",95422L,"Jamshedpur","Jharkhand",9431755184L,"akashsaha@gmil.com",
//				"AADHAR","354576582323543");
		return new ResponseEntity(service.searchUser(searchString), HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/getLastDonation")
	ResponseEntity getLastDonation(@RequestParam("id") long id){
		//int res = 50;
		return new ResponseEntity(service.getLastDonation(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/addDonation")
	ResponseEntity addDonation(@RequestBody() String donation) throws ParseException, java.text.ParseException {
		return new ResponseEntity(service.saveDontion(donation), HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/adduser")
	ResponseEntity adduser(@RequestBody() String  user) {
		return new ResponseEntity(service.saveUser(user), HttpStatus.CREATED);
	}
}
