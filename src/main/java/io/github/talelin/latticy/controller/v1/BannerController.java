package io.github.talelin.latticy.controller.v1;

import io.github.talelin.core.annotation.*;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
@PermissionModule(value = "Banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping
    @PermissionMeta(value = "创建banner")
    @GroupRequired
    public CreatedVO<BannerDO> created(@RequestBody BannerDTO bannerDTO) {
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        bannerService.save(bannerDO);
        return new CreatedVO<BannerDO>();
    }

    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除Banner")
    public DeletedVO<BannerDO> delete(@PathVariable @Positive long id) {
        bannerService.deleted(id);
        return new DeletedVO<BannerDO>();
    }

    @GetMapping("/{id}")
    @LoginRequired
    @PermissionMeta(value = "查询banner")
    @Logger(template = "{user.username}查询了banner数据")
    public BannerWithItemsBO withBannerItems(@PathVariable @Positive Long id) {
        return bannerService.withBannerItems(id);
    }

    @PutMapping("/{id}")
    @PermissionMeta(value = "更新banner")
    public UpdatedVO<BannerDO> update(@RequestBody @Validated BannerDTO bannerDTO,
                                      @PathVariable Integer id) {
        bannerService.update(bannerDTO, id);
        return new UpdatedVO<BannerDO>();
    }


    @GetMapping("/page")
    @LoginRequired
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0")
                                               @Min(0) Integer page,
                                               @RequestParam(required = false, defaultValue = "10")
                                               @Max(value = 20) Integer count) {
        Page<BannerDO> page1 = new Page<>(page, count);
        Page<BannerDO> paging = bannerService.getBaseMapper().selectPage(page1, null);
        return new PageResponseVO<BannerDO>(paging.getTotal(), paging.getRecords(), paging.getPages(), paging.getSize());

    }
}
