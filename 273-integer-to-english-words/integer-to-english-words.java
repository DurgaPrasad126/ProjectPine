class Solution {
   public String numberToWords(int num) {
	if(num==0) return "Zero";
	int billions = num/1000000000;
	num %= 1000000000;
	int millions = num/1000000;
	num %= 1000000;
	int thousands = num/1000;
	num %= 1000;
	int hundreds = num;
	StringBuilder s = new StringBuilder();
	if(billions>0) s.append(helper(billions)+" Billion "); 
	if(millions>0) s.append(helper(millions)+" Million ");
	if(thousands>0) s.append(helper(thousands)+" Thousand ");
	if(hundreds>0) s.append(helper(hundreds));

	return s.toString().trim();
}

public String helper(int n) {
	String[] tillNineteen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	int hundred = n/100;
	n %= 100;

	StringBuilder s = new StringBuilder();
	if(hundred!=0) s.append(tillNineteen[hundred]+" Hundred ");
	if(n<20) s.append(tillNineteen[n]);
	else {
		int ten = n/10;
		n = n%10;
		s.append(tens[ten]+" "+tillNineteen[n]);
	}
	return s.toString().trim();
}
}