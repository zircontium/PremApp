package com.javatechie.azure.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class RBMDonationApplication {
	@Autowired
	private static RBMDonationService rbmDonationService;

	public static void main(String[] args) {
		SpringApplication.run(RBMDonationApplication.class, args);
		//demo();
	}

	@CrossOrigin
	@GetMapping("/getusers")
	ResponseEntity getusers(){
		UserEntity devote1 = new UserEntity(null, "Shri", "Akash", null, "Saha","345, Bhuiadih P.O. Agrico",
				"Jamshedpur-831009, Jharkhand","Jamshedpur","Jharkhand",9431755184L,"akashsaha@gmil.com",
				"AADHAR","354576582323543");
		UserEntity devote2 = new UserEntity(null, null, "Puja", null, "Singh","6-1/2, Vaisali Hsg. Complex, Tentultala, P.O.R- Gopalpur",
				"","Kolkata","West Bengal",9163697077L,null,null,null);
		ArrayList<UserEntity> devotes = new ArrayList<>();
		devotes.add(devote1);
		devotes.add(devote2);
		return new ResponseEntity(devotes, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/getuser")
	ResponseEntity getuser(){
		UserEntity devote1 = new UserEntity(null, "Shri", "Akash", null, "Saha","345, Bhuiadih P.O. Agrico",
				"Jamshedpur-831009, Jharkhand","Jamshedpur","Jharkhand",9431755184L,"akashsaha@gmil.com",
				"AADHAR","354576582323543");
		return new ResponseEntity(devote1, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/addDonation")
	ResponseEntity addDonation(@RequestParam("donation") DonationEntity donation){
		return new ResponseEntity(donation, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/adduser")
	ResponseEntity adduser(@RequestParam("user") UserEntity user){
		return new ResponseEntity(user, HttpStatus.CREATED);
	}

	public static void demo() {
			// save few users
		UserEntity person1 = new UserEntity(null, "Shri", "Akash", null, "Saha","345, Bhuiadih P.O. Agrico",
				"Jamshedpur-831009, Jharkhand","Jamshedpur","Jharkhand",9431755184L,"akashsaha@gmil.com",
				"AADHAR","354576582323543");
		UserEntity person2 = new UserEntity(null, null, "Puja", null, "Singh","6-1/2, Vaisali Hsg. Complex, Tentultala, P.O.R- Gopalpur",
				"","Kolkata","West Bengal",9163697077L,null,null,null);

			rbmDonationService.save(person1);
			rbmDonationService.save(person2);

			// fetch all person
			System.out.println("-----List of user------");
			for (UserEntity devote : rbmDonationService.getuserList()) {
				System.out.println("user Detail:" + devote);
			}
		}
}
