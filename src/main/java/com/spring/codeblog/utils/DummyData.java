package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeblogRepository codeblogRepository;

//    @PostConstruct
    public void savePosts(){

        List<Post> postsList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Felipe Trindade");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("Texto de implementação de projeto springboot modelo de estudos");

        Post post2 = new Post();
        post2.setAutor("Jady Trindade");
        post2.setData(LocalDate.now());
        post2.setTitulo("Api Rest");
        post2.setTexto("Texto de implementação de projeto springboot modelo de estudos");

        postsList.add(post1);
        postsList.add(post2);

        for(Post post: postsList){
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
