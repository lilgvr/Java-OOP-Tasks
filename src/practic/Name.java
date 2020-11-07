package practic;

public class Name {
    private String name, midname, surname;
    private static NameBuildable builder;

    private Name(String name, String midname, String surname) {
        this.name = name;
        this.midname = midname;
        this.surname = surname;
    }

    public static NameBuildable getBuilder(){
        if(builder == null){
            builder = new NameBuilder();
            return builder;
        }

        return builder;
    }

    private static class NameBuilder implements NameBuildable{
        private String name, midname, surname;

        public NameBuildable setName(String name) {
            this.name = name;
            return this;
        }

        public NameBuildable setMidname(String midname) {
            this.midname = midname;
            return this;
        }

        public NameBuildable setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Name getName(){
            return new Name(name, midname, surname);
        }
    }

    public String toString(){
        return (midname == null)? (surname == null)? name :
                name + " " + surname :
                name + " " + midname + " " + surname;
    }
}

