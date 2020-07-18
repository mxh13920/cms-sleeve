package io.github.talelin.latticy.service;

import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSleeveService {

    @Autowired
    private BannerMapper bannerMapper;

    public List<BannerDO> getBanners(){
        return  bannerMapper.getAllBanners();
    }
    public List<BannerDO> getBanners1(){
        return  bannerMapper.getAllBanners1();
    }

    public Long insertBanner(){
        BannerDO bannerDO=new BannerDO();
        bannerDO.setName("new banner");
        bannerDO.setTitle("new banner title");
        bannerMapper.insertBanner(bannerDO);
        return bannerDO.getId();
    }
}
