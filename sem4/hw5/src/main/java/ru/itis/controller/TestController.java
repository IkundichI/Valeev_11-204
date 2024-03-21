package ru.itis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.annotation.MyCache;

@RestController
public class TestController {

    @GetMapping("/test")
    @MyCache(duration = 10)
    public String testCachedMethod(@RequestParam String name) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format("%s is reversed: %s", name, reverse(name));

    }

    private String reverse(String name) {
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
