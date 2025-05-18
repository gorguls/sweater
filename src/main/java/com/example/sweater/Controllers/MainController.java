package com.example.sweater.Controllers;

import com.example.sweater.Domain.Message;
import com.example.sweater.Domain.User;
import com.example.sweater.Repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        model.addAttribute("user", user.getUsername());
        return "main.ftlh";
    }

    @PostMapping("/main")
    public String addMessage(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Model model) {

        if (text != null && !text.isEmpty()) {
            messageRepo.save(new Message(text, tag, user));
        }

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        model.addAttribute("user", user.getUsername());
        return "main.ftlh";
    }

    @PostMapping("/filter")
    public String filterMessages(
            @AuthenticationPrincipal User user,
            @RequestParam String filter,
            Model model) {

        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
            model.addAttribute("messages", messages);
        } else {
            messages = messageRepo.findAll();
            model.addAttribute("messages", messages);
        }

        model.addAttribute("user", user.getUsername());
        return "main.ftlh";
    }
}
