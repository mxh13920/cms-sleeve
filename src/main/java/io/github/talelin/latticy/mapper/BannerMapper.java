package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.List;

@Repository
public interface BannerMapper extends BaseMapper<BannerDO> {

    List<BannerDO> getAllBanners();

    @Select("select * from banner")
    List<BannerDO> getAllBanners1();

    Long insertBanner(BannerDO bannerDO);
}
