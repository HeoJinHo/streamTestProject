package com.streamproject.demo;

import com.streamproject.demo.model.*;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class StreamProjectApplicationTests {


//    @Qualifier("appleFilterSvImp2")
//    @Autowired private AppleFilterSv appleFilterSv;

    @Test
    void contextLoads() {

        ArrayList<Apple> setApple = new ArrayList<>();
        setApple.add(new Apple("green", 151));
        setApple.add(new Apple("green", 152));
        setApple.add(new Apple("green", 153));
        setApple.add(new Apple("green2", 154));
        setApple.add(new Apple("green1", 155));
        ArrayList<Apple> result = new ArrayList<>();
//        filterApples(setApple, appleFilterSv);


//        setApple.stream()
//                .filter((i)-> i.getAppleWeigth() >= 152)
//                .skip(1)
//                .limit(2)
//                .forEach(result::add);
//
//        result.forEach((i)-> System.out.println(i.getAppleColor()));

    }

    @Test
    public void filterApples(List<Apple> appleList, AppleFilterSv s)
    {
        ArrayList<Apple> setApple = new ArrayList<>();
        setApple.add(new Apple("green", 151));
        setApple.add(new Apple("green", 152));
        setApple.add(new Apple("green", 153));
        setApple.add(new Apple("green2", 154));
        setApple.add(new Apple("green1", 155));
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : appleList)
        {
            if (s.test(apple))
            {
                result.add(apple);
            }
        }

//        result.forEach((i)-> System.out.println(i.getAppleWeigth() + " : " + i.getAppleColor()));

        sendTelegram("testMessage");

//        return result;
    }


    @Test
    public void testTelegram()
    {
//        String message = "[????????????]\n" +
//                "??????????????? : " + cpMember.getBusinessType().getName() + "\n" +
//                "????????? : " + cpMember.getMemberID() + "\n" +
//                "???????????? : " + cpMember.getCompany().getCeoName() + "\n" +
//                "???????????? : " + cpMember.getInfo().getMobile() + "\n" +
//                "????????? : " + df.format(cpMember.getRegModDate().getRegDate()) + "\n";



        sendTelegram("???????????? ?????? ??????????????????.");
    }


    public void sendTelegram(String msg)
    {
        String token = "1818713818:AAHJnC0-a5fHow8pVByGzuWasfD77PGD8eM";
        String chat_id = "-1001514331665";

        String url = "https://api.telegram.org/bot" + token + "/sendmessage";

        HttpHeaders headers = new HttpHeaders ();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("chat_id", chat_id)
                .queryParam("text", msg)
                ;

        HttpEntity<?> entity = new HttpEntity<> (headers);

        RestTemplate restTemplate = new RestTemplate ();

        ResponseEntity<Map> map = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, Map.class);

//        HttpEntity<TelegramResult<TgResChatContainer>> response = restTemplate.exchange(
//                builder.build().encode().toUri(),
//                HttpMethod.GET,
//                entity,
//                new ParameterizedTypeReference<TelegramResult<TgResChatContainer>>() {});

        System.out.println(map.getBody());
    }


    @Test
    public void test11111()
    {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

        int sum = numbers.stream().reduce(0, Integer::sum);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        System.out.println(sum);
        System.out.println(max.get());
        System.out.println(min.get());
    }


    @Test
    public void tradTest()
    {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");


        List<Transaction> transactions = Arrays.asList(
          new Transaction(brian, 2012, 300),
          new Transaction(raoul, 2012, 1000),
          new Transaction(raoul, 2011, 400),
          new Transaction(mario, 2012, 710),
          new Transaction(mario, 2012, 700),
          new Transaction(alan, 2012, 950)
        );

        List<Transaction> test = transactions.stream()
                .filter((i)-> i.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .filter((t)-> t.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing((k)-> k.getTrader().getName()))
                .collect(Collectors.toList());
        System.out.println(test);




    }



    @Test
    public void intStreamTestr(){
        Stream<int[]> test =
                IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                        .filter(b-> Math.sqrt(a * a + b * b) % 1 == 0 )
                        .mapToObj(b->
                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

    }


    @Test
    public void sumTest(){
        int[] numbers = { 2, 3, 5, 7, 11, 13};

        int sub = Arrays.stream(numbers).sum();

        int summary = 0;

        for (int number : numbers) {
            summary = summary + number;
        }


        System.out.println(sub);
        System.out.println(summary);


    }

    @Test
    public void inerateTest(){
//        int randomm = ThreadLocalRandom.current().nextInt(0, 51);
//        System.out.println(Math.random());
//        System.out.println(randomm);

//        Stream.iterate(0, n -> n + 2)
//                .limit(100)
//                .forEach(System.out::println);


        List<String> test = Arrays.asList("R", "A", "C", "W", "E", "X", "S", "B", "C", "A", "B", "B");

        test = test.stream()
                    .filter((i)-> !i.equals("X"))
                    .distinct()
                    .collect(Collectors.toList());


        System.out.println(test);



        Optional<String> test22 = test.stream()
                    .findFirst();


        System.out.println(test22.get());




    }



    @Test
    public void testCollector(){


        List<Transaction2> transactions2 = Arrays.asList(
                new Transaction2("KRW", 500),
                new Transaction2("KRW", 400),
                new Transaction2("KRW", 500),
                new Transaction2("KRW", 600),
                new Transaction2("KRW", 700),
                new Transaction2("US", 710),
                new Transaction2("US", 720),
                new Transaction2("US", 730),
                new Transaction2("US", 740)
        );


        // ???????????? sort?????? ???????????? ??????????????? map???????????? ??????
        Map<String, List<Transaction2>> currencyListMap =
                transactions2.stream()
                        .sorted(Comparator.comparing(Transaction2::getVal))
                        .collect(Collectors.groupingBy(Transaction2::getTong));


        System.out.println(currencyListMap);
        System.out.println(currencyListMap.get("KRW"));
        System.out.println(currencyListMap.get("US"));

        currencyListMap.get("KRW").forEach((i)-> System.out.println(i.getVal()));
        System.out.println("----------------------------------------------------------------------");
        currencyListMap.get("US").forEach((i)-> System.out.println(i.getVal()));


        currencyListMap.forEach((key, value) -> {
            currencyListMap.get(key).forEach((i)-> System.out.println(i.getVal() + " : " + i.getTong()));
        });



        // val ??????
        int valInt = transactions2.stream().collect(Collectors.summingInt(Transaction2::getVal));

        // val??? ?????????
        Double avgInt = transactions2.stream().collect(Collectors.averagingInt(Transaction2::getVal));

        // val ?????????
        Comparator<Transaction2> minInt = Comparator.comparingInt(Transaction2::getVal);

        // val max??? ?????????
        Optional<Transaction2> maxtInt = transactions2.stream().max(minInt);

        // val ??????, ??????, ??????, ????????? ?????????
        IntSummaryStatistics total = transactions2.stream().collect(Collectors.summarizingInt(Transaction2::getVal));

        System.out.print("?????? : "+total.getSum() + " / ");
        System.out.print("?????? : "+total.getMin() + " / ");
        System.out.print("?????? : "+total.getMax() + " / ");
        System.out.println("????????? : "+total.getAverage());


        // ????????? ??????
        String tongStr = transactions2.stream().map(Transaction2::getTong).collect(Collectors.joining(", "));
        System.out.println(tongStr);


        List<String> testList = Arrays.asList("tsss1", "tsss2", "tsss3", "tsss4", "tsss5");
        String strList = testList.stream().map(String::toString).collect(Collectors.joining(", "));
        System.out.println(strList);


        // ???????
        int totalVal = transactions2.stream().map(Transaction2::getVal).reduce(Integer::sum).get();
        int totalVal2 = transactions2.stream().mapToInt(Transaction2::getVal).sum();


        System.out.println(totalVal);
        System.out.println(totalVal2);

        int krwSum = transactions2.stream()
                                    .filter((i)-> i.getTong().equals("KRW"))
                                    .mapToInt(Transaction2::getVal).sum();

        int usSum = transactions2.stream()
                .filter((i)-> i.getTong().equals("US"))
                .mapToInt(Transaction2::getVal).sum();


        System.out.println(krwSum);
        System.out.println(usSum);


        // val ??????, ??????, ??????, ????????? ?????????
        IntSummaryStatistics krwMap = transactions2.stream()
                .filter((i)-> i.getTong().equals("KRW"))
                .collect(Collectors.summarizingInt(Transaction2::getVal));

        IntSummaryStatistics usMap = transactions2.stream()
                .filter((i)-> i.getTong().equals("US"))
                .collect(Collectors.summarizingInt(Transaction2::getVal));



        IntSummaryStatistics nulMap = transactions2.stream()
                .filter((i)-> i.getTong().equals("SKW"))
                .collect(Collectors.summarizingInt(Transaction2::getVal));

        System.out.println(krwMap);
        System.out.println(usMap);
        System.out.println(nulMap);



        // ???????????? ????????? ?????? ?????????
        Map<String, Long> tongCount =
                transactions2.stream()
                        .collect(Collectors.groupingBy(Transaction2::getTong, Collectors.counting()));


        System.out.println(tongCount.get("US"));
        System.out.println(tongCount.get("KRW"))


        ;

//        criteria.orOperator(Criteria.where("company.ceoName").regex(ceoName), Criteria.where("personal.name").regex(ceoName));










    }



    @Test
    public void lamdaTest()
    {

        List<Integer> num = Arrays.asList(3, 5, 1,2,6);
        num.sort(Comparator.naturalOrder());
        System.out.println(num);


        List<String> str = Arrays.asList("a", "B", "A","d","T");
        str.sort(Comparator.naturalOrder());
        System.out.println(str);





        List<Transaction2> transactions2 = Arrays.asList(
                new Transaction2("KRW", 500),
                new Transaction2("KRW", 400),
                new Transaction2("KRW", 500),
                new Transaction2("KRW", 600),
                new Transaction2("KRW", 700),
                new Transaction2("US", 710),
                new Transaction2("US", 720),
                new Transaction2("US", 730),
                new Transaction2("US", 740)
        );

        List<Transaction2> t = transactions2.stream().sorted(Comparator.comparing(Transaction2::getVal)).collect(Collectors.toList());

        t.forEach((i)-> System.out.println(i.getVal()));








    }




    @Test
    public void OptionsTest(){
        OptionsClass cc = new OptionsClass();

//        String s = Optional.ofNullable(cc.getAddr()).orElseGet(() -> "test");

        try {
            NullPointerException ex = new NullPointerException();
        }catch (Exception e){
            System.out.println(e);
        }/*finally {
            cc.setAddr("?????????");
        }*/

        System.out.println(cc.getAddr());


        List<String> testList = Arrays.asList("tsss1", "tsss2", "tsss3", "tsss4", "tsss5");
        String strList = testList.stream().map(String::toString).collect(Collectors.joining(", "));
        System.out.println(strList);



        Optional<OptionsClass> opt = Optional.ofNullable(cc);
        Optional<String> testsss = opt.map(OptionsClass::getAddr);
        System.out.println(testsss);

    }


    @Test
    public void stringMany(){
        List<String> testList = Arrays.asList("tsss1", "tsss2", "tsss3", "tsss4", "tsss5");
        String strList = testList.stream().map(String::toString).collect(Collectors.joining(", "));
        System.out.println(strList);


        String strList2  = StringUtils.join(testList, ',');

        System.out.println(strList2);

    }


















}
