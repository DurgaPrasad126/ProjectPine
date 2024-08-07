class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num / 1000 > 0) {
            int th = num/1000;
            if(th == 3) sb.append("MMM");
            else if(th==2) sb.append("MM");
            else sb.append("M");
        }
        num=num%1000;
        if(num / 100 > 0) {
            int h = (num/100);
            if(h == 1) sb.append("C");
            else if(h==2) sb.append("CC");
            else if(h==3) sb.append("CCC");
            else if(h==4) sb.append("CD");
            else if(h==5) sb.append("D");
            else if(h==6) sb.append("DC");
            else if(h==7) sb.append("DCC");
            else if(h==8) sb.append("DCCC");
            else if(h==9) sb.append("CM");
        }
        num=num%100;
        if(num / 10 > 0) {
            int h = (num/10);
            if(h == 1) sb.append("X");
            else if(h==2) sb.append("XX");
            else if(h==3) sb.append("XXX");
            else if(h==4) sb.append("XL");
            else if(h==5) sb.append("L");
            else if(h==6) sb.append("LX");
            else if(h==7) sb.append("LXX");
            else if(h==8) sb.append("LXXX");
            else if(h==9) sb.append("XC");
        }
        num=num%10;
        if(num>0){
            int h = num;
            if(h == 1) sb.append("I");
            else if(h==2) sb.append("II");
            else if(h==3) sb.append("III");
            else if(h==4) sb.append("IV");
            else if(h==5) sb.append("V");
            else if(h==6) sb.append("VI");
            else if(h==7) sb.append("VII");
            else if(h==8) sb.append("VIII");
            else if(h==9) sb.append("IX");
        }
        return sb.toString();
    }
}