import java.util.Stack;

public class homework2_20 {
    
        // 미로의 모습을 2차원 배열로 정의합니다.
        static int[][] map = {
            {0,1,0,1,0,1},
            {0,1,1,1,0,1},
            {0,0,0,1,0,1},
            {0,1,0,1,0,1},
            {0,1,0,0,0,0}
        };
        
        // 상하좌우로 이동할 때 사용할 배열을 정의합니다.
        static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // 이동 횟수를 저장할 변수를 정의합니다.
        static int move = 0;
    
        public static void main(String[] args) {
            // 출구를 찾으면 true를 반환하고 출력함
            System.out.println(findPath(0, 0));
        }
    
        static boolean findPath(int x, int y) {
            Stack<int[]> stack = new Stack<>(); // 스택을 생성합니다.
            stack.push(new int[]{x, y}); // 시작 위치를 스택에 넣습니다.
    
            while (!stack.isEmpty()) { // 스택이 비어있지 않은 동안 반복합니다.
                int[] curr = stack.pop(); // 스택에서 위치를 꺼냅니다.
                x = curr[0]; // 현재 위치의 x좌표를 저장합니다.
                y = curr[1]; // 현재 위치의 y좌표를 저장합니다.
    
                if (map[x][y] == 4 || map[x][y] == 5) { // 출구인 경우 true를 반환합니다.
                    return true;
                }
    
            }
    
            return false; // 출구를 찾지 못한 경우 false를 반환합니다.
        }

    }