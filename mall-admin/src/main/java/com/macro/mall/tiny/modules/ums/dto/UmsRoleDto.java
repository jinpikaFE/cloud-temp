package io.admin.modules.ums.dto;

import io.admin.modules.ums.model.UmsMenu;
import io.admin.modules.ums.model.UmsResource;
import io.admin.modules.ums.model.UmsRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UmsRoleDto extends UmsRole {
    @ApiModelProperty(value = "分配的菜单")
    private List<UmsMenu> menus;
    @ApiModelProperty(value = "分配的资源")
    private List<UmsResource> resources;
}
