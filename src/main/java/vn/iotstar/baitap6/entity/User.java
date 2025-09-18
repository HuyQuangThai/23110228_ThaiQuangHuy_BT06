package vn.iotstar.baitap6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "[user]")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(MAX)")
    private String fullName;

    @Column(unique = true)
    private  String phone;

    @Column(nullable = true, columnDefinition = "NVARCHAR(MAX)")
    private String images;


    @Column
    private int role;
}
