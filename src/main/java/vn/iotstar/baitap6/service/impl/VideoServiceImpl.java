package vn.iotstar.baitap6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.baitap6.entity.Video;
import vn.iotstar.baitap6.repository.VideoRepository;
import vn.iotstar.baitap6.service.VideoService;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> findByVideoNameContaining(String videoName) {
        return videoRepository.findByVideoNameContaining(videoName);
    }

    @Override
    public <S extends Video> S save(S entity) {
        return videoRepository.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        videoRepository.deleteById(integer);
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> findById(Integer integer) {
        return videoRepository.findById(integer);
    }
}
