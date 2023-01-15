package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping(path="/lab4")
public class LabController {
	@GetMapping(path="/add") //
	public @ResponseBody String addUser (@RequestParam String name, @RequestParam String
	email) {
	User n = new User();
	n.setName(name);
	n.setEmail(email);
	return n.toString();
	}
	
	@GetMapping(path="/addDomainObject") //
	public @ResponseBody String addProduct (@RequestParam String produto, @RequestParam Integer
	qtd) {
	CDomainClass c = new CDomainClass();
	c.setProduto(produto);
	c.setQtd(qtd);
	return c.toString();
	}
}
