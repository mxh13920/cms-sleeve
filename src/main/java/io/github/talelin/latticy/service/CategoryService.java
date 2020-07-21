package io.github.talelin.latticy.service;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-07-21
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, CategoryDO>  {

    public CategoryDO getCategoryById(Integer id) {
        CategoryDO bySpuId = this.getBaseMapper().getBySpuId(id);
        if (bySpuId == null) {
            throw new NotFoundException(40000);
        }
        return bySpuId;
    }

}
