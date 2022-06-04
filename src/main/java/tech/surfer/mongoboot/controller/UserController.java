package tech.surfer.mongoboot.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.surfer.mongoboot.dao.UserRepository;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    @NonNull
    private UserRepository userRepository;

    @RequestMapping(value = "health", method = RequestMethod.GET)
    public String getHealth() {
        return "Alive!!";
    }
}
