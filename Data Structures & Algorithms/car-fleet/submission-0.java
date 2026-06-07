class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int fleets = 0;
        double maxTime = 0;

        for(int i = n - 1; i >= 0; i--) {

            double time =
                (double)(target - arr[i][0]) / arr[i][1];

            if(time > maxTime) {
                fleets++;
                maxTime = time;
            }
        }

        return fleets;
    }
}
