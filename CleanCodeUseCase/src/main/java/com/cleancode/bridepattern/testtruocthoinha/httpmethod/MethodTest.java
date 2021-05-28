package com.cleancode.bridepattern.testtruocthoinha.httpmethod;


import com.cleancode.common.errors.LogicException;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;

public interface MethodTest {

    /**
     * データのタイプがオブジェクト一覧であるデータを取得する 「ポストメソッド」
     *
     * @param responseType データのタイプ
     * @param body         ボディ
     * @param params       パラメータ
     * @param pathSegment  パスセグメント
     * @return データ
     * @throws LogicException 論理例外
     */
     <T> T resultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType, T body,
                                          Map<String, Object> params, String... pathSegment) throws LogicException;

    default <T> T result(String apiName, T body, Map<String, Object> params, String... pathSegment) throws LogicException {
        return resultObject(apiName, new ParameterizedTypeReference<Map<String, T>>() { }, body, params, pathSegment);
    }

    default <T> T result(String apiName, T body, Map<String, Object> params) throws LogicException {
        return result(apiName, body, params, (String) null);
    }

    default <T> T result(String apiName, T body, String... pathSegment) throws LogicException {
        return result(apiName, body, null, pathSegment);
    }

    default <T> T result(String apiName, T body) throws LogicException {
        return result(apiName, body, (String) null);
    }

    default <T> T resultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType,
                                  T body, Map<String, Object> params) throws LogicException {
        return resultObject(apiName, responseType, body, params, (String) null);
    }

    default <T> T resultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType,
                                  T body, String... pathSegment) throws LogicException {
        return resultObject(apiName, responseType, body, null, pathSegment);
    }

    default <T> T resultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType, T body) throws LogicException {
        return resultObject(apiName, responseType, body, (String) null);
    }
}
