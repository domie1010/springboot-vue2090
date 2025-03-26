package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *视频分类：(VideoClassification)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VideoClassification")
public class VideoClassification implements Serializable {

    //VideoClassification编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_classification_id")
    private Integer video_classification_id;
    // 视频类别
    @Basic
    private String video_category;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
