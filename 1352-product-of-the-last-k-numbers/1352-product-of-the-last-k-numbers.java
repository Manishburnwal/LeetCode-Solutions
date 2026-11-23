class ProductOfNumbers {
    List<Integer> ans = new ArrayList<>();
    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        ans.add(num);
    }
    
    public int getProduct(int k) {
        int pro=1;
        int a=ans.size()-1;
        while(k-->0){
            pro *= ans.get(a--);
        }
        return pro;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */