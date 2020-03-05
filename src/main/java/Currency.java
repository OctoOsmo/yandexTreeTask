import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Currency {

//Нужно:
//1. самое важное требование, которое следует удовлетворять в процессе всей реализации -
//расставить как можно меньшее количество граблей для разработчика, который в будущем будет добавлять новые значения
//2. иметь фиксированный список значений, задаваемый на этапе компиялции
//3. иметь строгую типизацию значений
//4. уметь безопасно сравнивать значения по ==
//5. получать все значения
//6. иметь неизменяемый ordinal (порядковый номер с 0 в порядке объявления значений)
//7. получать значения по ordinal
//8. иметь название значения, совпадающее с названием поля для значения
//9. искать по имени

    private Integer ordinal;
    private String name;


    public Currency(String name) {
        this.ordinal = ordinalCounter;
        this.name = name;

        ordinalCounter = ordinal + 1;
        list.add(this);
    }

    static Integer ordinalCounter = 0;
    static List<Currency> list = new ArrayList<>();

    public final static Currency USD = new Currency("USD");
    public final static Currency RUB = new Currency("RUB");

    public Integer getOrdinalValue(){
        return ordinal;
    }
}
