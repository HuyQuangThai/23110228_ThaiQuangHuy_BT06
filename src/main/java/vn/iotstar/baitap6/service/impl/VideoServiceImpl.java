package vn.iotstar.baitap6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.baitap6.entity.Video;
import vn.iotstar.baitap6.repository.VideoRespository;
import vn.iotstar.baitap6.service.VideoService;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRespository videoRespository;

    @Override
    public List<Video> findByVideoNameContaining(String videoName) {
        return videoRespository.findByVideoNameContaining(videoName);
    }

    @Override
    public <S extends Video> S save(S entity) {
        return videoRespository.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        videoRespository.deleteById(integer);
    }

    @Override
    public List<Video> findAll() {
        return videoRespository.findAll();
    }
}
