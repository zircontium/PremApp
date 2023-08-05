package com.javatechie.azure.demo;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RBMDonationService {
    @Autowired
    UserRepository personRepo;

    @Autowired
    DonationRepository donationRepo;


    public List<UserEntity> getUserList() {
        return personRepo.findAll();
    }

    public boolean saveUser(String user) {
        if(user!= null) {
            final JSONObject userJSON = new JSONObject(user);
            final JSONObject userObject = userJSON.getJSONObject("user");
            final Long userId = userObject.getLong("id");
            final String salutation = userObject.has("salutation")?userObject.getString("salutation"):null;
            final String firstName = userObject.getString("firstName");
            final String lastName = userObject.getString("lastName");
            final String addressLine1 = userObject.getString("addressLine1");
            final String addressLine2 = userObject.has("addressLine2")?userObject.getString("addressLine2"):null;
            final String city = userObject.getString("city");
            final long pin = userObject.has("pin")?userObject.getLong("pin"):0;
            final String state = userObject.has("state")?userObject.getString("state"):null;
            final long contactNo = userObject.getLong("contactNo");
            final String email = userObject.has("email")?userObject.getString("email"):null;
            final String idProofName = userObject.has("idProofName")?userObject.getString("idProofName"):null;
            final String idProofDetails = userObject.has("idProofDetails")?userObject.getString("idProofDetails"):null;
            UserEntity userEntity = new UserEntity(null,userId, salutation, firstName, lastName, addressLine1,
                    addressLine2, pin, city, state, contactNo, email, idProofName, idProofDetails);

            personRepo.save(userEntity);
            return true;
        }
        return false;
    }

    public boolean saveDontion(String donation) throws ParseException {
        if(donation!= null) {
            final JSONObject donationjson = new JSONObject(donation);
            final JSONObject donationTransaction = donationjson.getJSONObject("donation");
            final Date date = new SimpleDateFormat("yyyy-MM-dd").parse(donationTransaction.getString("date"));
            final long receiptNo = donationTransaction.getLong("receiptNo");
            final long amountPerMonth = donationTransaction.getLong("amountPerMonth");
            final Date startMonth = new SimpleDateFormat("yyyy-MM-dd").parse(donationTransaction.getString("startMonth"));
            final Date endMonth = new SimpleDateFormat("yyyy-MM-dd").parse(donationTransaction.getString("endMonth"));
            final long userId = donationTransaction.getLong("userId");
            final long totalAmount = TimeUnit.MILLISECONDS.toDays((endMonth.getTime() - startMonth.getTime())) / 30 * amountPerMonth;
            DonationEntity donationEntity = new DonationEntity(null, date, receiptNo, amountPerMonth, startMonth, endMonth,
                    totalAmount, userId);
            donationRepo.save(donationEntity);
            return true;
        }
        return false;
    }

    public List<DonationEntity> getLastDonation(long id) {
        List<DonationEntity> transaction = donationRepo.findLastTransaction(id);
        return transaction;
    }

    public List<UserEntity> searchUser(String searchString) {
        List<UserEntity> users = personRepo.findAll();
        List<UserEntity> filteredUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            String fullName = users.get(i).getFirstName() + " " + users.get(i).getLastName();
            if(fullName.contains(searchString)){
                filteredUsers.add(users.get(i));
            }
        }
        return filteredUsers.size()>0?filteredUsers:null;
    }

    public UserEntity getUser(Long id) {
        Optional<UserEntity> user = personRepo.findById(id);
        return user.orElse(null);
    }
}