package keyin.com.DSA.controller;

import keyin.com.DSA.service.TreeRecordService;
import keyin.com.DSA.entity.TreeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NumberController {

    @Autowired
    private TreeRecordService treeRecordService;

    @GetMapping("/enter-numbers")
    public String showNumberInputForm() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        return "tree-result";
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeRecord> previousTrees = treeRecordService.getAllTreeRecords();
        model.addAttribute("previousTrees", previousTrees);
        return "previous-trees";
    }
}
