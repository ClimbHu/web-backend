package com.atguigu.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: ClimbHu
 * @date: 2023年12月09日 23:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSchedule implements Serializable {

    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}
