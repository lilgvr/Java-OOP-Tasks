package practic.univer;

import java.util.List;

public abstract class Door {
    private final String name;

    private Door(String name) {
        this.name = name;
    }

    public abstract Gift open(Gift... gifts);

    public abstract Gift open(List<Gift> gifts);


    public static final Door ONE = new Door("ONE") {

        public Gift open(Gift... gifts) {
            for (Gift i : gifts) {
                if (i.toString().equals("Автомобиль")) return i;
            }

            throw new IllegalArgumentException("В списке подарков нет автомобиля");
        }

        public Gift open(List<Gift> gifts) {
            for (Gift i : gifts) {
                if (i.toString().equals("Автомобиль")) return i;
            }

            throw new IllegalArgumentException("В списке подарков нет автомобиля");
        }
    };

    public static final Door TWO = new Door("TWO") {

        public Gift open(Gift... gifts) {
            return null;
        }

        public Gift open(List<Gift> gifts) {
            return null;
        }
    };

    public static final Door THREE = new Door("THREE") {
        public Gift open(Gift... gifts) {
            return gifts[(int) (Math.random() * gifts.length)];
        }


        public Gift open(List<Gift> gifts) {
            return gifts.get((int) (Math.random() * gifts.size()));
        }
    };

    public String toString() {
        return "Door: " + name;
    }

    ;
}






