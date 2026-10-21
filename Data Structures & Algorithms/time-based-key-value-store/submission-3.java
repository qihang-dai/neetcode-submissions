class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeVal = map.get(key);
        if(timeVal == null) return "";
        return timeVal.floorEntry(timestamp) == null ? "": timeVal.floorEntry(timestamp).getValue();
    }
}
