package com.thn.driver.service;

import com.thn.driver.reporitory.CheckDriverRepository;

public class CheckDriverService {
    public static boolean checkDriver(String login, String password) {
        return CheckDriverRepository.checkDriver(login, password);
    }
}
