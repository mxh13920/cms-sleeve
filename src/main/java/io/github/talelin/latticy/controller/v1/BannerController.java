package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/{id}")
    public BannerWithItemsBO withBannerItems(@PathVariable @Positive Long id){
        return bannerService.withBannerItems(id);
    }


    @DeleteMapping("/{id}")
    public DeletedVO<BannerDO> delete(@PathVariable @Positive long id) {
        bannerService.deleted(id);
        return new DeletedVO<BannerDO>();
    }

    @PutMapping("/{id}")
    public UpdatedVO<BannerDO> update(@RequestBody @Validated BannerDTO bannerDTO,
                            @PathVariable Integer id) {
        bannerService.update(bannerDTO, id);
        return new UpdatedVO<BannerDO>();
    }


    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0")
                                               @Min(0) Integer page,
                                               @RequestParam(required = false, defaultValue = "10")
                                               @Max(value = 20) Integer count) {
        Page<BannerDO> page1 = new Page<>(page, count);
        Page<BannerDO> paging = bannerService.getBaseMapper().selectPage(page1, null);
        return new PageResponseVO<BannerDO>(paging.getTotal(), paging.getRecords(), paging.getPages(), paging.getSize());

    }
}
