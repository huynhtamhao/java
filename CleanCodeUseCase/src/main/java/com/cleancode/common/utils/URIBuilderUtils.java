package com.cleancode.common.utils;

import com.cleancode.common.constants.Constants;
import java.net.URI;
import java.util.Map;
import org.springframework.web.util.UriComponentsBuilder;

public class URIBuilderUtils {

    private URIBuilderUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Create URI
     *
     * @param hostName    Host of the service
     * @param hostPort    Port of the service
     * @param params      Query Parameter
     * @param pathSegment Path Parameter
     * @return Uriコンポーネントビルダー
     */
    public static URI getUri(String hostName, String hostPort, String apiName,
        Map<String, Object> params, String... pathSegment) {
        String url = Constants.HTTP + hostName + Constants.COLON + hostPort + apiName;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .pathSegment(pathSegment);
        if (params != null) {
            params.forEach(builder::queryParam);
        }
        return builder.encode().build().toUri();

    }
}
