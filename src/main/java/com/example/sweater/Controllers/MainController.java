package com.example.sweater.Controllers;

import com.example.sweater.Domain.Message;
import com.example.sweater.Repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    public MessageRepo messageRepo;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/")
    public String addMessage(Model model, @RequestParam String text, @RequestParam String tag) {
        messageRepo.save(new Message(text, tag));

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

    return "main";
    }

}
