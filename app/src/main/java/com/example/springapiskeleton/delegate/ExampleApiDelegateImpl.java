package com.example.springapiskeleton.delegate;


import com.example.springapiskeleton.api.ExampleApiDelegate;
import com.example.springapiskeleton.api.model.Example;
import com.example.springapiskeleton.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleApiDelegateImpl implements ExampleApiDelegate {

    private final ExampleService exampleService;

    @Override
    public ResponseEntity<List<Example>> getExample() {
        List<Example> response = exampleService.getExamples();

        return ResponseEntity.ok().body(response);
    }
}