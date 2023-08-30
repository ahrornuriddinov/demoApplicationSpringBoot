package com.example.demo.service;

import com.example.demo.entity.PostData;
import com.example.demo.model.Post;
import com.example.demo.repository.PostDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostDataService {
    private final PostDataRepository postDataRepository;

    public PostData save(PostData postData){
        return postDataRepository.save(postData);
    }

    public List<PostData> saveAll(Post[] posts){
        List<PostData> postDataList = new ArrayList<>();
        for (Post post :
                posts) {
            PostData postData = new PostData();
            postData.setPostId(post.getId());
            postData.setUserId(post.getUserId());
            postData.setTitle(post.getTitle());
            postData.setBody(post.getBody());
            postDataList.add(postData);
        }
        return postDataRepository.saveAll(postDataList);
    }
    @Transactional(readOnly = true)
    public Page<PostData> findAllPage(Pageable pageable){
        return postDataRepository.findAll(pageable);
    }
}
