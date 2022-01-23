package com.socialfeed.back.social.facebook.repository;

import com.socialfeed.back.social.facebook.entity.FacebookReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookReactionRepository extends JpaRepository<FacebookReaction, Long> {

}
