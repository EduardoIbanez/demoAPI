package com.example.demoBCI.Service;

import com.example.demoBCI.DTO.Request.PhoneRequestDTO;
import com.example.demoBCI.DTO.Request.UserRequestDTO;
import com.example.demoBCI.DTO.Response.PhoneResponseDTO;
import com.example.demoBCI.DTO.Response.UserResponseDTO;
import com.example.demoBCI.Entity.Phone;
import com.example.demoBCI.Entity.User;
import com.example.demoBCI.Mapper.PhoneToPhoneDTO;
import com.example.demoBCI.Mapper.UserDTOToUser;
import com.example.demoBCI.Repository.PhoneRepository;
import com.example.demoBCI.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CreateUserService {

    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;
    private final UserDTOToUser mapperUser;
    private final PhoneToPhoneDTO mapperPhone;

    public CreateUserService(UserRepository userRepository, PhoneRepository phoneRepository, UserDTOToUser mapperUser, PhoneToPhoneDTO mapperPhone) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
        this.mapperUser = mapperUser;
        this.mapperPhone = mapperPhone;
    }


    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = mapperUser.map(userRequestDTO);
        this.userRepository.save(user);
        User userPhones = userRepository.findById(user.getUuid());
        if(userPhones != null ){
            IntStream.iterate(0, i -> userRequestDTO.getPhones().size() > 0, i -> i + 1).forEach(i -> createPhone(userPhones, userRequestDTO.getPhones().get(i)));

        }

        return generateResponse(userPhones);
    }

    private Phone createPhone(User user, PhoneRequestDTO phones){
        Phone phoneCreate = new Phone();
        phoneCreate.setNumber(phones.getNumber());
        phoneCreate.setCityCode(phones.getCityCode());
        phoneCreate.setCountryCode(phones.getCountryCode());
        phoneCreate.setUuidUser(user);
        return phoneRepository.save(phoneCreate);
    }

    private UserResponseDTO generateResponse(User user){
        User getUser = userRepository.findById(user.getUuid());
        List<Phone> phones  = phoneRepository.findByUser(user);

        UserResponseDTO userResponse  = new UserResponseDTO();
        userResponse.setName(getUser.getName());
        userResponse.setEmail(getUser.getEmail());
        userResponse.setPassword(getUser.getPassword());
        userResponse.setUuid(getUser.getUuid());
        userResponse.setCreated(getUser.getCreated());
        userResponse.setModified(getUser.getModified());
        userResponse.setLastLogin(getUser.getLastLogin());
        userResponse.setToken(getUser.getToken());
        userResponse.setIsActive(getUser.getIsActive());
        userResponse.setPhones(converterPhones(phones));


        return null;
    }
    private List<PhoneResponseDTO> converterPhones(List<Phone> phones){
        List<PhoneResponseDTO> phonesResponseDTO = new ArrayList<>();
        for (Phone phone : phones) {
            PhoneResponseDTO phoneResponseMapper = mapperPhone.map(phone);
            phonesResponseDTO.add(phoneResponseMapper);
        }
        return phonesResponseDTO;
    }
}
