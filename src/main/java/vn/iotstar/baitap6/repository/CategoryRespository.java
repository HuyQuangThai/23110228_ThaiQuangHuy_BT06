package vn.iotstar.baitap6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitap6.entity.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRespository extends JpaRepository<Category,Integer> {
    List<Category> findByCategoryNameContaining(String categoryName);
}
