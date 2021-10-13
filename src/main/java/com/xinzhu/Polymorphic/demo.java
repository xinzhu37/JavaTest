package com.xinzhu.Polymorphic;

/**
 * Create By GuoFZ on 2021/10/11
 */
class  Matcher{
    public void eat(){
        System.out.println("想吃烤山猪？");
    }

}

class Boy extends Matcher2 {
    public void eatKaoYang(){
        System.out.println("妈妈，我(儿子)想吃烤山猪");
    }
}

class Girl extends Matcher2 {
    public void eatKaoYang(){
        System.out.println("妈妈，我(闺女)想吃烤山猪");
    }
}

public class demo {
    public static void main(String[] args) {

        Matcher2 g = new Boy();//向上转型编译通过

        if (g instanceof Girl){
            Girl girl = (Girl) g;
            girl.eatKaoYang();
        } else if (g instanceof Boy){
            Boy boy = (Boy) g;
            boy.eatKaoYang();
        }

        // Boy x = (Boy)g;//向下转型

        // x.eatKaoYang();//编译通过,但运行报ClassCastException

    }
}
