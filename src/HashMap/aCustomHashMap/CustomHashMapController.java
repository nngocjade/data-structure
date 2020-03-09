package HashMap.aCustomHashMap;


import HashMap.aCustomHashMap.CustomHashMap;

class CustomHashMapController{
    public static void main(String[] args) {

        CustomHashMap<String, String> customHashMap = new CustomHashMap<>();

        customHashMap.put("a", "a");
        customHashMap.put("b", "b");
        customHashMap.put("c", "c");
        customHashMap.put("d", "d");
        customHashMap.put("e", "e");
        customHashMap.put("f", "f");

        System.out.println("Before");
        customHashMap.print();

        System.out.println("After");
        customHashMap.remove("b");
        customHashMap.print();

        System.out.println("\n");

        System.out.println(customHashMap.contains("a"));
        System.out.println(customHashMap.contains("b"));
        System.out.println(customHashMap.get("b"));

    }
}
