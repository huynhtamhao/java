package com.cleancode.bridepattern.externalsystem;

import com.cleancode.bridepattern.httpmethod.ExternalMethod;
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

public abstract class ExternalSystem implements ExternalMethod {

    abstract String getConnectionErrorMessage();
    abstract String getHostIp();
    abstract String getHostPort();

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T putResultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType, Object body, Map<String, Object> params, String... pathSegment) throws LogicException {
        HttpEntity<Object> requestEntity = new HttpEntity<>(body);
        URI uri = URIBuilderUtils.getUri(this.getHostIp(), this.getHostPort(), apiName, params, pathSegment);
        ResponseEntity<Map<String, T>> response = restTemplate.exchange(uri, HttpMethod.PUT, requestEntity, responseType);
        // Check response status
        if (response.getStatusCodeValue() != HttpStatus.OK.value()) {
            throw new LogicException(this.getConnectionErrorMessage());
        }
        if (!response.hasBody()) {
            return null;
        }
        return response.getBody().get(Constants.RESULT_RESPONSE_BODY);
    }
}
