package com.cleancode.testtruocthoinha;

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

public class PutMethodTestImpl implements PutMethodTest {

    private final String hostName;
    private final String hostPort;
    private final String connectionErrorMessage;

    PutMethodTestImpl(String hostName, String hostPort, String connectionErrorMessage) {
        this.hostName = hostName;
        this.hostPort = hostPort;
        this.connectionErrorMessage = connectionErrorMessage;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T putResultObject(String apiName,
        ParameterizedTypeReference<Map<String, T>> responseType, Object body,
        Map<String, Object> params, String... pathSegment) throws LogicException {
        HttpEntity<Object> requestEntity = new HttpEntity<>(body);
        URI uri = URIBuilderUtils
            .getUri(this.hostName, this.hostPort, apiName, params, pathSegment);
        ResponseEntity<Map<String, T>> response = restTemplate
            .exchange(uri, HttpMethod.PUT, requestEntity, responseType);
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
