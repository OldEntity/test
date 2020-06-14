package com.lishuo.ocr.entity;

import lombok.*;

/**
 * @Program：test
 * @Description：识别结果详情类
 * @Author：LearnLi
 * @Create:2020-03-27 20:13
 */

@Data
@NoArgsConstructor
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class OCRDetail {

    private static final long serialVersionUID = 8676131899637805511L;

    private String DiscernType;
    private String SuccessPercent;
    private String DiscernData;

}
