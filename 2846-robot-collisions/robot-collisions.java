class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        if(directions.indexOf('L') == -1 || directions.indexOf('R') == -1) return IntStream.of(healths).boxed().toList();
        
        int[][] positionSorted = new int[positions.length][2];
        for(int i=0;i<positions.length;i++) {
            positionSorted[i][0]=positions[i];
            positionSorted[i][1]=i;
        }

        Arrays.sort(positionSorted, (a,b) -> a[0]-b[0]);
        for(int i=0;i<positions.length;i++) {
            System.out.println(positionSorted[i][0] + "  ----  "  + positionSorted[i][1]);
        }
        Stack<Integer> collisionStack = new Stack<>();
        char[] dirch = directions.toCharArray();
        for(int i=0;i<positions.length;i++){
            if(collisionStack.isEmpty()) {
                collisionStack.push(positionSorted[i][1]);
            }
            else{
                //System.out.println("stack - " + dirch[collisionStack.peek()] + " ---- " +  collisionStack.peek());
                //System.out.println("array - " + dirch[positionSorted[i][1]] + " ---- " +  positionSorted[i][1]);
                if((dirch[collisionStack.peek()] == 'R' && dirch[positionSorted[i][1]] == 'L')) {
                    int robot = collisionStack.pop();

                    if(healths[robot] > healths[positionSorted[i][1]]) {
                        healths[robot]--;
                        collisionStack.push(robot);
                        healths[positionSorted[i][1]] = -1;
                    }
                    else if(healths[robot] == healths[positionSorted[i][1]]){
                        healths[robot] = -1;
                        healths[positionSorted[i][1]] = -1;
                    }
                    else {
                        healths[positionSorted[i][1]]--;
                        healths[robot] = -1;
                        i--;

                        //collisionStack.push(positionSorted[i][1]);
                    }
                }
                else collisionStack.push(positionSorted[i][1]);
            }
        }

        List<Integer> resultantHealth = new ArrayList<>();

        for(int i=0;i<healths.length;i++) {
            if(healths[i] != -1) 
                resultantHealth.add(healths[i]);
        }

        return resultantHealth;
    }
}