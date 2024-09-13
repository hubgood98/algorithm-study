class Solution {
  public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 입력 값 유효성 검사 및 파싱
        int[] video = parseTime(video_len);
        int[] position = parseTime(pos);
        int[] op_start_time = parseTime(op_start);
        int[] op_end_time = parseTime(op_end);

        // 오프닝 구간 논리 오류 처리
        if (!isValidOpeningRange(op_start_time, op_end_time)) {
            throw new IllegalArgumentException("Invalid opening range: start time is after end time.");
        }

        // 초기 상태에서 오프닝 건너뛰기
        skipOpening(position, op_start_time, op_end_time);

        // 명령어 처리
        for (String command : commands) {
            adjustPosition(command, position);
            skipOpening(position, op_start_time, op_end_time);
            clampPosition(position, video);
        }

        return String.format("%02d:%02d", position[0], position[1]);
    }

    // 명령어에 따른 위치 조정
    private static void adjustPosition(String command, int[] position) {
        if (command.equals("prev")) {
            position[1] -= 10;
            if (position[1] < 0) {
                if (position[0] > 0) {
                    position[0] -= 1;
                    position[1] += 60;
                } else {
                    // 현재 0분 0초라면 더 이상 줄지 않도록
                    position[1] = 0;
                }
            }
        } else if (command.equals("next")) {
            position[1] += 10;
            if (position[1] > 59) {
                position[0] += 1;
                position[1] -= 60;
            }
        }
        // 초가 음수로 내려가는 것을 방지
        position[1] = Math.max(position[1], 0);
    }

    // 오프닝 건너뛰기
    private static void skipOpening(int[] position, int[] op_start, int[] op_end) {
        if (isInRange(position, op_start, op_end)) {
            position[0] = op_end[0];
            position[1] = op_end[1];
        }
    }

    // 비디오 길이 초과하지 않도록 제한
    private static void clampPosition(int[] position, int[] video) {
        if (position[0] > video[0] || (position[0] == video[0] && position[1] > video[1])) {
            position[0] = video[0];
            position[1] = video[1];
        }
        // 초가 60을 넘지 않도록 처리
        position[1] = Math.min(position[1], 59);
    }

    // 오프닝 구간 유효성 검사
    private static boolean isValidOpeningRange(int[] start, int[] end) {
        return (start[0] < end[0]) || (start[0] == end[0] && start[1] <= end[1]);
    }

    // 범위 확인
    private static boolean isInRange(int[] pos, int[] start, int[] end) {
        return (pos[0] > start[0] || (pos[0] == start[0] && pos[1] >= start[1])) &&
               (pos[0] < end[0] || (pos[0] == end[0] && pos[1] <= end[1]));
    }

    // 시간 파싱과 예외 처리
    private static int[] parseTime(String time) {
        if (time == null || !time.contains(":")) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
        String[] parts = time.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
        try {
            return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Time contains non-numeric values: " + time);
        }
    }
}