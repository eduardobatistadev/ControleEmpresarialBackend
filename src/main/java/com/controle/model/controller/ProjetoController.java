package com.controle.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.model.Cliente;
import com.controle.model.Projeto;
import com.controle.model.service.ClienteService;
import com.controle.model.service.ProjetoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("")
	public List<Projeto> findAll(){
		return this.projetoService.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public List<Projeto> findByCliente(@PathVariable("id") long id){
		Cliente cliente = this.clienteService.findById(id);
		return this.projetoService.findByCliente(cliente);
	}
	
	@GetMapping("/{id}")
	public Projeto findById(@PathVariable("id") long id) {
		return this.projetoService.findById(id);
	}
	
	@PostMapping("")
	public Projeto save(@RequestBody Projeto projeto) {
		return this.projetoService.save(projeto);
	}
	
	@PutMapping("")
	public Projeto update(@RequestBody Projeto projeto) {
		return this.projetoService.update(projeto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") long id) {
		System.out.println(id);
		this.projetoService.deleteById(id);
	}
	
}
