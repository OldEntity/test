package com.lishuo.testspringboot.watermark;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import static org.opencv.highgui.Highgui.imread;
import static org.opencv.highgui.Highgui.imwrite;

/**
 * @Program：test
 * @Description：入口类
 * @Author：LearnLi
 * @Create:2020-02-17 19:37
 */

public class Main {

    static{
        //加载opencv动态库
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args){
        Mat img = Highgui.imread("E:\\缓存库\\Wallpaper\\WallpaperStudio10-102533.jpg");//加载图片
        Mat outImg = ImgWatermarkUtil.addImageWatermarkWithText(img,"testwatermark");
        imwrite("stzz-out.jpg",outImg);//保存加过水印的图片
        //读取图片水印
        Mat watermarkImg = ImgWatermarkUtil.getImageWatermarkWithText(outImg);
        imwrite("stzz-watermark.jpg",watermarkImg);//保存获取到的水印
    }
}
