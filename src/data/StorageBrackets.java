package data;

import enteties.Brackets;
import enteties.StatusBrackets;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Klunniy
 */
public class StorageBrackets {

    //  59+(3+2) + (3+2) + 1  = 70;
    //  55+((3+2) +(3+2))
    public static List<Integer> positionOpenBrackets = new ArrayList<>();
    public static List<Integer> positionClosedBrackets = new ArrayList<>();

    //пытаюсь начало и конец всех скобок записать
    public static List<Brackets> listBrackets = new ArrayList<>();

    //этот метод добавляет скобки и открывающую и закрывающую в listBrackets
    public static void addBrackets(int position, StatusBrackets status) {
        if (status == StatusBrackets.OPEN) {
            listBrackets.add(new Brackets(position));
        } else {
            for(int i = listBrackets.size()-1; i>=0; i--) {
                Brackets brackets = listBrackets.get(i);
                if (brackets.getClosedPosition() == -1) {
                    brackets.setClosedPosition(position);
                    return;
                }
            }
        }
    }

//    public static Brackets getBracket(int openIndex) {
//        for (int i=0; i<listBrackets.size(); i++) {
//
//            Brackets brackets = listBrackets.get(i);
//            if (openIndex == )
//        }
//    }
}
