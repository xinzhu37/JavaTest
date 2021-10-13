package com.xinzhu.Polymorphic;

class Matcher2 {
    public void matcherSpeak(){
        System.out.println("想吃烤山药？");
    }
}

class HappyMother extends Matcher2 {
    
}
class SadMother extends HappyMother{
    public void tt(){
        System.out.println("ttttttt");
    }
}
public class Test {
    public static void main(String[] args) {
        Matcher2 mm=new SadMother();
        mm.matcherSpeak();
    }

}
