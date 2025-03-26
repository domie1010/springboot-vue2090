package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *精彩视频：(WonderfulVideo)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "WonderfulVideo")
public class WonderfulVideo implements Serializable {

    //WonderfulVideo编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wonderful_video_id")
    private Integer wonderful_video_id;
    // 视频编号
    @Basic
    private String video_number;
    // 视频名称
    @Basic
    private String video_name;
    // 视频类别
    @Basic
    private String video_category;
    // 封面
    @Basic
    private String cover;
    // 视频
    @Basic
    private String video;
    // 用户名
    @Basic
    private Integer user_name;
    // 视频介绍
    @Basic
    private String video_introduction;
    // 点击数
    @Basic
    private Integer hits;
    // 点赞数
    @Basic
    private Integer praise_len;
    // 审核状态
    @Basic
    private String examine_state;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
