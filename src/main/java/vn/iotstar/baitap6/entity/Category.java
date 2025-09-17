package vn.iotstar.baitap6.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "[category]")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = true, columnDefinition = "NVARCHAR(255)")
    private String images;
}
