package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping(path="/lab5")
public class LabController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
   
   @GetMapping(path="/user/add") //
   public @ResponseBody String addUser (@RequestParam String name, @RequestParam String email) {
	   User n = new User();
	   n.setName(name);
	   n.setEmail(email);
	   userRepository.save(n);
	   return "User Saved";
   }
   @GetMapping(path="/user/all")
   public @ResponseBody Iterable<User> getAllUsers() {
       return userRepository.findAll();
   }
   @GetMapping(path="/user/edit") //
   public @ResponseBody String updateUser (@RequestParam Long id, @RequestParam String name, @RequestParam String email) {
	   User n = userRepository.findById(id).get();
	   n.setName(name);
	   n.setEmail(email);
	   userRepository.save(n);
	   return "User Updated";
   }
   
   @GetMapping(path="/user/delete") //
   public @ResponseBody String deleteUser (@RequestParam Long id) {
	   User n = userRepository.findById(id).get();
	   userRepository.delete(n);
	   return "User Deleted";
   }
   
   @GetMapping(path="/produto/add") //
   public @ResponseBody String addProduct (@RequestParam String name, @RequestParam Integer quantidade, @RequestParam Float preco) {
	   Produto n = new Produto();
	   n.setName(name);
	   n.setQuantidade(quantidade);
	   n.setPreco(preco);
	   produtoRepository.save(n);
	   return "Product Saved";
   }
   
   @GetMapping(path="/produto/all")
   public @ResponseBody Iterable<Produto> getAllProducts() {
       return produtoRepository.findAll();
   }
   
   @GetMapping(path="/produto/edit") //
   public @ResponseBody String updateProduto (@RequestParam Long id, @RequestParam String name, @RequestParam Integer quantidade, @RequestParam Float preco) {
	   Produto n = produtoRepository.findById(id).get();
	   n.setName(name);
	   n.setQuantidade(quantidade);
	   n.setPreco(preco);
	   produtoRepository.save(n);
	   return "Produto Updated";
   }
   
   @GetMapping(path="/produto/delete") //
   public @ResponseBody String deleteProduto (@RequestParam Long id) {
	   Produto n = produtoRepository.findById(id).get();
	   produtoRepository.delete(n);
	   return "Produto Deleted";
   }
   
   
}