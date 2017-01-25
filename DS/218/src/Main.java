import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//        int[][] buildings = new int[][]{{0, 2, 3}, {2, 5, 3}};
        int[][] buildings = new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}};
        List<int[]> lists = getSkyline(buildings);
        printTuple(lists);
    }

    public static class Quat {
        int x;
        int id;
        int status; // 1 - start 0 - end
        int height;
        public Quat(int start, int id, int status, int height) {
            this.x = start;
            this.id = id;
            this.status = status;
            this.height = height;
        }

        public static Comparator<Quat> QuatComparator = new Comparator<Quat>() {
            @Override
            public int compare(Quat q1, Quat q2) {
                if (q1.x == q2.x) {
                    return q2.status - q1.status;
                } else {
                    return q1.x - q2.x;
                }
            }
        };
    }

    public static class Tuple {
        int x;
        int height;

        public Tuple(int x, int height) {
            this.x = x;
            this.height = height;
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        List<Quat> line = new ArrayList<Quat>();

        int len = buildings.length;
        for(int i = 0; i < len; i++) {
            line.add(new Quat(buildings[i][0], i, 1, buildings[i][2]));
            line.add(new Quat(buildings[i][1], i, 0, buildings[i][2]));
        }

        Collections.sort(line, Quat.QuatComparator);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(len,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        int preH = 0;
        for(Quat quat : line) {
            if(quat.status == 1) {
                queue.offer(quat.height);
            } else {
                queue.remove(quat.height);
            }
            int maxH = 0;
            if (!queue.isEmpty()) {
                maxH = queue.peek();
            }
            if (maxH != preH) {
                result.add(new int[]{quat.x, maxH});
                preH = maxH;
            }
        }
        List<int[]> mergedResult = new ArrayList<int[]>();
        int[] prevList = result.get(0);
        for(int i = 1; i < result.size(); i++) {
            if(result.get(i)[0] != prevList[0]) {
                mergedResult.add(prevList);
            }
            prevList = result.get(i);
        }
        mergedResult.add(prevList);
        return  mergedResult;
    }

    public static void printTuple(List<int[]> result) {
        for(int[] list : result) {
            System.out.println(String.format("index: %s height: %s", list[0], list[1]));
        }
    }
}
