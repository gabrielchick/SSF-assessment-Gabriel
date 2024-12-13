package vttp.batch5.ssf.noticeboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.ssf.noticeboard.models.Notice;
import vttp.batch5.ssf.noticeboard.services.NoticeService;

@RestController

@RequestMapping()
public class NoticeRestController {
    
    @Autowired
    NoticeService noticeService;
    @GetMapping("") 
    public ResponseEntity<List<Notice>> postToNoticeServer() { 
    
        List<Notice> notice = noticeService.postToNoticeServer();

        return ResponseEntity.ok().body(notice);
    }
}