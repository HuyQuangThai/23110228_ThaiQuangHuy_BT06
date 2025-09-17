package vn.iotstar.baitap6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitap6.entity.Video;

import java.util.List;

@Repository
public interface VideoRespository extends JpaRepository<Video,Integer> {
    List<Video> findByVideoNameContaining(String videoName);
}
