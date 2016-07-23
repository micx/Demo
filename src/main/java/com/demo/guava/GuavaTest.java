/**
 * GuavaTest.java  
 * Created on  18/12/14 下午4:13
 * modify on                user            modify content
 * 18/12/14 下午4:13        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.guava;

import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.collect.*;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by micx  on 2014/12/18 下午4:13.
 */
public class GuavaTest implements Comparable<GuavaTest> {
    private int x;
    private int y;
    private int z;

    public GuavaTest() {
    }

    public GuavaTest(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {

        comparisonChainTest();
        equalsTest();
        hashCodeTest();



        multiSetTest();
        multiMapTest();
        biMapTest();
        tableTest();
        rangeSetTest();
        rangeMapTest();


        joinerTest();
        splitterTest();
        charMacherTest();
        charsetsTest();
        caseFromatTest();


    }

    private static void caseFromatTest() {
//        大小写格式[CaseFormat]
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME")); // returns "constantName"
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "CONSTANT_NAME")); // returns "constant-name"
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, "CONSTANT_NAME")); // returns "constant_name"
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "CONSTANT_NAME")); // returns "ConstantName"
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, "CONSTANT_NAME")); // returns "CONSTANT_NAME"

    }

    private static void charsetsTest() {
        String str = "charset Test ";
        try {
            byte[] bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // how can this possibly happen?
            throw new AssertionError(e);
        }

        byte[] bytes = str.getBytes(Charsets.UTF_8);

    }

    private static void charMacherTest() {

        String string = "   I control the Handler, 12 times ABCD  + \\ ";
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); //移除control字符
        String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');//去除两端的空格，并把中间的连续空格替换成单个空格
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);// 只保留数字和小写字母

        System.out.println(
                noControl+"\n"+
                theDigits+"\n"+
                spaced+"\n"+
                noDigits+"\n"+
                lowerAndDigit+"\n"
        );

    }

    private static void splitterTest() {
        String str = "foo,bar,,   qux";
        System.out.println(
                Splitter.on(',')
                        .trimResults()
                        .omitEmptyStrings()
                        .split(str)
        );

        String[] strs = str.split(",");
        for(String s:strs) {
            System.out.println("str:"+s);
        }
    }

    private static void joinerTest() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));

        Joiner.on(",").join(Arrays.asList(1, 5, 7)); // returns "1,5,7"
    }

    private static void multiMapTest() {
        Multimap<String, Integer> multimap = HashMultimap.create();
        multimap.put("a",1);
        multimap.put("a",1);
        multimap.put("a",2);
        multimap.put("a",3);
        multimap.put("b",4);
        multimap.put("b",5);
        multimap.put("c",6);
        System.out.println(multimap);
        System.out.println(multimap.get("ab"));
    }

    private static void rangeMapTest() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}

        System.out.println(rangeMap);
    }

    private static void rangeSetTest() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1,10]}
        rangeSet.add(Range.closedOpen(11, 15));//不相连区间:{[1,10], [11,15)}
        rangeSet.add(Range.closedOpen(15, 20)); //相连区间; {[1,10], [11,20)}
        rangeSet.add(Range.openClosed(0, 0)); //空区间; {[1,10], [11,20)}
        rangeSet.remove(Range.closed(5, 10));
        System.out.println(rangeSet);
        System.out.println(rangeSet.span());
        System.out.println(rangeSet.contains(11));
        System.out.println(rangeSet.rangeContaining(11));
        System.out.println(rangeSet.subRangeSet(Range.closed(3, 15)));//与给定集合的交集
        System.out.println(rangeSet.complement());// RangeSet的补集


    }

    private static void tableTest() {
        Table<Integer, Integer, Integer> weightedGraph = HashBasedTable.create();
        weightedGraph.put(2, 2, 4);
        weightedGraph.put(2, 10, 20);
        weightedGraph.put(1, 5, 5);
        System.out.println(weightedGraph.row(2).get(10)); // returns a Map mapping v2 to 4, v3 to 20
        System.out.println(weightedGraph.column(2)); // returns a Map mapping v1 to 20, v2 to 5
        System.out.println(weightedGraph.get(2,10)); // returns a Map mapping v1 to 20, v2 to 5

    }

    private static void biMapTest() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1,"one");
        biMap.put(2,"two");
        biMap.put(3,"three");
        biMap.put(4,"four");

        biMap.inverse().put("five",5);
        biMap.inverse().forcePut("one", 2);

        System.out.println(biMap.inverse().get("five"));//5
        System.out.println(biMap.inverse().get("three"));//3
        System.out.println(biMap.inverse().get("one"));//2
        System.out.println(biMap);

    }

    private static void multiSetTest() {
        List<String> words = Arrays.asList("a","b","a","c");
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }

        Multiset<String> multiset = HashMultiset.create();
        multiset.addAll(words);
        System.out.println(multiset);//[b, c, a x 2]
        System.out.println(multiset.elementSet());// [b, c, a]


        for(Map.Entry entry: counts.entrySet()){
            System.out.println(entry);
        }
    }

    private static void hashCodeTest() {
        GuavaTest a = new GuavaTest(1,2,3);
        GuavaTest b = new GuavaTest(4,5,6);

        System.out.println(Objects.hashCode(a));//1057
        System.out.println(Objects.hashCode(b));//4036
        System.out.println(Objects.hashCode(a,b));//36772
        System.out.println(Objects.hashCode(b,a));//126142
    }

    /**
     * 当一个对象中的字段可以为null时，实现Object.equals方法会很痛苦，
     * 因为不得不分别对它们进行null检查。使用Objects.equal帮助你执行null敏感的equals判断，
     * 从而避免抛出NullPointerException。
     */
    private static void equalsTest() {

        GuavaTest a = new GuavaTest(1,2,3);
        GuavaTest b = new GuavaTest(1,2,3);
        System.out.println(Objects.equal(a, b));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuavaTest)) return false;

        GuavaTest guavaTest = (GuavaTest) o;

        if (x != guavaTest.x) return false;
        if (y != guavaTest.y) return false;
        if (z != guavaTest.z) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    private static void comparisonChainTest() {
        List list = new ArrayList<Integer>();
        Random random = new Random(100);
        for(int i=0; i<100; ++i) {
            GuavaTest test = new GuavaTest();
            test.setX(random.nextInt()%10);
            test.setY(random.nextInt()%10);
            test.setZ(random.nextInt()%10);
            list.add(test);
        }
        Collections.sort(list);
        System.out.println(list);
    }


    public int compareTo(GuavaTest that) {
        return ComparisonChain.start().
                compare(this.x, that.x).
                compare(this.y, that.y).
                compare(this.z, that.z).result();
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "GuavaTest{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
