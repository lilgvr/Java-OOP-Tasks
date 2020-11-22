package practic.univer;

import java.util.ArrayList;
import java.util.List;

public class Name {
    private String name, midname, surname;
    private static NameBuildable builder;

    private Name(String name, String midname, String surname) {
        this.name = name;
        this.midname = midname;
        this.surname = surname;
    }

    public static NameBuildable getBuilder() {
        if (builder == null) {
            builder = new NameBuilder();
        }

        return builder;
    }

    private static class NameBuilder implements NameBuildable {
        private String name, midname, surname;
        private List <Name> names = new ArrayList <>();

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

        public Name getName() {
            Name res = new Name(name, midname, surname);

            if (names.contains(res)) return names.get(names.indexOf(res));

            names.add(res);

            return res;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != Name.class) return false;

        Name object = (Name) obj;

        if (name != null && object.name != null && !this.name.equals(object.name)) return false;
        if (midname != null && object.midname != null && !this.midname.equals(object.midname)) return false;
        if (surname != null && object.surname != null && !this.surname.equals(object.surname)) return false;

        return true;
    }

    public int hashCode() {
        return name.hashCode() + midname.hashCode() + surname.hashCode();
    }

    public String toString() {
        return (midname == null) ? (surname == null) ? name :
                                   name + " " + surname :
               name + " " + midname + " " + surname;
    }
}

