package javaone.homeworkseven;

public class Cat {
    private String name;
    private int appetite;
    private boolean bellyful;

    {
        bellyful = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite(){
        return this.appetite;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= this.getAppetite()) {
            plate.decreaseFood(this.appetite);
            this.bellyful = true;
        }
    }

    public void showInfo(){
        System.out.println("Имя: " + this.name + "\n" +
            "Аппетит: " + this.appetite + "\n" +
            "Сытость: " + this.bellyful);
    }
}
