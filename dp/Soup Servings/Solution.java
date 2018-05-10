class Solution {
    public double soupServings(int N) {
        if(N > 4800) return 1.0;
        double[][] help = new double[200][200];
        return count(help,(N+24)/25,(N+24)/25);
    }
    
    public double count(double[][] help, int a, int b)
    {
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1.0;
        if(b <= 0) return 0.0;
        
        if(help[a][b] > 0) return help[a][b];
        help[a][b] = 0.25*(count(help,a-4,b) + count(help,a-3,b-1) + count(help,a-2,b-2) + count(help,a-1,b-3));
        return help[a][b];
    }
}
