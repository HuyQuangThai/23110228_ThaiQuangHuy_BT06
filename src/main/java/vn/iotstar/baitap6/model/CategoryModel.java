package vn.iotstar.baitap6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.iotstar.baitap6.entity.Category;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
    List<Category> categories;
    String categoryName;
    String images;
    Integer id;
}
