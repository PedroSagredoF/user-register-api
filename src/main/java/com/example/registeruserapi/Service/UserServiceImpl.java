package com.example.registeruserapi.Service;


import com.example.registeruserapi.Utils.JWTGenerator;
import com.example.registeruserapi.Utils.Util;
import com.example.registeruserapi.domain.UserRequest;
import com.example.registeruserapi.domain.UserResponse;
import com.example.registeruserapi.entity.Phones;
import com.example.registeruserapi.entity.User;
import com.example.registeruserapi.repository.PhonesRepository;
import com.example.registeruserapi.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhonesRepository phonesRepository;

    @Override
    public Object register(UserRequest request) {

        LocalDateTime now = LocalDateTime.now();
        String uuid = Util.getUIID();

        User user = new User();
        user.setId(uuid);
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setCreated(now);
        user.setModified(now);
        user.setLastLogin(now);
        user.setActive(true);
        user.setToken(JWTGenerator.generateJWTToken(request));

        User newUser = userRepository.save(user);
        savePhones(request, newUser);

        UserResponse response = new UserResponse();
        response.setId(newUser.getId());
        response.setCreated(newUser.getCreated());
        response.setModified(newUser.getModified());
        response.setLastLogin(newUser.getLastLogin());
        response.setToken(newUser.getToken());
        response.setActive(newUser.isActive());
        return response;

    }


    private void savePhones(UserRequest request, User user) {

        Phones phone = new Phones();

        JSONObject jsResponse = new JSONObject(request);
        JSONArray jsonArray = jsResponse.getJSONArray("phones");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String number = object.getString("number");
            String citiCode = object.getString("citycode");
            String contryCode = object.getString("contrycode");
            phone.setUser(user);
            phone.setNumber(number);
            phone.setCitycode(citiCode);
            phone.setContrycode(contryCode);
            phonesRepository.save(phone);
        }
    }
}