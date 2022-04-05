package com.springrest.springrest.services;

import com.springrest.springrest.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl  implements  CourseService{

     List<Course> list;

    public CourseServiceImpl() {
        list=new ArrayList<>();
        list.add(new Course(123,"math","now its math class"));
        list.add(new Course(456,"computer science","its computer science you will go for computer"));
    }



    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c=null;
        for(Course course:list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e ->{
           if(e.getId()==course.getId()){
               e.setName(course.getName());
               e.setDescription(course.getDescription());
           }
        });
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    }


}
