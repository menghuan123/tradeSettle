package com.tencent.sr.bizmid.tradeSettle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

class DomainApplicationTests {

  @Test
  void contextLoads() {
    ExecutorService attcheGoodLabelThreadpool = new ThreadPoolExecutor(
        100,
        1000,
        120,
        TimeUnit.MINUTES,
        new ArrayBlockingQueue<>(5000));
    ;
    List<String> res = new ArrayList<>();
    Long startTime = System.currentTimeMillis();
    // 并发打标签
    List<Future<List<String>>> taskList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      taskList.add(attcheGoodLabelThreadpool.submit(() ->
          getAAA()));
    }

    // 处理结果
    for (Future<List<String>> task : taskList) {
      try {
        List<String>  a = task.get();
        if (CollectionUtils.isNotEmpty(a)) {
          res.addAll(a);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    Long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);

  }

  private List<String> getAAA() throws InterruptedException {
    Thread.sleep(500);
    return null;
  }

}
