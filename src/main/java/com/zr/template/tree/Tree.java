package com.zr.template.tree;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//@ApiModel(description = "树形VO")
public class Tree<T> {

//	@ApiModelProperty("节点ID")
	private Integer id;

//	@ApiModelProperty("节点文本")
	private String name;

//	@ApiModelProperty("节点父级ID")
	private Integer parentId;

//    @ApiModelProperty("节点level")
    private Integer level;

//    @ApiModelProperty("子节点")
	private List<Tree<T>> children = new ArrayList<Tree<T>>();

}
