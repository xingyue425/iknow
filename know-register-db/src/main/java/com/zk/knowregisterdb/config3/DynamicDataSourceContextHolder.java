package com.zk.knowregisterdb.config3;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal contextHolder = new ThreadLocal();
    public static List dataSourceIds = new ArrayList<>();
    //使用setDataSourceType设置当前的
    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }
    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
    //判断指定DataSrouce当前是否存在
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}
