/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Minato
 */
public class StackExchangeScraper2 {
    public static void main(String args[]) {
        Scanner input = new Scanner (System.in);
        StringBuilder sb = new StringBuilder();
        String regex1 = "(?<code1>id=\"question-summary-)(?<code2>\\d+)";
        String regex2 = "(?<code1><a href=\"\\/questions\\/\\d+.+?\">)(?<code2>.+)(?<code3><\\/a)";
        String regex3 = "(?<code1>class=\"relativetime\">)(?<code2>.+)(?<code3><\\/span>)";
        String text = "";
        int count = 0;
        while (input.hasNextLine()) {
            sb.append(input.nextLine());
            sb.append("\n");
            count++;
            // test
            if (count == 1000) {
                break;
            }
        }
        text = sb.toString();
        
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        Matcher matcher3 = pattern3.matcher(text);

        int count2 = 0;
        
        ArrayList<String> arrayList1 = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        ArrayList<String> arrayList3 = new ArrayList<String>();
        
        while (matcher1.find()) {
            arrayList1.add(matcher1.group("code2"));
        }
        
        while (matcher2.find()) {
            arrayList2.add(matcher2.group("code2"));
        }
        
        while (matcher3.find()) {
            arrayList3.add(matcher3.group("code2"));
            count2++;
        }
        
        for (int i = 0; i < count2; i++) {
            System.out.println(arrayList1.get(i) + ";" + arrayList2.get(i) + ";" + arrayList3.get(i));
        }
    }
}
