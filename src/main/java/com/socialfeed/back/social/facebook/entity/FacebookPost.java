package com.socialfeed.back.social.facebook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@Entity
@Table(name = "facebook_posts")
@AllArgsConstructor
@NoArgsConstructor
public class FacebookPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pageId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dbCreateDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(length = 99999)
    private String message;
    private String statusType;
    private String dataId;

    private String before;
    private String after;

}
