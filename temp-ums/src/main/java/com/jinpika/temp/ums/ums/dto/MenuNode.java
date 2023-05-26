package com.jinpika.temp.ums.ums.dto;

import com.jinpika.temp.ums.ums.model.Menu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuNode extends Menu {
    @ApiModelProperty(value = "子级菜单")
    private List<MenuNode> children;
}
