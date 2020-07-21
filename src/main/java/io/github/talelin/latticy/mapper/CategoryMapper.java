package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.CategoryDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-07-21
 */
@Repository
public interface CategoryMapper extends BaseMapper<CategoryDO> {

    CategoryDO getBySpuId(Integer id);
}
