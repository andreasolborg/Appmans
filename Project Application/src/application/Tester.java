package application;

import java.util.HashMap;

public class Tester {
    static HashMap<String, HashMap<String, String>> outerMap = new HashMap<String, HashMap<String,String>>();
    static HashMap<String, String> innerMap = new HashMap<String, String>();
    
    static HashMap<String ,HashMap<Integer ,Integer>> map1=new HashMap<>();
    static HashMap<Integer ,Integer> map2=new HashMap<>(); 

    
    
    public static void main(String[] args) {
    	
    	
        
        map2.put(1,1);
        map2.put(2,1);
        map2.put(3,1); 
        map1.put("1", map2); 
        System.out.println("After Inserting first value   "+map1.entrySet());
        /* OutPut:  After Inserting first value  [1={1=1, 2=1, 3=1}]*/

//        map2.clear(); //i cleared map 2 values
        map2 = new HashMap<Integer, Integer>();
        map2.put(4,2); 
        map2.put(5,2); 
        map2.put(6,2); 
        map1.put("2", map2); 
        System.out.println("After Inserting second value   "+map1.entrySet()); 
        /*output :  After Inserting second value    [2={4=2, 5=2, 6=2}, 1={4=2, 5=2, 6=2}]*/
        
        
    	innerMap.put("InnerKey", "InnerValue");
    	innerMap.put("InnerKey1", "InnerValue1");
        System.out.println("outerman is" + outerMap);
        outerMap.put("OuterKey", innerMap);
        System.out.println("outerman is" + outerMap);
        System.out.println("innermap is" + innerMap);
        String value = ((HashMap<String, String>)outerMap.get("OuterKey")).get("InnerKey").toString();
        System.out.println("Retreived value is : " + value);
	}
    
    
    
    
    for line in userGrades.txt{
    	split string at ";"
    	outerMap1.put(gradeSplitter[0], gradeSplitter[1])
    	print(outerMap1)
    }
    
}
