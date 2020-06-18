package com.xd.practice.springboot_mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shawn
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("book")
@ApiModel(value="BookEntity对象", description="")
public class BookEntity extends Model<BookEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "书名")
    @TableField("`name`")
    private String name;

    @ApiModelProperty(value = "对书的描述")
    @TableField("`desc`")
    private String desc;

    @ApiModelProperty(value = "出版社")
    @TableField("press")
    private String press;

    @ApiModelProperty(value = "删除标识（0 未删除 1 已删除）")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人（存ID）")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "更新人（存ID）")
    @TableField("update_by")
    private String updateBy;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
