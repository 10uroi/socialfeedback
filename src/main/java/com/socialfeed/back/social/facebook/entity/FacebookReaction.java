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
@Table(name = "facebook_reactions")
@AllArgsConstructor
@NoArgsConstructor
public class FacebookReaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String postId;

    private String dataId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dbCreateDate;

    private int totalCount;

    private String reactionType;

}
