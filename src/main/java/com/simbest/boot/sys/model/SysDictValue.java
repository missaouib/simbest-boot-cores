/*
 * 版权所有 © 北京晟壁科技有限公司 2008-2027。保留一切权利!
 */
package com.simbest.boot.sys.model;

import com.simbest.boot.base.annotations.EntityIdPrefix;
import com.simbest.boot.base.model.LogicModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 用途：数据字典值
 * 作者: lishuyi
 * 时间: 2018/1/30  17:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sys_dict_value", uniqueConstraints = {
        @UniqueConstraint(name="blocid_corpid_dictType_name", columnNames = {"blocid", "corpid", "dictType", "name"})
})
public class SysDictValue extends LogicModel {

    public final static String VALUE_TYPE_INT = "int";
    public final static String VALUE_TYPE_VARCHAR = "varchar";
    public final static String VALUE_TYPE_DATE = "date";
    public final static String VALUE_TYPE_DATETIME = "datetime";

    public final static String SYS_CONFIG = "sysconfig";

    @Id
    @Column(name = "id", length = 40)
    @GeneratedValue(generator = "snowFlakeId")
    @GenericGenerator(name = "snowFlakeId", strategy = "com.simbest.boot.util.distribution.id.SnowflakeId")
    @EntityIdPrefix(prefix = "V") //主键前缀，此为可选项注解
    private String id;

    @ApiModelProperty(value = "字典值名称")
    @Column(nullable = false, length = 200)
    private String name;

    @ApiModelProperty(value = "字典值")
    @Column(nullable = false, length = 200)
    private String value;

    @ApiModelProperty(value = "字典值描述")
    @Column
    private String description;

    @ApiModelProperty(value = "字典值排序")
    @Column
    private Integer displayOrder;

    @ApiModelProperty(value = "父亲节点外键")
    @Column
    private String parentId;

    @ApiModelProperty(value = "字典类型")
    @Column(nullable = false)
    private String dictType;

    @ApiModelProperty(value = "字典值类型")
    @Column
    private String valueType;

    @ApiModelProperty(value = "是否默认选择")
    @Column
    private Boolean isDefault;

    @ApiModelProperty(value = "流程类型标识")
    @Column(length = 50)
    private String flag;

    @ApiModelProperty(value = "扩展字段1")
    @Column(length = 200)
    private String spare1;

    @ApiModelProperty(value = "扩展字段2")
    @Column(length = 200)
    private String spare2;

    @ApiModelProperty(value = "集团id")
    @Column(length = 40)
    private String blocid;

    @ApiModelProperty(value = "企业id")
    @Column(length = 40)
    private String corpid;

}
