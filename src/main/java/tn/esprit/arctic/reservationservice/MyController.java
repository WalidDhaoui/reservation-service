package tn.esprit.arctic.reservationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rest")
public class MyController {

	@GetMapping("/docker")
	public String index(){
	return "docker exemple";	
	}
}
