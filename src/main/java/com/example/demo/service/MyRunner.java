package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CustomQueries;
import com.example.demo.repository.CustomQueryRepository;

@Component
@Transactional
public class MyRunner implements CommandLineRunner {

	@Autowired
	private CustomQueryRepository repository;

	@Override
	public void run(String... args) throws Exception {
		ArrayList<CustomQueries> arrayList = new ArrayList<>();
		arrayList.add(0, new CustomQueries(02, "sql", "Oracle", true));
		arrayList.add(01, new CustomQueries(03, "jpql", "jpa", true));
		arrayList.add(02, new CustomQueries(04, "hql", "hibernet", false));
		arrayList.add(03, new CustomQueries(05, "h2", "inbuilt", true));
		arrayList.add(04, new CustomQueries(06, "plsql", "procedure", false));
		arrayList.add(05, new CustomQueries(07, "datajpa", "springBoot", true));
		System.out.println("I am retriving the data");
		/**
		 * repository.saveAll(arrayList); CustomQueries byId = repository.getById(2); if
		 * (byId != null) { System.out.println(byId); } else { System.out.println("Soory
		 * it is null i cant retrive the data"); } System.out.println("i all ready
		 * retrived the data");
		 **/

		/**
		 * List<Object[]> getempname = repository.getempname(); System.out.println("I am
		 * retriving the queryName and queryAddress"); for (Object[] objects :
		 * getempname) { System.out.println(objects[0] + " " + objects[1]); }
		 * getempname.forEach(System.out::println); System.out.println("I am retrived
		 * the queryName and queryAddress");
		 **/
		/**
		 * Integer queryId = repository.getQueryId(); System.out.println("&&&&&&&");
		 * System.out.println(queryId); System.out.println(objects[0] +" "+ objects[1]);
		 **/
		/**
		 * List<Object[]> customQuiresBetween = repository.getCustomQuiresBetween(2, 6);
		 * System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		 * System.out.println("Retriving the data by using between operator"); for
		 * (Object[] objects : customQuiresBetween) { System.out.print(objects[0]); }
		 * System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		 **/
		/**
		 * List<CustomQueries> groupByData = repository.getGroupByData();
		 * System.out.println("********************"); System.out.println("I am
		 * retriving the data by group by function"); for (CustomQueries customQueries :
		 * groupByData) { System.out.println(customQueries); }
		 * System.out.println("*************************");
		 **/
		/**
		 * Integer updateTheData = repository.updateTheData("chandu", 4);
		 * System.out.println(updateTheData);
		 **/

		List<CustomQueries[]> queryIdAndQueryAddress = repository.getQueryIdAndQueryAddress();
		for (CustomQueries[] objects : queryIdAndQueryAddress) {
			System.out.println(objects[0]);
		}
	}
}
