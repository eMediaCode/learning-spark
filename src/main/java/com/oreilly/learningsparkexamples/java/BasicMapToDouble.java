/**
 * Illustrates a simple map in Java
 */
package com.oreilly.learningsparkexamples.java;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.DoubleFunction;

public class BasicMapToDouble {
  public static void main(String[] args) throws Exception {
		String master;
		if (args.length > 0) {
      master = args[0];
		} else {
			master = "local";
		}
		JavaSparkContext sc = new JavaSparkContext(
      master, "basicmap", System.getenv("SPARK_HOME"), System.getenv("JARS"));
    JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4));
    JavaDoubleRDD result = rdd.map(
      new DoubleFunction<Integer>() { public Double call(Integer x) { Double y = (double) x; return y * y;}});
    System.out.println(StringUtils.join(result.collect(), ","));
	}
}
