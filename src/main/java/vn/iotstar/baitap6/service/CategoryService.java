package vn.iotstar.baitap6.service;

import org.springframework.data.domain.Example;
import vn.iotstar.baitap6.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findByCategoryNameContaining(String categoryName);

    List<Category> findAll();

    <S extends Category> List<S> findAll(Example<S> example);

    <S extends Category> S save(S entity);

    Optional<Category> findById(Integer integer);
}
