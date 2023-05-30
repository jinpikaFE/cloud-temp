package com.jinpika.temp.ums.ums.dto;

import com.jinpika.temp.ums.ums.model.Admin;
import com.jinpika.temp.ums.ums.model.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AdminDto extends Admin {
    @ApiModelProperty("角色ids")
    private List<Integer> roleIds;

    @ApiModelProperty("角色")
    private List<Role> roles;
}
