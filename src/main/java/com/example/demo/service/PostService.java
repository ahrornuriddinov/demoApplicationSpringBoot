package com.example.demo.service;

import com.example.demo.entity.PostData;
import com.example.demo.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {

    private final RestTemplate restTemplate;
    private final PostDataService postDataService;
    @Value("${api.jsonplaceholder}")
    private String api;


    public Post save(Post post){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<>(post,headers);
        Post result = restTemplate.exchange(this.api+"/posts",HttpMethod.POST,entity, Post.class).getBody();
        return result;
    }
    public Object findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post[]> entity = new HttpEntity<>(headers);
        Post[] result = restTemplate.exchange(this.api+"/posts", HttpMethod.GET,entity,Post[].class).getBody();
        postDataService.saveAll(result);
        return result;
        }
        public Post update(Long id,Post post){
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Post> entity = new HttpEntity<>(post,headers);
            Post result = restTemplate.exchange(this.api+"/posts/"+id,HttpMethod.PUT,entity, Post.class).getBody();
            return result;
        }
        public List<Post> findAllByQueryParam(Long postId){
            HttpEntity<Post[]> entity = new HttpEntity<>(getHeader());
            String urlTemplete = UriComponentsBuilder.fromHttpUrl(this.api+"/comments")
                    .queryParam("postId","{postId}")
                    .encode()
                    .toUriString();

            Map<String,Object> params = new HashMap<>();
            params.put("postId",postId);

            List<Post> result = restTemplate.exchange(
                    urlTemplete, HttpMethod.GET,entity,List.class,params).getBody();
            return result;
        }


        private HttpHeaders getHeader(){
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            return headers;
        }

        public Page<PostData> findAllPage(Pageable pageable){
        return postDataService.findAllPage(pageable);
        }
}
