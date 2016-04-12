package studio365.exerapp2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by 성훈 on 2016-04-05.
 */
public class ExerData extends RealmObject {

    @PrimaryKey
    private int date;
    private String exerName;

    private int weight_exer;
    private int times;
    private int set;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getExerName() {
        return exerName;
    }

    public void setExerName(String exerName) {
        this.exerName = exerName;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getWeight_exer() {
        return weight_exer;
    }

    public void setWeight_exer(int weight) {
        this.weight_exer = weight_exer;
    }
}
