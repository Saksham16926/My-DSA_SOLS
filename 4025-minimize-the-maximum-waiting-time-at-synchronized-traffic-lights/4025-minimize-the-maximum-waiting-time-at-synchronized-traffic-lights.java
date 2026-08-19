class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxtraffic = 0;
        for (int light : lights) {
            if (light > maxtraffic) {
                maxtraffic = light;
            }
        }

        int wait = 0;
        for (int time : arrivalTime) {
            int r = time % period;
            if (r >= maxtraffic) {
                int waitt = period - r;
                if (waitt > wait) {
                    wait = waitt;
                }
            }
        }
        
        return wait;
    }
}