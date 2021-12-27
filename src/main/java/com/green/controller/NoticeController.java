package com.green.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j
@RequestMapping("/notice/*")
public class NoticeController {

    @GetMapping("notice")
    public void getNoitce(){

    }
}