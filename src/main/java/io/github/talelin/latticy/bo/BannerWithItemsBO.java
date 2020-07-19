package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BannerWithItemsBO {

    private long id;
    private String name;
    private String description;
    private String title;
    private String img;

    private List<BannerItemDO> items;

    public BannerWithItemsBO(BannerDO bannerDO,List<BannerItemDO> bannerItemDO){
        BeanUtils.copyProperties(bannerDO,this);
        this.setItems(bannerItemDO);
    }
}
