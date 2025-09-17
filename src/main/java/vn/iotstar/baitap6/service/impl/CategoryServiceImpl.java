package vn.iotstar.baitap6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import vn.iotstar.baitap6.entity.Category;
import vn.iotstar.baitap6.repository.CategoryRespository;
import vn.iotstar.baitap6.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRespository categoryRespository;

    @Override
    public List<Category> findByCategoryNameContaining(String categoryName) {
        return categoryRespository.findByCategoryNameContaining(categoryName);
    }

    @Override
    public List<Category> findAll() {
        return categoryRespository.findAll();
    }

    @Override
    public <S extends Category> List<S> findAll(Example<S> example) {
        return categoryRespository.findAll(example);
    }

    @Override
    public <S extends Category> S save(S entity) {
        return categoryRespository.save(entity);
    }

    @Override
    public Optional<Category> findById(Integer integer) {
        return categoryRespository.findById(integer);
    }
}
