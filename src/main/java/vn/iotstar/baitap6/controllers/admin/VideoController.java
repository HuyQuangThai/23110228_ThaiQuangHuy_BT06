package vn.iotstar.baitap6.controllers.admin;

import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.iotstar.baitap6.entity.Video;
import vn.iotstar.baitap6.model.VideoModel;
import vn.iotstar.baitap6.service.VideoService;

import java.util.List;
import java.util.Optional;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    public void setDefaultAttribute(Model model) {
        model.addAttribute("home","/admin/home");
        model.addAttribute("category","/admin/category");
        model.addAttribute("user","/admin/user");
        model.addAttribute("video","video");

        model.addAttribute("active_home","");
        model.addAttribute("active_category","");
        model.addAttribute("active_user","");
        model.addAttribute("active_video","active");
    }

    @GetMapping("admin/video")
    private String viewVideo(Model model) {
        setDefaultAttribute(model);
        List<Video> videos = videoService.findAll();
        model.addAttribute("videos", videos);
        return "admin/videos/list";
    }

    @GetMapping("admin/video/add")
    private String addVideo(Model model) {
        model.addAttribute("action","add");
        return "admin/videos/edit";
    }

    @PostMapping("admin/video/add")
    public String addVideo(@ModelAttribute VideoModel videoModel) {
        String name = videoModel.getVideoName();
        String url = videoModel.getVideoUrl();

        Video newVideo = new Video();
        newVideo.setVideoName(name);
        newVideo.setVideoUrl(url);
        videoService.save(newVideo);
        return "redirect:/admin/video";
    }

    @GetMapping("admin/video/delete")
    private String deleteVideo(@RequestParam Integer id) {
        videoService.deleteById(id);
        return "forward:/admin/video";
    }

    @GetMapping("admin/video/edit")
    private String editVideo(@RequestParam Integer id, Model model) {
        Optional<Video> video = videoService.findById(id);
        if (video.isPresent()) {
            model.addAttribute("video",video.get());
            model.addAttribute("action","edit");
            return "admin/videos/edit";
        }
        else  return "forward:/admin/video";
    }

    @PostMapping("admin/video/edit")
    public String editVideo(@ModelAttribute VideoModel videoModel) {
        Integer id = videoModel.getId();
        String name = videoModel.getVideoName();
        String url = videoModel.getVideoUrl();
        Video newVideo = new Video(id, name, url);
        videoService.save(newVideo);
        return "redirect:/admin/video";
    }

    @GetMapping("admin/video/search")
    public String searchVideo(@RequestParam String keyword, Model model) {
        setDefaultAttribute(model);
        List<Video> videos = null;
        if (keyword.isEmpty()) {
            videos = videoService.findAll();
        } else videos = videoService.findByVideoNameContaining(keyword);
        model.addAttribute("videos",videos);
        return "admin/videos/list";
    }
}
