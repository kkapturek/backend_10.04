package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class UserController {

    private final Object locker = new Object();
    private final Map<Long, UserEntity> users = new LinkedHashMap<>();

    @PostConstruct
    private void onCreate() { // it is executed only once imidiately after UsersController is created
        users.put(1L, new UserEntity(1L, "John"));
        users.put(2L, new UserEntity(2L, "Matt"));
        users.put(3L, new UserEntity(3L, "Kate"));
    }

    // http://localhost:8080/users/1/get
    // http://localhost:8080/users/2/get
    // http://localhost:8080/users/3/get
    //
    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object getUser(@PathVariable Long id) {
        synchronized (this.locker) { // it is used only to prevent against simultaneous access from different threads/users
            return this.users.get(id);
        }}
    @RequestMapping("/api/users")
    @ResponseBody
    public Object getUsers(
            @RequestParam(name="page-number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name="page-size", defaultValue = "20") Integer pageSize,
                ) {

        UsersPage page = new UsersPage();

        page.setPageNumber(pageNumber);
        page.setPagesCount(1);
        page.setPageSize(pageSize);
        page.setTotalCount(1);
        page.set
    }
}