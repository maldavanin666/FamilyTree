import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private long id;
    private String name;
    private LocalDate birth;
    private LocalDate death;
    private Gender gender;
    private List<Human> parents;
    private List<Human> children;

    public Human (String name, LocalDate birth, LocalDate death, Gender gender, Human mother, Human father){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        children = new ArrayList<>();
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
    }

    public Human (String name, Gender gender, LocalDate birth) {
        this(name, birth, null, gender, null, null);
    }

    public Human (String name, Gender gender, LocalDate birth, Human mother, Human father) {
        this(name, birth, null, gender, mother, father);
    }

    public boolean addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for(Human parent : parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for(Human parent : parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    private int getDate(LocalDate birth, LocalDate death){
        Period date = Period.between(birth, death);
        return date.getYears();
    }

    public int getAge(){
        if(death == null){
            return getDate(birth, LocalDate.now());
        } else {
            return getDate(birth, death);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(gender);
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(getMother());
        sb.append(", ");
        sb.append(getFather());
        sb.append(", ");
        sb.append(getChildren());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестно: ";
        }

        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестно: ";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("нет");
            }
            return res.toString();
            }
        }


