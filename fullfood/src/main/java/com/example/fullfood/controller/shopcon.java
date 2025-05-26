package com.example.fullfood.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fullfood.entity.Order;
import com.example.fullfood.entity.OrderItem;
import com.example.fullfood.entity.Product;
import com.example.fullfood.repo.OrderRepository;
import com.example.fullfood.service.catogiryserve;
import com.example.fullfood.service.prodserv;

import jakarta.servlet.http.HttpSession;

@Controller
public class shopcon {
	@Autowired
	private catogiryserve cat;
	@Autowired
	private prodserv pro;
	@Autowired
	private OrderRepository orderRepo;

	@GetMapping("/shop")
	
	public String addpro(Model mo) {
		mo.addAttribute("productdto", pro.listpro());
		mo.addAttribute("catogiry", cat.listcato());
		return "shop";
	}
	@GetMapping("shop/category/{id}")
	public String shopbycato(Model mo, @PathVariable("id") int id) {
		mo.addAttribute("productdto", pro.procatid(id));
		mo.addAttribute("catogiry", cat.listcato());
		return "shop";
	}
	   // ✅ View single product
    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable("id") int proid, Model model) {
        Product product = pro.getById(proid); // You must implement this method in prodserv
        model.addAttribute("product", product);
        return "product"; // product.html
    }

    // ✅ Add to cart
    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") int id, HttpSession session) {
        Product product = pro.getById(id);

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(product);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    // ✅ View cart
    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        int totalAmount = cart.stream()
                              .mapToInt(Product::getPrice)
                              .sum();

        model.addAttribute("cartItems", cart);
        model.addAttribute("totalAmount", totalAmount); // ✅ Pass total to Thymeleaf
        return "cart"; // cart.html
    }
    @PostMapping("/placeOrder")
    public String placeOrder(HttpSession session,
                             @RequestParam String username,
                             @RequestParam String location,
                             @RequestParam String phone,
                             Model model) {

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Cart is empty.");
            return "cart";
        }

        int total = cart.stream().mapToInt(Product::getPrice).sum();

        Order order = new Order();
        order.setUsername(username);
        order.setLocation(location);
        order.setPhone(phone);
        order.setTotalPrice(total);

        List<OrderItem> orderItems = cart.stream().map(p -> {
            OrderItem item = new OrderItem();
            item.setProductName(p.getProname());
            item.setPrice(p.getPrice());
            item.setQuantity(1); // or support quantity later
            item.setOrder(order);
            return item;
        }).toList();

        order.setItems(orderItems);

        // Save order + items
        orderRepo.save(order);

        // Clear cart
        session.removeAttribute("cart");

        model.addAttribute("order", order);
        return "order_success"; // ✅ Create this page
    }


    
}


