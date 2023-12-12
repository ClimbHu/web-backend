package com.atguigu.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 1 实体类的类名和表格名称应该对应
 * 2 实体类的属性名和表格的列名对应
 * 3 每个属性必须都是私有的
 * 4 每个属性都应具备 getter setter
 * 5 必须具备无参构造器
 * 6 应该实现序列化接口(缓存 分布式项目中的数据传递 可能会将对象序列化)
 * 7 应该重写类的hashcode和equals方法
 * 8 toString是否重写都可以
 *
 * 使用Lombok帮助我们生成这些内容 getter setter 全参构造 无参构造 equals hashcode
 *      Lombok使用步骤：
 *          1 检查IDEA是否安装了Lombok插件
 *          2 检查是否开启了 enable annotation processing
 *          3 导入lombok依赖
 *
 * @author: ClimbHu
 * @date: 2023年12月09日 23:54
 */
@AllArgsConstructor // 全参构造区
@NoArgsConstructor // 无参构造器
@Data // set get equals hashcode toString
public class SysUser implements Serializable {

    private Integer uid;
    private String username;
    private String userPwd;

}
