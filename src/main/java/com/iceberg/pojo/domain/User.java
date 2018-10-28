package com.iceberg.pojo.domain;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@DynamicUpdate
@Data
public class User {
    @Id
    private String id;

    /* 用户名，账号*/
    private String username;

    /** 密码 */
    private String password;

    /** 我的头像，如果没有默认给一张 */
    private String faceImage;

    /** */
    private String faceImageBig;

    /** 昵称 */
    private String nickname;

    /** 新用户注册后默认后台生成二维码，并且上传到fastdfs*/
    private String qrCode;

    private String cid;

    @CreatedDate
    private Date createTime = new Date(System.currentTimeMillis());

    @LastModifiedDate
    private Date updateTime = new Date(System.currentTimeMillis());

}
