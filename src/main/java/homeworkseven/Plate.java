package homeworkseven;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void setFood(int foodAmount) {
        if (foodAmount < 0) {return;}
        this.food = foodAmount;
    }
    public int getFood() {
        return this.food;
    }
    public void decreaseFood(int decreaseAmount) {
        // альтернатива: this.food - decreaseAmount < 0 ? 0 : this.food - decreaseAmount;
        this.food = Math.max(this.food - decreaseAmount, 0);
    }
    public void showInfo() {
        System.out.println("Еды в тарелке: " + food);
    }
}
