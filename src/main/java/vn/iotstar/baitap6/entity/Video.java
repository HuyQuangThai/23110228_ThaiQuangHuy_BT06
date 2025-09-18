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
    @Column(name = "video_id")
    private int id;

    @Column(unique = true, nullable = false, name = "video_name")
    private String videoName;

    @Column(unique = true, nullable = false, name = "video_url")
    private String videoUrl;
}
