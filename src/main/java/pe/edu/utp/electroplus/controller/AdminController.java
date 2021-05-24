package pe.edu.utp.electroplus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.utp.electroplus.model.Product;
import pe.edu.utp.electroplus.services.ProductService;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("/admin")
    public String start(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);
        return "/admin";

    }

    @GetMapping("/addproduct")
    public String addProduct(Product product) {

        return "/admin";
    }

    @GetMapping("/saveproduct")
    public String saveProduct(@Valid Product product, Errors err) {

        if (err.hasErrors()) {
            return "/admin";
        }

        productService.agregarProducto(product);
        return "redirect:/admin";
    } 
}
