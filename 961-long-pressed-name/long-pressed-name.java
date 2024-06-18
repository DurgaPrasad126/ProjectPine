class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int namePointer = 0;
        int typedPointer = 0;
        char[] nameCh = name.toCharArray();
        char[] typedCh = typed.toCharArray();

        while(namePointer < name.length() && typedPointer < typed.length()) {
            if(nameCh[namePointer] == typedCh[typedPointer]) {
                int nameC = 0;
                int typedC = 0;
                while(typedPointer < typed.length() && typedCh[typedPointer] == nameCh[namePointer]) {
                    typedPointer++;
                    typedC++;
                }
                while(namePointer < name.length() && nameCh[namePointer] == typedCh[typedPointer-1]) {
                    namePointer++;
                    nameC++;
                }
                if(nameC > typedC) return false;
            }
            else return false;
        }
        if(namePointer < name.length() || typedPointer < typed.length()) return false;
        return true;
    }
}