package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("banner_item")
public class BannerItemDO {

    private Long id;
    private String img;
    private String keyword;
    private Integer type;
    private Long bannerId;
    private String name;

    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    @TableLogic
    private Date deleteTime;
}
