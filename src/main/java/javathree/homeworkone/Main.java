package javathree.homeworkone;

import javathree.homeworkone.boxes.Box;
import javathree.homeworkone.fruits.*;


public class Main {
    public static void main(String[] args)
    throws Exception{
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addItemToBox(new Orange());
        orangeBox.addItemToBox(new Orange(), new Orange(), new Orange());
        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addItemToBox(new Orange());
        orangeBox2.addItemToBox(new Orange(), new Orange(), new Orange(), new Orange());
        Box<Apple> appleBox = new Box<>();
        appleBox.addItemToBox(new Apple());
        appleBox.addItemToBox(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        System.out.println(orangeBox.getBoxWeight());
        System.out.println(appleBox.getBoxWeight());
        System.out.println(orangeBox.compareWeight(appleBox));
        orangeBox.moveContentToAnotherBox(orangeBox2);
        System.out.println(orangeBox.getBoxWeight());
        System.out.println(orangeBox2.getBoxWeight());
    }
}
