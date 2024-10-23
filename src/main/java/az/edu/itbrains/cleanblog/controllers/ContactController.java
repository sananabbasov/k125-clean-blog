package az.edu.itbrains.cleanblog.controllers;

import az.edu.itbrains.cleanblog.dtos.contact.ContactSendDto;
import az.edu.itbrains.cleanblog.services.ContactService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String contact(Model model,String success){
        model.addAttribute("contactSendDto", new ContactSendDto());
        if (success == null){
            model.addAttribute("success", false);
        }else{
            model.addAttribute("success", true);
        }
        return "contact.html";
    }

    @PostMapping("/contact")
    public String contact(@Valid ContactSendDto contactSendDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "contact";
        }
        contactService.sendEmail(contactSendDto);
        return "redirect:/contact?success=true";
    }
}
