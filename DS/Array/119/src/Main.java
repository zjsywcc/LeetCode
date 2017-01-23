import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        printList(getRow(0));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(rowIndex < 0) {
            return new ArrayList<Integer>();
        } else if(rowIndex == 0) {
            return new ArrayList<Integer>(){{
                add(1);
            }};
        } else if(rowIndex  == 1) {
            return new ArrayList<Integer>(){{
                add(1);
                add(1);
            }};
        }
        rst.add(new ArrayList<Integer>(){{
            add(1);
        }});
        rst.add(new ArrayList<Integer>(){{
            add(1);
            add(1);
        }});
        for(int i = 2; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for(int j = 1; j < i; j++) {
                int num = rst.get(i - 1).get(j - 1) + rst.get(i - 1).get(j);
                list.add(num);
            }
            list.add(1);
            rst.add(list);
        }
        return rst.get(rowIndex);
    }

    public static void printList(List<Integer> list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
