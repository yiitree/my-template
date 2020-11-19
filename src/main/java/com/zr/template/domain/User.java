package com.zr.template.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value="sys_user") //建立User.class和数据的sys_user表的关系
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

    //代表它是主键
	@TableId(value="id")
	private Integer id;

	@TableField(value="name")
	private String name;

	private String address;

	private Date birth;

//    @TableField(exist=false)//当查询结果里面没有这个字段可以这个方法忽略这个属性
//    private String sex;

    /**
     * 返回中不会存在此字段，
     * 接收时：如果为@RequestBody，则该字段为null
     * 如果不加@RequestBody，则可以接收到值
     */
//    @JsonIgnore
//    private String password;
}
