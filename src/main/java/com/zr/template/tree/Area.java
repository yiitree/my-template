package com.zr.template.tree;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area implements Serializable {

//    @ApiModelProperty("主键ID")
    private Integer id;

//    @ApiModelProperty("父级ID 0为顶级")
    private Integer parentId;

//    @ApiModelProperty("区域名称")
    private String name;

//    @ApiModelProperty("状态 1启用 0禁用")
    private String status;

//    @ApiModelProperty("菜单等级")
    private Integer level;

    private static final long serialVersionUID = 1L;

}
