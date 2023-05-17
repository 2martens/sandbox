package de.twomartens.sandbox.enums;

import de.twomartens.sandbox.enums.model.OtherEnum;
import de.twomartens.sandbox.enums.model.TestEnum;

public class Store {
    private TestEnum test;
    private OtherEnum other;

    public TestEnum getTest() {
        return test;
    }

    public OtherEnum getOther() {
        return other;
    }

    public void setTest(TestEnum test) {
        this.test = test;
    }

    public void setOther(OtherEnum other) {
        this.other = other;
    }
}
