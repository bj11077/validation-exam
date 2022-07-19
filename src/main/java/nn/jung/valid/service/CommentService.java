package nn.jung.valid.service;

import lombok.RequiredArgsConstructor;
import nn.jung.valid.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;


    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
