class Solution {
    public int minSteps(int n) {
        int ans = 0;
        if(n == 1){
            return ans;
        }
        else if(isPrime(n)){
            ans = n;
        }
        else if(n % 2 == 0){
            ans =  minSteps((n/2)) + 2;
        }else{
            ans =  minSteps(getdiv(n)) + (n/getdiv(n));
        }
        return ans;
    }

    public boolean isPrime(int n){
          boolean ans = true;
           if (n == 2) {
            return ans;
        }
        
        if (n % 2 == 0) {
            ans = false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
    }
    return ans;
}
public int getdiv(int n){
        int ans = 0;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                ans =  n / i;
                return ans;
            }
        }
        return ans;
    }
        }