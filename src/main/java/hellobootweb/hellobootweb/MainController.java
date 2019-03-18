package hellobootweb.hellobootweb;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	    
		RestTemplate restTemplate = new RestTemplate();
		String hellobooturl=System.getenv("HELLO_BOOT_API_SERVER_NAME")+"/helloboot?name="+name;
		ResponseEntity<String> response=restTemplate.getForEntity(hellobooturl, String.class);
		model.addAttribute("message",response.getBody());
		model.addAttribute("name", name);
	    return "greeting";
    }
}
