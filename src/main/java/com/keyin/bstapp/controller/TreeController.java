package com.keyin.bstapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.bstapp.entity.TreeEntity;
import com.keyin.bstapp.service.TreeService;
import com.keyin.bstapp.trees.BinaryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/enter-numbers")
    public String showEnterNumbersPage() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        BinaryNode tree = treeService.createBinarySearchTree(numbers);
        treeService.saveTree(numbers, tree);

        // Serialize the tree to pretty-printed JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String treeJson = "";
        try {
            treeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("tree", treeJson);
        return "tree-view";  // Ensure you have a corresponding template
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        // Retrieve previous trees from the database
        List<TreeEntity> previousTrees = treeService.getPreviousTrees();
        model.addAttribute("previousTrees", previousTrees);
        return "previous-trees";  // Ensure you have a corresponding template
    }
}