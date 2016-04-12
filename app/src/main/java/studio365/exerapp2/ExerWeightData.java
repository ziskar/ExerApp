package studio365.exerapp2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by 성훈 on 2016-04-06.
 */
public class ExerWeightData extends RealmObject {

    @PrimaryKey
    private int date;

    private int weight;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
