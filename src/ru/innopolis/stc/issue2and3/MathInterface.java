package ru.innopolis.stc.issue2and3;

import java.util.List;

public interface MathInterface {

    void clearData();

    double getPi();

    void addItem(Integer item);

    int summator();

    void searchAndRemoveItem(Integer item);

    List splitter(int divider);
}
