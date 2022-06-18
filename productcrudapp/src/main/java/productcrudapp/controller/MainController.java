package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productdao;
	private Product product;
	

	@RequestMapping("/")
	public String show(Model m)	
	{
		List<Product> products = productdao.getProducts();
		m.addAttribute("product", products);
		return "showproduct";
	}
	
	// show add product
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	// handle add product form
	@RequestMapping(value="/Genjutsu",method=RequestMethod.POST)
	public RedirectView addProduct(@ModelAttribute Product product, HttpServletRequest request)
	{
		System.out.println(product);
		productdao.createProduct(product);		 
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	// Delete Handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request)
	{
		this.productdao.deleteProducts(productId);
		RedirectView redirectView = new RedirectView(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int pId , Model m)
	{
		Product product = this.productdao.getProduct(pId);
		m.addAttribute("p",product);
		return "update_form";
	}
	
}
