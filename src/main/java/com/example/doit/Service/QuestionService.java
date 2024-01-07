package com.example.doit.Service;

import com.example.doit.Entity.Question;
import com.example.doit.Exception.DataNotFoundException;
import com.example.doit.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id) throws ConfigDataLocationNotFoundException {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) return question.get();
        else {
            throw new DataNotFoundException("question not found");
        }
    }
}
