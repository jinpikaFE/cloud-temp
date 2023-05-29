package com.jinpika.temp.ums.ums.dto;

import com.jinpika.temp.ums.ums.model.Menu;
import com.jinpika.temp.ums.ums.model.Resource;
import com.jinpika.temp.ums.ums.model.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RoleDto extends Role {
    @ApiModelProperty("菜单ids")
    private List<Long> menuIds;

    @ApiModelProperty("资源ids")
    private List<Long> resourceIds;

    @ApiModelProperty("分配的菜单")
    private List<Menu> menus;

    @ApiModelProperty("分配的资源")
    private List<Resource> resources;
}
