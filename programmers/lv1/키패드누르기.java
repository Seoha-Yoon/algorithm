class Solution {
    
    class Touch{
        int x;
        int y;
        
        public Touch(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        String answer ="";
        
        String priorityHand;
        if(hand.equals("right")) priorityHand = "R";
        else priorityHand = "L";

        Touch left = new Touch(3,0); // 왼손 시작 위치
        Touch right = new Touch(3,2); // 오른손 시작 위치
        
        String movingHand;
        for(int i=0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1: case 4: case 7:
                    answer = answer.concat("L");
                    left.x = numbers[i]/3;
                    left.y = 0;
                    break;
                case 3: case 6: case 9:
                    answer = answer.concat("R");
                    right.x = numbers[i]/3 - 1;
                    right.y = 2;
                    break;
                case 2: case 5: case 8:
                    movingHand = calculateDistance(numbers[i], right, left, priorityHand);
                    answer = answer.concat(movingHand);
                    if(movingHand.equals("R")){
                        right.x = numbers[i]/3;
                        right.y = numbers[i]%3-1;
                    }else{
                        left.x = numbers[i]/3;
                        left.y = numbers[i]%3-1;
                    }
                    break;
                case 0:
                    movingHand = calculateDistance(numbers[i], right, left, priorityHand);
                    answer = answer.concat(movingHand);
                    if(movingHand.equals("R")){
                        right.x = 3;
                        right.y = 1;
                    }else{
                        left.x = 3;
                        left.y = 1;
                    }
                    break;
                default:
                    break;   
            }
            //System.out.println("left = ("+left.x+","+left.y+"), right = ("+ right.x+","+right.y+")");
        }
        
        
        return answer;
    }
    public String calculateDistance(int num, Touch rightHand, Touch leftHand, String priorityHand){
        int numX, numY;
        if(num == 0){
            numX = 3;
            numY = 1;
        }else{
            numX = num/3;
            numY = num%3-1;
        }
        int rightDistance = Math.abs(rightHand.x - numX) + Math.abs(rightHand.y - numY);
        int leftDistance = Math.abs(leftHand.x - numX) + Math.abs(leftHand.y - numY);
        
        if(rightDistance == leftDistance) return priorityHand;
        else if(rightDistance > leftDistance) return "L";
        else return "R";
    }
}