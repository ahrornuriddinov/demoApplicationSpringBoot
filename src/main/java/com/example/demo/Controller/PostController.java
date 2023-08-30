package com.example.demo.Controller;

import com.example.demo.entity.PostData;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping("/posts")
    public ResponseEntity create(@RequestBody Post post){
        Post save = postService.save(post);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/posts")
    public ResponseEntity getPosts(){
        Object all = postService.findAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Post post){
        Post update = postService.update(id, post);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/posts/params")
    public ResponseEntity getAllByParam(@RequestParam Long postId){
        List<Post> param = postService.findAllByQueryParam(postId);
        return ResponseEntity.ok(param);
    }

    @GetMapping("/posts/paging")
    public ResponseEntity getAllByPaging(Pageable pageable){
        Page<PostData> allPage = postService.findAllPage(pageable);
        return ResponseEntity.ok(allPage);
    }
}
