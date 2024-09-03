import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String solution(String[] survey, int[] choices) {
        // 각 성격 유형의 점수를 저장하기 위한 Map
        Map<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('R', 0);
        scoreMap.put('T', 0);
        scoreMap.put('C', 0);
        scoreMap.put('F', 0);
        scoreMap.put('J', 0);
        scoreMap.put('M', 0);
        scoreMap.put('A', 0);
        scoreMap.put('N', 0);

        // 각 선택지에 따른 점수를 계산
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0); // 비동의 성격 유형
            char agree = survey[i].charAt(1);    // 동의 성격 유형
            int choice = choices[i];

            if (choice < 4) {
                // 비동의 선택지 선택 시 점수 부여
                scoreMap.put(disagree, scoreMap.get(disagree) + (4 - choice));
            } else if (choice > 4) {
                // 동의 선택지 선택 시 점수 부여
                scoreMap.put(agree, scoreMap.get(agree) + (choice - 4));
            }
            // choice == 4인 경우는 점수를 부여하지 않음 (모르겠음)
        }

        // 각 지표에서 점수가 높은 성격 유형을 결정
        StringBuilder result = new StringBuilder();
        result.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T'); // 1번 지표
        result.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F'); // 2번 지표
        result.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M'); // 3번 지표
        result.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N'); // 4번 지표

        return result.toString();
    }
}