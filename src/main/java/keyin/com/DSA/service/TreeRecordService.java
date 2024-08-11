package keyin.com.DSA.service;

import keyin.com.DSA.entity.TreeRecord;
import keyin.com.DSA.repository.TreeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeRecordService {

    @Autowired
    private TreeRecordRepository treeRecordRepository;

    public TreeRecord getTreeRecordById(Long id) {
        return treeRecordRepository.findById(id).orElse(null);
    }

    public TreeRecord createTreeRecord(TreeRecord newRecord) {
        return treeRecordRepository.save(newRecord);
    }

    public List<TreeRecord> getAllTreeRecords() {
        return treeRecordRepository.findAll();
    }

    public TreeRecord updateTreeRecord(Long id, TreeRecord updatedRecord) {
        if (treeRecordRepository.existsById(id)) {
            updatedRecord.setId(id);
            return treeRecordRepository.save(updatedRecord);
        }
        return null;
    }

    public void deleteTreeRecord(Long id) {
        treeRecordRepository.deleteById(id);
    }
}
