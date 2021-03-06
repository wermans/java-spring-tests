package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.Product;

@Controller
public class ProductsController {
	@Autowired private ProductDAO productDAO;
	@RequestMapping("/products/form")
	public String form(){
		return "products/form";
	}
	@RequestMapping("/products")
	@Transactional
	public String save(Product product){
		System.out.println("Cadastrando o produto: " + product);
		productDAO.save(product);
		return "products/ok";
	}
}
