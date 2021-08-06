package com.streamproject.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.comparator.Comparators;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SvTest
{


    @Test
    public void test()
    {
        String s = "one4seveneight";
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }

        String finalS = s;
        IntStream.rangeClosed(0, 9).forEach((i)-> finalS.replaceAll(alphabets[i],digits[i]));

        System.out.println(finalS);


        System.out.println(Integer.parseInt(finalS));


    }




    @Test
    public void arrTest()
    {
        List<Integer> arrInt = Arrays.asList(1, 5, 2, 6, 3, 7, 4);
        List<Integer> arrInt2 = new ArrayList<>();

        arrInt.stream().sorted().filter(integer -> !integer.equals(3)).forEach(arrInt2::add);

        System.out.println(arrInt);
        System.out.println(arrInt2);

        List<Integer> arrInt3 = Arrays.asList(1, 5, 2, 6, 3, 7, 4);

        int sumValue = arrInt2.stream().reduce(0, Integer::sum);
        OptionalDouble avgValue = arrInt3.stream().mapToInt(Integer::intValue).average();
        System.out.println("더한값 : " + sumValue);
        if (avgValue.isPresent())
            System.out.println("평균값 : " + avgValue.getAsDouble());

        // 최소값 구하기
        Integer sumMin = arrInt2.stream().min(Comparator.comparing(x -> x)).orElseThrow(NoSuchElementException::new);
        System.out.println("최소값 : " + sumMin);

        Integer sumMax = arrInt2.stream().max(Comparator.comparing(x->x)).orElseThrow(NoClassDefFoundError::new);
        System.out.println("최대값 : " + sumMax);




        System.out.println("람다 후 : start");
        arrInt2.forEach(System.out::println);
        System.out.println("람다 후 : end");

        System.out.println("람다 전 : start");
        for (Integer integer : arrInt2) {
            System.out.println(integer);
        }
        System.out.println("람다 전 : end");
//
//
//        int[] arraInt2 = {1, 5, 2, 6, 3, 7, 4};
//
//
//        for (int j : arraInt2) {
//            System.out.println(j);
//        }
//
//
//        //정렬하는 코드
//        System.out.println("--------------------");
//        for (int i = 0; i < arraInt2.length; i++) {
//            for (int k = 0; k < arraInt2.length-1; k++) {
//                //값을 바꾸는 코드
//                if (arraInt2[k]> arraInt2[k+1]) {//오름차순 , 내림차순으로 바꾸고 싶으면 부등호 바꾸면 됨
//                    int temp = arraInt2[k];
//                    arraInt2[k] = arraInt2[k+1];
//                    arraInt2[k+1] = temp;
//                }
//            }
//        }
//
//        //Arrays.sort(score);
//        System.out.println("--------------------");
//        System.out.print("정렬 후: ");
//        System.out.println(Arrays.toString(arraInt2));


    }



    @Test
    public void solTest()
    {

        Stream<String> stream1 = Stream.of("넷", "둘", "셋", "하나", "1111", "333333");
        Stream<String> stream2 = Stream.of("넷", "둘", "셋", "하나", "2222", "55555");

        Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2);
        result1.ifPresent(System.out::println);

        // 초기값이 있는 reduce
        String result2  = stream2.reduce("시작", (s1, s2) -> s1 + "++" + s2);
        System.out.println(result2);
    }


    @Test
    public void idTest()
    {
        List<String> indexText = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
        List<String> converter = Arrays.asList("zero","one","two","three","four","five","six","seven","eight","nine");
        String name = "one2three8nine";
        final String[] result = {name};
        IntStream.range(0, 10).forEach((i) -> {
            result[0] = result[0].replaceAll(converter.get(i), indexText.get(i));
        });


        System.out.println(Integer.parseInt(result[0]));

    }


    /**
     * 문제 설명
     * 짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
     * 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
     * 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 문자열 S가 주어졌을 때,
     * 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
     *
     * 예를 들어, 문자열 S = baabaa 라면
     * b aa baa → bb aa → aa → 의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
     *
     * 제한사항
     * 문자열의 길이 : 1,000,000이하의 자연수
     * 문자열은 모두 소문자로 이루어져 있습니다.
     * 입출력 예
     * s	result
     * baabaa	1
     * cdcd	0
     * 입출력 예 설명
     * 입출력 예 #1
     * 위의 예시와 같습니다.
     * 입출력 예 #2
     * 문자열이 남아있지만 짝지어 제거할 수 있는 문자열이 더 이상 존재하지 않기 때문에 0을 반환합니다.
     *
     * ※ 공지 - 2020년 6월 8일 테스트케이스가 추가되었습니다.
     */


    @Test
    public void steamManyTest(){

        String s = "cdcd";

        byte[] bytes = s.getBytes();
        int length = bytes.length;

        Stack<Integer> stack = new Stack<>();

        int iLeft = 0;
        int iRight = iLeft + 1;

        while (iLeft < length && iRight < length) {
            if (bytes[iLeft] == bytes[iRight]) {
                if (stack.empty()) {
                    iLeft = iRight + 1;
                    iRight = iLeft + 1;
                } else {
                    iLeft = stack.pop();
                    iRight++;
                }
            } else {
                stack.push(iLeft);
                iLeft = iRight;
                iRight = iLeft + 1;
            }
        }

        //출력
        System.out.println(iLeft >= length && iRight >= length ? 1 : 0);



    }


    /**
     * 문제 설명
     * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
     * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
     *
     * 구조대 : 119
     * 박준영 : 97 674 223
     * 지영석 : 11 9552 4421
     * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
     * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한 사항
     * phone_book의 길이는 1 이상 1,000,000 이하입니다.
     * 각 전화번호의 길이는 1 이상 20 이하입니다.
     * 같은 전화번호가 중복해서 들어있지 않습니다.
     *
     * 입출력 예제
     * phone_book	return
     * ["119", "97674223", "1195524421"]	false
     * ["123","456","789"]	true
     * ["12","123","1235","567","88"]	false
     * 입출력 예 설명
     * 입출력 예 #1
     * 앞에서 설명한 예와 같습니다.
     *
     * 입출력 예 #2
     * 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
     *
     * 입출력 예 #3
     * 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
     */


    @Test
    public void phoneNumberTest()
    {
        String[] phoneList2 = {"123", "456", "789"};

        List<String> testList = new ArrayList<>(Arrays.asList(phoneList2));

        int test = (int) testList.stream().skip(1).filter(line -> line.startsWith(testList.get(0))).count();

        int tttt = 0;
        boolean testb;
        for (int i=0; i<testList.size()-1; i++) {
            String index = testList.get(i+1);
             if(testList.stream().skip(i).anyMatch(line -> line.startsWith(index))) {
                 System.out.println(i);
                 tttt++;
             }
        }

        System.out.println(tttt);

//        System.out.println(tttt <= 0);
//        System.out.println(test <= 0);



    }


    /**
     * 문제 설명
     * 가로 길이가 2이고 세로의 길이가 1인 직사각형 모양의 타일이 있습니다.
     * 이 직사각형 타일을 이용하여 세로의 길이가 3이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다
     *
     * 타일을 가로로 배치 하는 경우
     * 타일을 세로로 배치 하는 경우
     * 예를들어서 n이 8인 직사각형은 다음과 같이 채울 수 있습니다.
     *
     * Imgur
     *
     * 직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 가로의 길이 n은 5,000이하의 자연수 입니다.
     * 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
     * 입출력 예
     * n	result
     * 4	11
     * 입출력 예 설명
     * 입출력 예 #1
     * 다음과 같이 11가지 방법이 있다.
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     * Imgur
     */

    @Test
    public void tileTest()
    {
        System.out.println(tiling(4));
    }



    public int tiling(int n) {


        int DIVISOR = 10007;
        int[] dp = new int[1001];

        if (n < 2) {

            return 1;
        }

        if (dp[n] > 0) {

            return dp[n];
        }

        dp[n] = (tiling(n - 1) + tiling(n - 2)) % DIVISOR;


        return dp[n];
    }


    /**
     *문제 설명
     * 로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. 아래는 로또의 순위를 정하는 방식입니다. 1
     *
     * 순위	당첨 내용
     * 1	6개 번호가 모두 일치
     * 2	5개 번호가 일치
     * 3	4개 번호가 일치
     * 4	3개 번호가 일치
     * 5	2개 번호가 일치
     * 6(낙첨)	그 외
     * 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다.
     * 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
     * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
     * 알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다. 당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
     *
     * 당첨 번호	31	10	45	1	6	19	결과
     * 최고 순위 번호	31	0→10	44	1	0→6	25	4개 번호 일치, 3등
     * 최저 순위 번호	31	0→11	44	1	0→7	25	2개 번호 일치, 5등
     * 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
     * 알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
     * 3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
     * 알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
     * 5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
     * 민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
     * 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * lottos는 길이 6인 정수 배열입니다.
     * lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
     * 0은 알아볼 수 없는 숫자를 의미합니다.
     * 0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
     * lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
     * win_nums은 길이 6인 정수 배열입니다.
     * win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
     * win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
     * win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.
     * 입출력 예
     * lottos	win_nums	result
     * [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
     * [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
     * [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
     * 입출력 예 설명
     * 입출력 예 #1
     * 문제 예시와 같습니다.
     *
     * 입출력 예 #2
     * 알아볼 수 없는 번호들이 아래와 같았다면, 1등과 6등에 당첨될 수 있습니다.
     *
     * 당첨 번호	38	19	20	40	15	25	결과
     * 최고 순위 번호	0→38	0→19	0→20	0→40	0→15	0→25	6개 번호 일치, 1등
     * 최저 순위 번호	0→21	0→22	0→23	0→24	0→26	0→27	0개 번호 일치, 6등
     * 입출력 예 #3
     * 민우가 구매한 로또의 번호와 당첨 번호가 모두 일치하므로, 최고 순위와 최저 순위는 모두 1등입니다.
     */
    @Test
    public void randomTest(){
        int[] l1 = {44, 1, 0, 0, 31, 25};
        int[] l2 = {0, 0, 0, 0, 0, 0};
        int[] l3 = {45, 4, 35, 20, 3, 9};
        int[] w1 = {31, 10, 45, 1, 6, 19};
        int[] w2 = {38, 19, 20, 40, 15, 25};
        int[] w3 = {20, 9, 3, 45, 4, 35};

        ArrayList<int[]> lotosList = new ArrayList<>();
        ArrayList<int[]> winList = new ArrayList<>();
        lotosList.add(l1);
        lotosList.add(l2);
        lotosList.add(l3);
        winList.add(w1);
        winList.add(w2);
        winList.add(w3);

        int topRank = (int) Arrays.stream(l2).filter((x)-> Arrays.stream(w2).anyMatch(w -> w == x || x == 0)).count();
        int lowRank = (int) Arrays.stream(l2).filter((x)-> Arrays.stream(w2).anyMatch(w -> w == x)).count();

        System.out.println(Arrays.toString(LongStream.of(topRank, lowRank).mapToInt(x -> (int) x).toArray()));



        for (int i=0; i<lotosList.size(); i++){
            System.out.println(Arrays.toString(rankTest(lotosList.get(i), winList.get(i))));
        }

    }


    public int[] rankTest(int[] lottos, int[] win_nums){
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l) || l == 0).count(), //다 맞았을경우 count
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l)).count()  //다 틀린경우 count
        ).mapToInt(op -> (int) (op > 6 ? op - 1 : op)).toArray();
    }



    @Test
    public void khTest(){
        long beforeTime = System.currentTimeMillis();
        Integer sum5 = IntStream.range(1, 5000000).parallel().reduce(10, Integer::sum);
//        Integer sum4 = numbers4.parallel().reduce(10, Integer::sum);
//        System.out.println("sum4: " + sum4);
        System.out.println(sum5);



        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);

    }


    @Test
    public void bsssTest(){

        long beforeTime = System.currentTimeMillis();
        Integer sum6 = IntStream.range(1, 5000000).sum();
        System.out.println(sum6);

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
    }

}


