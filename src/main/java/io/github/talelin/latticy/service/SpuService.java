package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpuService extends ServiceImpl<SpuMapper, SpuDO> {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SpuImgService spuImgService;

    @Autowired
    private SpuDetailImgService spuDetailImgService;
    @Autowired
    private SpuKeyService spuKeyService;

    public SpuDetailDO getDetail(Long id) {
        return this.getBaseMapper().getDetail(id);
    }

    @Transactional
    public void create(SpuDTO dto) {
        SpuDO spuDO = new SpuDO();
        BeanUtils.copyProperties(dto, spuDO);
        CategoryDO categoryDO = categoryService.getCategoryById(dto.getCategoryId());
        spuDO.setRootCategoryId(categoryDO.getParentId());
        this.save(spuDO);

        List<String> supImgList = new ArrayList<>();
        if (dto.getSpuImgList() == null) {
            supImgList.add(dto.getImg());
        } else {
            supImgList = dto.getSpuImgList();
        }
        this.insertSpuImgList(supImgList, spuDO.getId());
        if (dto.getSpuDetailImgList() != null) {
            this.insertDetailImgList(dto.getSpuDetailImgList(), spuDO.getId());
        }
        if (dto.getSpecKeyIdList() != null) {
            this.insertSpuKeyList(dto.getSpecKeyIdList(),spuDO.getId());
        }
    }

    private void insertSpuKeyList(List<Integer> specKeyIdList,Long spuId){
        List<SpuKeyDO> spuKeyDOList = specKeyIdList.stream().map(sk -> {
            SpuKeyDO spuKeyDO = new SpuKeyDO();
            spuKeyDO.setSpuId(spuId.intValue())
                    .setSpecKeyId(sk);
            return spuKeyDO;
        }).collect(Collectors.toList());
        spuKeyService.saveBatch(spuKeyDOList);
    }

    private void insertDetailImgList(List<String> detailImgList, Long spuId) {
//        List<SpuDetailImgDO> spuDetailImgDOList = detailImgList.stream().map(s -> {
//            SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
//            spuDetailImgDO.setImg(s)
//                    .setIndex(i)
//                    .setSpuId(spuId.intValue());
//            return spuDetailImgDO;
//        }).collect(Collectors.toList());
        List<SpuDetailImgDO> spuDetailImgDOList = new ArrayList<>();
        for (int j = 0; j < detailImgList.size(); j++) {
            SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
            spuDetailImgDO.setImg(detailImgList.get(j))
                    .setSpuId(spuId.intValue())
                    .setIndex(j);
            spuDetailImgDOList.add(spuDetailImgDO);
        }
        spuDetailImgService.saveBatch(spuDetailImgDOList);
    }

    private void insertSpuImgList(List<String> spuImgList, Long supId) {
        List<SpuImgDO> spuImgDOList = spuImgList.stream().map(s -> {
            SpuImgDO spuImgDO = new SpuImgDO();
            spuImgDO.setImg(s);
            spuImgDO.setSpuId(supId.intValue());
            return spuImgDO;
        }).collect(Collectors.toList());
        spuImgService.saveBatch(spuImgDOList);
    }


}
