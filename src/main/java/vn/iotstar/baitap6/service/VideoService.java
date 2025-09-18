package vn.iotstar.baitap6.service;

import vn.iotstar.baitap6.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    List<Video> findByVideoNameContaining(String videoName);

    <S extends Video> S save(S entity);

    void deleteById(Integer integer);

    List<Video> findAll();

    Optional<Video> findById(Integer integer);
}
