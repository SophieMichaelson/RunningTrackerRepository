package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.UserData;
import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/RunningTracker")
@RestController
public class UserDataController {
    private final UserDataService userDataService;


    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }


    @PostMapping("/userData")
    List<UserData> getUserData(@RequestBody UserData userData) {
        return userDataService.getUserData(userData);
    }

    @PostMapping("/addData")
    HttpStatus post(@RequestBody UserData userData) {
        if (!userDataService.createUserData(userData)) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/deleteData")
    HttpStatus delete(@RequestBody UserData userData) {
        if (!userDataService.deleteUserData(userData)) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.GONE;
    }

    @PutMapping("/updateData")
    HttpStatus update(@RequestBody UserData userData) {
        if (!userDataService.updateUserData(userData)) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

}
