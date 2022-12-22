package io.admin.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.admin.modules.ums.mapper.UmsAdminRoleRelationMapper;
import io.admin.modules.ums.model.UmsAdminRoleRelation;
import io.admin.modules.ums.service.UmsAdminRoleRelationService;
import org.springframework.stereotype.Service;

/**
 * 管理员角色关系管理Service实现类
 * Created by macro on 2020/8/21.
 */
@Service
public class UmsAdminRoleRelationServiceImpl extends ServiceImpl<UmsAdminRoleRelationMapper, UmsAdminRoleRelation> implements UmsAdminRoleRelationService {
}
