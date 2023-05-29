package com.jinpika.temp.ums.ums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinpika.temp.ums.ums.dto.RoleDto;
import com.jinpika.temp.ums.ums.model.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色列表 服务类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface RoleService extends IService<Role> {
    /**
     * 添加角色
     *
     * @param roleDto
     * @return
     */
    @Transactional
    RoleDto create(RoleDto roleDto);

    /**
     * 删除资源分类
     *
     * @param id
     * @param role
     * @return
     */
    @Transactional
    Boolean delete(Long id, Role role);

    /**
     * 给角色分配菜单
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * @param roleId
     * @param resourceIds
     * @return
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);

    @Transactional
    boolean update(Integer id, RoleDto roleDto);

    /**
     * 分页获取角色列表
     *
     * @param keyword
     * @param pageSzie
     * @param pageNum
     * @return
     */
    Page<Role> list(String keyword, Integer pageSzie, Integer pageNum);
}
