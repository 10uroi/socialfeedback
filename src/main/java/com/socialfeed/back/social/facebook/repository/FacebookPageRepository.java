package com.socialfeed.back.social.facebook.repository;

import com.socialfeed.back.social.facebook.entity.FacebookPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookPageRepository extends JpaRepository<FacebookPage, Long> {

}
