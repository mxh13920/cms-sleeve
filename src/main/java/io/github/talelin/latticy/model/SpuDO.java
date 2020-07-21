package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("spu")
public class SpuDO extends BaseModel {


    private String title;

    private String subtitle;

    private Integer categoryId;

    private Integer rootCategoryId;

    private Integer online;

    /**
     * 文本型价格，有时候SPU需要展示的是一个范围，或者自定义平均价格
     */
    private String price;

    /**
     * 某种规格可以直接附加单品图片
     */
    private Integer sketchSpecId;

    /**
     * 默认选中的sku
     */
    private Integer defaultSkuId;

    private String img;

    private String discountPrice;

    private String description;

    private String tags;

    private Integer isTest;

    private String spuThemeImg;

    private String forThemeImg;


}
