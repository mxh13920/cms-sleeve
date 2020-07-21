package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.SpecKeyDO;
import io.github.talelin.latticy.model.SpuKeyDO;
import io.github.talelin.latticy.mapper.SpuKeyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-07-20
 */
@Service
public class SpuKeyService extends ServiceImpl<SpuKeyMapper, SpuKeyDO> {

    public List<SpecKeyDO> getBySpuId(Long id){
        return this.getBaseMapper().getBySpuId(id);
    }
}
