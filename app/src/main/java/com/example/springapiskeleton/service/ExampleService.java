package com.example.springapiskeleton.service;

import com.example.springapiskeleton.dao.ExampleTableRepository;
import com.example.springapiskeleton.models.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleTableRepository exampleTableRepository;

    public List<com.example.springapiskeleton.api.model.Example> getExamples(){
        List<Example> examples = exampleTableRepository.findAll();

        return examples.stream()
                .map(this:: mapExamples)
                .toList();
    }

    private com.example.springapiskeleton.api.model.Example mapExamples(Example example){
        return new com.example.springapiskeleton.api.model.Example()
                .id(example.getId())
                .fullName(example.getFullName())
                .age(example.getAge())
                .createdAt(example.getCreatedAt());
    }
}
