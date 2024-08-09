class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        String res = "";
        if(length < 10000 && width < 10000 && height < 10000) {
            long volume = 1l*length * width * height;
            System.out.println(volume);
            if(volume >= 1000000000) res = "Bulky";
        }
        else {
            res = "Bulky";   
        }
        if(mass >= 100) {
            if(res.equals("Bulky")) return "Both";
            else return "Heavy";
        }
        return res.equals("Bulky") ? "Bulky" : "Neither";
    }
}