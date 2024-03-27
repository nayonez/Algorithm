class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length]; // photo의 행에 맞게
        int score = 0;
        for (int i = 0; i < photo.length; i++) {
            score = 0; // 행 돌때마다 0점으로 초기화
            for (int j = 0; j < photo[i].length; j++) {
                for (int k = 0; k < name.length; k++) {
                    if (photo[i][j].equals(name[k])) {
                        score += yearning[k];
                    }
                }
            } answer[i] = score;
        }
        return answer;
    }
}