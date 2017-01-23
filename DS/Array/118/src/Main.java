import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        printLists(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return rst;
        } else if(numRows == 1) {
            rst.add(new ArrayList<Integer>(){{
                add(1);
            }});
            return rst;
        } else if(numRows == 2) {
            rst.add(new ArrayList<Integer>(){{
                add(1);
            }});
            rst.add(new ArrayList<Integer>(){{
                add(1);
                add(1);
            }});
            return rst;
        }
        rst.add(new ArrayList<Integer>(){{
            add(1);
        }});
        rst.add(new ArrayList<Integer>(){{
            add(1);
            add(1);
        }});
        for(int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for(int j = 1; j < i; j++) {
                int num = rst.get(i - 1).get(j - 1) + rst.get(i - 1).get(j);
                list.add(num);
            }
            list.add(1);
            rst.add(list);
        }
        return rst;
    }

    public static void printLists(List<List<Integer>> lists) {
        for(List<Integer> list : lists) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
