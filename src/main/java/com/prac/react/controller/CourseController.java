package com.prac.react.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.react.model.dto.Course;
import com.prac.react.model.dto.CourseWrapper;
import com.prac.react.model.dto.Place;
import com.prac.react.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	Logger logger = LoggerFactory.getLogger(CourseController.class);
	private CourseService cs;

	public CourseController(CourseService cs){
		this.cs = cs;
	}

	@PostMapping("")
	public int insertCourse(@RequestBody CourseWrapper cw) {
		List<Place> placesList = cw.getCourse();

		int result = 0;

		String places = "";
		//받은 Place에 접근을 하여서 placeNum이 없는 애들은 place를 저장하자.
		for(Place place : placesList){
			logger.info("Place Info : " + place.toString());
			if(place.getPlaceNum() == 0){
				//placeNum이 없는 애들은 map에서 고른애들이다. 따라서 우리 DB에 있을수도 있고 없을수도 있다.
				//따라서 우리는 장소이름과 경도와 위도가 DB에 없다면 추가를 할것이다.
				// select placeNum from places where name = 이름 && lat = 위도 && lng = 경도
				Integer placeNum = cs.checkPlaceDb(place);
				//placeNum이 null 이면 값이 없는거고 값이 있으면 이미 저장되어 있는 장소다.
				if(placeNum == null ){
					logger.info("No place info in DB, save process start");
					cs.saveNewPlace(place);
					if(place.getPlaceNum() < 0){ //뭔가 입력이 안됐거나 오류가 생긴 경우
						return 500;
					}
					places += place.getPlaceNum() + "/";
				}else{ //placeNum이 해당 장소정보로 저장된 경우
					places += placeNum + "/";
				}
			}else{//이미 백에 저장되어 placeNum이 넘어온경우
				places += place.getPlaceNum() + "/";
			}
		}

		Course course = new Course(0,cw.getCourseName(),places,cw.getMemberNum());
		logger.info("Course : "+ course.toString());
		result = cs.insertCourse(course);

		if(result < 0){
			return 500;
		}

		return result;
	}
	@GetMapping("/{memberNum}")
	public List<CourseWrapper> getCourses(@PathVariable("memberNum")int memberNum){
		//해당 멤버의 코스를 모두 불러와야한다.
		List<CourseWrapper> memberCourseList = new ArrayList<>(); //여기에 담아서 보내줄것이다.

		List<Course> courses = cs.getCourses(memberNum); //코스를 모두 불러왔다.

		//그럼 이제 CourseWrapper에 place info를 담도록 하자.
		//이건 이제 MultiThread를 이용해서 

		return null;
	}
}
