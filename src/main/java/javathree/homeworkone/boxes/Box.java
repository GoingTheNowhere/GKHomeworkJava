package javathree.homeworkone.boxes;

import javathree.homeworkone.fruits.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> content = new ArrayList<>();

    public double getBoxWeight(){
        double result = .0;
        for (T c: this.content) {
            result += c.getWeight();
        }
        return result;
    }

    public void addItemToBox(T... item){
        this.content.addAll(Arrays.asList(item));
    }

    public boolean compareWeight(Box<? extends Fruit> box){
        return this.getBoxWeight() == box.getBoxWeight();
    }

    public void moveContentToAnotherBox(Box<T> box){
        if(this.content.isEmpty()){
            return;
        }
        box.content.addAll(this.content);
        this.content.clear();
    }

}
