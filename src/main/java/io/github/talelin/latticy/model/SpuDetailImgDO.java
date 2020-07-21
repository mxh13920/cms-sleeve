package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("spu_detail_img")
public class SpuDetailImgDO extends BaseModel {


    private String img;

    private Integer spuId;

    @TableField(value = "`index`")
    private Integer index;


}
