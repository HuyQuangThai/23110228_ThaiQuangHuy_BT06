package vn.iotstar.baitap6.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "[video]")

public class Video implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoId;

    @Column(unique = true, nullable = false)
    private String videoName;

    @Column(unique = true, nullable = false)
    private String videoUrl;
}
