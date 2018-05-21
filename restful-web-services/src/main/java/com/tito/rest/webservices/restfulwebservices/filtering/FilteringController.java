package com.tito.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

  @GetMapping("/filtering")
  public MappingJacksonValue retrieveSomeBean() {
    //only want to map fields 1 & 2
    SomeBean someBean = new SomeBean("value 1", "value 2", "value 3");

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

    MappingJacksonValue mapping = new MappingJacksonValue(someBean);
    mapping.setFilters(filters);

    return mapping;
  }

  @GetMapping("/filtering-list")
  public MappingJacksonValue retrieveListOfSomeBeans() {
    //only want to send fields 2 & 3
    List<SomeBean> list = Arrays.asList(
        new SomeBean("value 1", "value 2", "value 3"),
        new SomeBean("value 4", "value 5", "value 6")
    );

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

    MappingJacksonValue mapping = new MappingJacksonValue(list);
    mapping.setFilters(filters);

    return mapping;
  }
}
