package vn.iotstar.baitap6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.iotstar.baitap6.entity.Category;

import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByCategoryNameContaining(String categoryName);
}
