package ru.innopolis.stc.issue1;

import java.util.ArrayList;
import java.util.List;

public interface MathInterface {

    void addItem(Integer item);

    int summator();

    void searchAndRemoveItem(Integer item);

    List splitter(int divider);

    void setNumberTreeSet(ArrayList<Integer> array);

}
