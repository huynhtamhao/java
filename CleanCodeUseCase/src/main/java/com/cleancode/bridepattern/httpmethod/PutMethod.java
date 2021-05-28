package com.cleancode.bridepattern.httpmethod;


import com.cleancode.common.errors.LogicException;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;

public interface PutMethod {

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
     <T> T putResultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType, Object body,
                                          Map<String, Object> params, String... pathSegment) throws LogicException;

    default <T> T putResult(String apiName, Object body, Map<String, Object> params, String... pathSegment) throws LogicException {
        return putResultObject(apiName, new ParameterizedTypeReference<Map<String, T>>() { }, body, params, pathSegment);
    }

    default <T> T putResult(String apiName, Object body, Map<String, Object> params) throws LogicException {
        return putResult(apiName, body, params, (String) null);
    }

    default <T> T putResult(String apiName, Object body, String... pathSegment) throws LogicException {
        return putResult(apiName, body, null, pathSegment);
    }

    default <T> T putResult(String apiName, Object body) throws LogicException {
        return putResult(apiName, body, (String) null);
    }

    default <T> T putResultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType,
                                  Object body, Map<String, Object> params) throws LogicException {
        return putResultObject(apiName, responseType, body, params, (String) null);
    }

    default <T> T putResultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType,
                                  Object body, String... pathSegment) throws LogicException {
        return putResultObject(apiName, responseType, body, null, pathSegment);
    }

    default <T> T putResultObject(String apiName, ParameterizedTypeReference<Map<String, T>> responseType, Object body) throws LogicException {
        return putResultObject(apiName, responseType, body, (String) null);
    }
}
