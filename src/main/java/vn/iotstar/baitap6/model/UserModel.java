package vn.iotstar.baitap6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;
    private String images;
    private Integer role;
}
