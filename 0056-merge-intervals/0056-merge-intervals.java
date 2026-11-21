class Solution {
    public int[][] merge(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));

        int idx = 0;
        for(int i=1;i<n;i++){
            if(arr[i][0]<=arr[idx][1]){
                arr[idx][1] = Math.max(arr[idx][1],arr[i][1]);
            }
            else {
                idx++;
                arr[idx]=arr[i];
            }
        }
        return Arrays.copyOfRange(arr,0,idx+1);
    }
}