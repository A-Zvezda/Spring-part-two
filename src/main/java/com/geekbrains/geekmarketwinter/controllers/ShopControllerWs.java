package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.entites.Greeting;
import com.geekbrains.geekmarketwinter.entites.Message;
import com.geekbrains.geekmarketwinter.entites.OrderItem;
import com.geekbrains.geekmarketwinter.services.ProductService;
import com.geekbrains.geekmarketwinter.services.ShoppingCartService;
import com.geekbrains.geekmarketwinter.utils.HttpSessionUtils;
import com.geekbrains.geekmarketwinter.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopControllerWs {
    private HttpSessionUtils httpSessionUtils;
    private ShoppingCartService shoppingCartService;
    private ProductService productService;

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }
    @Autowired
    public void setHttpSessionUtils(HttpSessionUtils httpSessionUtils) {
        this.httpSessionUtils = httpSessionUtils;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public List<Message> greeting(Message message , SimpMessageHeaderAccessor headerAccessor) throws Exception {
        Thread.sleep(3000); // simulated delay
        HttpSession currentSession = httpSessionUtils.findSession(headerAccessor.getSessionAttributes().get("HTTPSESSIONID").toString());
        List<Message> messageList = new ArrayList<Message>();
        if (currentSession != null) {

            ShoppingCart shoppingCart = shoppingCartService.getCurrentCart(currentSession);
            //Long quantity = shoppingCart.findOrderFromProduct(productService.getProductById(message.getId())).getQuantity();
            //Double cost = shoppingCart.findOrderFromProduct(productService.getProductById(message.getId())).getItemPrice();
            //Double totalCost = shoppingCart.getTotalCost();
            List<OrderItem> orderItems = shoppingCart.getItems();
            for (OrderItem o: orderItems) {
                Long id = o.getProduct().getId();
                Long quantity = o.getQuantity();
                Double cost = o.getItemPrice();
                Double totalCost = shoppingCart.getTotalCost();
                messageList.add(new Message(id, quantity , cost , totalCost));
            }

            return messageList;
        } else {
            return messageList;
        }
    }

}
