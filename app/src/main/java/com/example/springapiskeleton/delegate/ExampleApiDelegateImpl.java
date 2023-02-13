package com.example.springapiskeleton.delegate;


import com.example.springapiskeleton.api.ExampleApiDelegate;
import com.example.springapiskeleton.api.model.GetExample200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExampleApiDelegateImpl implements ExampleApiDelegate {

    @Override
    public ResponseEntity<GetExample200Response> getExample() {
        GetExample200Response response = new GetExample200Response();
        response.status("Success");

        return ResponseEntity.ok().body(response);
    }
}
