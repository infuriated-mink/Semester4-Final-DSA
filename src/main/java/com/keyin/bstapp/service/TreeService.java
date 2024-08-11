package com.keyin.bstapp.service;

import com.keyin.bstapp.entity.TreeEntity;
import com.keyin.bstapp.repository.TreeRepository;
import com.keyin.bstapp.trees.BinaryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    public BinaryNode createBinarySearchTree(String numbers) {
        String[] numberArray = numbers.split(",");
        BinaryNode root = null;
        for (String num : numberArray) {
            int value = Integer.parseInt(num.trim());
            root = insertIntoBST(root, value);
        }
        return root;
    }

    public void saveTree(String numbers, BinaryNode root) {
        TreeEntity treeEntity = new TreeEntity();
        treeEntity.setNumbers(numbers);
        treeEntity.setRootNode(root);
        treeRepository.save(treeEntity);
    }

    public List<TreeEntity> getPreviousTrees() {
        return treeRepository.findAll();
    }

    private BinaryNode insertIntoBST(BinaryNode root, int value) {
        if (root == null) {
            return new BinaryNode(value);
        }
        if (value < root.getValue()) {
            root.setLeftChild(insertIntoBST(root.getLeftChild(), value));
        } else if (value > root.getValue()) {
            root.setRightChild(insertIntoBST(root.getRightChild(), value));
        }
        return root;
    }
}
