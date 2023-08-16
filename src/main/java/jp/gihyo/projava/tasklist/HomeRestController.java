package jp.gihyo.projava.tasklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class HomeRestController {


//    record TaskItem(String id, String task,String deadline, boolean done){}

//    @Autowired
//    HomeRestController(TaskListDao dao){
//        this.dao = dao;
//    }
//    @RequestMapping(value = "/resthello")
//    String hello(Model model){
//        model.addAttribute("time", LocalDateTime.now());
//        return "hello";
//    }
//
//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//
//    @GetMapping("/add")
//    String addItem(@RequestParam("task") String task,
//                   @RequestParam("deadline") String deadLine){
//        String id = UUID.randomUUID().toString().substring(0,8);
//        TaskItem item = new TaskItem(id, task, deadLine, false);
//        this.dao.add(item);
//        return "redirect:/list";
//    }
//
//    @GetMapping("/list")
//    String listItems(Model model){
//        List<TaskItem> list = this.dao.findAll();
//        model.addAttribute("tasklist", list);
//        return "home";
//    }
//
//    @GetMapping("/delete")
//    String deleteItem(@RequestParam("id") String id){
//        this.dao.delete(id);
//        return "redirect:/list";
//    }
}
