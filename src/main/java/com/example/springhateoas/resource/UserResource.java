package com.example.springhateoas.resource;

import com.example.springhateoas.model.User;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    @GetMapping("/all")
    public List<User> getAll() {
        User user1 = new User("Carlos", 8000L);
        User user2 = new User("Eduardo", 7900L);
        return Arrays.asList(user1, user2);
    }

    @GetMapping(value = "/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
    public List<User> getHateOASAll() {
        User user1 = new User("Carlos", 8000L);
        User user2 = new User("Eduardo", 7900L);

        addSelfLink(user1);
        addUserLink(user2);
        return Arrays.asList(user1, user2);
    }


    private void addSelfLink(User user1) {
        user1.add(linkTo(UserResource.class).slash((user1.getSalary())).withSelfRel());
    }

    private void addUserLink(User user2) {
        user2.add(linkTo(UserResource.class).slash((user2.getName())).withRel("name"));
    }
}
