package com.zk.knowlotteryrule.aspect;

import java.util.List;
import java.util.Map;

public interface Aspect {

    public List<String> splitBetCodes(String betCode,String gameCode,String betWay);

    public void prepareData();

    public Map<String,Integer> computeBallNum();

    public Map<Long,Integer> computeGrade();
}
