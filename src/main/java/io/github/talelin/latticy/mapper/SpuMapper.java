package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.SpuDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.SpuDetailDO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-07-20
 */
public interface SpuMapper extends BaseMapper<SpuDO> {

    SpuDetailDO getDetail(Long id);


}
