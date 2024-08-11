package com.keyin.bstapp.controller;

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
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) {
        BinaryNode tree = treeService.createBinarySearchTree(numbers);
        treeService.saveTree(numbers, tree);
        model.addAttribute("tree", tree);
        return "tree-view";  // Assuming you have a template to visualize the tree
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeEntity> previousTrees = treeService.getPreviousTrees();
        model.addAttribute("previousTrees", previousTrees);
        return "previous-trees";
    }
}
