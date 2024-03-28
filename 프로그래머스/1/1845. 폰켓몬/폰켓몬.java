import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        // set(중복x)에 다 다른 종류의 폰켓몬의 번호가 저장됨
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        if (set.size() <= nums.length / 2) {
            answer = set.size();
        } else { // set의 사이즈가 nums.length보다 크다면
            answer = nums.length / 2;
        }

        return answer;
    }
   
}