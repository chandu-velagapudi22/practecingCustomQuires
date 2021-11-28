package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CustomQueries;

public interface CustomQueryRepository extends JpaRepository<CustomQueries, Serializable> {

	@Query("select data  from  CustomQueries data")
	List<CustomQueries> getAlldata();

	@Query("select id from  CustomQueries  id where id.queryId=2")
	CustomQueries getDataById();

	@Query("select c.queryName,c.queryAddress from  CustomQueries c where c.queryId=5")
	List<Object[]> getempname();

	@Query("select c.queryName from  CustomQueries c where c.queryId=6")
	String getQueryName();

	@Query("select c.queryId from  CustomQueries c where c.queryId=3")
	Integer getQueryId();

//I AM RETRIVING ONLY 2 QUIRES SO I AM using the Object[] Object array bcz retriving data in the form of object
	// But if i try insted of object with entity class it is showing exception why??
	@Query("select c.queryId,c.queryAddress from  CustomQueries c where c.queryId=4")
	List<CustomQueries[]> getQueryIdAndQueryAddress();

//using in opeartor	
	@Query("select c from  CustomQueries c where c.queryId in (:data)")
	List<CustomQueries> getinOperator();

	// I am using between function to retrive the data
	@Query("select b from CustomQueries b where b.queryId between :start and :end")
	List<Object[]> getCustomQuiresBetween(Integer start, Integer end);

	// I am retriving the data by using the group by function,This is native queries
	// so don't use alias names..only hql and jpql quires we have to use the alias
	// names
	@Query(nativeQuery = true, value = "select * from custom_queries   group by  query_name")
	List<CustomQueries> getGroupByData();

	// i am doing updating the data by using the @Query annotation
	@Query("update CustomQueries  set queryName=:name   where queryId=:queryId")
	@Modifying
	@Transactional
	Integer updateTheData(String name, Integer queryId);
}
