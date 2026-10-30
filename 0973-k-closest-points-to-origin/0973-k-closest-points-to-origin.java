class Solution { 
    class Pair{
        int[] arr;
        double val;
        Pair(int[] arr, double val){
            this.arr = arr;
            this.val = val;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        ArrayList<int[]>  list = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> Double.compare(a.val,b.val));

        for(int i = 0 ; i < points.length ; i++){
            q.offer(new Pair(points[i],euval(points[i])));
        }

        for(int i = 0 ; i < k ; i++){
            list.add(q.poll().arr);
        }

        return list.toArray(new int[0][]);
    }

    public double euval(int[] arr){
        int a = arr[0] * arr[0];
        int b = arr[1] * arr[1];
        double res = Math.sqrt(a + b);
        return res;
    }
}