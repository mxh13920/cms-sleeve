package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.SpecKeyDO;
import io.github.talelin.latticy.model.SpuKeyDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface SpuKeyMapper extends BaseMapper<SpuKeyDO> {

    List<SpecKeyDO> getBySpuId(Long id);
}
