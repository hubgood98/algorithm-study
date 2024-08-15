import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class TestSimpleRegexMatches {
    public static int runTest(String regex, String text)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;

        while(matcher.find())
            matches++;  
        return matches;
    }

    @Test
    public void givenText_whenSimpleRegexMatches_thenCorrect()
    {
        
        String source = "푸푸2";
        Pattern pattern = Pattern.compile("푸");
        Matcher matcher = pattern.matcher(source);

        assertTrue(matcher.find());
    }

    @Test
    public void givenText_whenSimpleRegexMatches_thenCorrect2()
    {
        String source = "푸푸리나";
        Pattern pattern = Pattern.compile("푸");
        Matcher matcher = pattern.matcher(source);

        int matches = 0;

        while(matcher.find())
        {matches++;}
        assertEquals(matches, 2);
    }

    @Test
    public void givenORSet_whenMatchesAnyAndAll_thenCorrect() {
        int matches = runTest("[abc]", "b");

        assertEquals(1,matches);
    }

    //특정한 문자열을 찾을 때 사용됨.
    @Test
    public void givenNORSet_whenMatchesAllExceptElements_thenCorrect() { //bcr을 제외한 at이 있냐
        int matches = runTest("[^bcr]at", "sat mat eat");

        assertTrue(matches > 0);
    }

    @Test
    public void givenNORSet_whenMatchesNon_thenCorrect() { //abc를 뺀 나머지
        int matches = runTest("[^abc]", "g");

        assertTrue(matches > 0);
    }

    @Test
    public void givenUpperCaseRange_whenMatchesUpperCase_thenCorrect() { //A~Z까지 몇개있냐
        int matches = runTest("[A-Z]", "Two UpperCase Alphabets 34 overall");
        
        assertEquals(matches, 4);
    }

    @Test
    public void givenBothLowerAndUpperCaseRange_whenMatchesAllLetters_thenCorrect() //알파벳 전체 추출
    {
        int matches = runTest("[A-Za-z]", "Two Uppercase alphabets 34 overall");
        assertEquals(matches, 28);
    }

    @Test
    public void givinTwoSets()
    {
        int mathces = runTest("[1-6&&[3-9]]","123456789");

        assertEquals(mathces, 4);
    }

    @Test
    public void givenDigits_whenMatches_thenCorrect() { //d는 [0-9]와 동일, //D는 [^0-9]와 같음
        int matches = runTest("\\D", "12398");
    
        assertEquals(matches, 0);
    }

    @Test
    public void Space_whenMatches_thenCorrect() {
    int matches = runTest("\\s", "a c");

    assertEquals(matches, 1);
}

    @Test
    public void Nosutja() { //숫자 2개가 있는지
    int matches = runTest("\\d\\d", "13");

    assertEquals(matches, 1);
}

    @Test
    public void Nosutja2() { //숫자 2개가 있는지
    int matches = runTest("(\\d\\d)", "13954");

    assertEquals(matches, 2);
    }

    @Test
    public void givenText_whenMatchesAtBeginning_thenCorrect() { //dog로 시작되었는지
    int matches = runTest("^dog", "dogs are friendly");

    assertTrue(matches > 0);
}

    @Test
    public void whenMatchesAtBeginning_thenCorrect() { //dog로 단어가 끝나는지
    int matches = runTest("dog$", "dogs are friendly");

    assertTrue(matches > 0);
    }

 
    
}
