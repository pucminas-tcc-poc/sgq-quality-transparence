package com.pucminas.sgq.qualitytransparence.controller;

import com.pucminas.sgq.qualitytransparence.service.NotificationService;
import com.pucminas.sgq.qualitytransparence.vo.NotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification/api/v1")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public ResponseEntity<NotificationVO> createNotification(@RequestBody NotificationVO notificationVO) {
        try {
            notificationService.publish(notificationVO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
