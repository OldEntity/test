package com.lishuo.testshiro.tbuser.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @Program：TestSpringCloud
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-02 09:59
 */

@Entity
@Table(name="tbuser")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tbuser {
 @Id
 @GeneratedValue   //  自动生成
 private Integer userid;
 @NonNull
 private String username,password;
 private String userroles,nickname;
 private Date regtime;
}
