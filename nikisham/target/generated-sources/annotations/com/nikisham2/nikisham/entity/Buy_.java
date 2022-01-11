package com.nikisham2.nikisham.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Buy.class)
public abstract class Buy_ {

	public static volatile SingularAttribute<Buy, String> date;
	public static volatile SingularAttribute<Buy, String> lot;
	public static volatile SingularAttribute<Buy, String> volume;
	public static volatile SingularAttribute<Buy, Integer> number;
	public static volatile SingularAttribute<Buy, String> price;
	public static volatile SingularAttribute<Buy, String> name;
	public static volatile SingularAttribute<Buy, UUID> id;

	public static final String DATE = "date";
	public static final String LOT = "lot";
	public static final String VOLUME = "volume";
	public static final String NUMBER = "number";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String ID = "id";

}

