package az.edu.itbrains.cleanblog.controllers.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/admin")
    public String home(){
        return "/dashboard/index.html";
    }


    @GetMapping("/admin/contact")
    public String contact(){
        return "/dashboard/contact.html";
    }
}
