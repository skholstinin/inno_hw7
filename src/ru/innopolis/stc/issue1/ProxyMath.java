package ru.innopolis.stc.issue1;

import java.util.ArrayList;
import java.util.List;

public class ProxyMath implements MathInterface {
    private MathBox mathbox;


    @Override
    public void addItem(Integer item) {
        if (mathbox == null) {
            mathbox = new MathBox();
        }
        mathbox.addItem(item);
    }

    @Override
    public int summator() {
        if (mathbox == null) {
            mathbox = new MathBox();
        }
        return mathbox.summator();
    }

    @Override
    public void searchAndRemoveItem(Integer item) {
        if (mathbox == null) {
            mathbox = new MathBox();
        }
        mathbox.searchAndRemoveItem(item);
    }

    @Override
    public List splitter(int divider) {
        if (mathbox == null) {
            mathbox = new MathBox();
        }
        return mathbox.splitter(divider);
    }

    @Override
    public void setNumberTreeSet(ArrayList<Integer> array) {
        if (mathbox == null) {
            mathbox = new MathBox();
        }
    }
}

