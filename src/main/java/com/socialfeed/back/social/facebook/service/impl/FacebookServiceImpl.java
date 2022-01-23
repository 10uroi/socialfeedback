package com.socialfeed.back.social.facebook.service.impl;

import com.socialfeed.back.configuration.Properties;
import com.socialfeed.back.service.ConfigService;
import com.socialfeed.back.social.facebook.entity.FacebookPage;
import com.socialfeed.back.social.facebook.entity.FacebookPost;
import com.socialfeed.back.social.facebook.entity.FacebookReaction;
import com.socialfeed.back.social.facebook.mapper.FacebookMapper;
import com.socialfeed.back.social.facebook.model.page.FacebookPageModel;
import com.socialfeed.back.social.facebook.model.post.FacebookPostModel;
import com.socialfeed.back.social.facebook.model.reaction.FacebookReactionModel;
import com.socialfeed.back.social.facebook.model.reaction.FacebookReactionTypeEnum;
import com.socialfeed.back.social.facebook.repository.FacebookPageRepository;
import com.socialfeed.back.social.facebook.repository.FacebookPostRepository;
import com.socialfeed.back.social.facebook.repository.FacebookReactionRepository;
import com.socialfeed.back.social.facebook.request.FacebookRequest;
import com.socialfeed.back.social.facebook.service.FacebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FacebookServiceImpl implements FacebookService {

    private final ConfigService configService;
    private final FacebookPageRepository facebookPageRepository;
    private final FacebookPostRepository facebookPostRepository;
    private final FacebookReactionRepository facebookReactionRepository;
    private final FacebookRequest facebookRequest;

    public void getFacebookPageJob() {
        String token = configService.getConfigFindByKey(Properties.FACEBOOK_TOKEN_KEY).getValue();
        String me = configService.getConfigFindByKey(Properties.FACEBOOK_ME_KEY).getValue();
        FacebookPageModel facebookPageModel = facebookRequest.getFacebookPage(me, token);
        List<FacebookPage> facebookPages = FacebookMapper.getFacebookPage(facebookPageModel);

        facebookPages.stream().forEach(facebookPage -> {
            saveFacebookPage(facebookPage);

            FacebookPostModel facebookPostModel = facebookRequest.getFacebookPost(facebookPage.getDataId(), token);
            List<FacebookPost> facebookPosts = FacebookMapper.getFacebookPost(facebookPostModel);

            facebookPosts.stream().forEach(facebookPost -> {
                saveFacebookPost(facebookPage.getDataId(), facebookPost);

                Arrays.stream(FacebookReactionTypeEnum.values()).forEach(facebookReactionTypeEnum -> {
                    FacebookReactionModel facebookReactionModel = facebookRequest.getFacebookReaction(facebookPost.getDataId(), token, facebookReactionTypeEnum);
                    if (facebookReactionModel.getReactions().getSummary().getTotal_count() > 0) {

                        FacebookReaction reaction = FacebookMapper.getFacebookReaction(facebookReactionModel);
                        reaction.setPostId(facebookPost.getDataId());
                        reaction.setReactionType(facebookReactionTypeEnum.name());
                        facebookReactionRepository.save(reaction);

                    }
                });
            });
        });
    }

    private void saveFacebookPage(FacebookPage facebookPage) {
        facebookPageRepository.save(facebookPage);
    }

    private void saveFacebookPost(String pageId, FacebookPost facebookPost) {
        facebookPost.setPageId(pageId);
        facebookPostRepository.save(facebookPost);
    }

}
