package store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.entities.*;
import store.repositories.*;

@Controller
public class MainController {

    private ClientRepository clientRepository;
    private WorkerRepository workerRepository;
    private ProviderRepository providerRepository;
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    public MainController(ClientRepository clientRepository, WorkerRepository workerRepository, ProviderRepository providerRepository, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.workerRepository = workerRepository;
        this.providerRepository = providerRepository;
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String Menu(){
        return "menu";
    }

    @GetMapping("/item")
    public String itemForm(Model model){
        model.addAttribute("item", new Item());
        return "item";
    }
    @PostMapping("/item")
    public String itemSubmit(@ModelAttribute Item item, Model model){
        model.addAttribute("item", item);
        itemRepository.save(item);
        return "resultOfItem";
    }

    @GetMapping("/allItems")
    public String getItems(Model model){
        model.addAttribute("items", itemRepository.findAllItems());
        return "allItems";
    }

    @GetMapping("/order")
    public String orderForm(Model model){
        model.addAttribute("order", new Order());
        return "item";
    }
    @PostMapping("/order")
    public String ordersSubmit(@ModelAttribute Order order, Model model){
        model.addAttribute("order", order);
        orderRepository.save(order);
        return "resultOfItem";
    }

    @GetMapping("/allOrders")
    public String getOrders(Model model){
        model.addAttribute("order", orderRepository.findAllOrders());
        return "allOrders";
    }

    @GetMapping("/provider")
    public String providerForm(Model model){
        model.addAttribute("provider", new Provider());
        return "provider";
    }

    @PostMapping("/provider")
    public String providerSubmit(@ModelAttribute Provider provider, Model model){
        model.addAttribute("provider", provider);
        providerRepository.save(provider);
        return "resultOfProvider";
    }

    @GetMapping("/allProviders")
    public String getProviders(Model model){
        model.addAttribute("providers", providerRepository.findAllProviders());
        return "allProviders";
    }

    @GetMapping("/client")
    public String clientForm(Model model){
        model.addAttribute("client", new Client());
        return "client";
    }

    @PostMapping("/client")
    public String clientSubmit(@ModelAttribute Client client, Model model){
        model.addAttribute("client", client);
        clientRepository.save(client);
        return "resultOfClient";
    }

    @GetMapping("/allClients")
    public String getClients(Model model){
        model.addAttribute("clients", clientRepository.findAllClients());
        return "allClients";
    }

    @GetMapping("/worker")
    public String workerForm(Model model){
        model.addAttribute("worker", new Worker());
        return "worker";
    }

    @PostMapping("/worker")
    public String workerSubmit(@ModelAttribute Worker worker, Model model){
        model.addAttribute("worker", worker);
        workerRepository.save(worker);
        return "resultOfWorker";
    }

    @GetMapping("/allWorkers")
    public String getWorkers(Model model){
        model.addAttribute("workers", workerRepository.findAllWorkers());
        return "allWorkers";
    }
}
