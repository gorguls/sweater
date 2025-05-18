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
            @RequestParam(required = false) String filter,
            Model model
    ) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("filter", filter);
            messages = messageRepo.findByTag(filter);
            model.addAttribute("messages", messages);
        } else {
            model.addAttribute("filter", "");
            messages = messageRepo.findAll();
            model.addAttribute("messages", messages);
        }

        return "main";
    }

    @PostMapping("/main")
    public String addMessage(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam(required = false) String filter,
            Model model) {

        Iterable<Message> messages;

        if (text != null && !text.isEmpty()) {
            messageRepo.save(new Message(text, tag, user));
        }

        messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        model.addAttribute("filter", "");

        return "main";
    }

}
