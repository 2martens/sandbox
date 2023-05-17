package de.twomartens.sandbox.enums;

import de.twomartens.sandbox.enums.model.AscEnum;
import de.twomartens.sandbox.enums.model.OtherEnum;
import de.twomartens.sandbox.enums.model.TestEnum;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task<Store, ?>> tasks = List.of(
                new Task<>(Store::setTest, column -> parse(column, TestEnum.class)),
                new Task<>(Store::setOther, column -> parse(column, OtherEnum.class))
        );
        Store store = new Store();
        List<String> columns = List.of(
                "SOMETHING",
                "bull"
        );
        for (int index = 0; index < columns.size(); index++) {
            String column = columns.get(index);
            Task<Store, ?> task = tasks.get(index);
            store(task, column, store);
        }
        System.out.println("SOMETHING == de.twomartens.sandbox.enums.model.TestEnum.SOMETHING: "
                + (store.getTest() == TestEnum.SOMETHING));
        System.out.println("bull == de.twomartens.sandbox.enums.model.OtherEnum.BULL: "
                + (store.getOther() == OtherEnum.BULL));
    }

    public static <V> void store(Task<Store, V> task, String column, Store store) {
        task.setter().accept(store, task.parser().apply(column));
    }

    public static <T extends AscEnum> T parse(String column, Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
            .filter(e -> e.getAscStrings().contains(column))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}