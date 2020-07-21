package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.TestSleeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/test")
@RestController
@Validated
public class TestController {

    @Autowired
    private TestSleeveService testSleeveService;

    @Autowired
    private BannerMapper bannerMapper;

    @GetMapping("/test1")
    public List<BannerDO> test() {
        return testSleeveService.getBanners();
    }

    @GetMapping("/test2")
    public Long test2() {
        return testSleeveService.insertBanner();
    }

    @GetMapping("/test3")
    public List<BannerDO> test3() {
        return testSleeveService.getBanners1();
    }

    @GetMapping("test4")
    public List<BannerDO> test43() {
        return bannerMapper.selectList(null);
    }
}
