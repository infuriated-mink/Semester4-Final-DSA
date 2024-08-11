package keyin.com.DSA.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tree_records")
public class TreeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numbers;
    private String treeJson;

    public TreeRecord() {}

    public TreeRecord(String numbers, String treeJson) {
        this.numbers = numbers;
        this.treeJson = treeJson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }
}
