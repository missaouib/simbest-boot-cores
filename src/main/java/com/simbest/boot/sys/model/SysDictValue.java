/*
 * 版权所有 © 北京晟壁科技有限公司 2008-2027。保留一切权利!
 */
package com.simbest.boot.sys.model;

import com.simbest.boot.base.annotations.EntityIdPrefix;
import com.simbest.boot.base.model.LogicModel;
import lombok.AllArgsConstructor;
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
@Entity
public class SysDictValue extends LogicModel {

    public final static String VALUE_TYPE_INT = "int";
    public final static String VALUE_TYPE_VARCHAR = "varchar";
    public final static String VALUE_TYPE_DATE = "date";
    public final static String VALUE_TYPE_DATETIME = "datetime";

    @Id
    @Column(name = "id", length = 40)
    @GeneratedValue(generator = "snowFlakeId")
    @GenericGenerator(name = "snowFlakeId", strategy = "com.simbest.boot.util.distribution.id.SnowflakeId")
    @EntityIdPrefix(prefix = "V") //主键前缀，此为可选项注解
    private String id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String value;

    @Column
    private String description;

    @Column
    private Integer displayOrder;

    @Column
    private String parentId;

    @Column(nullable = false)
    private String dictType;

    @Column
    private String valueType;

    @Column
    private Boolean isDefault;

    @Column(length = 50)
    private String flag;

    @Column(length = 200)
    private String spare1;

    @Column(length = 200)
    private String spare2;

    private String blocid; //集团id

    private String corpid; //企业id

}
