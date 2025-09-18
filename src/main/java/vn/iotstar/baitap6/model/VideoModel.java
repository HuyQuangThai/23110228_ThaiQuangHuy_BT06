package vn.iotstar.baitap6.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoModel {
    private Integer id;
    private String videoName;
    private String videoUrl;

}
