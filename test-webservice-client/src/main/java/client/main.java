package client;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-04 15:21
 */

public class main {
    public static void main(String[] args) {
        DemoService_Service dss=new DemoService_Service();
        DemoService ds=dss.getDemoServiceImplPort();
        String result=ds.hello("lishuo");
        System.out.println("收到的结果为："+result);

    }
}
