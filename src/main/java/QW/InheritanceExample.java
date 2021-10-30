package QW;

public class InheritanceExample {
    static class Character1 {

        Character1() {
            System.out.println("A Character has been created");
        }
        Character1(String name) {
            System.out.println(name + "was invoked");
        }
        void move() {
            System.out.println("Character walking...");
        }

    }

    static class Moe extends Character1 {

        Moe() {
            super();
        }

        void giveBeer() {
            super.move();
            System.out.println("Give beer");
        }

    }
    static class Barney extends Character1 {

        Barney() {
            super("Barney Gumble");
        }
    }

    public static void main(String[] args) {
        Character1 c1 = new Character1();
        Moe m1 = new Moe();
        Barney b1 = new Barney();
        m1.giveBeer();
    }
}
