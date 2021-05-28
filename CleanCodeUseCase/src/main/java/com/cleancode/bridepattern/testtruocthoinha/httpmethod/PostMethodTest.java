package com.cleancode.bridepattern.testtruocthoinha.httpmethod;

import com.cleancode.common.constants.Constants;
import com.cleancode.common.errors.LogicException;
import com.cleancode.common.utils.URIBuilderUtils;
import java.net.URI;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostMethodTest extends DefaultMethodTest {

    PostMethodTest(String hostName, String hostPort, String connectionErrorMessage) {
        super(hostName, hostPort, connectionErrorMessage);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T resultObject(String apiName,
        ParameterizedTypeReference<Map<String, T>> responseType, T body,
        Map<String, Object> params, String... pathSegment) throws LogicException {

        HttpEntity<Object> requestEntity = new HttpEntity<>(body);
        URI uri = URIBuilderUtils.getUri(this.hostName, this.hostPort, apiName, params, pathSegment);

        ResponseEntity<Map<String, T>> response = restTemplate
            .exchange(uri, HttpMethod.POST, requestEntity, responseType);
        // Check response status
        if (response.getStatusCodeValue() != HttpStatus.OK.value()) {
            throw new LogicException(this.connectionErrorMessage);
        }
        if (!response.hasBody()) {
            return null;
        }
        return response.getBody().get(Constants.RESULT_RESPONSE_BODY);
    }
}
