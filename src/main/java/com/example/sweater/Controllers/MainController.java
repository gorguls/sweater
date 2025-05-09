package com.example.sweater.Controllers;

import com.example.sweater.Domain.Message;
import com.example.sweater.Repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    public MessageRepo messageRepo;

    @GetMapping("/")
    public String mainPage(Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/")
    public String addMessage(@RequestParam String text, @RequestParam String tag, Model model) {
        if (text != null && !text.isEmpty()) {
            messageRepo.save(new Message(text, tag));
        }

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping("/filter")
    public String filterMessages(@RequestParam String filter, Model model) {
        if (filter != null && !filter.isEmpty()) {
            List<Message> messagesByTag = messageRepo.findByTag(filter);
            model.addAttribute("messages", messagesByTag);
        } else {
            Iterable<Message> messages = messageRepo.findAll();
            model.addAttribute("messages", messages);
        }

        return "main";
    }
}
