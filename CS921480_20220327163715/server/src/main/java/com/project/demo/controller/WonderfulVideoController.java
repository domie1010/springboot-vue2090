package com.project.demo.controller;

import com.project.demo.entity.WonderfulVideo;
import com.project.demo.service.WonderfulVideoService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *精彩视频：(WonderfulVideo)表控制层
 *
 */
@RestController
@RequestMapping("/wonderful_video")
public class WonderfulVideoController extends BaseController<WonderfulVideo,WonderfulVideoService> {

    /**
     *精彩视频对象
     */
    @Autowired
    public WonderfulVideoController(WonderfulVideoService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
