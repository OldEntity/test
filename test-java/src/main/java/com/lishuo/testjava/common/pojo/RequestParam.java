package com.lishuo.testjava.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.NameValuePair;

/**
 * @Program：test
 * @Description：请求参数
 * @Author：LearnLi
 * @Create:2020-08-02 00:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RequestParam implements NameValuePair {

private String name;
private String value;

}
