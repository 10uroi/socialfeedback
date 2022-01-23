package com.socialfeed.back.social.facebook.repository;

import com.socialfeed.back.social.facebook.entity.FacebookPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookPostRepository extends JpaRepository<FacebookPost, Long> {

}
