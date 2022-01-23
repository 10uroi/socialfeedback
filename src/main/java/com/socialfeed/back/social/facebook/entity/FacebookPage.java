package com.socialfeed.back.social.facebook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@Entity
@Table(name = "facebook_pages")
@AllArgsConstructor
@NoArgsConstructor
public class FacebookPage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dbCreateDate;

    @Column(length = 999)
    private String accessToken;

    private String category;
    private String name;
    private String dataId;
    private String tasks;

    private String before;
    private String after;


}
